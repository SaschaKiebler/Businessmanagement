package de.saschakiebler.businessmanagement.exceptions;

public class IllegalSQLStatementException extends Exception{
    public IllegalSQLStatementException(String errorMessage){
        super(errorMessage);
    }
}
