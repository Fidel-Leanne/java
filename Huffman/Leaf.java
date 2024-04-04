
package Huffman;

public class Leaf extends Node {

    private final char character;

    public Leaf(char character, int frequency) {
        super(null, null); // Leaf nodes don't have children
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
