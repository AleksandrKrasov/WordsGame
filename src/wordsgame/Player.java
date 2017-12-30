/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Julia
 */
public class Player {
    
    ArrayList<String> vocabulary;
    ArrayList<String> usedWords;

    public Player(int theme) throws FileNotFoundException {
        if(theme == 1)
            vocabulary = new Vocabulary(new File("res/general.txt")).getWords();
        if(theme == 2)
            vocabulary = new Vocabulary(new File("res/animals.txt")).getWords();
        if(theme == 3)
            vocabulary = new Vocabulary(new File("res/jobs.txt")).getWords();
        if(theme == 4)
            vocabulary = new Vocabulary(new File("res/food.txt")).getWords();
        usedWords = new ArrayList<>();
    }

    public ArrayList<String> getVocabulary() {
        return vocabulary;
    }
    
    public boolean isWordFound(String word){
        boolean flag = false;
        for(int i=0; i<vocabulary.size(); i++){
            if(word.equals(vocabulary.get(i))){
                flag = true;
                break;
            }
        }
        return flag;
    }
    
    public String getLastLetter(String word){
        return word.substring(word.length() - 1);
    }
    
    public boolean checkIfUsed(String word){
        boolean flag = false;
        int counter = 0;
        for(int i=0; i<usedWords.size(); i++){
            if(word.equals(usedWords.get(i))){
                flag = true;
                counter ++;
                break;
            }
        }if(counter == 0){
            usedWords.add(word);
            flag = false;
        }        
        return flag;        
    }
    
    public void addUsedWord(String word){
        usedWords.add(word);
    }

    public ArrayList<String> getUsedWords() {
        return usedWords;
    }
}
