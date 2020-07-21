package com.example.user.findhostel;

public class HostelAdapter {

    public HostelAdapter() {
    }

    public HostelAdapter(String nameOfhostel, String gender) {
        this.nameOfhostel = nameOfhostel;
        this.gender = gender;

    }



    public String getNameOfhostel() {
        return nameOfhostel;
    }


    public String nameOfhostel,placeOfHostel,gender;

    public String getGender() {
        return gender;
    }
}
