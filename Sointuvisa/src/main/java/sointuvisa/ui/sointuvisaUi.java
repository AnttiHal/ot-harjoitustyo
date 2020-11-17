
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
import sointuvisa.domain.SointuvisaService;

/**
 *
 * @author anttihalmetoja
 */
public class sointuvisaUi extends Application {
    private SointuvisaService sointuvisaService;
    Scene usernameInputScene, startScene, questionScene, scene2;
    
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
        VBox usernameInputPane = new VBox(10);
        
        usernameInputPane.setPadding(new Insets(10));
        Label loginLabel = new Label("käyttäjätunnus");
        TextField usernameInput = new TextField();
        
        Button okButton = new Button("OK");                
        Label loginMessage = new Label();
        
        okButton.setOnAction(e->{
            String username = usernameInput.getText();
            sointuvisaService.createUser(username);
            usernameInput.setText("");
            primaryStage.setScene(questionScene);   
        });  
        usernameInputPane.getChildren().addAll(loginMessage, loginLabel, usernameInput, okButton);
        usernameInputScene = new Scene(usernameInputPane,300,250);
        
        
        //Creating a Text object 
        Text text = new Text();
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        //Setting the text to be added. 
        text.setText("Sointuvisa");

        //setting the position of the text 
        text.setX(50);
        text.setY(50);
        //Kuuntelunapin luonti
        Button play1 = new Button("Kuuntele");

        //Radiopainikkeiden käsittely
        final ToggleGroup group = new ToggleGroup();
        Label l = new Label("Valitse oikea sointutyyppi: ");
        Label chosen = new Label("Valintasi: ");

        RadioButton rb1 = new RadioButton("Duuri");
        rb1.setToggleGroup(group);

        RadioButton rb2 = new RadioButton("Molli");
        rb2.setToggleGroup(group);
        RadioButton rb3 = new RadioButton("Vähennetty");
        rb3.setToggleGroup(group);
        RadioButton rb4 = new RadioButton("Ylinouseva");
        rb4.setToggleGroup(group);
        Button next = new Button("Seuraava");
        VBox pane = new VBox(8);
        pane.setAlignment(Pos.CENTER_LEFT);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.getChildren().add(text);
        pane.getChildren().add(play1);
        pane.getChildren().add(l);
        pane.getChildren().add(rb1);
        pane.getChildren().add(rb2);
        pane.getChildren().add(rb3);
        pane.getChildren().add(rb4);
        pane.getChildren().add(chosen);
        pane.getChildren().add(next);

        questionScene = new Scene(pane);
        
        //Toisen scenen testaus
        Label label2 = new Label("This is the second scene");
        Button button2 = new Button("Go to scene 1");
        button2.setOnAction(e -> primaryStage.setScene(questionScene));
        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(label2, button2);
        scene2 = new Scene(layout2, 300, 250);

        //Audiofailin käsittely
        String path1 = "src/main/java/sointuvisa/audiofiles/kolmisoinnut-major-1.aif";
        String path2 = "src/main/java/sointuvisa/audiofiles/kolmisoinnut-major-2.aif";
        String path3 = "src/main/java/sointuvisa/audiofiles/kolmisoinnut-major-3.aif";
        String path4 = "src/main/java/sointuvisa/audiofiles/kolmisoinnut-major-4.aif";
        String path5 = "src/main/java/sointuvisa/audiofiles/kolmisoinnut-minor-1.aif";
        String path6 = "src/main/java/sointuvisa/audiofiles/kolmisoinnut-minor-2.aif";
        String path7 = "src/main/java/sointuvisa/audiofiles/kolmisoinnut-minor-3.aif";
        String path8 = "src/main/java/sointuvisa/audiofiles/kolmisoinnut-diminished-1.aif";
        String path9 = "src/main/java/sointuvisa/audiofiles/kolmisoinnut-diminished-2.aif";
        String path10 = "src/main/java/sointuvisa/audiofiles/kolmisoinnut-diminished-3.aif";
        String path11 = "src/main/java/sointuvisa/audiofiles/kolmisoinnut-augmented-1.aif";
        String path12 = "src/main/java/sointuvisa/audiofiles/kolmisoinnut-augmented-2.aif";
        String path13 = "src/main/java/sointuvisa/audiofiles/kolmisoinnut-augmented-3.aif";
        FileQuestionDao.findQuestionById(1);
        Media media1 = new Media(new File(path1).toURI().toString());
        Media media2 = new Media(new File(path2).toURI().toString());
        MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
        play1.setOnAction(e -> {
            mediaPlayer1.seek(mediaPlayer1.getStartTime());
            mediaPlayer1.play();
        });

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

        
        next.setOnAction(e -> primaryStage.setScene(scene2));
        primaryStage.setTitle("Sointuvisa");
        primaryStage.setScene(usernameInputScene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
