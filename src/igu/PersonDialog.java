package igu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import data.PersonData;
import entities.Person;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PersonDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    JTextField fromField = new JTextField(30);
    JTextField toField = new JTextField(30);
    JTextField toFieldHora = new JTextField(30);

    JButton goButton = new JButton("Back");
    JButton addButton = new JButton("Agregar Tarea");
    JButton delButton = new JButton("Eliminar Tarea");
    JTable jTable;
    JScrollPane jSP;
    PersonData personData = new PersonData();

    public PersonDialog() {
        setSize(420, 500);
        setTitle("Tarea Nueva");
        setLocationRelativeTo(null);
        initForm();
        paintTable();
        getContentPane().setBackground(Color.gray);
        setIconImage();
    }

    private void paintTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        List<Person> lis = personData.list();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        for (Person d : lis) {
            modelo.addRow(new Object[]{d.getId(), d.getName(), d.getSex(), d.getHora()});
        }
    }

    void initForm() {

        jTable = new JTable();
        jTable.setModel(new DefaultTableModel(new Object[][]{ // { 1, 2 },
        // { 3, 4 }
        }, new String[]{"ID", "Tarea", "Fecha", "Hora"}));
        jSP = new JScrollPane();
        jSP.setViewportView(jTable);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Nombre de Tarea:"));
        add(fromField);
        add(new JLabel("Fecha a Entregar:"));

        add(toField);

        add(new JLabel("Hora a Entregar:"));

        add(toFieldHora);

        add(addButton);
        add(delButton);
        add(jSP);
        add(goButton);

        // Manejo de eventos
        final JDialog outer = this;
        goButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println(" goButton has press ");
                dispose();
            }
        });
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPerson(e);
            }
        });
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delPerson(e);
            }
        });

    }

    void addPerson(ActionEvent e) {

        if (fromField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Asegurate de rellenar todos los campos");
            System.out.println(" Agregar.Button <presionado> ");
            Person d = new Person();
            d.setName(fromField.getText());
            d.setSex(toField.getText());
            d.setHora(toFieldHora.getText());
            personData.create(d);
            paintTable();
        } else if (this.toField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Asegurate de rellenar todos los campos");
            System.out.println(" Agregar.Button <presionado> ");
            Person d = new Person();
            d.setName(fromField.getText());
            d.setSex(toField.getText());
            d.setHora(toFieldHora.getText());
            personData.create(d);
            paintTable();
            
        } else if (this.toFieldHora.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Asegurate de rellenar todos los campos");
            System.out.println(" Agregar.Button <presionado> ");
            Person d = new Person();
            d.setName(fromField.getText());
            d.setSex(toField.getText());
            d.setHora(toFieldHora.getText());
            personData.create(d);
            paintTable();

        } else {
            System.out.println(" Agregar.Button <presionado> ");
            Person d = new Person();
            d.setName(fromField.getText());
            d.setSex(toField.getText());
            d.setHora(toFieldHora.getText());
            personData.create(d);
            paintTable();
        }

    }

    void delPerson(ActionEvent e) {
        if (jTable.getSelectedRow() != -1) {
            System.out.println(" Eliminar.Button <presionado> ");
            int[] row = jTable.getSelectedRows();
            String ids = jTable.getValueAt(row[0], 0).toString();
            System.out.println("Se seleccionó: " + ids);
            int id = Integer.parseInt(ids);
            personData.delete(id);
            paintTable();
        }
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("favicon.png")));
        
    }
}
