package com.main;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Personnel implements Printer, Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String nom;

  private String prenom;

  private String fonction;

  private ArrayList<PhoneNumber> phoneNumbers;

  private LocalDate birthDate;


  public Personnel(Builder builder) {
    this.nom = builder.nom;
    this.prenom = builder.prenom;
    this.fonction = builder.fonction;
    this.birthDate = builder.birthDate;
    this.phoneNumbers = builder.phoneNumbers;

  }

  public static class Builder {
    private String nom;

    private String prenom;

    private String fonction;

    // Paramètres optionnels
    private ArrayList<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

    private LocalDate birthDate = LocalDate.parse("1970-01-01");

    public Builder(String nom, String prenom, String fonction) {
      this.nom = nom;
      this.prenom = prenom;
      this.fonction = fonction;
    }

    public Builder addBirthDate(LocalDate birthDate) {
      this.birthDate = birthDate;
      return this;
    }

    public Builder addNumber(PhoneNumber number) {
      this.phoneNumbers.add(number);
      return this;
    }

    public Personnel build() {
      return new Personnel(this);
    }
  }

  public String getNom() {
    return nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public String getFonction() {
    return fonction;
  }

  public ArrayList<PhoneNumber> getPhoneNumbers() {
    return phoneNumbers;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void print() {
    System.out
        .println("Hello, i am " + this.prenom + " " + this.nom + " and i work as " + this.fonction);

  }

}

