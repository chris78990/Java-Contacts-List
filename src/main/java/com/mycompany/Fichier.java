/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

/**
 *
 * @author bouvr
 */
public class Fichier {
    private java.io.BufferedWriter fW;
    private java.io.BufferedReader fR;
    private String urlFichier;
    
    public void setUrlFichier(String tmp) {
        urlFichier = tmp;
    }
    
    public boolean OpenReadByLine(String nf) {
        //Ligne par ligne
        try 
        {
            setUrlFichier(nf);
            File f = new File(urlFichier);
            fR = new java.io.BufferedReader(new FileReader(f));
            fW = null;
            return true;
        }
        catch (IOException e) 
        {
            System.err.println("Erreur à l'ouverture de fichier en lecture");
            return false;
        }
        
    }
    
    public boolean OpenWriteByLine(String nf) {
        //Ligne par ligne
        try 
        {
            setUrlFichier(nf);
            File f = new File(urlFichier);
            fR = null;
            fW = new java.io.BufferedWriter(new FileWriter(f));
            return true;
        }
        catch (IOException e) 
        {
            System.err.println("Erreur à l'ouverture de fichier en écriture");
            return false;
        }
    }
    
    
    public boolean ecrire(String tmp) {
        try 
        {
            if (tmp != null)   {
                fW.write(tmp,0,tmp.length());
                fW.newLine();
            }
            return true;
        }
        catch (IOException err) 
        {
            System.err.println(urlFichier+" : Erreur d'écriture ");
            return false;
        }
       }	    
    
    
    public String Lire()   {
        try
        {
         String Chaine = fR.readLine();
         return Chaine;
        }
        catch (IOException e)
        {
            System.err.println("Erreur de lecture");
            return null;
        }

    }
    

    
    
    
    public String[] ExtractData(String tmp) {
        
        if (tmp == null) {  return null;}
            
        StringTokenizer st = new StringTokenizer(tmp, ";");
        String Mots[] = new String[st.countTokens()];
        int i = 0;
        while(st.hasMoreTokens()) {
            Mots[i] = st.nextToken();
            i++;
        }
        return Mots;
    }
    
    
    public boolean fermer()  {
        try 
        {
            if (fR != null) fR.close();
            else  if (fW != null) fW.close();
            return true;
        }
        catch (IOException err) 
        {
            System.err.println(urlFichier+" : Erreur à la fermeture ");
            return false;
        }
    }
        
    
}
