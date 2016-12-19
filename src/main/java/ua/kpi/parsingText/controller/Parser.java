package ua.kpi.parsingText.controller;

import ua.kpi.parsingText.model.Sentence;
import ua.kpi.parsingText.model.Type;
import ua.kpi.parsingText.model.Word;
import ua.kpi.parsingText.model.WordFactory;
import ua.kpi.parsingText.view.Regex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeniy on 10.12.2016.
 */
public class Parser {
    private WordFactory flyweightFactory = new WordFactory();

    public WordFactory getFlyweightFactory() {
        return flyweightFactory;
    }

    /**
     * Method parse incoming String into Text array by splitTag from the parsingText.view. Then go through this array and create
     * objects of the class Sentence with specified type.v
     * @return list of the sentences
     */
    public List<Sentence> parseTextBySentence(String text){
        List<Sentence> parsedText = new ArrayList<>();
        String[] parsedTextIntoSentenceAndCode = text.split(Regex.END_OF_SENTENCE);
        for (String s : parsedTextIntoSentenceAndCode) {
            if(s.contains(Regex.CODE_MARK)){
                parsedText.add(new Sentence(s, Type.CODE));
            } else if (s.contains(Regex.TEXT_MARK)) {
                parsedText.add(new Sentence(s, Type.SENTENCE));
            } else {
                parsedText.add(new Sentence(s, Type.SENTENCE));
            }
        }
        return parsedText;
    }

    /**
     * Method parse incoming list of the sentences by regular expression from the parsingText.view. Then go through this array and create
     * objects of the class Word using Flyweight factory.
     * @param sentences list of the sentences
     * @return list of the words
     */
    public List<Word> parseTextByWords(List<Sentence> sentences){
        List<Word> allWords = new ArrayList<>();
        for (Sentence s: sentences) {
            allWords.addAll(s.getWords());
        }
        return allWords;
    }
}
