package Huffman;

public class Main {
    public static void main(String[] args) {
        // Example text to encode and decode
        Huffman huffman = new Huffman("aaaaaaaabbbbbbbccccdd");

        String encodedText = huffman.encode();
        System.out.println(encodedText);

        huffman.printCodes();

        String originalText = huffman.decode(encodedText);
        System.out.println(originalText);
    }
}
