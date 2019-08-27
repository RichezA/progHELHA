package be.helha.models;

import be.helha.models.exceptions.DuplicatedItemException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  This class defines a list of all of the product categories we do save in our resources files for our main interface
 */
public class CategoryList {
    // VARIABLES
    private ArrayList<Category> categories;

    // CONSTRUCTOR
    public CategoryList()
    {
        categories = new ArrayList<>();
    }

    // GETTERS
    public List<Category> getCategories(){
        return Collections.unmodifiableList(categories);
    }

    public Category getCategory(Category category)
    {
        for (Category c : this.categories)
        {
            if(c.getName().equals(category.getName()))
            {
                return c;
            }
        }
        return null;
    }

    /**
     *  This method is used when we desire to add a new category to our list, to do so, we first need to check if we don't already have this category in our list
     *  If an error thrown you here, please refer to the "isDuplicate" method
     * @param cat : Category -> The category that we desire to add to our list
     */
    public void addCategory(Category cat){
        isDuplicate(cat);
        categories.add(cat);
    }

    /**
     *  This method is used to check if we don't already have the desired category in our list, if we do find it a "DuplicatedItemException" is thrown
     *  If you want to know more about this exception please refer to (be.helha.models.exceptions.DuplicatedItemException)
     * @param category -> The category that we want to check if it's duplicate.
     */
    private void isDuplicate(Category category){
        for(Category cat: categories){
            if(cat.getName().equals(category.getName()))
            {
                throw new DuplicatedItemException();
            }
        }
    }
}
