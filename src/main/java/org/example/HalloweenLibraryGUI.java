package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HalloweenLibraryGUI {
    private Library library;
    private ShoppingCart cart;

    public HalloweenLibraryGUI(Library library, ShoppingCart cart) {
        this.library = library;
        this.cart = cart;
        createGUI();
    }

    private void createGUI() {
        // Main frame
        JFrame frame = new JFrame("👻 Haunted Library 👻");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Main panel with dark theme
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(new GridLayout(4, 1, 10, 10));

        // Buttons
        JButton btnAvailable = new JButton("Show Available Books");
        JButton btnCart = new JButton("Cart / Checkout");
        JButton btnCheckedOut = new JButton("Show Checked Out Books");
        JButton btnExit = new JButton("Exit");

        // Customize buttons for Halloween theme
        JButton[] buttons = {btnAvailable, btnCart, btnCheckedOut, btnExit};
        for (JButton btn : buttons) {
            btn.setFont(new Font("Chiller", Font.BOLD, 24));
            btn.setForeground(Color.ORANGE);
            btn.setBackground(Color.BLACK);
            btn.setFocusPainted(false);

            // Hover effect
            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    btn.setForeground(Color.GREEN); // spooky glow
                }

                public void mouseExited(MouseEvent e) {
                    btn.setForeground(Color.ORANGE);
                }
            });
        }

        // Add buttons to panel
        mainPanel.add(btnAvailable);
        mainPanel.add(btnCart);
        mainPanel.add(btnCheckedOut);
        mainPanel.add(btnExit);

        frame.add(mainPanel);
        frame.setVisible(true);

        // Button actions
        btnAvailable.addActionListener(e -> showAvailableBooks());
        btnCart.addActionListener(e -> showCart());
        btnCheckedOut.addActionListener(e -> showCheckedOutBooks());
        btnExit.addActionListener(e -> System.exit(0));
    }

    private void showAvailableBooks() {
        JFrame frame = new JFrame("Available Books");
        frame.setSize(600, 400);
        frame.setBackground(Color.BLACK);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.ORANGE);
        textArea.setFont(new Font("Courier", Font.BOLD, 16));

        for (Book book : library.getBooks()) {
            if (book.isCheckedIn()) {
                textArea.append(book.getId() + ") " + book.getTitle() + " [" + book.getCategory() + "]\n");
            }
        }

        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }

    private void showCart() {
        JFrame frame = new JFrame("Your Cart");
        frame.setSize(600, 400);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.ORANGE);
        textArea.setFont(new Font("Courier", Font.BOLD, 16));

        for (Book book : cart.getCartItems()) {
            textArea.append(book.getTitle() + " [" + book.getCategory() + "]\n");
        }

        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }

    private void showCheckedOutBooks() {
        JFrame frame = new JFrame("Checked Out Books");
        frame.setSize(600, 400);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.ORANGE);
        textArea.setFont(new Font("Courier", Font.BOLD, 16));

        for (Book book : library.getBooks()) {
            if (book.isCheckedOut()) {
                textArea.append(book.getTitle() + " [" + book.getCategory() + "]\n");
            }
        }

        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Library library = new Library();
        ShoppingCart cart = new ShoppingCart();
        new HalloweenLibraryGUI(library, cart);
    }
}
