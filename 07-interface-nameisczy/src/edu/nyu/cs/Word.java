package edu.nyu.cs;

import java.util.ArrayList;

public class Word extends OrderedThing implements SequentiallyOrdered {
    private ArrayList<Character> characters;
    private int position;

    public Word(String s, int position) {
        this.characters = new ArrayList<>();
        for (char c : s.toCharArray()) {
            this.characters.add(new Character(c));
        }
        this.position = position;
    }
    public int getPosition() {
        return position;
    }
    public OrderedThing getFirst() {
        return characters.get(0);
    }
    public OrderedThing getLast() {
        return characters.get(characters.size() - 1);
    }
    public ArrayList<OrderedThing> getSequence() {
        ArrayList<OrderedThing> sequence = new ArrayList<>();
        sequence.addAll(characters);
        return sequence;
    }
}
