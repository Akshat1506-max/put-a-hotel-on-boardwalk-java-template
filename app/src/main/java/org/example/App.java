package org.example;

public class App {
    private Node current;
    private int size;
    
    private class Node {
        String data;
        Node next;
        
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public App() {
        current = null;
        size = 0;
        initializeBoard();
    }

    // Keep original method for test to pass
    public String getGreeting() {
        return "Hello World!";
    }
    
    private void initializeBoard() {
        append("Go");
        append("Mediterranean Avenue");
        append("Community Chest");
        append("Baltic Avenue");
        append("Income Tax");
    }
    
    public void append(String data) {
        Node newNode = new Node(data);
        
        if (current == null) {
            current = newNode;
            current.next = current;  // Point to itself
        } else {
            Node temp = current;
            while (temp.next != current) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = current;
        }
        size++;
    }
    
    public String getCurrentSpace() {
        if (current == null) {
            throw new IllegalStateException("Board is empty");
        }
        return current.data;
    }
    
    public void step() {
        if (current != null) {
            current = current.next;
        }
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.getGreeting());
        
        // Test the board
        System.out.println("Starting at: " + app.getCurrentSpace());
        app.step();
        System.out.println("After one step: " + app.getCurrentSpace());
    }
}