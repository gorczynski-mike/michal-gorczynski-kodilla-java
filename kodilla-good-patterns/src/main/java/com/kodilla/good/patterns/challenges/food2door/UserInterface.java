package com.kodilla.good.patterns.challenges.food2door;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame implements MessageService{

    private FoodOnlineStore foodOnlineStore;
    private JTextArea outputTextArea;
    private JPanel controlPanel;
    private JButton closeStore;
    private JButton sendNewOrder;
    private JButton sendNewCustomOrder;

    public UserInterface(FoodOnlineStore foodOnlineStore) {

        this.foodOnlineStore = foodOnlineStore;

        this.setTitle("Food Online Store");
        this.setLayout(new BorderLayout());
        this.setSize(500, 500);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        outputTextArea = new JTextArea(30,60);
        outputTextArea.setEditable(false);
        this.getContentPane().add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

        controlPanel = new JPanel(new FlowLayout());

        closeStore = new JButton("Close the store");
        closeStore.addActionListener(event -> foodOnlineStore.stopOperating());
        controlPanel.add(closeStore);

        sendNewOrder = new JButton("Send new default order to the store");
        sendNewOrder.addActionListener(event -> foodOnlineStore.acceptNewOrder(getSampleFoodOrder())
        );
        controlPanel.add(sendNewOrder);

        sendNewCustomOrder = new JButton("Send new custom order to the store");
        sendNewCustomOrder.addActionListener(event -> new NewOrderFrame());
        controlPanel.add(sendNewCustomOrder);

        this.getContentPane().add(new JScrollPane(controlPanel), BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void acceptMessage(String message) {
        this.outputTextArea.append(message + String.format("%n"));
        this.outputTextArea.setCaretPosition(this.outputTextArea.getDocument().getLength());
    }

    private FoodOrder getSampleFoodOrder() {
        return new FoodOrder("A", "A", 2, new ExtraFoodShop());
    }

    private class NewOrderFrame extends JFrame {
        private JLabel customerLabel = new JLabel("Customer: ");
        private JTextField customerField = new JTextField("Customer name", 30);
        private JPanel customerPanel = new JPanel();

        private JLabel productLabel = new JLabel("Product: ");
        private JTextField productField = new JTextField("Product name", 30);
        private JPanel productPanel = new JPanel();

        private JLabel quantityLabel = new JLabel("Quantity: ");
        private JComboBox<Integer> quantityField = new JComboBox<>(new Integer[] {1,2,3,4,5,6,7,8,9,10});
        private JPanel quantityPanel = new JPanel();

        private JLabel supplierLabel = new JLabel("Supplier: ");
        private JComboBox<GenericFoodSupplier> supplierField = new JComboBox<>(foodOnlineStore.getFoodSuppliers().toArray(new GenericFoodSupplier[]{}));
        private JPanel supplierPanel = new JPanel();

        private JButton sendOrderButton = new JButton("Send order");
        private JButton closeButton = new JButton("Close");
        private JPanel buttons = new JPanel();


        private NewOrderFrame() {

            customerPanel.add(customerLabel);
            customerPanel.add(customerField);
            productPanel.add(productLabel);
            productPanel.add(productField);
            quantityPanel.add(quantityLabel);
            quantityPanel.add(quantityField);
            supplierPanel.add(supplierLabel);
            supplierPanel.add(supplierField);

            sendOrderButton.addActionListener((e) -> {
                foodOnlineStore.acceptNewOrder(new FoodOrder(
                        customerField.getText(),
                        productField.getText(),
                        quantityField.getItemAt(quantityField.getSelectedIndex()),
                        supplierField.getItemAt(supplierField.getSelectedIndex())));
            });
            closeButton.addActionListener(e -> this.dispose());
            buttons.add(sendOrderButton);
            buttons.add(closeButton);

            this.setSize(200, 200);
            this.setLocation(200, 200);
            this.setTitle("New custom order");
            this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
            this.add(customerPanel);
            this.add(productPanel);
            this.add(quantityPanel);
            this.add(supplierPanel);
            this.add(buttons);
            this.pack();
            this.setResizable(false);
            this.setVisible(true);
        }
    }

}
