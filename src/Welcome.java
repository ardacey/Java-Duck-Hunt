import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Welcome {
    public static ImageView welcome = UIAsset.welcome;
    public static void welcome(Stage primaryStage){
        welcome.setFitWidth(welcome.getImage().getWidth() * DuckHunt.SCALE);
        welcome.setFitHeight(welcome.getImage().getHeight() * DuckHunt.SCALE);

        CustomApplication.root.getChildren().add(welcome);

        TextAsset.MAIN_START.showText();
        TextAsset.MAIN_START.Transition();

        TextAsset.MAIN_EXIT.showText();
        TextAsset.MAIN_EXIT.Transition();

        SoundAsset.title.play();

        CustomApplication.scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                CustomApplication.root.getChildren().remove(welcome);
                TextAsset.MAIN_START.removeText();
                TextAsset.MAIN_EXIT.removeText();
                Options.optionSelector(primaryStage);
            }
            if (event.getCode() == KeyCode.ESCAPE) {
                System.exit(0);
            }
        });
    }
}
