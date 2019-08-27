package be.helha.models.exceptions;

/**
 *  This exception is thrown when we go through one of our list and we do find an element that is already inside
 *  This custom exception is extended from the RuntimeException class that permits us to throw them during the normal operation of the JVM
 *  Check more about the RuntimeException superclass at https://docs.oracle.com/javase/8/docs/api/java/lang/RuntimeException.html
 */
public class DuplicatedItemException extends RuntimeException
{

}
