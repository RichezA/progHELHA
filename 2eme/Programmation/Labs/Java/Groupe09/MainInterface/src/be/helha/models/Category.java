package be.helha.models;

import be.helha.models.exceptions.DuplicatedItemException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This class is used to define a category of product in our main interface
 */
public class Category
{
    // VARIABLES
    private String name;
    private ArrayList<Product> products;
    private Scanner scanner;
    private String filePath;

    // CONSTRUCTOR
    public Category(String name){
        this.name = name;
        this.products = new ArrayList<>();
    }

    // GETTERS
    public String getName() {
        return name;
    }
    public List<Product> getProducts(){
        return Collections.unmodifiableList(this.products);
    }

    // SETTERS
    public void setScanner(Scanner scanner)
    {
        this.scanner = scanner;
    }
    public Scanner getScanner()
    {
        return scanner;
    }
    public void setFilePath(String absolutePath)
    {
        this.filePath = absolutePath;
    }

    /**
     * This method is used when we want to add a product to our product list, to do so we first have to check if we don't already have this product in our list
     * If not and you're checking why the error is indicating this method, check for more at the "checkDuplicatedProduct" method
     * @param product -> The product that we desire to add to our product list.
     */
    public void addProduct(Product product) {
        checkDuplicatedProduct(product.getName());
        products.add(product);
    }

    /**
     * This method is used when we want to add a new product product to a file, to do so we use a FileWriter (check more at https://docs.oracle.com/javase/8/docs/api/index.html?java/io/FileWriter.html)
     * and append our product (trimmed in a certain way to facilitates us the "parsing" process) to the already existing file
     * @param product -> the product that we desire to add to our category file
     */
    public void addNewProductToFile(Product product)
    {
        checkDuplicatedProduct(product.getName());
        products.add(product);
        try
        {
            File file = new File(this.filePath);
            FileWriter fWriter = new FileWriter(file, true);
            fWriter.append(System.lineSeparator() + "&@#" + System.lineSeparator() + product.getName() +
                    System.lineSeparator() + product.getPrice() + System.lineSeparator() + product.getType());
            fWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method is used when we want to check if a product is already in our list, if so we throw a "DuplicatedItemException" (check more at be.helha.models.exceptions.DuplicatedItemException)
     * @param name -> The name of a product
     */
    private void checkDuplicatedProduct(String name){
        for(Product product : products){
            if(product.hasName(name)){
                throw new DuplicatedItemException();
            }
        }
    }



}
