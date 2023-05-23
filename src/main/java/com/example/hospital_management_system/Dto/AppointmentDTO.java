package com.example.hospital_management_system.Dto;

import java.util.Date;

public class AppointmentDTO {
    private Long id;
    private Date appointmentDate;
    private Long doctor;
    private Long patient;
    private String room;


  //  private Date AddmistionDate;
    private  double cost;
    public AppointmentDTO() {
    }

    public Long getDoctor() {
        return doctor;
    }

    public void setDoctor(Long doctor) {
        this.doctor = doctor;
    }

    public Long getPatient() {
        return patient;
    }

    public void setPatient(Long patient) {
        this.patient = patient;
    }

    public AppointmentDTO(Long id, Date appointmentDate, Long doctor, Long patient, String room, Date addmistionDate, double cost) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
        this.patient = patient;
        this.room = room;
        //AddmistionDate = addmistionDate;
        this.cost = cost;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = (appointmentDate);
    }





    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    //public Date getAddmistionDate() {
   //     return AddmistionDate;
   // }

   // public void setAddmistionDate(Date addmistionDate) {
    //    AddmistionDate = addmistionDate;
   // }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


}
