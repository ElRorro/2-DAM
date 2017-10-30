package com.example.elrorro.socialtechfragment;

import android.support.v4.app.Fragment;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matinal on 11/10/2017.
 */

public class Contact implements Serializable {
    private String nameContact;
    private String surnameContact;
    private int telephoneContact;
    private String emailContact;
    private String trainingContact;
    private String provinceContact;
    private int ageContact;
    private String genderContact;

    public Contact(String nameContact, String surnameContact, int telephoneContact, String emailContact, String trainingContact, String provinceContact, int ageContact, String genderContact) {
        this.nameContact = nameContact;
        this.surnameContact = surnameContact;
        this.telephoneContact = telephoneContact;
        this.emailContact = emailContact;
        this.trainingContact = trainingContact;
        this.provinceContact = provinceContact;
        this.ageContact = ageContact;
        this.genderContact = genderContact;
    }

    public Contact() {
    }

    public String getNameContact() {
        return nameContact;
    }

    public void setNameContact(String nameContact) {
        this.nameContact = nameContact;
    }

    public String getSurnameContact() {
        return surnameContact;
    }

    public void setSurnameContact(String surnameContact) {
        this.surnameContact = surnameContact;
    }

    public int getTelephoneContact() {
        return telephoneContact;
    }

    public void setTelephoneContact(int telephoneContact) {
        this.telephoneContact = telephoneContact;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public String getTrainingContact() {
        return trainingContact;
    }

    public void setTrainingContact(String trainingContact) {
        this.trainingContact = trainingContact;
    }

    public String getProvinceContact() {
        return provinceContact;
    }

    public void setProvinceContact(String provinceContact) {
        this.provinceContact = provinceContact;
    }

    public int getAge() {
        return ageContact;
    }

    public void setAge(int age) {
        this.ageContact = ageContact;
    }

    public String getGender() {
        return genderContact;
    }

    public void setGender(String gender) {
        this.genderContact = gender;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nameContact='" + nameContact + '\'' +
                ", surnameContact='" + surnameContact + '\'' +
                ", telephoneContact=" + telephoneContact +
                ", emailContact='" + emailContact + '\'' +
                ", trainingContact='" + trainingContact + '\'' +
                ", provinceContact='" + provinceContact + '\'' +
                ", ageContact=" + ageContact +
                ", genderContact='" + genderContact + '\'' +
                '}';
    }
}

