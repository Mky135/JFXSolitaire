package solitaire;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Solitaire");
        Parent mainParent = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
        Scene mainScene = new Scene(mainParent);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
