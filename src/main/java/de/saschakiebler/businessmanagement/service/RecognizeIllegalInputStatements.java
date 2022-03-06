package de.saschakiebler.businessmanagement.service;

import java.util.Locale;

public class RecognizeIllegalInputStatements {

    public static boolean recognizeAnySQLRelevantWords(String input){
        String inputToCheck = input.toLowerCase(Locale.ROOT);
        if (inputToCheck.contains(";")||inputToCheck.contains("drop")||inputToCheck.contains("select")||inputToCheck.contains("*"))
        {
            System.out.println("Contains illegal SQL statement. Possible injection attack!!!!!!!!!!!!");
            return false;
        }
        return true;
    }
}
