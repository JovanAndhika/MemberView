package com.example.memberview;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SceneMember {

    @FXML
    private Button order;

    @FXML
    private Button progress;
    @FXML
    private Button komplain;
    @FXML
    private Button logout;
    @FXML
    private TableView<String> list_nota;
    public static int nota_id;

    @FXML
    protected void onOrderClick() {
        MemberView app = MemberView.getApplicationInstance();
        Stage primStage = app.getPrimaryStage();
        Scene orderScene = app.getSceneOrder();
        primStage.setTitle("Order");
        primStage.setScene(orderScene);
    }

    @FXML
    protected void onProgressClick() {
        MemberView app = MemberView.getApplicationInstance();
        Stage primStage = app.getPrimaryStage();
        Scene progressScene = app.getSceneProgress();
        primStage.setTitle("Progress");
        primStage.setScene(progressScene);
    }

    @FXML
    protected void onComplainClick (){

    }

    @FXML
    protected void onLogoutClick() {

    }

//    public void initialize() {
//        nota_id = Integer.parseInt(list_nota.getSelectionModel().getSelectedItem());
//        order.setVisible(false);
//    }

}