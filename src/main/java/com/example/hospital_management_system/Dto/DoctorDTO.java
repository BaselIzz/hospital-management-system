package com.example.hospital_management_system.Dto;


import jakarta.validation.constraints.NotNull;

public class DoctorDTO {
  //  @NotNull
 //   @Size(min = 1,max = 300)
    private  Long ID ;

    @NotNull
    private String name;
    @NotNull
    private  String contentNumber;

    public Long getID() {
        return ID;
    }

    public DoctorDTO(long ID, String name, String contentNumber) {
        this.ID = ID;
        this.name = name;
        this.contentNumber = contentNumber;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public DoctorDTO() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentNumber() {
        return contentNumber;
    }

    public void setContentNumber(String contentNumber) {
        this.contentNumber = contentNumber;
    }
}
