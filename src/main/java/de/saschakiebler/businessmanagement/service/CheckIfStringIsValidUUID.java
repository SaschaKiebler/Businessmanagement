package de.saschakiebler.businessmanagement.service;

import java.util.UUID;

public class CheckIfStringIsValidUUID {

    static boolean checkIfStringIsValidUUID(String input){
        try {
            UUID.fromString(input);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
