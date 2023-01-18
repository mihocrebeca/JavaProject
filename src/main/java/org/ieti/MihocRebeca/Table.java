package org.ieti.MihocRebeca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.RED;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Table {


    public void buildTable(String[][] content, String[] headers) {
        JFrame container = new JFrame("Work");
        container.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTable table = new JTable(content, headers);
        JTableHeader tableHeader=table.getTableHeader();
        tableHeader.setBackground(Color.PINK);
        


        table.setCellSelectionEnabled(true);


        ListSelectionListenerImpl listSelectionListener = new ListSelectionListenerImpl(table);

        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        select.addListSelectionListener(listSelectionListener);

        DefaultTableModel model=new DefaultTableModel(content,headers);
        table.setModel(model);

        table.setBackground(Color.orange);
        table.setGridColor(RED);


        JPanel buttonPanel=new JPanel();
        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(table),BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        panel.setBackground(Color.DARK_GRAY);
        panel.setVisible(true);

        JButton addButton=new JButton("ADD");
        addButton.setBackground(Color.GREEN);
        JButton deleteButton=new JButton("DELETE");
        deleteButton.setBackground(Color.WHITE);
        JButton updateButton=new JButton("UPDATE");
        updateButton.setBackground(Color.yellow);
        JButton exitButton=new JButton("EXIT");
        exitButton.setBackground(Color.LIGHT_GRAY);


        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(exitButton);

        buttonPanel.setBackground(Color.cyan);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        buttonPanel.setVisible(true);
        panel.add(buttonPanel,BorderLayout.SOUTH);


        JFrame frame=new JFrame("Employees");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField nameField=new JTextField(15);
                JTextField lastField=new JTextField(15);
                JTextField departField=new JTextField(15);
                JTextField idField=new JTextField(15);
                JTextField emailField=new JTextField(20);
                JButton saveButton=new JButton("SAVE");
                saveButton.setBackground(Color.green);
                JButton closeButton=new JButton("CLOSE");
                closeButton.setBackground(RED);

                JPanel inputPanel=new JPanel();
                inputPanel.setLayout(new BoxLayout(inputPanel,BoxLayout.PAGE_AXIS));
                inputPanel.add(new JLabel("First Name"));
                inputPanel.add(nameField);
                inputPanel.add(new JLabel("Last Name"));
                inputPanel.add(lastField);
                inputPanel.add(new JLabel("Department"));
                inputPanel.add(departField);
                inputPanel.add(new JLabel("ID"));
                inputPanel.add(idField);
                inputPanel.add(new JLabel("Email"));
                inputPanel.add(emailField);
                inputPanel.add(saveButton);
                inputPanel.add(closeButton);

                JFrame inputFrame=new JFrame("Add a Employee");
                inputFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                inputFrame.add(inputPanel);
                inputFrame.pack();
                inputFrame.setVisible(true);

                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name= nameField.getText();
                        String last= lastField.getText();
                        String department=departField.getText();
                        String id= idField.getText();
                        String email=emailField.getText();

                        DefaultTableModel model=(DefaultTableModel) table.getModel();
                        model.addRow(new String[]{name, last,department,id, email});
                        JOptionPane.showMessageDialog(null,"Data successfully added!");

                        inputFrame.dispose();
                    }
                });
                closeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);

                    }
                });


            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow=table.getSelectedRow();
                if(selectedRow !=-1){
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(null,"Row successfully deleted!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please select a row");

                }



            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model=(DefaultTableModel) table.getModel();
                int selectedRowIndex=table.getSelectedRow();
                String name=model.getValueAt(selectedRowIndex,0).toString();
                String last=model.getValueAt(selectedRowIndex,1).toString();
                String department=model.getValueAt(selectedRowIndex,2).toString();
                String id=model.getValueAt(selectedRowIndex,3).toString();
                String email=model.getValueAt(selectedRowIndex,4).toString();

                String NewName=JOptionPane.showInputDialog(null,"Enter new  first name",name);
                String NewLastName=JOptionPane.showInputDialog(null,"Enter new last name",last);
                String NewDepartment=JOptionPane.showInputDialog(null,"Enter new department",department);
                String NewId=JOptionPane.showInputDialog(null,"Enter new id",id);
                String NewEmail=JOptionPane.showInputDialog(null,"Enter new email",email);

                model.setValueAt(NewName,selectedRowIndex,0);
                model.setValueAt(NewLastName,selectedRowIndex,1);
                model.setValueAt(NewDepartment,selectedRowIndex,2);
                model.setValueAt(NewId,selectedRowIndex,3);
                model.setValueAt(NewEmail,selectedRowIndex,4);

                JOptionPane.showMessageDialog(null,"Row successfully updated!");





            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });





    }




}


