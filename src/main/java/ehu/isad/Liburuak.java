package ehu.isad;

import ehu.isad.controller.XehetasunakKud;
import ehu.isad.controller.LiburuKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Liburuak extends Application {

  private Parent xehetasunakUI;
  private Parent liburuUI;

  private Stage stage;

  private XehetasunakKud xehetasunakKud;
  private LiburuKud liburuKud;

  private Scene sceneXeheta;
  private Scene sceneLiburu;

  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Liburuak xehetasun");
    stage.setScene(sceneXeheta);
    stage.show();
  }


  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/Xehetasuna.fxml"));
    xehetasunakUI = (Parent) loaderMain.load();
    sceneXeheta = new Scene(xehetasunakUI);
    xehetasunakKud = loaderMain.getController();
    xehetasunakKud.setMainApp(this);

    FXMLLoader loaderKautotu = new FXMLLoader(getClass().getResource("/Liburuak.fxml"));
    liburuUI = (Parent) loaderKautotu.load();
    sceneLiburu = new Scene(liburuUI, 700, 450);
    liburuKud = loaderKautotu.getController();
    liburuKud.setMainApp(this);
  }

  public static void main(String[] args) {
    launch(args);
  }

  public void liburuakErakutsi(String title, String publishers, Integer number_of_pages) {
    liburuKud.setLblIzen(title);
    liburuKud.setLblArgitaletxe(publishers);
    liburuKud.setLblOrriKop(number_of_pages.toString());
    stage.setScene(sceneLiburu);
    stage.show();
  }

  public void xehetasunakErakutsi() {
    stage.setScene(sceneXeheta);
    stage.show();


  }
}
