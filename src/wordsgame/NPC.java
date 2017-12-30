/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Julia
 */
public class NPC {
    
    ArrayList<String> vocabulary;
    ArrayList<String> usedWords;

    public NPC(int theme) throws FileNotFoundException {
        usedWords = new ArrayList<>();
                
        if(theme == 1)
            vocabulary = new Vocabulary(new File("res/general.txt")).getWords();
        if(theme == 2)
            vocabulary = new Vocabulary(new File("res/animals.txt")).getWords();
        if(theme == 3)
            vocabulary = new Vocabulary(new File("res/jobs.txt")).getWords();
        if(theme == 4)
            vocabulary = new Vocabulary(new File("res/food.txt")).getWords();
    }

    public ArrayList<String> getVocabulary() {
        return vocabulary;
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
    
    private String getLastLetter(String word){
        return word.substring(word.length() - 1);
    }
    
    public String generateWordByLastLetter(String word){
        Random rnd = new Random();
        String lastLetter = getLastLetter(word);
        ArrayList<String> buf = new ArrayList<>();
        for(int i=0; i<vocabulary.size(); i++){
            if(vocabulary.get(i).startsWith(lastLetter))
                buf.add(vocabulary.get(i));
        }
        return buf.get(rnd.nextInt(buf.size()));    
    }
    
    public void addUsedWord(String word){
        usedWords.add(word);
    }

    public ArrayList<String> getUsedWords() {
        return usedWords;
    }
}
