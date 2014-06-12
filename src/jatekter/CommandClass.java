/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jatekter;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author szilard
 */
public interface CommandClass {
    
    ArrayList<Pair<String, Class[]>> commands=new ArrayList<>();

    public ArrayList<Pair<String, Class[]>> getCommands();
}
