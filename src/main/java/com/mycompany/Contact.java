/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author bouvr
 */


public class Contact extends javax.swing.JPanel {

    /**
     * Creates new form Contact
     */

    private String [] ListInfos;
    private int id;
    
    public void setId(int tmp) {
        id = tmp;
    }
    public int getId() {
        return id;
    }    
        
    public void setListeInfos(String [] tmp) {
        ListInfos = tmp;
    }
    public String [] getListeInfos() {
        return ListInfos;
    }   
    
    private void AfficheInfos() {
        lblNom.setText(ListInfos[1]);
        lblPrenom.setText(ListInfos[0]);
        AffichePhoto();
        ColoredIdPair();
    }
    
    private void AffichePhoto() {
        ImageIcon iconPhoto = new ImageIcon(ListInfos[2]);   //carte0.png       
        java.awt.Image img = iconPhoto.getImage() ;                             //Transformation en image
        img = img.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH ) ;   //Réduction de 50% en adoucissant
        iconPhoto.setImage(img);
        lblPhoto.setIcon(iconPhoto);
    }
    
    private void SetCouleur(JLabel tmp)   {
        tmp.setBackground(Color.white);
        tmp.setOpaque(true);
    }
    
    private void ColoredIdPair()  {
        if (id % 2 == 0) {
            SetCouleur(lblPhoto);
            SetCouleur(lblNom);
            SetCouleur(lblPrenom);
        }
    }

    public Contact(String [] l_personne, int l_id) {      //String [] personne, int l_id
        initComponents(); 
        
        setListeInfos(l_personne);
        setId(l_id);
        AfficheInfos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPhoto = new javax.swing.JLabel();
        lblPrenom = new javax.swing.JLabel();
        lblNom = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 3));

        lblPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhoto.setPreferredSize(new java.awt.Dimension(80, 60));
        add(lblPhoto);

        lblPrenom.setText("prenom");
        lblPrenom.setPreferredSize(new java.awt.Dimension(150, 60));
        add(lblPrenom);

        lblNom.setText("nom");
        lblNom.setPreferredSize(new java.awt.Dimension(150, 60));
        add(lblNom);
    }// </editor-fold>//GEN-END:initComponents

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblPrenom;
    // End of variables declaration//GEN-END:variables
}
