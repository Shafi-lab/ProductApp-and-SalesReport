/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productapp;

/**
 *
 * @author Student
 */
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class ProductApp extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    public ProductApp() {
        setTitle("Product App");
        setSize(420, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        processItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processSale();
            }
        });

        clearItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        editMenu.add(processItem);
        editMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);

        // Labels and Input Fields
        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(30, 25, 120, 25);
        add(lblCustomer);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(160, 25, 210, 25);
        add(txtCustomerName);

        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(30, 65, 120, 25);
        add(lblProduct);

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        cmbProduct = new JComboBox<>(products);
        cmbProduct.setBounds(160, 65, 210, 25);
        add(cmbProduct);

        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(30, 105, 120, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(160, 105, 210, 25);
        add(txtPrice);

        // Process Button
        btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(160, 150, 210, 30);
        btnProcess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processSale();
            }
        });
        add(btnProcess);
    }

    private void processSale() {
        String customerName = txtCustomerName.getText().trim();
        String productName = cmbProduct.getSelectedItem().toString();
        String priceInput = txtPrice.getText().trim();

        if (customerName.isEmpty() || priceInput.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        try {
            double price = Double.parseDouble(priceInput);
            double vat = price * 0.15;
            double commission = price * 0.05;
            double total = price + vat + commission;

            String message = "Customer Name: " + customerName + "\n"
                           + "Product: " + productName + "\n"
                           + "VAT: R " + vat + "\n"
                           + "COMMISSION: R " + commission + "\n"
                           + "TOTAL: R " + total;

            // Display message popup
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save details to data.txt
            saveToFile(message);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price.");
        }
    }

    private void saveToFile(String info) {
        try {
            FileWriter writer = new FileWriter("data.txt", true);
            writer.write("DATA LOG\n");
            writer.write("*******************************\n");
            writer.write(info + "\n");
            writer.write("*******************************\n\n");
            writer.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving to data.txt");
        }
    }

    private void clearForm() {
        txtCustomerName.setText("");
        cmbProduct.setSelectedIndex(0);
        txtPrice.setText("");
    }

    public static void main(String[] args) {
        ProductApp form = new ProductApp();
        form.setVisible(true);
    }
}
