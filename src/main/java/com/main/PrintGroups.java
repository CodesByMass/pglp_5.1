package com.main;

import java.io.Serializable;
import java.util.ArrayList;

public class PrintGroups extends IteratorPersonnel implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -269401832920945421L;

  public PrintGroups(CompositePersonnel groupe, ArrayList<Printer> liste) {
    super(groupe, liste);
  }

  @Override
  public void iteratorPersonnel() {

    Iterator<Printer> iterator = (Iterator<Printer>) this.getListe().iterator();
    while (iterator.hasNext()) {
      iterator.next().print();
    }

  }

}
