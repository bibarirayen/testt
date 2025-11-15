package com.bfs.blackfabricsecuritybackend.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String address;
    private String zipCode;

    private Double latitude;
    private Double longitude;
    private double range;
    private boolean sendIncidents;

    public Client(Long id, String name, String email, String phone, String zipCode, String address, Double latitude, Double longitude, boolean sendIncidents, Double range) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.zipCode = zipCode;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.sendIncidents = sendIncidents;
        this.range = range;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public Client() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public boolean isSendIncidents() {
        return sendIncidents;
    }

    public void setSendIncidents(boolean sendIncidents) {
        this.sendIncidents = sendIncidents;
    }
}
