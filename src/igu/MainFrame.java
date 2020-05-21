package igu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    JMenuItem m11;
    JMenuItem m12;
    JMenuItem m19;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setTitle("Gestor de Tareas");
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.gray);
        initMenu();
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/favicon.png")));
    }

    void initMenu() {
        // menu
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Archivo");
        JMenu m2 = new JMenu("Administrar");
        JMenu m3 = new JMenu("Resumen");
        
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);

        m11 = new JMenuItem("Tarea");
        m11.addActionListener(this);
        
        m12 = new JMenuItem("Curso");
      
        m19 = new JMenuItem("Salir");
        m19.addActionListener(this);
        m1.add(m11);
        m1.add(m12);
        m1.add(m19);

    
        // setLayout(null); // null setBounds(x,y, w,h)
        add(BorderLayout.NORTH, mb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == m11) {
            System.out.println("Menu 1.1  <presionado> ");
            PersonDialog personDialog = new PersonDialog();
            personDialog.setVisible(true);
        }
        if (e.getSource() == m19) {
            System.out.println("Acabas de cerrar App ");
            System.exit(0);
        }
    }

    

}
