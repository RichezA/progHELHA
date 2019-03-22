package be.helha.morpion.exceptions;

public class AlreadyClickedException extends RuntimeException{
    public AlreadyClickedException() {
        System.out.println("THIS BUTTON HAS ALREADY BEEN PLAYED");
    }
}
