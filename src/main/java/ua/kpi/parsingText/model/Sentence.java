package ua.kpi.parsingText.model;

import ua.kpi.parsingText.view.Regex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeniy on 10.12.2016.
 */
public class Sentence implements Text {
    private String sentence;
    private List<Word> words = new ArrayList<>();
    private WordFactory wordFactory = new WordFactory();
    private Type type;

    public Sentence(String sentence, Type type) {
        this.sentence = sentence;
        this.type = type;
        words = setWords();
    }

    public List<Word> getWords() {
        return words;
    }

    public List<Word> setWords() {
        if (type.equals(Type.SENTENCE)) {
            String [] stringWords = sentence.split(Regex.SPACE_CHARACTER);
            for (String w: stringWords) {
                if (!w.equals(Regex.EMPTY_SPACE)) {
                    Word word = wordFactory.getWord(w);
                    words.add(word);
                }
            }
        }
        return words;
    }

    public String getSentence() {
        return sentence;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Sentence: " + sentence + "; type = " + type.toString() + ";" + " words = " + words.toString();
    }
}
