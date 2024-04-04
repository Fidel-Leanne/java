package Huffmanv2;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class Node {
    Character ch;
    Integer freq;
    Node left = null;
    Node right = null;

    Node(Character ch, Integer freq) {
        this.ch = ch;
        this.freq = freq;
    }

    public Node(Character ch, Integer freq, Node left, Node right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

public class HuffmanTreeGUI extends JFrame {
    private Map<Character, String> huffmanCode;

    public HuffmanTreeGUI(Map<Character, String> huffmanCode) {
        this.huffmanCode = huffmanCode;

        setTitle("Huffman Tree Visualization");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HuffmanTreePanel treePanel = new HuffmanTreePanel(huffmanCode);
        JScrollPane scrollPane = new JScrollPane(treePanel);
        add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Example Huffman codes
        Map<Character, String> huffmanCode = new HashMap<>();
        huffmanCode.put('a', "01");
        huffmanCode.put('b', "001");
        huffmanCode.put('c', "000");
        huffmanCode.put('d', "1");

        SwingUtilities.invokeLater(() -> new HuffmanTreeGUI(huffmanCode));
    }
}

class HuffmanTreePanel extends JPanel {
    private Map<Character, String> huffmanCode;
    private Node root;

    public HuffmanTreePanel(Map<Character, String> huffmanCode) {
        this.huffmanCode = huffmanCode;
        buildTree();
    }

    private void buildTree() {
        root = new Node(null, null);
        for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
            addNode(root, entry.getKey(), entry.getValue());
        }
    }

    private void addNode(Node root, char ch, String code) {
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '0') {
                if (root.left == null) {
                    root.left = new Node(null, null);
                }
                root = root.left;
            } else {
                if (root.right == null) {
                    root.right = new Node(null, null);
                }
                root = root.right;
            }
        }
        root.ch = ch;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTree(g, getWidth() / 2, 20, 200, 0, root);
    }

    private void drawTree(Graphics g, int x, int y, int spread, double angle, Node node) {
        if (node == null)
            return;

        g.setColor(Color.BLACK);

        // Draw current node
        g.drawOval(x - 10, y - 10, 20, 20);
        g.drawString(node.ch.toString(), x - 5, y + 5);

        // Draw lines to children
        int xLeft = x + (int) (Math.cos(angle - Math.PI / 4) * spread);
        int yLeft = y + (int) (Math.sin(angle - Math.PI / 4) * spread);
        int xRight = x + (int) (Math.cos(angle + Math.PI / 4) * spread);
        int yRight = y + (int) (Math.sin(angle + Math.PI / 4) * spread);

        g.drawLine(x, y, xLeft, yLeft);
        g.drawLine(x, y, xRight, yRight);

        // Draw children
        drawTree(g, xLeft, yLeft, spread / 2, angle - Math.PI / 4, node.left);
        drawTree(g, xRight, yRight, spread / 2, angle + Math.PI / 4, node.right);
    }
}
