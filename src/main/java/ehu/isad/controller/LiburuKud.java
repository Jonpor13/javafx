package ehu.isad.controller;


import ehu.isad.Liburuak;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LiburuKud {

  // Reference to the main application.
  private Liburuak liburuakApp;

  @FXML
  private ImageView Irudia;

  @FXML
  private Label labelIzenburu;

  @FXML
  private Label labelArgitaletxe;

  @FXML
  private Label labelOrriKop;

  @FXML
  private Button btAtzera;


  public void setMainApp(Liburuak liburuak) {
    this.liburuakApp = liburuakApp;
  }

  @FXML
  public void onClic(ActionEvent event) throws IOException {
    this.liburuakApp.xehetasunakErakutsi();
  }

  public void setLblIzen(String pIzenburu) {
    this.labelIzenburu.setText(pIzenburu);
  }

  public void setLblArgitaletxe(String pArgitaletxe) {
    this.labelArgitaletxe.setText(pArgitaletxe);
  }

  public void setLblOrriKop(String pOrri) {
    this.labelOrriKop.setText(pOrri);

  }
}