package project1GIVE_TO_STUDENTS;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StopWatchGUIFX extends Application {

    private Button susButton;

    @Override
    public void start(Stage primaryStage) throws Exception {

        String cssLayout = "-fx-border-color: Black;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n";

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.getChildren().add (new StopWatchPanelFX());

        susButton = new Button("Suspend is OFF");
        root.getChildren().add (susButton);
        root.setSpacing(60);

        susButton.setOnAction(this::actionPerformed);
        root.setSpacing(10);

        root.setStyle(cssLayout);
        primaryStage.setTitle("StopWatch");
        primaryStage.setScene(new Scene(root, 1200, 300));
        primaryStage.show();
    }

    private void actionPerformed(javafx.event.ActionEvent actionEvent) {

    }
    
    public static void main(String[] args) {
        launch(args);
    }
}