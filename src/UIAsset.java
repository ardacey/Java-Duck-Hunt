import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UIAsset {
    static ImageView[] background = {
            new ImageView(new Image("assets/background/1.png")),
            new ImageView(new Image("assets/background/2.png")),
            new ImageView(new Image("assets/background/3.png")),
            new ImageView(new Image("assets/background/4.png")),
            new ImageView(new Image("assets/background/5.png")),
            new ImageView(new Image("assets/background/6.png"))
    };

    static ImageView[] foreground = {
            new ImageView(new Image("assets/foreground/1.png")),
            new ImageView(new Image("assets/foreground/2.png")),
            new ImageView(new Image("assets/foreground/3.png")),
            new ImageView(new Image("assets/foreground/4.png")),
            new ImageView(new Image("assets/foreground/5.png")),
            new ImageView(new Image("assets/foreground/6.png"))
    };

    static Image[] crosshair = {
            new Image("assets/crosshair/1.png"),
            new Image("assets/crosshair/2.png"),
            new Image("assets/crosshair/3.png"),
            new Image("assets/crosshair/4.png"),
            new Image("assets/crosshair/5.png"),
            new Image("assets/crosshair/6.png"),
            new Image("assets/crosshair/7.png")
    };

    static Image favicon = new Image("assets/favicon/1.png");

    static ImageView welcome = new ImageView(new Image("assets/welcome/1.png"));
}
