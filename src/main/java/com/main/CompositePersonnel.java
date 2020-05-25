package com.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class CompositePersonnel implements Printer, Serializable, Iterable<Printer> {

  /**
   *
   */
  private static final long serialVersionUID = -826881756634659858L;
  private String nomGroupe;
  private ArrayList<Printer> listPersonnel;

  public CompositePersonnel() {
    this.listPersonnel = new ArrayList<Printer>();
    this.nomGroupe = "Uknown";
  }

  public CompositePersonnel(String nom, ArrayList<Printer> liste) {
    this.nomGroupe = nom;
    this.listPersonnel = liste;
  }

  public ArrayList<Printer> getPersonnel() {
    return this.getPersonnel();
    // return ( ArrayList<InterfacePersonne>) Collections.unmodifiableList(this.personnel);

  }

  @Override
  public void print() {
    for (Printer personnel : listPersonnel) {
      personnel.print();
    }
  }

  public void add(Printer personnel) {
    listPersonnel.add(personnel);
  }

  public void delete(Printer personnel) {
    if (listPersonnel.contains(personnel)) {
      listPersonnel.remove(personnel);
    } else {
      throw new IllegalArgumentException("Cet élément n'existe pas");
    }
  }

  @Override
  public Iterator iterator() {
    // TODO Auto-generated method stub
    return this.listPersonnel.iterator();
  }

  public String getNomGroupe() {
    return nomGroupe;
  }

  public ArrayList<Printer> getListPersonnel() {
    return listPersonnel;
  }
}
