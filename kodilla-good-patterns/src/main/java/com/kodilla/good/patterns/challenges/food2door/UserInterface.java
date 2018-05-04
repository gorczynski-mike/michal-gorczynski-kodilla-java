package com.kodilla.good.patterns.challenges.food2door;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame implements MessageService{

    private FoodOnlineStore foodOnlineStore;
    private JTextArea outputTextArea;
    private JPanel controlPanel;
    private JButton closeStore;
    private JButton sendNewOrder;

    public UserInterface(FoodOnlineStore foodOnlineStore) {

        this.foodOnlineStore = foodOnlineStore;

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

        sendNewOrder = new JButton("Send new order to the store");
        sendNewOrder.addActionListener(event -> foodOnlineStore.acceptNewOrder(getSampleFoodOrder())
        );
        controlPanel.add(sendNewOrder);

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
}
