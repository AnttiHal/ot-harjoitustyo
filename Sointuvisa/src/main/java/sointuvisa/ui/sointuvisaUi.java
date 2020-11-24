
/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import sointuvisa.dao.FileQuestionDao;
import sointuvisa.dao.FileUserDao;
import sointuvisa.domain.Question;
import sointuvisa.domain.SointuvisaService;
import sointuvisa.domain.User;

/**
 *
 * @author anttihalmetoja
 */
public class sointuvisaUi extends Application {
    private ToggleGroup group = new ToggleGroup();
    private SointuvisaService sointuvisaService;
    private TextField usernameInput;
    Scene usernameInputScene, startScene, qScene1,
            qScene2, qScene3, qScene4, qScene5, qScene6, qScene7, qScene8,
            qScene9, qScene10, scene2;
    Question q1;

    @Override
    public void init() throws IOException, Exception {
        Properties properties = new Properties();

        properties.load(new FileInputStream("config.properties"));

        String userFile = properties.getProperty("userFile");
        String questionFile = properties.getProperty("questionFile");

        FileUserDao userDao = new FileUserDao(userFile);
        FileQuestionDao questionDao = new FileQuestionDao(questionFile);

        sointuvisaService = new SointuvisaService(questionDao, userDao);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        
        //usernameInputScene
        Text header = header();
        VBox usernameInputPane = new VBox(10);

        usernameInputPane.setPadding(new Insets(10));
        Label loginLabel = new Label("Anna käyttäjänimesi:");
        usernameInput = new TextField();

        Button okButton = new Button("OK");
        Label loginMessage = new Label();

        okButton.setOnAction(e -> {
            String username = usernameInput.getText();
            sointuvisaService.createUser(username);
            usernameInput.setText("");
            primaryStage.setScene(startScene);
        });
        usernameInputPane.getChildren().addAll(header, loginMessage, loginLabel, usernameInput, okButton);
        usernameInputScene = new Scene(usernameInputPane, 300, 250);

        //Start scene
        VBox startPane = new VBox(10);
        Text welcomeText = new Text();
        welcomeText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));

        welcomeText.setText("Tervetuloa opettelemaan \nsointujen tunnistusta!\n\n");
        welcomeText.setX(50);
        welcomeText.setY(50);
        Button startButton = new Button("Aloita");
        startButton.setOnAction(e -> {
            primaryStage.setScene(qScene1);
        });
        startPane.getChildren().add(welcomeText);
        startPane.getChildren().add(startButton);
        startScene = new Scene(startPane, 300, 200);

        
        
        //QuestionScene 1
        q1 = sointuvisaService.getQuestionById(1);
        VBox p1 = addQuestiontemplate(q1);
        Button next1 = new Button("Seuraava");
        p1.getChildren().add(next1);
        next1.setOnAction(e -> {
            primaryStage.setScene(qScene2);
                RadioButton rb = (RadioButton) group.getSelectedToggle();
                
                if (rb != null) {
                    String selected = rb.getText().toLowerCase();
                    System.out.println(selected);
                    if (q1.getChordType().equals(selected)) {
                        try {
                            User u = sointuvisaService.getUserByUsername(usernameInput.getText());
                            u.setPoints(1);
                            System.out.println(u.getPoints());
                        } catch (Exception ex) {
                            Logger.getLogger(sointuvisaUi.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                });
        
        qScene1 = new Scene(p1);
        

        //QuestionScene 2
        Question q2 = sointuvisaService.getQuestionById(2);
        VBox p2 = addQuestiontemplate(q2);
        Button next2 = new Button("Seuraava");
        p2.getChildren().add(next2);
        next2.setOnAction(e -> primaryStage.setScene(qScene3));
        qScene2 = new Scene(p2);

        //QuestionScene 3
        Question q3 = sointuvisaService.getQuestionById(3);
        VBox p3 = addQuestiontemplate(q3);
        Button next3 = new Button("Seuraava");
        p3.getChildren().add(next3);
        next3.setOnAction(e -> primaryStage.setScene(qScene4));
        qScene3 = new Scene(p3);
        
        //QuestionScene 4
        Question q4 = sointuvisaService.getQuestionById(4);
        VBox p4 = addQuestiontemplate(q4);
        Button next4 = new Button("Seuraava");
        p4.getChildren().add(next4);
        next4.setOnAction(e -> {
            primaryStage.setScene(qScene5);
            group.getSelectedToggle();
                });
        qScene4 = new Scene(p4);
        
        //QuestionScene 5
        Question q5 = sointuvisaService.getQuestionById(5);
        VBox p5 = addQuestiontemplate(q5);
        Button next5 = new Button("Seuraava");
        p5.getChildren().add(next5);
        next5.setOnAction(e -> primaryStage.setScene(qScene6));
        qScene5 = new Scene(p5);

        primaryStage.setTitle("Sointuvisa");
        primaryStage.setScene(usernameInputScene);
        primaryStage.show();

    }

    public VBox addQuestiontemplate(Question q) {
        Text text = header();
        
        Text questionNumberText = new Text();
        questionNumberText.setFont(Font.font("verdana", FontPosture.REGULAR, 13));
        questionNumberText.setText("Sointu numero " + q.getId());
        //Kuuntelunapin luonti
        Button play1 = new Button("Kuuntele");
        //Radiopainikkeiden käsittely
        
        Label l = new Label("Valitse oikea sointutyyppi: ");
        Label chosen = new Label("Valintasi: ");
        RadioButton rb1 = new RadioButton("Duuri");
        RadioButton rb2 = new RadioButton("Molli");
        RadioButton rb3 = new RadioButton("Vähennetty");
        RadioButton rb4 = new RadioButton("Ylinouseva");
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);
        rb4.setToggleGroup(group);

        VBox pane = new VBox(8);
        pane.setAlignment(Pos.CENTER_LEFT);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.getChildren().add(text);
        pane.getChildren().add(questionNumberText);
        pane.getChildren().add(play1);
        pane.getChildren().add(l);
        pane.getChildren().add(rb1);
        pane.getChildren().add(rb2);
        pane.getChildren().add(rb3);
        pane.getChildren().add(rb4);
        pane.getChildren().add(chosen);

        //listenerin toiminta
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ob,
                    Toggle o, Toggle n) {
                RadioButton rb = (RadioButton) group.getSelectedToggle();
                if (rb != null) {
                    String s = rb.getText();

                    // change the label 
                    chosen.setText("Valintasi: " + s);
                }
            }
        });
        Media media1 = new Media(new File(q.getAudio_url()).toURI().toString());
        MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
        play1.setOnAction(e -> {
            mediaPlayer1.seek(mediaPlayer1.getStartTime());
            mediaPlayer1.play();
        });

        return pane;
    }
    
    public Text header() {
        Text text = new Text();
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text.setText("Sointuvisa");
        text.setX(50);
        text.setY(50);
        
        return text;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
