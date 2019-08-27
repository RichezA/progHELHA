package be.helha.models.exceptions;

/**
 *  This exception is thrown when a configuration error is detected (We actually use it when we read our categories files and we don't get the exact same parameters as it shoudl be)
 *  This custom exception is extended from the RuntimeException class that permits us to throw them during the normal operation of the JVM
 *  Check more about the RuntimeException superclass at https://docs.oracle.com/javase/8/docs/api/java/lang/RuntimeException.html
 */
 public class ConfigErrorException extends RuntimeException
 {

 }
