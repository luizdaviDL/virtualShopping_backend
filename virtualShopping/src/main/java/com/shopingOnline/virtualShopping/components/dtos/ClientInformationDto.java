package com.shopingOnline.virtualShopping.components.dtos;

import com.shopingOnline.virtualShopping.entity.Client;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClientInformationDto {
    private Long id;
    private ClientDto user;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String documentNumber;
    private LocalDate birthDate;
    private String gender;
    private Integer loyaltyPoints;
    private LocalDateTime updatedAt;
    private Integer age;

    public ClientInformationDto(Long id, ClientDto user, String firstName, String lastName, String phoneNumber, String documentNumber, LocalDate birthDate, String gender, Integer loyaltyPoints, LocalDateTime updatedAt, Integer age) {
        this.id = id;
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.documentNumber = documentNumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.loyaltyPoints = loyaltyPoints;
        this.updatedAt = updatedAt;
        this.age = age;
    }

    public ClientInformationDto(Long id, String firstName, String lastName, String phoneNumber, String documentNumber, LocalDate birthDate, String gender, Integer loyaltyPoints, LocalDateTime updatedAt, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.documentNumber = documentNumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.loyaltyPoints = loyaltyPoints;
        this.updatedAt = updatedAt;
        this.age = age;
    }

    public ClientInformationDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientDto getUser() {
        return user;
    }

    public void setUser(ClientDto user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
