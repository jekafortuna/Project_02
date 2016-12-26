package ua.kpi.parsingText.model;

import java.util.Comparator;

/**
 * Created by Evgeniy on 10.12.2016.
 * Word comparator to find for every word correct place
 */
public class WordComparator implements Comparator<Word> {
    @Override
    public int compare(Word word1, Word word2) {
        String firstWord = word1.getWord().toLowerCase();
        String secondWord = word2.getWord().toLowerCase();
        return firstWord.compareTo(secondWord);
    }
}