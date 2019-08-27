package be.helha.models.exceptions;

/**
 * This exception is thrown when we go through an order list and there is no products that match our searched element
 *  This custom exception is extended from the RuntimeException class that permits us to throw them during the normal operation of the JVM
 *  Check more about the RuntimeException superclass at https://docs.oracle.com/javase/8/docs/api/java/lang/RuntimeException.html
 */
public class NotOrderedProductException extends RuntimeException
{

}
