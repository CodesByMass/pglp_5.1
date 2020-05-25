package com.main;

/**
 *
 * Pattern Iterator.
 * 
 * @author Mass'
 *
 * @param <PrintPersonnel> l'interface Composite.
 */
@SuppressWarnings("hiding")
public interface Iterator<PrintPersonnel> {
  boolean hasNext();

  PrintPersonnel next();

}
