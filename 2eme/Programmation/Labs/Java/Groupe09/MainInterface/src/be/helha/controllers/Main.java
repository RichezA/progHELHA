package be.helha.controllers;

import be.helha.models.*;
import be.helha.models.exceptions.ConfigErrorException;
import be.helha.models.exceptions.NotOrderedProductException;
import be.helha.models.exceptions.UnweightedProductException;
import be.helha.models.network.NetworkObject;
import be.helha.models.network.Server;
import be.helha.views.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Main extends Application implements Observer, BalanceToMainViewInteraction, MainViewInteraction, AddViewInteraction, ListViewInteraction
{
    // ATTRIBUTES
    private MainViewController mainViewController;
    private BalanceViewController balanceViewController;
    private ListViewController listViewController;
    private AddViewController addViewController;
    private CategoryList categoryList;
    private Product currentProduct;
    private Order order;
    private Server server;
    private boolean paiement = false;
    private final String appPath = System.getProperty("user.home")+System.getProperty("file.separator")+"Groupe-09-Traiteur";

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.categoryList = new CategoryList();
        this.order = new Order();
        server = new Server(this);
        server.setDaemon(true);
        server.start();
        this.checkFirstLaunch();
        this.loadCategories();
        this.loadMainWindows(primaryStage);
        this.loadBalance();
    }

    private void checkFirstLaunch(){
        File file = new File(this.appPath);
        if(!file.exists())
        {
            file.mkdir();
            this.createExampleCategory();
        }
    }

    private void createExampleCategory()
    {
        File file = new File(this.appPath+System.getProperty("file.separator")+"ExampleCategory.txt");
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8")))
        {
            writer.write("Category Name"); writer.write(System.lineSeparator());
            writer.write("Kilo Product Name"); writer.write(System.lineSeparator());
            writer.write("9.99"); writer.write(System.lineSeparator());
            writer.write("KILO"); writer.write(System.lineSeparator());
            writer.write("&@#"); writer.write(System.lineSeparator());
            writer.write("Piece Product Name"); writer.write(System.lineSeparator());
            writer.write("99.99"); writer.write(System.lineSeparator());
            writer.write("PIECE"); writer.write(System.lineSeparator());
        }
        catch(IOException e)
        {

        }
    }

    /**
     * This method is used to load categories from our files
     * @throws FileNotFoundException -> thrown if we don't find any resource file that contains our categories
     */
    private void loadCategories() throws FileNotFoundException
    {

        File[] files = new File(this.appPath+System.getProperty("file.separator")).listFiles();
        if(files != null) {
            for(File file : files) {
                Scanner scan = new Scanner(file);
                if(scan.hasNextLine()){
                    Category category = new Category(scan.nextLine());
                    this.categoryList.addCategory(category);
                    category.setScanner(scan);
                    category.setFilePath(file.getAbsolutePath());
                    this.loadProducts(category);
                }
            }
        }
    }

    /**
     * This method is used to read through our categories files to create our product
     * @param category -> the category that we want the products from
     */
    private void loadProducts(Category category)
    {
        category.getScanner().useDelimiter("&@#"+System.lineSeparator());
        while(category.getScanner().hasNext()){
            String[] strs = category.getScanner().next().split(System.lineSeparator());
            if(strs.length < 3 || strs.length > 4)
            {
                throw new ConfigErrorException();
            }
            if(strs.length == 3){
                category.addProduct(new Product(strs[0], Double.parseDouble(strs[1]), strs[2]));
            }
            else{
                category.addProduct(new Product(strs[0], Double.parseDouble(strs[1]), strs[2], "file:/"+strs[3]));
            }
        }
    }

    /**
     * This method is used to create and show up to the screen the main window of our application
     * @param primaryStage : Stage
     * @throws Exception
     */
    private void loadMainWindows(Stage primaryStage) throws Exception
    {
        FXMLLoader mainViewLoader = new FXMLLoader(MainViewController.class.getResource("MainView.fxml"));
        mainViewLoader.load();
        Parent root = mainViewLoader.getRoot();
        mainViewController = mainViewLoader.getController();
        this.setupMainViewController();
        primaryStage.setTitle("Traitor view");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest((event) -> Platform.exit());
    }

    /**
     * This method is used to setup the main view controller and instantiate its required components like the interaction
     */
    private void setupMainViewController()
    {
        mainViewController.setList(categoryList);
        listViewController = mainViewController.getListViewController();
        listViewController.setInteraction(this);
        listViewController.setOrder(order);
        mainViewController.setInteraction(this);
        mainViewController.setUp();
        mainViewController.addWeightLabel();
        mainViewController.setDisableButton(true);
    }

    /**
     * This method is used to create and show up to the screen the "balance" window
     * @throws Exception
     */
    private void loadBalance() throws Exception
    {
        FXMLLoader balanceViewLoader = new FXMLLoader(BalanceViewController.class.getResource("BalanceView.fxml"));
        balanceViewLoader.load();
        Parent balance = balanceViewLoader.getRoot();
        balanceViewController = balanceViewLoader.getController();
        balanceViewController.setInteraction(this);
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Balance");
        secondaryStage.setScene(new Scene(balance));
        secondaryStage.show();
    }

    /**
     * This method is used to create and show up to the screen the "add a new product" window
     * @param c : Category -> the category in which we want to add a product
     * @throws Exception
     */
    @Override
    public void loadAddingWindow(Category c) throws Exception
    {
        FXMLLoader addViewLoader = new FXMLLoader(AddViewController.class.getResource("AddView.fxml"));
        addViewLoader.load();
        Parent addView = addViewLoader.getRoot();
        addViewController = addViewLoader.getController();
        addViewController.setInteraction(this);
        addViewController.setCategory(c);
        Stage addStage = new Stage();
        addStage.setTitle("Add a product");
        addStage.setScene(new Scene(addView));
        addStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method is used when we want to update the weight label based on the balance window
     * @param input : String
     */
    @Override
    public void updateWeight(String input) {
        if(this.currentProduct == null || this.currentProduct.getType() == ProductType.KILO)
        {
            mainViewController.setWeightLabel(input);
            this.updatePrice();
        }
        else{
            balanceViewController.sendWrongProductType();
        }
    }

    /**
     * This method is used when we want to reset the current product-related specifications like the current product label
     */
    private void resetCurrentProduct()
    {
        this.currentProduct = null;
        mainViewController.updateCurrentProductLabel("");
        mainViewController.addWeightLabel();
        this.updateWeight(balanceViewController.askBalanceWeight());
        mainViewController.updatePriceLabel(0.0);
        mainViewController.setDisableButton(true);
    }

    /**
     * This method is used when we select a product
     * @param p : Product -> the product we just selected
     */
    @Override
    public void setChoosenProduct(Product p)
    {
        if(!this.checkSameProduct(p))
        {
            this.currentProduct = p;
            mainViewController.updateCurrentProductLabel(p.getName());
            this.checkProductType();
        }
        else{
            if(p.getType() == ProductType.PIECE){
                mainViewController.incrementChoiceBox();
            }
        }
        this.updatePrice();
        mainViewController.setDisableButton(false);
    }

    /**
     * This method is used to update price label based on the current product and his corresponding quantity
     */
    @Override
    public void updatePrice(){
        if(currentProduct != null)
        {
            if (currentProduct.getType() == ProductType.KILO)
            {
                int weight = mainViewController.askWeight();
                mainViewController.updatePriceLabel(currentProduct.getPrice() * ((double)weight / 1000));
            } else
            {
                int number = mainViewController.askBoxValue();
                mainViewController.updatePriceLabel(currentProduct.getPrice() * (double)number);
            }
        }
    }

    /**
     * returns true if the product that we just selected is the same than the previous one
     * @param p : Product -> the product we want to check if it already is our chose product
     * @return Boolean -> returns true if it already is
     */
    private boolean checkSameProduct(Product p){
        if(this.currentProduct != null)
        {
            return this.currentProduct.getName().equals(p.getName());
        }
        return false;
    }

    /**
     * This method is used when we want to show up the weight label or the pieces choice box depending on the current product type
     */
    private void checkProductType()
    {
        if(this.currentProduct.getType() == ProductType.KILO){
            mainViewController.addWeightLabel();
            this.updateWeight(balanceViewController.askBalanceWeight());
        }
        else{
            mainViewController.addPieceBoxes();
        }
    }

    /**
     * This method is used when we want to add a product to the current order, we reset the current product and send the new order to the client view
     */
    @Override
    public void addToOrder()
    {
        double quantity;
        if(currentProduct.getType() == ProductType.KILO)
        {
            quantity = mainViewController.askWeight();
        }
        else{
            quantity = mainViewController.askBoxValue();
        }
        try{
            order.addElement(currentProduct, quantity);
            listViewController.refreshOrder();
            this.resetCurrentProduct();
            this.sendOrderToClient();
        }catch(UnweightedProductException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Couldn't add " + currentProduct.getName() + ".\nReason: This product does not have any weight, please give it one.", ButtonType.OK);
            alert.setTitle("Unweighted product");
            alert.showAndWait();
            System.err.println("Unweighted product for: " + this.currentProduct.getName() + "\nPID: " + currentProduct);
        }catch(NotOrderedProductException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "The product isn't selected, please select a product before continuing", ButtonType.OK);
            alert.setTitle("Product not selected");
            alert.showAndWait();
        }
    }

    /**
     * This method is used when we want to delete an element, we remove it from our current order, we refresh the view and send it to the client view
     * @param element : OrderElement -> the element of an order that we'd like to remove from our order
     */
    @Override
    public void deleteElement(OrderElement element)
    {
        order.removeElement(element);
        listViewController.refreshOrder();
        this.sendOrderToClient();
    }

    @Override
    public void askPaiement()
    {
        try
        {
            server.broadcast(order.getPrice() + "€");
        }
        catch (IOException e)
        {
            System.err.println("Please check the connection to the server:\n" + e.getMessage());
        }
    }

    /**
     * This method is used when we want to broadcast an order to all of our clients
     */
    private void sendOrderToClient()
    {
        try{
            server.broadcast(order);
        }
        catch (IOException e)
        {
            System.err.println("Please check the connection to the server:\n" + e.getMessage());
        }
    }

    /**
     * This method is used when we want to close the "add a new product" window
     * @param source : Object -> the source of the request
     */
    @Override
    public void closeAddWindow(Object source)
    {
        if(source instanceof Button)
        {
            Button btn = (Button) source;
            Stage stage = (Stage) btn.getScene().getWindow();
            stage.close();
        }
    }

    /**
     * This method is used when we want to add a new product to a category
     * @param category -> the category to which we want to add a new product
     * @param name -> the name of our new product
     * @param price -> the price of our new product
     * @param type -> the type of our new product
     */
    @Override
    public void addProduct(Category category, String name, double price, String type)
    {
        Product product = new Product(name, price, type);
        this.categoryList.getCategory(category).addNewProductToFile(product);
        this.mainViewController.refreshCategory(category);
    }

    /**
     * This method needs to be override since we implement the Observer interface, it will permit us to manage the request from our different clients.
     */
    @Override
    public void update(Observable o, Object arg)
    {
        if(arg instanceof String)
        {
            String string = (String) arg;
            if(string.equals("YES")){
                this.order = new Order();
                sendOrderToClient();
                Platform.runLater(() -> {
                    listViewController.setOrder(order);
                    listViewController.refreshOrder();
                });
            }
            if(string.equals("BYE"))
            {
                if(o instanceof NetworkObject)
                {
                    try
                    {
                        ((NetworkObject) o).close();
                    }
                    catch (IOException e)
                    {

                    }
                }
            }
        }
    }
}
