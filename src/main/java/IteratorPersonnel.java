package com.main;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public abstract class IteratorPersonnel implements Iterator<Printer> {

  private CompositePersonnel groupe;

  private ArrayList<Printer> liste;

  private int position;

  public IteratorPersonnel(CompositePersonnel groupe, ArrayList<Printer> liste) {
    this.groupe = groupe;
    this.liste = liste;
    this.liste.addAll(groupe.getPersonnel());
    this.position = 0;

  }


  public boolean hasNext() {
    if (position < liste.size()) {
      return true;
    }
    return false;
  }

  public Printer next() {
    if (!hasNext()) {
      throw new NoSuchElementException("Il n y a plus d'élément");
    } else {
      Printer temp = this.liste.get(position++);
      return temp;
    }
  }

  public CompositePersonnel getGroupe() {
    return groupe;
  }

  public ArrayList<Printer> getListe() {
    return liste;
  }

  public abstract void iteratorPersonnel();

}
