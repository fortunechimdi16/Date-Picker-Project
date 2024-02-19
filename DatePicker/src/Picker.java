import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Picker extends Application {

    private Text message;
    private DatePicker datePicker;
    private ColorPicker colorPicker;

    public void start(Stage primaryStage) {

        datePicker = new DatePicker(LocalDate.now());
        datePicker.setOnAction(this::processDateChoice);

        colorPicker = new ColorPicker(Color.BLACK);
        colorPicker.setOnAction(this::processColorChoice);

        message = new Text("Select your birthdate"); //Text to br displayed before you select your D0B
        message.setFont(Font.font("Helvetica", FontWeight.SEMI_BOLD,
                FontPosture.REGULAR, 24));

        HBox pickers = new HBox(datePicker, colorPicker);
        pickers.setSpacing(15);
        pickers.setAlignment(Pos.CENTER);

        VBox root = new VBox();
        root.setStyle("-fx-background-color:LAVENDER");
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(pickers, message);

        Scene scene = new Scene(root, 500, 300);

        primaryStage.setTitle("Date Picker");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void processDateChoice(ActionEvent event) {

        LocalDate date = datePicker.getValue();
        if (date != null) {
            int age = LocalDate.now().getYear() - date.getYear();
            message.setText("Age: " + age);
        }
    }

    public void processColorChoice(ActionEvent event) {

        message.setFill(colorPicker.getValue());
    }


}

