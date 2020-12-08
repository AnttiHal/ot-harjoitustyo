
/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    Scene usernameInputScene, startScene, HSScene, qScene1,
            qScene2, qScene3, qScene4, qScene5, qScene6, qScene7, qScene8,
            qScene9, qScene10, endScene;
    Question q1;
    User user;
    int points;

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
        Button HSButton = new Button("Huipputulokset");
        Label loginMessage = new Label();
        Label message = new Label();
        okButton.setOnAction(e -> {

            String username = usernameInput.getText();
            if (username.length() < 3) {
                message.setText("Käyttäjänimen tulee olla \nvähintään kolme merkkiä pitkä");
            } else {
                sointuvisaService.createUser(username);
                try {
                    user = sointuvisaService.getUserByUsername(username);
                } catch (Exception ex) {
                    Logger.getLogger(sointuvisaUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                usernameInput.setText("");
                primaryStage.setScene(startScene);
            }
        });
        HSButton.setOnAction(e -> {
            try {
                primaryStage.setScene(getHighScoreScene(usernameInputScene, primaryStage));
            } catch (Exception ex) {
                Logger.getLogger(sointuvisaUi.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        usernameInputPane.getChildren().addAll(header(), loginMessage, loginLabel, usernameInput, okButton, message, HSButton);
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
        startPane.getChildren().add(header);
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
            checkAnswerAndRaisePointsIfCorrect(q1);
            addAnswer();

        });
        qScene1 = new Scene(p1);

        //QuestionScene 2
        Question q2 = sointuvisaService.getQuestionById(2);
        VBox p2 = addQuestiontemplate(q2);
        Button next2 = new Button("Seuraava");
        p2.getChildren().addAll(next2);
        next2.setOnAction(e -> {
            primaryStage.setScene(qScene3);
            checkAnswerAndRaisePointsIfCorrect(q2);
            addAnswer();
        });
        qScene2 = new Scene(p2);

        //QuestionScene 3
        Question q3 = sointuvisaService.getQuestionById(3);
        VBox p3 = addQuestiontemplate(q3);
        Button next3 = new Button("Seuraava");
        p3.getChildren().addAll(next3);
        next3.setOnAction(e -> {
            primaryStage.setScene(qScene4);
            checkAnswerAndRaisePointsIfCorrect(q3);
            addAnswer();
        });
        qScene3 = new Scene(p3);

        //QuestionScene 4
        Question q4 = sointuvisaService.getQuestionById(4);
        VBox p4 = addQuestiontemplate(q4);
        Button next4 = new Button("Seuraava");
        p4.getChildren().addAll(next4);
        next4.setOnAction(e -> {
            addAnswer();
            primaryStage.setScene(qScene5);
            checkAnswerAndRaisePointsIfCorrect(q4);
        });
        qScene4 = new Scene(p4);

        //QuestionScene 5
        Question q5 = sointuvisaService.getQuestionById(5);
        VBox p5 = addQuestiontemplate(q5);
        Button next5 = new Button("Seuraava");
        p5.getChildren().addAll(next5);
        next5.setOnAction(e -> {
            primaryStage.setScene(qScene6);
            checkAnswerAndRaisePointsIfCorrect(q5);
            addAnswer();
        });
        qScene5 = new Scene(p5);

        //QuestionScene 6
        Question q6 = sointuvisaService.getQuestionById(6);
        VBox p6 = addQuestiontemplate(q6);
        Button next6 = new Button("Seuraava");
        p6.getChildren().addAll(next6);
        next6.setOnAction(e -> {
            primaryStage.setScene(qScene7);
            checkAnswerAndRaisePointsIfCorrect(q6);
            addAnswer();
        });
        qScene6 = new Scene(p6);

        //QuestionScene 7
        Question q7 = sointuvisaService.getQuestionById(7);
        VBox p7 = addQuestiontemplate(q7);
        Button next7 = new Button("Seuraava");
        p7.getChildren().addAll(next7);
        next7.setOnAction(e -> {
            primaryStage.setScene(qScene8);
            checkAnswerAndRaisePointsIfCorrect(q7);
            addAnswer();
        });
        qScene7 = new Scene(p7);

        //QuestionScene 8
        Question q8 = sointuvisaService.getQuestionById(8);
        VBox p8 = addQuestiontemplate(q8);
        Button next8 = new Button("Seuraava");
        p8.getChildren().addAll(next8);
        next8.setOnAction(e -> {
            primaryStage.setScene(qScene9);
            checkAnswerAndRaisePointsIfCorrect(q8);
            addAnswer();
        });
        qScene8 = new Scene(p8);

        //QuestionScene 9
        Question q9 = sointuvisaService.getQuestionById(9);
        VBox p9 = addQuestiontemplate(q9);
        Button next9 = new Button("Seuraava");
        p9.getChildren().addAll(next9);
        next9.setOnAction(e -> {
            primaryStage.setScene(qScene10);
            checkAnswerAndRaisePointsIfCorrect(q9);
            addAnswer();
        });
        qScene9 = new Scene(p9);

        //QuestionScene 10
        Question q10 = sointuvisaService.getQuestionById(10);
        VBox p10 = addQuestiontemplate(q10);
        Button next10 = new Button("katso tulokset");
        p10.getChildren().addAll(next10);
        next10.setOnAction(e -> {
            checkAnswerAndRaisePointsIfCorrect(q10);
            addAnswer();
            VBox endPane = new VBox(10);
            Text endText = new Text();
            ArrayList<Question> list;
            Text qu1 = new Text();
            Text qu2 = new Text();
            Text qu3 = new Text();
            Text qu4 = new Text();
            Text qu5 = new Text();
            Text qu6 = new Text();
            Text qu7 = new Text();
            Text qu8 = new Text();
            Text qu9 = new Text();
            Text qu10 = new Text();
            try {
                list = sointuvisaService.getQuestionList();
                qu1.setText("Kysymys 1, oikea sointutyyppi:" + list.get(0).getChordType() + ", vastauksesi:" + sointuvisaService.getAnswerByNumber(0));
                qu2.setText("Kysymys 2, oikea sointutyyppi:" + list.get(1).getChordType() + ", vastauksesi:" + sointuvisaService.getAnswerByNumber(1));
                qu3.setText("Kysymys 3, oikea sointutyyppi:" + list.get(2).getChordType() + ", vastauksesi:" + sointuvisaService.getAnswerByNumber(2));
                qu4.setText("Kysymys 4, oikea sointutyyppi:" + list.get(3).getChordType() + ", vastauksesi:" + sointuvisaService.getAnswerByNumber(3));
                qu5.setText("Kysymys 5, oikea sointutyyppi:" + list.get(4).getChordType() + ", vastauksesi:" + sointuvisaService.getAnswerByNumber(4));
                qu6.setText("Kysymys 6, oikea sointutyyppi:" + list.get(5).getChordType() + ", vastauksesi:" + sointuvisaService.getAnswerByNumber(5));
                qu7.setText("Kysymys 7, oikea sointutyyppi:" + list.get(6).getChordType() + ", vastauksesi:" + sointuvisaService.getAnswerByNumber(6));
                qu8.setText("Kysymys 8, oikea sointutyyppi:" + list.get(7).getChordType() + ", vastauksesi:" + sointuvisaService.getAnswerByNumber(7));
                qu9.setText("Kysymys 9, oikea sointutyyppi:" + list.get(8).getChordType() + ", vastauksesi:" + sointuvisaService.getAnswerByNumber(8));
                qu10.setText("Kysymys 10, oikea sointutyyppi:" + list.get(9).getChordType() + ", vastauksesi:" + sointuvisaService.getAnswerByNumber(9));

            } catch (Exception ex) {
                Logger.getLogger(sointuvisaUi.class.getName()).log(Level.SEVERE, null, ex);
            }

            endText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
            endText.setText("Sait " + getUserPoints() + "/10 pistettä!");

            endText.setX(50);
            endText.setY(50);
            Button HSButton2 = new Button("Huipputulokset");
            Button playAgain = new Button("Pelaa uudestaan");
            Button quit = new Button("Lopeta");
            HSButton2.setOnAction(e1 -> {
                try {
                    primaryStage.setScene(getHighScoreScene(endScene, primaryStage));
                } catch (Exception ex) {
                    Logger.getLogger(sointuvisaUi.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            playAgain.setOnAction(e1 -> {
                try {
                    sointuvisaService.clearAnswerList();
                    sointuvisaService.resetPoints(user);
                    sointuvisaService.savePoints();
                } catch (Exception ex) {
                    Logger.getLogger(sointuvisaUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                primaryStage.setScene(startScene);

            });
            quit.setOnAction(e1 -> {
                try {
                    sointuvisaService.savePoints();
                } catch (Exception ex) {
                    Logger.getLogger(sointuvisaUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                Platform.exit();
            });
            endPane.getChildren().addAll(header(), endText, qu1, qu2, qu3, qu4, qu5, qu6, qu7, qu8, qu9, qu10, HSButton2, playAgain, quit);
            endScene = new Scene(endPane, 500, 500);
            primaryStage.setScene(endScene);

            try {

                points = getUserPoints();

            } catch (Exception ex) {
                Logger.getLogger(sointuvisaUi.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        qScene10 = new Scene(p10);

        //EndScene
        primaryStage.setTitle("Sointuvisa");
        primaryStage.setScene(usernameInputScene);
        primaryStage.show();
    }

    public int getUserPoints() {
        int points = 0;
        try {
            points = sointuvisaService.getUserPoints(user);
        } catch (Exception ex) {
            Logger.getLogger(sointuvisaUi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return points;
    }

    public void checkAnswerAndRaisePointsIfCorrect(Question q) {
        RadioButton rb = (RadioButton) group.getSelectedToggle();
        if (rb != null) {
            String selected = rb.getText().toLowerCase();
            if (q.getChordType().equals(selected)) {
                try {
                    sointuvisaService.updateUserPoints(user);
                } catch (Exception ex) {
                    Logger.getLogger(sointuvisaUi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Scene getHighScoreScene(Scene backScene, Stage ps) throws Exception {
        VBox HSPane = new VBox(10);
        ArrayList<User> theBest = sointuvisaService.getTopThree();
        Text tulokset = new Text();
        Text yksi = new Text();
        Text kaksi = new Text();
        Text kolme = new Text();
        yksi.setText("1. " + theBest.get(0).getUsername() + ", " + theBest.get(0).getPoints() + " pistettä");
        kaksi.setText("2. " + theBest.get(1).getUsername() + ", " + theBest.get(1).getPoints() + " pistettä");
        kolme.setText("3. " + theBest.get(2).getUsername() + ", " + theBest.get(2).getPoints() + " pistettä");
        tulokset.setText("Tarkkakorvaisimmat pelaajat");
        Button backButton = new Button("Takaisin");
        backButton.setOnAction(e -> {
            ps.setScene(backScene);
        });
        HSPane.getChildren().addAll(header(), tulokset, yksi, kaksi, kolme, backButton);
        HSScene = new Scene(HSPane, 300, 200);
        return HSScene;
    }

    public void addAnswer() {
        RadioButton rb = (RadioButton) group.getSelectedToggle();
        if (rb != null) {
            String selected = rb.getText().toLowerCase();
            sointuvisaService.addAnswer(selected);
        }
    }

    public VBox addQuestiontemplate(Question q) throws URISyntaxException {
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
        
        Media media1 = new Media(this.getClass().getResource(q.getAudioUrl()).toString());
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
