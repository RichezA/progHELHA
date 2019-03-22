package be.helha.morpion.models;

import be.helha.morpion.exceptions.AlreadyClickedException;
import be.helha.morpion.views.MainBoxInteraction;
import javafx.scene.control.Button;

public class Box {
    public final int NB_BTNSIZE = 30;

    MainBoxInteraction interaction;
    private Button btn;
    boolean isClicked;

    public Box(double coordX, double coordY){
        btn = new Button();
        btn.setPrefSize(NB_BTNSIZE, NB_BTNSIZE); btn.setLayoutX(coordX); btn.setLayoutY(coordY);
        btn.setOnMouseClicked(event -> {
            if(!isClicked){
                    interaction.clickedOnBox(this.getX() / NB_BTNSIZE, this.getY() / NB_BTNSIZE);
                    this.isClicked = true;
            }else{
                throw new AlreadyClickedException("Bouton déjà cliqué");
            }
        });
        isClicked = false;
    }

    public int getX(){ return (int) this.btn.getLayoutX(); }
    public int getY(){ return (int) this.btn.getLayoutY(); }
    public Button getBtn() { return this.btn; }


    public void setInteraction(MainBoxInteraction interaction){
        this.interaction = interaction;
    }
    public void setTextOnBtn(String text){
        btn.setText(text);
    }
    public void setClicked(boolean value){
        this.isClicked = value;
    }
}
