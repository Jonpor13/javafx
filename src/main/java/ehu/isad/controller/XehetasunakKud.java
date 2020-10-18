package ehu.isad.controller;

import ehu.isad.Book;
import ehu.isad.Liburuak;
import ehu.isad.utils.Sarea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class XehetasunakKud implements Initializable {

  // Reference to the main application.
  private Liburuak liburuakApp;

  @FXML
  private ComboBox cbLiburu;

  @FXML
  private Button btIkusi;


  public void setMainApp(Liburuak liburuak) {
    this.liburuakApp = liburuak;
  }

  @FXML
  public void onClick(ActionEvent actionEvent) throws IOException {
    Book book = (Book)cbLiburu.getValue();
    Book liburua= Sarea.readFromUrl(book.getIsbn());
    liburuakApp.liburuakErakutsi(liburua.getDetails().getTitle(),liburua.getDetails().getPublishers(),liburua.getDetails().getNumber_of_pages());

    }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    cbLiburu.getItems().addAll(
            new Book("1491910399", "R for Data Science"),
            new Book("1491946008", "Fluent Python"),
            new Book("9781491906187", "Data Algorithms")
    );
    this.converter();
  }

    private void converter(){
      cbLiburu.setConverter(new StringConverter<Book>() {
        @Override
        public String toString(Book book) {
          if (book==null)
            return "";
          return book.getTitle();
        }

        @Override
        public Book fromString(String string) {
          return null;
        }
      });
    }


  }


