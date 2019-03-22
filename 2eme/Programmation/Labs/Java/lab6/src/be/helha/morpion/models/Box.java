package be.helha.morpion.models;

import be.helha.morpion.exceptions.AlreadyClickedException;
import javafx.scene.control.Button;

public class Box {
    public final int NB_BTNSIZE = 30;

    private Button btn;
    boolean isClicked;

    public Box(double coordX, double coordY){
        btn = new Button();
        btn.setPrefSize(NB_BTNSIZE, NB_BTNSIZE); btn.setLayoutX(coordX); btn.setLayoutY(coordY);
        btn.setOnMouseClicked(event -> {
            if(!isClicked){
                System.out.println("Button x:" + this.getX() + " y:" + this.getY() + " has been clicked");

                this.isClicked = true;
            }else{
                throw new AlreadyClickedException();
            }
        });
        isClicked = false;
    }

    public int getX(){ return (int) this.btn.getLayoutX(); }
    public int getY(){ return (int) this.btn.getLayoutY(); }
    public Button getBtn() { return this.btn; }

    public void toggleClick(){
        isClicked = !isClicked;
    }
}
