import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.scene.ImageCursor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.util.Duration;

@SuppressWarnings("SuspiciousMethodCalls")
public class LevelGenerator {
    public static Duck duck1 = new Duck(100,350, AnimationAsset.black_horizontal_flying, AnimationAsset.black_shot, AnimationAsset.black_fall);
    private static final Duck duck2 = new Duck(600,350, AnimationAsset.blue_horizontal_flying, AnimationAsset.blue_shot, AnimationAsset.blue_fall);
    private static final Duck duck3 = new Duck(300,180, AnimationAsset.red_horizontal_flying, AnimationAsset.red_shot, AnimationAsset.red_fall);
    private static final Duck duck4 = new Duck(200,200, AnimationAsset.black_diagonal_flying, AnimationAsset.black_shot, AnimationAsset.black_fall);
    private static final Duck duck5 = new Duck(400,500, AnimationAsset.blue_diagonal_flying, AnimationAsset.blue_shot, AnimationAsset.blue_fall);
    private static final Duck duck6 = new Duck(300,400, AnimationAsset.red_diagonal_flying, AnimationAsset.red_shot, AnimationAsset.red_fall);
    private static boolean horizontal, isInScene, isInSceneOver, winText, overText, win, isOver, enterPressed = false;
    private static int ammo = 3;
    private static CustomText AMMO;
    private static final int FRAME_DURATION = 200;
    private static Timeline timeline1, timeline2, timeline3, timeline4, timeline5, timeline6;

    public static void levelGenerator(Stage primaryStage){
        level1(primaryStage);
    }

    public static void level1(Stage primaryStage){
        ammo = 3;
        AMMO = new CustomText("Ammo Left: " + ammo, 550, 0, 10);
        horizontal = true;
        showDuck(duck1);
        TextAsset.LEVEL1.showText();
        AMMO.showText();
        timeline1 = new Timeline(new KeyFrame(Duration.millis(FRAME_DURATION), event -> {
            Move.moveDuck(horizontal, duck1);
            ammoChecker();
            if (duck1.isShot()){
                enterPressed = false;
                winLevel();
            }
            if (ammo == 0 && !win && !duck1.isShot()) gameOver(primaryStage, timeline1);
            if (duck1.isShot()){
                CustomApplication.scene.setOnKeyPressed(levelEvent -> {
                    if (!enterPressed && levelEvent.getCode() == KeyCode.ENTER) {
                        enterPressed = true;
                        duck1.setShot(false);
                        clearScene();
                        ammo = 3;
                        level2(primaryStage);
                        timeline1.stop();
                    }
                });
            }
        }));
        timeline1.setCycleCount(Animation.INDEFINITE);
        timeline1.play();
    }

    public static void level2(Stage primaryStage){
        AMMO = new CustomText("Ammo Left: " + ammo, 550, 0, 10);
        horizontal = false;
        showDuck(duck4);
        TextAsset.LEVEL2.showText();
        AMMO.showText();
        timeline2 = new Timeline(new KeyFrame(Duration.millis(FRAME_DURATION), event -> {
            Move.moveDuck(horizontal, duck4);
            ammoChecker();
            if (duck4.isShot()){
                enterPressed = false;
                winLevel();
            }
            if (ammo == 0 && !win && !duck4.isShot()) gameOver(primaryStage, timeline2);
            if (duck4.isShot()) {
                CustomApplication.scene.setOnKeyPressed(levelEvent -> {
                    if (!enterPressed && levelEvent.getCode() == KeyCode.ENTER) {
                        enterPressed = true;
                        duck4.setShot(false);
                        clearScene();
                        ammo = 6;
                        level3(primaryStage);
                        timeline2.stop();
                    }
                });
            }
        }));
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();
    }

    public static void level3(Stage primaryStage){
        AMMO = new CustomText("Ammo Left: " + ammo, 550, 0, 10);
        horizontal = true;
        showDuck(duck1);
        showDuck(duck2);
        TextAsset.LEVEL3.showText();
        AMMO.showText();
        timeline3 = new Timeline(new KeyFrame(Duration.millis(FRAME_DURATION), event -> {
            Move.moveDuck(horizontal, duck1);
            Move.moveDuck(horizontal, duck2);
            ammoChecker();
            if (duck1.isShot() && duck2.isShot()){
                enterPressed = false;
                winLevel();
            }
            if (ammo == 0 && !win &&  (!duck1.isShot() || !duck2.isShot())) gameOver(primaryStage, timeline3);
            if (duck1.isShot() && duck2.isShot()) {
                CustomApplication.scene.setOnKeyPressed(levelEvent -> {
                    if (!enterPressed && levelEvent.getCode() == KeyCode.ENTER) {
                        enterPressed = true;
                        duck1.setShot(false);
                        duck2.setShot(false);
                        clearScene();
                        ammo = 6;
                        level4(primaryStage);
                        timeline3.stop();
                    }
                });
            }
        }));
        timeline3.setCycleCount(Animation.INDEFINITE);
        timeline3.play();
    }

    public static void level4(Stage primaryStage){
        AMMO = new CustomText("Ammo Left: " + ammo, 550, 0, 10);
        horizontal = false;
        showDuck(duck4);
        showDuck(duck5);
        TextAsset.LEVEL4.showText();
        AMMO.showText();
        timeline4 = new Timeline(new KeyFrame(Duration.millis(FRAME_DURATION), event -> {
            Move.moveDuck(horizontal, duck4);
            Move.moveDuck(horizontal, duck5);
            ammoChecker();
            if (duck4.isShot() && duck5.isShot()){
                enterPressed = false;
                winLevel();
            }
            if (ammo == 0 && !win &&  (!duck4.isShot() || !duck5.isShot())) gameOver(primaryStage, timeline4);
            if (duck4.isShot() && duck5.isShot()) {
                CustomApplication.scene.setOnKeyPressed(levelEvent -> {
                    if (!enterPressed && levelEvent.getCode() == KeyCode.ENTER) {
                        enterPressed = true;
                        duck4.setShot(false);
                        duck5.setShot(false);
                        clearScene();
                        ammo = 9;
                        level5(primaryStage);
                        timeline4.stop();
                    }
                });
            }
        }));
        timeline4.setCycleCount(Animation.INDEFINITE);
        timeline4.play();
    }

    public static void level5(Stage primaryStage){
        AMMO = new CustomText("Ammo Left: " + ammo, 550, 0, 10);
        horizontal = true;
        showDuck(duck1);
        showDuck(duck2);
        showDuck(duck3);
        TextAsset.LEVEL5.showText();
        AMMO.showText();
        timeline5 = new Timeline(new KeyFrame(Duration.millis(FRAME_DURATION), event -> {
            Move.moveDuck(horizontal, duck1);
            Move.moveDuck(horizontal, duck2);
            Move.moveDuck(horizontal, duck3);
            ammoChecker();
            if (duck1.isShot() && duck2.isShot() && duck3.isShot()){
                enterPressed = false;
                winLevel();
            }
            if (ammo == 0 && !win &&  (!duck1.isShot() || !duck2.isShot() || !duck3.isShot())) gameOver(primaryStage, timeline5);
            if (duck1.isShot() && duck2.isShot() && duck3.isShot()) {
                CustomApplication.scene.setOnKeyPressed(levelEvent -> {
                    if (!enterPressed && levelEvent.getCode() == KeyCode.ENTER) {
                        enterPressed = true;
                        duck1.setShot(false);
                        duck2.setShot(false);
                        duck3.setShot(false);
                        clearScene();
                        ammo = 9;
                        level6(primaryStage);
                        timeline5.stop();
                    }
                });
            }
        }));
        timeline5.setCycleCount(Animation.INDEFINITE);
        timeline5.play();
    }

    public static void level6(Stage primaryStage){
        AMMO = new CustomText("Ammo Left: " + ammo, 550, 0, 10);
        horizontal = false;
        showDuck(duck4);
        showDuck(duck5);
        showDuck(duck6);
        TextAsset.LEVEL6.showText();
        AMMO.showText();
        timeline6 = new Timeline(new KeyFrame(Duration.millis(FRAME_DURATION), event -> {
            Move.moveDuck(horizontal, duck4);
            Move.moveDuck(horizontal, duck5);
            Move.moveDuck(horizontal, duck6);
            ammoChecker();
            if (duck4.isShot() && duck5.isShot() && duck6.isShot()){
                enterPressed = false;
                complete();
            }
            if (ammo == 0 && !win &&  (!duck4.isShot() || !duck5.isShot() || !duck6.isShot())) gameOver(primaryStage, timeline6);
            if (duck4.isShot() && duck5.isShot() && duck6.isShot()) {
                CustomApplication.scene.setOnKeyPressed(levelEvent -> {
                    if (!enterPressed && levelEvent.getCode() == KeyCode.ENTER) {
                        enterPressed = true;
                        duck4.setShot(false);
                        duck5.setShot(false);
                        duck6.setShot(false);
                        clearScene();
                        AMMO.removeText();
                        ammo = 3;
                        timeline6.stop();
                        level1(primaryStage);
                    }
                    else if (levelEvent.getCode() == KeyCode.ESCAPE) {
                        duck4.setShot(false);
                        duck5.setShot(false);
                        duck6.setShot(false);
                        clearScene();
                        AMMO.removeText();
                        ammo = 3;
                        timeline6.stop();
                        CustomApplication.root.getChildren().remove(Options.getBackground());
                        CustomApplication.root.getChildren().remove(Options.getForeground());
                        Welcome.welcome(primaryStage);
                    }
                });
            }
        }));
        timeline6.setCycleCount(Animation.INDEFINITE);
        timeline6.play();
    }

    public static void showDuck(Duck duck){
        CustomApplication.root.getChildren().add(duck.getDuckImageView());
        duck.getDuckImageView().setLayoutX(duck.getX());
        duck.getDuckImageView().setLayoutY(duck.getY());
        Options.getForeground().toFront();
    }

    public static void winLevel(){
        win = true;
        CustomApplication.scene.setOnMouseClicked(Event::consume);
        if(!winText){
            TextAsset.WIN.showText();
            SoundAsset.levelCompleted.stop();
            SoundAsset.levelCompleted.play();
            winText = true;
        }
        if(!isInScene){
            TextAsset.NEXT_LEVEL.showText();
            TextAsset.NEXT_LEVEL.Transition();
            isInScene = true;
        }
    }

    public static void complete(){
        if(!winText){
            TextAsset.COMPLETE.showText();
            SoundAsset.gameCompleted.stop();
            SoundAsset.gameCompleted.play();
            winText = true;
        }
        if(!isInScene){
            TextAsset.AGAIN.showText();
            TextAsset.ESC.showText();
            TextAsset.AGAIN.Transition();
            TextAsset.ESC.Transition();
            isInScene = true;
        }
    }

    public static void ammoChecker(){
        CustomApplication.scene.setOnMouseClicked(clickEvent -> {
            if (clickEvent.getButton() == MouseButton.PRIMARY) {
                SoundAsset.gunshot.stop();
                SoundAsset.gunshot.play();
                AMMO.removeText();
                if (ammo > 0) ammo--;
                AMMO = new CustomText("Ammo Left: " + ammo, 550, 0, 10);
                AMMO.showText();
            }
        });
    }

    public static void gameOver(Stage primaryStage, Timeline timeline){
        CustomApplication.scene.setOnMouseClicked(Event::consume);
        duck1.getDuckImageView().setOnMouseClicked(Event::consume);
        duck2.getDuckImageView().setOnMouseClicked(Event::consume);
        duck3.getDuckImageView().setOnMouseClicked(Event::consume);
        duck4.getDuckImageView().setOnMouseClicked(Event::consume);
        duck5.getDuckImageView().setOnMouseClicked(Event::consume);
        duck6.getDuckImageView().setOnMouseClicked(Event::consume);
        isOver = true;
        if(!overText){
            TextAsset.GAME_OVER.showText();
            SoundAsset.gameOver.stop();
            SoundAsset.gameOver.play();
            overText = true;
        }
        if(!isInSceneOver){
            TextAsset.AGAIN.showText();
            TextAsset.ESC.showText();
            TextAsset.AGAIN.Transition();
            TextAsset.ESC.Transition();
            isInSceneOver = true;
        }
        CustomApplication.scene.setOnKeyPressed(overEvent -> {
            if (isOver && overEvent.getCode() == KeyCode.ENTER) {
                isOver = false;
                timeline.stop();
                clearScene();
                level1(primaryStage);
            }
            if (isOver && overEvent.getCode() == KeyCode.ESCAPE) {
                isOver = false;
                timeline.stop();
                clearScene();
                CustomApplication.root.getChildren().subList(0, CustomApplication.root.getChildren().size()).clear();
                CustomApplication.scene.setCursor(new ImageCursor());
                Welcome.welcome(primaryStage);
            }
        });
    }

    public static void clearScene(){
        win = false;
        CustomApplication.root.getChildren().remove(duck1.getDuckImageView());
        CustomApplication.root.getChildren().remove(duck2.getDuckImageView());
        CustomApplication.root.getChildren().remove(duck3.getDuckImageView());
        CustomApplication.root.getChildren().remove(duck4.getDuckImageView());
        CustomApplication.root.getChildren().remove(duck5.getDuckImageView());
        CustomApplication.root.getChildren().remove(duck6.getDuckImageView());
        for (int i = 0; i < 3; i++){
            CustomApplication.root.getChildren().remove(duck1.getDuckImage()[i]);
            CustomApplication.root.getChildren().remove(duck2.getDuckImage()[i]);
            CustomApplication.root.getChildren().remove(duck3.getDuckImage()[i]);
            CustomApplication.root.getChildren().remove(duck4.getDuckImage()[i]);
            CustomApplication.root.getChildren().remove(duck5.getDuckImage()[i]);
            CustomApplication.root.getChildren().remove(duck6.getDuckImage()[i]);
        }
        TextAsset.LEVEL1.removeText();
        TextAsset.LEVEL2.removeText();
        TextAsset.LEVEL3.removeText();
        TextAsset.LEVEL4.removeText();
        TextAsset.LEVEL5.removeText();
        TextAsset.LEVEL6.removeText();
        TextAsset.WIN.removeText();
        TextAsset.NEXT_LEVEL.removeText();
        AMMO.removeText();
        TextAsset.COMPLETE.removeText();
        TextAsset.AGAIN.removeText();
        TextAsset.ESC.removeText();
        TextAsset.GAME_OVER.removeText();
        isInScene = false;
        winText = false;
        overText = false;
        isInSceneOver = false;
        SoundAsset.duckFalls.stop();
        SoundAsset.gameCompleted.stop();
        SoundAsset.gameOver.stop();
        SoundAsset.gunshot.stop();
        SoundAsset.intro.stop();
        SoundAsset.levelCompleted.stop();
        SoundAsset.title.stop();
    }
}
