package com.kodilla.good.patterns.challenges.food2door;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class UserInterface extends JFrame implements MessageService{

    private FoodOnlineStore foodOnlineStore;
    private JTextArea outputTextArea;
    private JPanel controlPanel;
    private JScrollPane controlPanelScrollPane;
    private JButton closeStore;
    private JButton sendNewOrder;
    private JButton sendNewCustomOrder;
    private JPanel changeFontPanel;
    private JButton changeFontSizeButton;
    private JSlider changeFontSizeSlider;

    public UserInterface(FoodOnlineStore foodOnlineStore) {

        this.foodOnlineStore = foodOnlineStore;

        this.setTitle("Food Online Store");
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(650, 400));
        this.setLocation(100,100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        outputTextArea = new JTextArea(30,60);
        outputTextArea.setEditable(false);
        outputTextArea.setFont(outputTextArea.getFont().deriveFont(16f));
        this.getContentPane().add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

        controlPanel = new JPanel(new FlowLayout());
        controlPanel.setPreferredSize(new Dimension(0, 80));

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

        changeFontPanel = new JPanel();
        changeFontSizeSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 40, 20);
        changeFontPanel.add(changeFontSizeSlider);
        changeFontSizeButton = new JButton("Change font size");
        changeFontSizeButton.addActionListener(event -> {
            this.outputTextArea.setFont(
                this.outputTextArea.getFont().deriveFont((float)changeFontSizeSlider.getValue())
            );
        });
        changeFontPanel.add(changeFontSizeButton);
        controlPanel.add(changeFontPanel);

        controlPanelScrollPane = new JScrollPane(controlPanel);
        controlPanelScrollPane.setMinimumSize(new Dimension(0, 80));
        this.getContentPane().add(controlPanel, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void acceptMessage(String message) {
        this.outputTextArea.append(message + String.format("%n"));
        this.outputTextArea.setCaretPosition(this.outputTextArea.getDocument().getLength());
    }

    private FoodOrder getSampleFoodOrder() {
        return new FoodOrder("Sample Customer", "Sample Product", 2,
                foodOnlineStore.getFoodSuppliers().get(0));
    }

    private class NewOrderFrame extends JFrame {
        private JLabel customerLabel = new JLabel("Customer: ");
        private JTextField customerField = new JTextField("", 30);
        private JPanel customerPanel = new JPanel();

        private JLabel productLabel = new JLabel("Product: ");
        private JTextField productField = new JTextField("", 30);
        private JPanel productPanel = new JPanel();

        private JLabel quantityLabel = new JLabel("Quantity: ");
        JSlider quantitySlider = new JSlider(JSlider.HORIZONTAL,1, 10, 1);
        private JPanel quantityPanel = new JPanel();

        private JLabel supplierLabel = new JLabel("Supplier: ");
        private JComboBox<String> supplierField;
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
            quantitySlider.setMinorTickSpacing(1);
            quantitySlider.setMajorTickSpacing(2);
            quantitySlider.setPaintTicks(true);
            quantitySlider.setPaintLabels(true);
            quantityPanel.add(quantitySlider);

            Map<String, FoodSupplier> supplierNameToSupplier = new HashMap<>();
            foodOnlineStore.getFoodSuppliers().stream().forEach(supplier -> {
                supplierNameToSupplier.put(supplier.getFoodSupplierName(), supplier);
            });
            String[] supplierNames = supplierNameToSupplier.keySet().toArray(new String[]{});
            supplierField = new JComboBox<>(supplierNames);
            supplierPanel.add(supplierLabel);
            supplierPanel.add(supplierField);

            sendOrderButton.addActionListener((e) -> {
                foodOnlineStore.acceptNewOrder(new FoodOrder(
                        customerField.getText(),
                        productField.getText(),
                        quantitySlider.getValue(),
                        supplierNameToSupplier.get(supplierField.getItemAt(supplierField.getSelectedIndex()))));
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
