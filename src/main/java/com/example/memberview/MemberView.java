package com.example.memberview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MemberView extends Application {

    //DATABASE CONNECTION
    final static String driver = "com.mysql.cj.jdbc.Driver";
    final static String databaseName = "Laundry";
    final static String url = "jdbc:mysql://localhost/" + databaseName;
    final static String user = "root";
    final static String password = "";

    public static Connection createDatabaseConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }
    //Stage
    private Stage primaryStage;
    private Scene memberScene;

    //Scene untuk buat order
    private Scene sceneOrder;
    private SceneOrder sceneOrderController;


    //Scene untuk lihat progress
    private Scene sceneProgress;
    private SceneProgress sceneProgressController;


    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(MemberView.class.getResource("SceneMember.fxml"));
        memberScene = new Scene(fxmlLoader.load(), 800, 600);

        fxmlLoader = new FXMLLoader(MemberView.class.getResource("SceneOrder.fxml"));
        sceneOrder = new Scene(fxmlLoader.load(), 800, 600);
        sceneOrderController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(MemberView.class.getResource("SceneProgress.fxml"));
        sceneProgress = new Scene(fxmlLoader.load(), 800, 600);
        sceneProgressController = fxmlLoader.getController();

        stage.setTitle("Member View");
        stage.setScene(memberScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public MemberView() {
        applicationInstance = this;
    }

    private static MemberView applicationInstance;

    public static MemberView getApplicationInstance(){
        return applicationInstance;
    }


    public Stage getPrimaryStage () {
        return primaryStage;
    }
    public Scene getMemberScene () {
        return memberScene;
    }
    public Scene getSceneOrder () {
        return sceneOrder;
    }

    public SceneOrder getSceneOrderController () {
        return sceneOrderController;
    }

    public Scene getSceneProgress () {
        return sceneProgress;
    }

    public SceneProgress getSceneProgressController () {
        return sceneProgressController;
    }
}