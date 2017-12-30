/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Julia
 */
public class Vocabulary {
    
    ArrayList<String> words;

    public Vocabulary(File file) throws FileNotFoundException {
        this.words = new ArrayList<>();
        
        Scanner scn = new Scanner(file);
        
        while(scn.hasNextLine())
            words.add(scn.nextLine());
    }

    public ArrayList<String> getWords() {
        return words;
    }
}
