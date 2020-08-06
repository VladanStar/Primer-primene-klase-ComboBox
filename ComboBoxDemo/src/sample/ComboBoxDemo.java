package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.Flags;

public class ComboBoxDemo extends Application {

    // Deklaracija niza sa String objektima za naslove zastava
    private String[] flagTitles = {"Canada", "China", "Denmark",
            "France", "Germany", "India", "Norway", "United Kingdom",
            "United States of America"};

    // Deklaracija niza objekata ImageView sa zastavama 9 zemalja.
    private ImageView[] flagImage = {new ImageView("image/ca.jpg"),
            new ImageView("image/china.jpg"),
            new ImageView("image/denmark.jpg"),
            new ImageView("image/fr.jpg"),
            new ImageView("image/germany.jpg"),
            new ImageView("image/india.jpg"),
            new ImageView("image/norway.jpg"),
            new ImageView("image/uk.jpg"),
            new ImageView("image/us.jpg")};

    // Deklaracija niza sa String objektima sa tekstom opisa zastava
    private String[] flagDescription = new String[9];

    // Deklaracija i kreiranja opisnog okna
    private DescriptionPane descriptionPane = new DescriptionPane();

    // Kreiranje padajužeg menija za izabrane zemlje
    private ComboBox<String> cbo = new ComboBox<>(); // nazivi zastava;

    @Override // Redefinisanje metoda start() klase Application class
    public void start(Stage primaryStage) {
        // Unos tekstova sa opisom
        flagDescription[0] = "The Canadian national flag ...";
        flagDescription[1] = "Description for China ... ";
        flagDescription[2] = "Description for Denmark ... ";
        flagDescription[3] = "Description for France ... ";
        flagDescription[4] = "Description for Germany ... ";
        flagDescription[5] = "Description for India ... ";
        flagDescription[6] = "Description for Norway ... ";
        flagDescription[7] = "Description for UK ... ";
        flagDescription[8] = "Description for US ... ";

        for (int i = 0; i < flagImage.length; i++) {
            flagImage[i].setFitHeight(150);
            flagImage[i].setFitWidth(200);
        }

        //  Unos prve zemlje (Canada) za prikaz
        setDisplay(0);

        // Dodaj padajući meni i opisno okno u granično okno
        BorderPane pane = new BorderPane();

        BorderPane paneForComboBox = new BorderPane();
        paneForComboBox.setLeft(new Label("Select a country: "));
        paneForComboBox.setCenter(cbo);
        pane.setTop(paneForComboBox);
        cbo.setPrefWidth(400);
        cbo.setValue("Canada");

        ObservableList<String> items
                = FXCollections.observableArrayList(flagTitles);
        cbo.getItems().addAll(items);
        pane.setCenter(descriptionPane);

        // Prikaz izabrane zemlje
        cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));

        // Kreiranje scene i njeno  postavljanje na pozornicu
        Scene scene = new Scene(pane, 450, 250);
        primaryStage.setTitle("ComboBoxDemo"); // Unos naslova pozornice
        primaryStage.setScene(scene); // Postavljanje scene na pozornicu
        primaryStage.show(); // Prikaz pozornice
    }

    /**
     * Postavljanje prikaza informacija na opisno okno
     */
    public void setDisplay(int index) {
        descriptionPane.setTitle(flagTitles[index]);
        descriptionPane.setImageView(flagImage[index]);
        descriptionPane.setDescription(flagDescription[index]);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
