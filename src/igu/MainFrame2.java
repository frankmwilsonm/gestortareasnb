package igu;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame2 extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    JMenuItem m11;
    JMenuItem m12;
    JMenuItem m19;
    JMenuItem m22;

    public MainFrame2() {
        //Toolkit mipantalla;
        //mipantalla = Toolkit.getDefaultToolkit();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setTitle("Gestor de Tareas");
        setLocationRelativeTo(null);
        //this.getContentPane().setBackground(Color.gray);
        

        initMenu();
        // initForm();
    }
    
        void initMenu() {
        // menu
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Archivo");
        JMenu m2 = new JMenu("Tareas");
        JMenu m3 = new JMenu("Ayuda");
        // 
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);

        m11 = new JMenuItem("Nueva Tarea");
        m11.addActionListener((ActionListener) this);

        m22 = new JMenuItem("Pendientes");
        m22.addActionListener((ActionListener) this);

        m19 = new JMenuItem("Salir");
        m19.addActionListener((ActionListener) this);
        m1.add(m11);
        //m1.add(m11);
        m1.add(m19);

        m2.add(m22);

        // setLayout(null); // null setBounds(x,y, w,h)
        add(BorderLayout.NORTH, mb);
    }
        

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == m11) {
            System.out.println("Menu 1.1  <presionado> ");
            PersonDialog personDialog = new PersonDialog();
            personDialog.setVisible(true);
        }
        if (e.getSource() == m22) {
            System.out.println("Menu 1.2  <presionado> ");
            PendientesDialog PendientesDialog = new PendientesDialog();
            PendientesDialog.setVisible(true);
        }
        if (e.getSource() == m19) {
            System.out.println("Menu 1.3  <presionado> ");
            System.exit(0);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setTitle(String gestor_de_Tareas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
