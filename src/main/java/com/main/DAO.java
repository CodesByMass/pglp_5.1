package com.main;

/**
 * La classe Data Access Object.
 *
 * @author Mass'
 *
 * @param <T> Le type d'objet (Personnel, Composite Personnel)
 */
public abstract class DAO<T> {

  public abstract void create(T t) throws Exception;

  public abstract void update(T t, String file);

  public abstract void delete(T t);

  public abstract T read(String s);

}
