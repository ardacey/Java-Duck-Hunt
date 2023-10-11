import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CustomApplication extends Application {

    public static Pane root;
    public static Scene scene;

    @Override
    public void start(Stage primaryStage) {
        SoundAsset.setVolume(DuckHunt.VOLUME);
        root = new Pane();
        scene = new Scene(root, DuckHunt.WINDOW_WIDTH, DuckHunt.WINDOW_HEIGHT);
        primaryStage.setTitle("HUBBM Duck Hunt");
        primaryStage.getIcons().add(UIAsset.favicon);
        Welcome.welcome(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
