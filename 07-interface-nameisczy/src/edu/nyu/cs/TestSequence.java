package edu.nyu.cs;

public class TestSequence {
    public static void main(String[] args) {
        Sentence sentence = new Sentence("This is a test sentence.");
        System.out.println(sentence.getFirst().getSequence());
        System.out.println(sentence.getLast().getSequence());
        System.out.println(sentence.getSequence());

        Word word = (Word) sentence.getSequence().get(2);
        System.out.println(word.getFirst());
        System.out.println(word.getLast());
        System.out.println(word.getSequence());
        System.out.println(word.getPosition());
    }

}
