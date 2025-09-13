package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.service.EmailService;
import com.projetintegration.projetintegration.service.UtilisateurService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UtilAct")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/sendVerificationEmail")
    public ResponseEntity<?> sendVerificationEmail(@RequestBody String email) {
        try {
            emailService.sendVerificationEmail(email);
            return ResponseEntity.ok("");
        } catch (MessagingException e) {
            return ResponseEntity.badRequest().body("Error sending email: " + e.getMessage());
        }
    }

    @PostMapping("/verifyCode")
    public ResponseEntity<?> verifyCode(@RequestParam String email, @RequestParam String code) {
        if (emailService.verifyCode(email, code)) {
            emailService.removeCode(email);
            return ResponseEntity.ok("");
        }
        return ResponseEntity.badRequest().body("Invalid verification code.");
    }


}
