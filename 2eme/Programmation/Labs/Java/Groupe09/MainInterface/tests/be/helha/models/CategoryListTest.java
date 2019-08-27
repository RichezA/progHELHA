package be.helha.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CategoryListTest {

    CategoryList catListTest;

    @Before
    public void initialize(){
        catListTest = new CategoryList();
        catListTest.addCategory(new Category("Fruits"));
        catListTest.addCategory(new Category("Vegetables"));
    }

    @Test
    public void getCategories() {
        CategoryList test = new CategoryList();
        test.addCategory(new Category("Fruits")); test.addCategory(new Category("Vegetables"));
        assertEquals(catListTest.getCategories().get(0).getName(), "Fruits");
    }

    @Test
    public void addCategory() {
        List<Category> test = new ArrayList<>();
        test.add(new Category("test"));
        test.add(new Category("test2"));
        assertEquals(catListTest.getCategories().size(), test.size());
    }

    @Test
    public void getCategory() {
        Category test = new Category("Junk");
        catListTest.addCategory(test);
        assertEquals(catListTest.getCategory(test), test);
    }
}