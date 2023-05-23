package com.example.hospital_management_system.Dto;

public class SpecialtyDTO {
    private Long id;
    private String description;
    private  String name;

    public SpecialtyDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpecialtyDTO(Long id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
