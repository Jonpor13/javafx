package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.ZerbitzuKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class KautotuKud implements Initializable {

    // Reference to the main application.
    private Main mainApp;

    @FXML
    private ComboBox comboZerbitzua;

    @FXML
    private TextField txtErabiltzaile;

    @FXML
    private TextField txtPasahitza;

    @FXML
    private Button btSartu;

    @FXML
    private Button btEzabatu;


    public void setMainApp(Main main) {
        this.mainApp = main;
    }


    @FXML
    void onEzabatu(ActionEvent event) {
        ZerbitzuKud.getInstance().ezbatuZerbitzua(comboZerbitzua.getValue().toString());
        this.iniziatuV2();

    }

    @FXML
    void onSartu(ActionEvent event) {
        ZerbitzuKud.getInstance().sartuZerbitzua(comboZerbitzua.getEditor().getText());
        this.iniziatuV2();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.iniziatuV2();

    }

    private void iniziatuV2(){
        List<String> herrialdeakList = ZerbitzuKud.getInstance().lortuZerbitzuak();
        ObservableList<String> herrialdeak = FXCollections.observableArrayList(herrialdeakList);

        comboZerbitzua.setItems( herrialdeak );

    }

}
