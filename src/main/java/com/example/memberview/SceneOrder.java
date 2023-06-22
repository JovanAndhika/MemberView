package com.example.memberview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class SceneOrder implements Initializable {
    @FXML
    private Label labelJenisJasa;
    @FXML
    private Label nominal;
    @FXML
    private TextField kuantitas;
    @FXML
    private TableView <String> table_pesanan;

    protected String jenisJasa;

    @FXML
    protected void onCancelClick () {
        MemberView app = MemberView.getApplicationInstance();
        Stage primStage = app.getPrimaryStage();
        Scene memberScene = app.getMemberScene();
        primStage.setTitle("Member View");
        primStage.setScene(memberScene);
    }

    @FXML
    protected void onAddOrderClick () {
        int jumlah = Integer.parseInt(kuantitas.getText());
        System.out.println(labelJenisJasa.getText());
        System.out.println(jumlah);
    }

    @FXML
    protected void onMakeOrderClick (ActionEvent ae) {
        //ini belum ta buat  nyambung ke pembuatan nota sama pengurangan saldo nya.
        //if (saldo >= nominal) {}
        Alert alert = new Alert(Alert.AlertType.NONE, "Make this order? Click OK to confrim.", ButtonType.OK, ButtonType.CANCEL);
        alert.setTitle("Order confirmation");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isEmpty()){
            System.out.println("Alert closed");
        } else if (result.get() == ButtonType.OK) {
            labelJenisJasa.setText("");
//            table_pesanan.getItems().clear();
            kuantitas.setText("");

            Alert alertConfirm = new Alert(Alert.AlertType.NONE, "Order made!", ButtonType.OK);
            alertConfirm.setTitle("Order made");
            Optional<ButtonType> resultConfirm = alertConfirm.showAndWait();

            if (resultConfirm.isEmpty()) {
                MemberView app = MemberView.getApplicationInstance();
                Stage primStage = app.getPrimaryStage();
                Scene memberScene = app.getMemberScene();
                primStage.setTitle("Member View");
                primStage.setScene(memberScene);

                System.out.println("OK. Order is made.");
            } else if (resultConfirm.get() == ButtonType.OK) {
                MemberView app = MemberView.getApplicationInstance();
                Stage primStage = app.getPrimaryStage();
                Scene memberScene = app.getMemberScene();
                primStage.setTitle("Member View");
                primStage.setScene(memberScene);

                System.out.println("OK. Order is made.");
            }

            //saldo.setText(String.valueOf(Integer.parseInt(saldo.getText()) - Integer.parseInt(nominal.getText())));
        } else if (result.get() == ButtonType.CANCEL) {
            System.out.println("Order is cancelled.");
        }
        /*

        else {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Saldo tidak mencukupi!");

         */
    }
    @FXML
    public void clickCuciSetrika(){
        labelJenisJasa.setText("Cuci Setrika");
    }

    @FXML
    public void clickCuciLipat(){
        labelJenisJasa.setText("Cuci Lipat");
    }

    @FXML
    public void clickLaundrySpreiSelimut(){
        labelJenisJasa.setText("Laundry Sprei / Selimut");
    }

    @FXML
    public void clickPengharumLaundry(){
        labelJenisJasa.setText("Pengharum Laundry");
    }

    @FXML
    public void clickDryCleanGaunPesta(){
        labelJenisJasa.setText("Dry Clean Gaun Pesta");
    }

    @FXML
    public void clickDryCleanJas(){
        labelJenisJasa.setText("Dry Clean Jas");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        listJasa.getItems().addAll("Cuci Setrika", "Cuci Lipat", "Laundry Sprei/Selimut",
//                "Pengharum Baju", "Dry Clean Gaun Pesta", "Dry Clean Jas");
    }
}