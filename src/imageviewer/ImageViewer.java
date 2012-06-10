/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Manuel DAHMEN
 */
public class ImageViewer extends Application {

    private Accordion accordian;
    private Button openwithButton;
    private Button loadButton;
    private ImageViewer image;

    public static void main(String[] args) {
        Application.launch(ImageViewer.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
        stage.setScene(new Scene(root));
        loadButton = new Button();
        loadButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                try {
                    List<BufferedImage> img = new ArrayList<BufferedImage>();
                    try {
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setTitle("Choisir des fichiers");
                        List<File> files = fileChooser.showOpenMultipleDialog(null);
                        Iterator<File> it = files.iterator();
                        while (it.hasNext()) {
                            img.add(ImageIO.read(it.next()));
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ImageViewer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (img.size() > 0) {
                        image.start(null);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ImageViewer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        stage.show();
    }
}
