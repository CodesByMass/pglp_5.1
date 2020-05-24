package com.main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Mass'
 *
 *         La classe de s�rialisation.
 */
public class Serialization<T extends Serializable> {

  /**
   * M�thode qui ajoute un objet � un fichier, qui sera cr�� si il n'existe pas.
   *
   * @param obj l'objet � ajouter.
   * @param filename le fichier � �crire.
   */
  public void writeFile(T obj, String filename) {


    ObjectOutputStream oos = null;

    try {
      oos = new ObjectOutputStream(
          new BufferedOutputStream(new FileOutputStream(createFile(filename))));

      oos.writeObject(obj);
      oos.flush();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {


      try {
        if (oos != null)
          oos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  /**
   * V�rifie si le fichier existe, le cr�e dans ce cas.
   *
   * @param name nom du fichier.
   * @return le fichier, cr�� si il n'existe pas.
   */
  public File createFile(String filename) {
    File temp = new File(filename);
    if (temp.exists()) {
      temp.delete();
    } else {
      return temp;
    }
    return temp;
  }

  public T readFile(String filename) {

    ObjectInputStream ois = null;
    T temp = null;
    try {
      ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(filename))));
      temp = (T) ois.readObject();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        if (ois != null)
          ois.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return temp;
  }


}
