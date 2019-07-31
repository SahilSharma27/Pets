package com.example.android.pets;

public class Pet {
   private String name;
   private int gender;
   private String breed;
   private int measurement;

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getMeasurement() {
        return measurement;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setMeasurement(int measurement) {
        this.measurement = measurement;
    }
}
