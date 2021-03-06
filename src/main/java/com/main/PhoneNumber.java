package com.main;

import java.io.Serializable;

/**
 * Définit le type du numéro de téléphone.
 *
 * @author Mass'
 *
 */
public class PhoneNumber implements Serializable {


  private static final long serialVersionUID = -3021925163289423480L;
  private String type;
  private String number;

  public PhoneNumber(String type, String number) {
    this.type = type;
    this.number = number;
  }

  public String getType() {
    return type;
  }

  public String getNumber() {
    return number;
  }
}
