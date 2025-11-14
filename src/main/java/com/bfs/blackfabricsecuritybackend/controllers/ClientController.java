package com.bfs.blackfabricsecuritybackend.controllers;

import com.bfs.blackfabricsecuritybackend.models.Client;
import com.bfs.blackfabricsecuritybackend.services.ClientService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*") // allow Angular to call
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    // Get all clients
    @GetMapping
    public List<Client> getAllClients() {
        return service.getAll();
    }

    // Search by name
    @GetMapping("/search")
    public List<Client> searchClients(@RequestParam String name) {
        return service.searchByName(name);
    }

    // Get by ID
    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id) {
        return service.getById(id);
    }

    // Create
    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return service.create(client);
    }

    // Update
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return service.update(id, client);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        service.delete(id);
    }
}
