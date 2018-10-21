package com.industrialmaster.doca99.entity;

public class Session  {
    private int id;
    private String doctorName;
    private String specialityName;
    private String hospitalName;
    private String date;

    public Session(int id, String drName, String spName, String hpName, String date){
        this.setId(id);
        this.setDate(date);
        this.setDoctorName(drName);
        this.setHospitalName(hpName);
        this.setSpecialityName(spName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
