package com.ms.cms.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 2, message = "is required")
    private String lastName;
    private String state;
    private String[] languages;
    private String gender;

    public Customer() {

    }

    public Customer(@NotNull(message = "is required") @Size(min = 1, message = "is required")
                            String firstName,
                    @NotNull(message = "is required") @Size(min = 2, message = "is required")
                            String lastName,
                    String state,
                    String[] languages,
                    String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.languages = languages;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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


}
