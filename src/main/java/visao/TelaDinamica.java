package visao;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author gusta
 */
public class TelaDinamica extends javax.swing.JFrame {

    GridBagLayout layout = new GridBagLayout();
    protected static TelaLogin login;
    protected static TelaCadastro cadastro;
    protected static TelaHome home;
    protected static TelaPerfil perfil;

    public TelaDinamica() {
        initComponents();

        setTitle("Biblioteca Pessoal");

        login = TelaLogin.getTelaLogin();
        cadastro = TelaCadastro.getTelaCadastro();
        home = TelaHome.getTelaHome();
        perfil = TelaPerfil.getTelaPerfil();

        setLayout(layout);
        
        GridBagConstraints constante = new GridBagConstraints();
        constante.gridx = 0;
        constante.gridy = 0;

        add(login, constante);
        add(cadastro, constante);
        add(home, constante);
        add(perfil, constante);

        login.setVisible(true);
        cadastro.setVisible(false);
        home.setVisible(false);
        perfil.setVisible(false);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 500));
        setPreferredSize(new java.awt.Dimension(600, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 689, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
