import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Duck {
    public static final double DUCK_WIDTH = 27 * DuckHunt.SCALE;
    public static final double DUCK_HEIGHT = 31 * DuckHunt.SCALE;
    private Image shotImage;
    private Image fallImage;
    private Image[] duckImage;
    private ImageView duckImageView;
    private double x;
    private double y;
    private boolean isShot;
    private boolean movingRight;
    private boolean movingDown;
    private int frameIndex;

    public Duck(double x, double y, Image[] duckImage, Image shotImage, Image fallImage) {
        this.x = x;
        this.y = y;
        this.isShot = false;
        this.duckImage = duckImage;
        this.duckImageView = new ImageView(duckImage[0]);
        this.movingRight = true;
        this.movingDown = false;
        this.shotImage = shotImage;
        this.fallImage = fallImage;
        this.frameIndex = 0;
        duckImageView.setFitWidth(DUCK_WIDTH);
        duckImageView.setFitHeight(DUCK_HEIGHT);
        duckImageView.setLayoutX( DuckHunt.WINDOW_WIDTH / 2 - DUCK_WIDTH / 2);
        duckImageView.setLayoutY( DuckHunt.WINDOW_HEIGHT / 2 - DUCK_HEIGHT / 2);
    }

    public Image[] getDuckImage() {
        return duckImage;
    }

    public ImageView getDuckImageView() {
        return duckImageView;
    }

    public void setShot(boolean shot) {
        isShot = shot;
    }

    public boolean isShot() {
        return isShot;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    public Image getShotImage() {
        return shotImage;
    }

    public Image getFallImage() {
        return fallImage;
    }

    public int getFrameIndex() {
        return frameIndex;
    }

    public void setFrameIndex(int frameIndex) {
        this.frameIndex = frameIndex;
    }
}
