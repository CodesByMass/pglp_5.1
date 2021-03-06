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
 *
 * Implémente la sérialisation.
 *
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


    // Utilisation de try with resources de Java 7.
    try (FileOutputStream fos = new FileOutputStream(createFile(filename));
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos)) {


      oos.writeObject(obj);
      oos.flush();
    } catch (FileNotFoundException e) {
      throw new Error("Une erreur s'est produite lors de la sérialisation");
    } catch (IOException e) {
      throw new Error("Une erreur s'est produite lors de la sérialisation");
    }
  }



  /**
   * V�rifie si le fichier existe, le cr�e dans ce cas.
   *
   * @param filename nom du fichier.
   * @return le fichier, cr�� si il n'existe pas.
   *
   * @version 1.1
   */
  public File createFile(String filename) {
    File temp = new File(filename);
    if (temp.exists()) {
      if (temp.delete()) {
        System.out.println("Le fichier a été supprimé");
      } else {
        System.out.println("Le fichier n'a pas été supprimé");
      }
    } else {
      return temp;
    }
    return temp = new File(filename);
  }

  /**
   * Lit le fichier pour extraire un objet.
   *
   * @param filename Nom du fichier � lire
   * @return l'pobjet lu, si il existe
   */
  public T readFile(String filename) {

    ObjectInputStream ois = null;
    T temp = null;
    try {
      ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(filename))));
      temp = (T) ois.readObject();
    } catch (FileNotFoundException e) {
      throw new Error("Ce fichier n'existe pas");
    } catch (IOException e) {
      throw new Error("Une erreur s'est produite lors de la sérialisation");
    } catch (ClassNotFoundException e) {
      throw new Error("Une erreur s'est produite lors de la sérialisation");
    } finally {
      try {
        if (ois != null) {
          ois.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return temp;
  }


}
