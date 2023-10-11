import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

public class Move {
    private static final int HORIZONTAL_MOVEMENT_SPEED = 20;
    private static final int VERTICAL_MOVEMENT_SPEED = 20;
    public static void moveDuck(boolean horizontal, Duck duck) {
        ImageView duckFrame = duck.getDuckImageView();
        Image[] duckImages = duck.getDuckImage();

        double dx = duck.isMovingRight() ? HORIZONTAL_MOVEMENT_SPEED : -HORIZONTAL_MOVEMENT_SPEED;
        double dy = duck.isMovingDown() ? VERTICAL_MOVEMENT_SPEED : -VERTICAL_MOVEMENT_SPEED;

        if(horizontal) dy = 0;

        if (!duck.isShot()){
            duckFrame.setLayoutX(duckFrame.getLayoutX() + dx);
            duckFrame.setLayoutY(duckFrame.getLayoutY() + dy);

            duckFrame.setImage(duckImages[duck.getFrameIndex()]);
            duck.setFrameIndex((duck.getFrameIndex() + 1) % duckImages.length);

            duckFrame.setOnMouseClicked(event -> {
                if (!duck.isShot() && event.getButton() == MouseButton.PRIMARY) {
                    SoundAsset.duckFalls.stop();
                    SoundAsset.duckFalls.play();
                    duck.setShot(true);
                    duckFrame.setImage(duck.getShotImage());
                }
            });

            Bounds bounds = duckFrame.getBoundsInParent();
            boolean atRightEdge = bounds.getMaxX() >= DuckHunt.WINDOW_WIDTH;
            boolean atLeftEdge = bounds.getMinX() <= 0;
            boolean atBottomEdge = bounds.getMaxY() >= DuckHunt.WINDOW_HEIGHT;
            boolean atTopEdge = bounds.getMinY() <= 0;

            if (atRightEdge) {
                duck.setMovingRight(!duck.isMovingRight());
                duckFrame.setScaleX(-1);
            }
            if (atLeftEdge) {
                duck.setMovingRight(!duck.isMovingRight());
                duckFrame.setScaleX(1);
            }
            if (atBottomEdge) {
                duck.setMovingDown(!duck.isMovingDown());
                duckFrame.setScaleY(1);
            }
            if (atTopEdge) {
                duck.setMovingDown(!duck.isMovingDown());
                duckFrame.setScaleY(-1);
            }
        }
        else {
            duckFrame.setImage(duck.getFallImage());
            duckFrame.setLayoutY(duckFrame.getLayoutY() + VERTICAL_MOVEMENT_SPEED);
        }
    }
}
