package ua.kpi.parsingText.controller;

import ua.kpi.parsingText.model.Sentence;
import ua.kpi.parsingText.model.Word;
import ua.kpi.parsingText.model.WordComparator;
import ua.kpi.parsingText.view.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ua.kpi.parsingText.view.View.print;

/**
 * Created by Evgeniy on 10.12.2016.
 */
public class Controller {
    Parser parser = new Parser();

    public void processUser(){
        List<Sentence> sentences = parser.parseTextBySentence(readFile(View.FILE_PATH));
        printSentences(sentences);
        print();
        List<Word> words = parser.parseTextByWords(sentences);
        printWords(words);
        print();
        printWords(sortWordsByAlphabet(words));
    }

    /**
     * Reads the file information
     *
     * @param path path of the file
     * @return file's text
     */
    public String readFile(String path) {
        BufferedReader bufferedReader = null;
        String text = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String tmp = "";
            while ((tmp = bufferedReader.readLine()) != null) {
                text += tmp + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return text;
    }

    /**
     * Sorts all the words in the sentences by the first letter
     *
     * @param words list of the words
     * @return list of the sorted words
     */
    public List<Word> sortWordsByAlphabet(List<Word> words) {
        Word [] arr = new Word [words.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = words.get(i);
        }
        Arrays.sort(arr, new WordComparator());
        List<Word> sortedWords = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            sortedWords.add(parser.getFlyweightFactory().getWord(arr[i].getWord()));
        }
        return sortedWords;
    }

    /**
     * Prints all the sentences
     *
     * @param sentences list of the sentences
     */
    private void printSentences(List<Sentence> sentences){
        StringBuffer buffer = new StringBuffer();
        for (Sentence s : sentences){
            buffer.append(s);
            buffer.append('\n');
        }
        print(buffer.toString());
    }

    /**
     * Prints all the words
     *
     * @param words list of the words
     */
    private void printWords(List<Word> words){
        StringBuffer buffer = new StringBuffer();
        for (Word w : words){
            buffer.append(w);
            buffer.append('\n');
        }
        print(buffer.toString());
    }
}
