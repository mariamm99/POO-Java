package gestisimal;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class MainAlmacenFX extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {

    primaryStage.setTitle("Almacen");
    FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("vistas/almacen.fxml"));
    BorderPane root = fxml.<BorderPane>load();

    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  public static void main(String[] args) {

    launch(args);
  }
}
