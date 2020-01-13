package solitaire.controlers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import solitaire.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{
    @FXML
    ImageView heartsSlot;
    @FXML
    ImageView diamondsSlot;
    @FXML
    ImageView clubsSlot;
    @FXML
    ImageView spadesSlot;
    @FXML
    ImageView drawn1;
    @FXML
    ImageView drawn2;
    @FXML
    ImageView drawn3;
    @FXML
    ImageView drawPile;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        heartsSlot.setImage(new Image(String.valueOf(Main.class.getResource("backs/blue_back.png"))));
        diamondsSlot.setImage(new Image(String.valueOf(Main.class.getResource("backs/blue_back.png"))));
        clubsSlot.setImage(new Image(String.valueOf(Main.class.getResource("backs/blue_back.png"))));
        spadesSlot.setImage(new Image(String.valueOf(Main.class.getResource("backs/blue_back.png"))));
        drawn1.setImage(new Image(String.valueOf(Main.class.getResource("backs/blue_back.png"))));
        drawn2.setImage(new Image(String.valueOf(Main.class.getResource("backs/blue_back.png"))));
        drawn3.setImage(new Image(String.valueOf(Main.class.getResource("backs/blue_back.png"))));
        drawPile.setImage(new Image(String.valueOf(Main.class.getResource("backs/blue_back.png"))));
    }
}
