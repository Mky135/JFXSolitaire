package solitaire.controlers;

import com.sun.tools.javac.jvm.Items;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import solitaire.Main;
import solitaire.util.Game;

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
    @FXML
    AnchorPane gameBoard;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Image back = new Image(String.valueOf(Main.class.getResource(Main.back)), 68, 104, true, true, false);
        heartsSlot.setImage(back);
        diamondsSlot.setImage(back);
        clubsSlot.setImage(back);
        spadesSlot.setImage(back);
        drawn1.setImage(back);
        drawn2.setImage(back);
        drawn3.setImage(back);
        drawPile.setImage(back);

        Game game = new Game(600);
        for(ImageView imageView : game.onField)
        {
         if(imageView.isDisable())
         {
             imageView.setImage(back);
             gameBoard.getChildren().add(imageView);
         }
         else
         {
             gameBoard.getChildren().add(imageView);
         }
        }
        gameBoard.getChildren().addAll(game.drawPile);
    }
}
