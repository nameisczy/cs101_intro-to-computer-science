package edu.nyu.cs;

import java.util.ArrayList;

public class Sentence implements SequentiallyOrdered {
    private ArrayList<Word> words;
    public Sentence(String s) {
        this.words = new ArrayList<>();
        String[] wordStrings = s.split("[^\\w']+");
        for (int i = 0; i < wordStrings.length; i++) {
            words.add(new Word(wordStrings[i], i));
        }
    }
    public OrderedThing getFirst() {
        return words.get(0);
    }
    public OrderedThing getLast() {
        return words.get(words.size() - 1);
    }
    public ArrayList<OrderedThing> getSequence() {
        ArrayList<OrderedThing> sequence = new ArrayList<>();
        for (Word w : words) {
            sequence.add(w);
        }
        return sequence;
    }
}
