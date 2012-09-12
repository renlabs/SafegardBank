package com.safegard.bank.enums;

public enum Gender {

    MALE("Male"),
    FEMALE("Female");

    private String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
