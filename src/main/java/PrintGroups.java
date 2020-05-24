package com.main;

import java.util.ArrayList;

public class PrintGroups extends IteratorPersonnel {

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
