import javafx.scene.ImageCursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Options {
    private static int backgroundIndex = 0;
    private static int crosshairIndex = 0;
    private static ImageView background, foreground;
    private static boolean pressed = true;
    static boolean mediaPlaying = false;
    public static void optionSelector(Stage primaryStage){
        pressed = true;
        backgroundIndex = 0;
        crosshairIndex = 0;
        backgroundSelector();
        TextAsset.NAVIGATE.showText();
        TextAsset.START.showText();
        TextAsset.EXIT.showText();
        CustomApplication.scene.setCursor(new ImageCursor(UIAsset.crosshair[crosshairIndex]));
        CustomApplication.scene.setOnKeyPressed(event -> {
            if (mediaPlaying || !pressed) {
                return;
            }

            if (event.getCode() == KeyCode.RIGHT) {
                CustomApplication.root.getChildren().remove(background);
                CustomApplication.root.getChildren().remove(foreground);
                backgroundIndex = (backgroundIndex + 1) % UIAsset.background.length;
                backgroundSelector();
            }

            if (event.getCode() == KeyCode.LEFT) {
                CustomApplication.root.getChildren().remove(background);
                CustomApplication.root.getChildren().remove(foreground);
                backgroundIndex = (backgroundIndex - 1) % UIAsset.background.length;
                if (backgroundIndex == -1) backgroundIndex = 5;
                backgroundSelector();
            }

            if (event.getCode() == KeyCode.DOWN) {
                CustomApplication.scene.setCursor(new ImageCursor(UIAsset.crosshair[crosshairIndex]));
                crosshairIndex = (crosshairIndex + 1) % UIAsset.crosshair.length;
            }

            if (event.getCode() == KeyCode.UP) {
                CustomApplication.scene.setCursor(new ImageCursor(UIAsset.crosshair[crosshairIndex]));
                crosshairIndex = (crosshairIndex - 1) % UIAsset.crosshair.length;
                if (crosshairIndex == -1) crosshairIndex = 6;
            }

            if (pressed && event.getCode() == KeyCode.ENTER) {
                pressed = false;
                SoundAsset.title.stop();
                foreground.setDisable(true);
                SoundAsset.intro.setOnEndOfMedia(() -> {
                    mediaPlaying = false;
                    TextAsset.NAVIGATE.removeText();
                    TextAsset.START.removeText();
                    TextAsset.EXIT.removeText();
                    LevelGenerator.levelGenerator(primaryStage);
                    SoundAsset.intro.stop();
                });
                SoundAsset.intro.play();
                mediaPlaying = true;
            }

            if (pressed && event.getCode() == KeyCode.ESCAPE) {
                pressed = false;
                CustomApplication.root.getChildren().remove(background);
                CustomApplication.root.getChildren().remove(foreground);
                CustomApplication.scene.setCursor(null);
                TextAsset.NAVIGATE.removeText();
                TextAsset.START.removeText();
                TextAsset.EXIT.removeText();
                Welcome.welcome(primaryStage);
            }
        });
    }

    public static void backgroundSelector(){
        background = UIAsset.background[backgroundIndex];
        foreground = UIAsset.foreground[backgroundIndex];

        background.setFitWidth(background.getImage().getWidth() * DuckHunt.SCALE);
        background.setFitHeight(background.getImage().getHeight() * DuckHunt.SCALE);

        foreground.setFitWidth(foreground.getImage().getWidth() * DuckHunt.SCALE);
        foreground.setFitHeight(foreground.getImage().getHeight() * DuckHunt.SCALE);

        CustomApplication.root.getChildren().add(background);
        CustomApplication.root.getChildren().add(foreground);

        TextAsset.NAVIGATE.textToFront();
        TextAsset.START.textToFront();
        TextAsset.EXIT.textToFront();
    }

    public static ImageView getBackground() {
        return background;
    }

    public static ImageView getForeground() {
        return foreground;
    }
}
