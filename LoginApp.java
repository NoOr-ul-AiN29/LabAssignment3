import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginApp extends Application {

  
    private final String[][] credentials1= {
            {"user1", "pass1"},
            {"user2", "pass2"},
            {"admin", "adminpass"}
    };

    @Override
    public void start(Stage primaryStage) {
    
        Image image = new Image("im.png"); 
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(300);
        imageView.setFitHeight(200);


        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

    
        Button loginButton = new Button("Login");
        Button cancelButton = new Button("Cancel");
        Button exitButton = new Button("Exit");

        
        Label notificationLabel = new Label();

        
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (validateCredentials(username, password)) {
                notificationLabel.setText("Login successful!");
            } else {
                notificationLabel.setText("Invalid username or password.");
            }
        });

        
        cancelButton.setOnAction(e -> {
            usernameField.clear();
            passwordField.clear();
            notificationLabel.setText("");
        });

    
        exitButton.setOnAction(e -> primaryStage.close());

    
        VBox layout = new VBox(10);
        layout.getChildren().addAll(imageView, usernameField, passwordField, loginButton, cancelButton, exitButton, notificationLabel);

    
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    private boolean validateCredentials(String username, String password) {
        for (String[] pair : credentials1) {
            if (pair[0].equals(username) && pair[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
    private static final String CREDENTIALS_FILE = "D:\\PROGRAMMING\\java\\JavaGUI\\FirstGui\\src";
    private final Map<String, String> credentials = new HashMap<>();

    public static void main(String[] args) {
        launch(args);
    }
}