package edu.nyu.cs;

import java.util.ArrayList;

public class Character extends OrderedThing {
    private char character;
    public Character(char c) {
        this.character = c;
    }
    public char getCharacter() {
        return character;
    }
    public OrderedThing getFirst() {
        return this;
    }
    public OrderedThing getLast() {
        return this;
    }
    public ArrayList<OrderedThing> getSequence() {
        ArrayList<OrderedThing> sequence = new ArrayList<>();
        sequence.add(this);
        return sequence;
    }
}
