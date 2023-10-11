import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class SoundAsset {
    static MediaPlayer duckFalls = new MediaPlayer(new Media(new File("assets/effects/DuckFalls.mp3").toURI().toString()));
    static MediaPlayer gameCompleted = new MediaPlayer(new Media(new File("assets/effects/GameCompleted.mp3").toURI().toString()));
    static MediaPlayer gameOver = new MediaPlayer(new Media(new File("assets/effects/GameOver.mp3").toURI().toString()));
    static MediaPlayer gunshot = new MediaPlayer(new Media(new File("assets/effects/Gunshot.mp3").toURI().toString()));
    static MediaPlayer intro = new MediaPlayer(new Media(new File("assets/effects/Intro.mp3").toURI().toString()));
    static MediaPlayer levelCompleted = new MediaPlayer(new Media(new File("assets/effects/LevelCompleted.mp3").toURI().toString()));
    static MediaPlayer title = new MediaPlayer(new Media(new File("assets/effects/Title.mp3").toURI().toString()));

    public static void setVolume(double volume) {
        SoundAsset.title.setCycleCount(MediaPlayer.INDEFINITE);
        duckFalls.setVolume(volume);
        gameCompleted.setVolume(volume);
        gameOver.setVolume(volume);
        gunshot.setVolume(volume);
        intro.setVolume(volume);
        levelCompleted.setVolume(volume);
        title.setVolume(volume);
    }
}
