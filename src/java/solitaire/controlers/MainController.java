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
    AnchorPane gameBoard;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Game game = new Game(600);
        for(ImageView imageView : game.onField)
        {
            gameBoard.getChildren().add(imageView);
        }
        gameBoard.getChildren().addAll(game.drawPile);
    }
}
