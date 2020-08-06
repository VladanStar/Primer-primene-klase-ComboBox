package sample;

import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class DescriptionPane extends BorderPane {

    /**
     * Natpis za prikaz slike i naslova
     */
    private Label lblImageTitle = new Label();

    /**
     * Prostor za prikazivanje teksta
     */
    private TextArea taDescription = new TextArea();

    public DescriptionPane() {
        // Centriranje ikone i teksta i postavljenje teksta ispod ikone
        lblImageTitle.setContentDisplay(ContentDisplay.TOP);
        lblImageTitle.setPrefSize(200, 100);

        // Unos fonta natpisa i  polja za tekst
        lblImageTitle.setFont(new Font("SansSerif", 16));
        taDescription.setFont(new Font("Serif", 14));

        taDescription.setWrapText(true);
        taDescription.setEditable(false);

        // Kreiranje okna sa klizačima za prikaz polja teksta
        ScrollPane scrollPane = new ScrollPane(taDescription);

        // Postavljanje natpisa i okna sa klizačima u granično okno
        setLeft(lblImageTitle);
        setCenter(scrollPane);
        setPadding(new Insets(5, 5, 5, 5));
    }

    /**
     * Unos naslova
     */
    public void setTitle(String title) {
        lblImageTitle.setText(title);
    }

    /**
     * Unos pogleda na sliku
     */
    public void setImageView(ImageView icon) {
        lblImageTitle.setGraphic(icon);
    }

    /**
     * Unos opisa teksta
     */
    public void setDescription(String text) {
        taDescription.setText(text);
    }
}
