package Huffmanv2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Node class to represent tree nodes
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

public class HuffmanCode {

    // Function to build Huffman tree
    public static void createHuffmanTree(String text) {
        if (text == null || text.length() == 0)
            return;

        // Count character frequencies
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Priority queue to store tree nodes
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.freq));
        for (var entry : freq.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Build Huffman tree
        while (pq.size() != 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            int sum = left.freq + right.freq;
            pq.add(new Node(null, sum, left, right));
        }

        // Root of Huffman tree
        Node root = pq.peek();

        // Store Huffman codes in a map
        Map<Character, String> huffmanCode = new HashMap<>();
        encodeData(root, "", huffmanCode);

        // Print Huffman codes
        System.out.println("Huffman Codes: " + huffmanCode);

        // Encode the input text
        System.out.println("Original Text: " + text);
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(huffmanCode.get(c));
        }
        System.out.println("Encoded Text: " + sb);

        // Decode the encoded text
        System.out.print("Decoded Text: ");
        if (isLeaf(root)) {
            while (root.freq-- > 0) {
                System.out.print(root.ch);
            }
        } else {
            int index = -1;
            while (index < sb.length() - 1) {
                index = decodeData(root, index, sb);
            }
        }
    }

    // Encode data and store Huffman codes
    public static void encodeData(Node root, String str, Map<Character, String> huffmanCode) {
        if (root == null)
            return;
        if (isLeaf(root)) {
            huffmanCode.put(root.ch, str.length() > 0 ? str : "1");
        }
        encodeData(root.left, str + '0', huffmanCode);
        encodeData(root.right, str + '1', huffmanCode);
    }

    // Decode encoded data
    public static int decodeData(Node root, int index, StringBuilder sb) {
        if (root == null)
            return index;
        if (isLeaf(root)) {
            System.out.print(root.ch);
            return index;
        }
        index++;
        root = (sb.charAt(index) == '0') ? root.left : root.right;
        index = decodeData(root, index, sb);
        return index;
    }

    // Check if a node is a leaf
    public static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    // Main method
    public static void main(String args[]) {
        String text = "javatpoint";
        createHuffmanTree(text);
    }
}
