package com.bfs.blackfabricsecuritybackend.services;


import com.bfs.blackfabricsecuritybackend.models.Client;
import com.bfs.blackfabricsecuritybackend.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository repo;

    public ClientService(ClientRepository repo) {
        this.repo = repo;
    }

    // Create client
    public Client create(Client client) {
        return repo.save(client);
    }

    // Update client
    public Client update(Long id, Client client) {
        Optional<Client> existingOpt = repo.findById(id);
        if (existingOpt.isPresent()) {
            Client existing = existingOpt.get();
            existing.setName(client.getName());
            existing.setEmail(client.getEmail());
            existing.setPhone(client.getPhone());
            existing.setAddress(client.getAddress());
            existing.setZipCode(client.getZipCode());
            existing.setLatitude(client.getLatitude());
            existing.setLongitude(client.getLongitude());
            existing.setSendIncidents(client.isSendIncidents());
            return repo.save(existing);
        } else {
            throw new RuntimeException("Client not found with id: " + id);
        }
    }

    // Delete client
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // Get all clients
    public List<Client> getAll() {
        return repo.findAll();
    }

    // Search by name
    public List<Client> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    // Get single client
    public Client getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
