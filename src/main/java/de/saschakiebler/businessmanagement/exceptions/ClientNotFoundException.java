package de.saschakiebler.businessmanagement.exceptions;

public class ClientNotFoundException extends Exception{

    public ClientNotFoundException (String errorMessage){
        super(errorMessage);
    }

}
