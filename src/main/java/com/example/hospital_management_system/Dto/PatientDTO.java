package com.example.hospital_management_system.Dto;

import com.example.hospital_management_system.enumm.Sex;

import java.util.Date;

public class PatientDTO {
    //@Size(min=1,max=300)
    private Long id ;
    private Date dob;
    private String name;
    private String address;

    public PatientDTO() {
    }

    public PatientDTO(Long id, Date dob, String name, String address, String contentnumber, String note, Sex gender) {
        this.id = id;
        this.dob = dob;
        this.name = name;
        this.address = address;
        this.contentnumber = contentnumber;
        this.note = note;
        Gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContentnumber() {
        return contentnumber;
    }

    public void setContentnumber(String contentnumber) {
        this.contentnumber = contentnumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Sex getGender() {
        return Gender;
    }

    public void setGender(Sex gender) {
        Gender = gender;
    }

    private String contentnumber;
    private String note;
    private Sex Gender;


}
