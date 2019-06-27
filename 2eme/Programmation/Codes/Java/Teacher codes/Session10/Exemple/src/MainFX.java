import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();

        Label label = new Label("HelHa");
        root.getChildren().add(label);

        TextField tf = new TextField();
        root.getChildren().add(tf);
        TextField tf2 = new TextField();
        root.getChildren().add(tf2);


//        tf.textProperty().addListener(
//                (observable, oldValue, newValue) -> label.setText(newValue));

//        tf.setText("Fred");

//        label.textProperty().bind(primaryStage.heightProperty().asString());

        SimpleStringProperty name = new SimpleStringProperty("Fred");

        name.bindBidirectional(tf2.textProperty()); // On bind la property `name` de façon bidirectionnelle avec tf2
        name.bindBidirectional(tf.textProperty());  // On bind la property `name` de façon bidirectionnelle avec tf
        label.textProperty().bind(name);            // On bind label avec la property `name`
//        tf.textProperty().bindBidirectional(tf2.textProperty());

        primaryStage.titleProperty().bind(tf.textProperty()); // On bind la property du titre du Primary Stage  avec tf

        // Quand on modifiera tf ou tf2, vu qu'ils sont tout deux bind en bidirectionnel, name changera et updatera donc l'un et l'autre
        // Vu que label est bind avec name, dès que name change, le label change aussi
        // Pour le title property, vu qu'il est bind avec la text property de tf et que tf est dynamiquement changé avec name, il sera update aussi

        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
