package igu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import data.PersonData;
import entities.Person;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

    public class PendientesDialog extends JDialog {
    private static final long serialVersionUID = 1L;

    JButton goButton = new JButton("Back");

    
    JTable jTable;
    JScrollPane jSP;
    PersonData personData = new PersonData();

    public PendientesDialog() {
        setSize(380, 500);
        setTitle("Tareas Pendientes");
        setLocationRelativeTo(null);

        initForm();
        paintTable();
    }

    private void paintTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        List<Person> lis = personData.list();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        for (Person d : lis) {
            modelo.addRow(new Object[]{d.getId(), d.getName(), d.getSex()});
        }
    }

    void initForm() {

        jTable = new JTable();
        jTable.setModel(new DefaultTableModel(new Object[][]{ // { 1, 2 },
        // { 3, 4 }
        }, new String[]{"ID", "Nombre", "Fecha"}));
        jSP = new JScrollPane();
        jSP.setViewportView(jTable);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        // add(new JLabel("Nombre de Tarea:"));
        // add(fromField);
        // add(new JLabel("Fecha a Entregar:"));
        //add(toField);
        //add(addButton);
        //add(delButton);
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
       /* addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPerson(e);
            }
        }); */
       /* delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delPerson(e);
            }
        }); */

    }

   /* void addPerson(ActionEvent e) {

        if (fromField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Asegurate de rellenar los campos");
        } else if (this.toField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Asegurate de rellenar los campos");
        } else {
            System.out.println(" Agregar.Button <presionado> ");
            Person d = new Person();
            d.setName(fromField.getText());
            d.setSex(toField.getText());
            personData.create(d);
            paintTable();
        }

    } */

   /* void delPerson(ActionEvent e) {
        if (jTable.getSelectedRow() != -1) {
            System.out.println(" Eliminar.Button <presionado> ");
            int[] row = jTable.getSelectedRows();
            String ids = jTable.getValueAt(row[0], 0).toString();
            System.out.println("Se seleccionó: " + ids);
            int id = Integer.parseInt(ids);
            personData.delete(id);
            paintTable();
        }
    } */
}
