package be.helha.views;

import be.helha.models.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * This is the main view controller of our main application
 */
public class MainViewController implements Initializable {
    // ATTRIBUTES
    @FXML
    public VBox categoryBoxes;
    @FXML
    public Label currentProductLabel;
    @FXML
    public Label currentPriceLabel;
    @FXML
    public BorderPane bottomBd;
    @FXML
    public Button addBtn;
    @FXML
    private ListViewController listViewController;

    private Label weightLabel;
    private ChoiceBox<Integer> pieceChoice;
    private final DecimalFormat df = new DecimalFormat("0.00");
    private final Integer[] choiceBoxItems = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
            16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

    private MainViewInteraction interaction;
    private CategoryList list;
    private HashMap<Category, TitledPane> map;
    private Order order;

    // SETTERS
    public void setList(CategoryList list)
    {
        this.list = list;
    }

    public void setInteraction(MainViewInteraction interaction)
    {
        this.interaction = interaction;
    }
    // GETTERS
    public ListViewController getListViewController()
    {
        return listViewController;
    }

    /**
     * This method is used to initialize the window during the loading of our controller. Here we instantiate our hashmap
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        map = new HashMap<>();
    }

    /**
     * This method is used to setup our view, here it does create the template for each category loaded
     */
    public void setUp()
    {
        for(Category cat: list.getCategories())
        {
            TitledPane tPane = new TitledPane();
            tPane.setText(cat.getName());
            categoryBoxes.getChildren().add(tPane);
            map.put(cat, tPane);
            this.refreshCategory(cat);
        }
    }

    /**
     * This method is used to create the template for each of our products in their own categories
     * It can send a request to our main controller to say that we just checked this product
     * @param p : Product
     * @return Button
     */
    private Button getProductBtnNode(Product p)
    {
        BorderPane bd = new BorderPane();
        ImageView imageView = this.getProductImageNode(p.getImage());
        BorderPane.setAlignment(imageView, Pos.CENTER);
        bd.setCenter(imageView);
        BorderPane pDescription = this.getProductNameAndPriceNode(p.getName(), p.getPrice() + p.getType().notation);
        bd.setBottom(pDescription);
        Button btn = new Button("", bd);
        btn.setMinWidth(150);
        btn.setMinHeight(150);
        btn.setOnAction(event -> {
            interaction.setChoosenProduct(p);
        });
        return btn;
    }

    /**
     * This method is used to create the template for each of our product images
     * @param image
     * @return ImageView
     */
    private ImageView getProductImageNode(Image image)
    {
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        return imageView;
    }

    /**
     * This method is used to create a template for our products specifications
     * @param name
     * @param price
     * @return BorderPane
     */
    private BorderPane getProductNameAndPriceNode(String name, String price)
    {
        BorderPane bd = new BorderPane();
        Label lName = new Label(name);
        Label lPrice = new Label(price);
        BorderPane.setAlignment(lName, Pos.CENTER);
        BorderPane.setAlignment(lPrice, Pos.CENTER);
        bd.setTop(lName);
        bd.setBottom(lPrice);
        return bd;
    }

    /**
     * This method is used to create a template for the "Add a new product" button
     * It can send a request to open the "Add a new product" window to our main controller
     * @param c : Category
     * @return Button
     */
    private Button getAddButtonNode(Category c)
    {
        BorderPane bd = new BorderPane();
        ImageView imageView = new ImageView(this.getClass().getResource("/images/Add.png").toString());
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        Label label = new Label("Add a product");
        BorderPane.setAlignment(label, Pos.CENTER);
        BorderPane.setAlignment(imageView, Pos.CENTER);
        bd.setCenter(imageView);
        bd.setBottom(label);
        Button btn = new Button("", bd);
        btn.setMinWidth(150);
        btn.setMinHeight(150);
        btn.setOnAction(event -> {
            try
            {
                interaction.loadAddingWindow(c);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });
        return btn;
    }

    /**
     * This method is used to enable or disable the add button
     * @param value : Boolean
     */
    public void setDisableButton(boolean value)
    {
        addBtn.setDisable(value);
    }

    /**
     * This method is used to create and refresh the template for each of our products
     * @param c : Category
     */
    public void refreshCategory(Category c)
    {
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(5.0));
        for (Product p:c.getProducts())
        {
            Button btn = getProductBtnNode(p);
            FlowPane.setMargin(btn, new Insets(0.0));
            flowPane.getChildren().add(btn);
        }
        flowPane.getChildren().add(this.getAddButtonNode(c));
        map.get(c).setContent(flowPane);
    }


    /**
     * This method is used to update the weight label on the main window
     * @param input : String
     */
    public void setWeightLabel(String input){
        if(weightLabel != null)
        {
            this.weightLabel.setText(input + "g");
        }
    }

    /**
     * This method is used when we want to update the "product name" label on our main window
     * @param name : String
     */
    public void updateCurrentProductLabel(String name)
    {
        currentProductLabel.setText(name);
    }

    /**
     * This method is used to create the template of our weight label on our main window (when a product "by weight" is select nor by default)
     */
    public void addWeightLabel()
    {
        Label label = new Label("0g");
        bottomBd.setCenter(label);
        BorderPane.setAlignment(label, Pos.CENTER);
        Font font = new Font("System Bold", 18);
        label.setFont(font);
        this.weightLabel = label;
        this.pieceChoice = null;
    }

    /**
     * This method is used to create the template of our choice box on our main window (when a product "by piece" is selected)
     */
    public void addPieceBoxes()
    {
        ChoiceBox<Integer> box = new ChoiceBox<>();
        box.setItems(FXCollections.observableArrayList(choiceBoxItems));
        box.setValue(1);
        box.setOnAction(event -> interaction.updatePrice());
        bottomBd.setCenter(box);
        BorderPane.setAlignment(box, Pos.CENTER);
        this.weightLabel = null;
        this.pieceChoice = box;
    }

    /**
     * This method is used to create and set the choice box value (when selecting x pieces of a product)
     */
    public void incrementChoiceBox()
    {
        if(pieceChoice != null){
            int value = pieceChoice.getValue();
            if(value == 30) return;
            pieceChoice.setValue(++value);
        }
    }

    /**
     * returns the weight for a product or 0 if our weight label is null (when a product "per piece" is selected)
     * @return Integer
     */
    public int askWeight()
    {
        if(weightLabel != null)
        {
            return Integer.parseInt(weightLabel.getText().replace("g", ""));
        }
        return 0;
    }

    /**
     * returns the value of our choice box or 0 if it is null (by default nor a product "by weight" is selected)
     * @return Integer
     */
    public int askBoxValue()
    {
        if(pieceChoice != null)
        {
            return pieceChoice.getValue();
        }
        return 0;
    }

    /**
     * It does update the current price label in the correct format
     * @param v : Double
     */
    public void updatePriceLabel(double v)
    {
        this.currentPriceLabel.setText(df.format(v)+"€");
    }

    public void addBtnAction(ActionEvent actionEvent)
    {
        interaction.addToOrder();
    }

}
