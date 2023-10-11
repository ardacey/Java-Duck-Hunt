import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class CustomText extends Text {
    private StackPane text;
    public CustomText(String string, double x, double y, double size) {
        Text textString = new Text(string);
        textString.setFont(Font.font("Verdana", size * DuckHunt.SCALE));
        textString.setFill(Color.ORANGE);
        this.text = new StackPane(textString);
        text.setTranslateX(x);
        text.setTranslateY(y);
    }

    public void showText(){
        CustomApplication.root.getChildren().add(text);
    }

    public void removeText(){
        CustomApplication.root.getChildren().remove(text);
    }

    public void Transition(){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(text.visibleProperty(), true)),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(text.visibleProperty(), false)),
                new KeyFrame(Duration.seconds(1), new KeyValue(text.visibleProperty(), true))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void textToFront(){
        text.toFront();
    }
}
