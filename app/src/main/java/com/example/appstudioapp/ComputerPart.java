package com.example.appstudioapp;

import java.io.Serializable;

public class ComputerPart implements Serializable {
    private PartType partType;
    private String partChosen;
    private double partPrice;

    public ComputerPart(PartType partType){
        this.partType = partType;
    }

    public void setPartChosen(String partChosen){
        this.partChosen = partChosen;
    }

    public void setPartPrice(double partPrice){
        this.partPrice = partPrice;
    }

    public PartType getPartType(){
        return partType;
    }

    public String getPartChosen(){
        return partChosen;
    }

    public double getPartPrice(){
        return partPrice;
    }
}
