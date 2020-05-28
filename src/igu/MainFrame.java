package igu;

//import data.PersonData;
//import entities.Person;
import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.List;
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.UIManager;
//import javax.swing.plaf.synth.SynthLookAndFeel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L;
    JMenuItem m11;
    JMenuItem m12;
    JMenuItem m19;
    JMenuItem m22;

    public MainFrame() {
        //Toolkit mipantalla;
        //mipantalla = Toolkit.getDefaultToolkit();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setTitle("Gestor de Tareas");
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.gray);
        
        

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
        m11.addActionListener(this);

        m22 = new JMenuItem("Pendientes");
        m22.addActionListener(this);

        m19 = new JMenuItem("Salir");
        m19.addActionListener(this);
        m1.add(m11);
        //m1.add(m11);
        m1.add(m19);

        m2.add(m22);

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

}
