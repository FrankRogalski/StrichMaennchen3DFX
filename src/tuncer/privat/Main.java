package tuncer.privat;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.AmbientLight;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	
	private Pane root;
	private StrichMännchen strich;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		final double fps = 1000/60;
		Timeline tl_draw = new Timeline(new KeyFrame(Duration.millis(fps), e -> {
			this.draw();
		}));
		tl_draw.setCycleCount(Timeline.INDEFINITE);
		tl_draw.play();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.root = new Pane();
		Scene scene = new Scene(this.root, 1000, 1000, true, SceneAntialiasing.BALANCED);
		this.root.setTranslateX(scene.getWidth()/2);
		this.root.setTranslateY(scene.getHeight()/2);

		this.root.getTransforms().add(new Rotate(20, Rotate.Y_AXIS));
		this.root.getTransforms().add(new Rotate(70, Rotate.X_AXIS));
		this.root.getTransforms().add(new Rotate(0, Rotate.Z_AXIS));
		
		final double[] sizesX = {200, 100, 70, 70, 70, 70};
		final double[] sizesY = {200, 300, 170, 170, 170, 170};
		final double[] sizesZ = {200, 100, 70, 70, 70, 70};
		final String[] imgs = {"Bilder/Kopf/Kopf.png", "", "", "", "", ""}; 
		this.strich = new StrichMännchen(sizesX, sizesY, sizesZ, imgs, this.root);

		this.root.getChildren().add(new AmbientLight());
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				strich.move(e.getCode());
			}
		});
		
		primaryStage.setTitle("StrichMännchen");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void draw() {
		this.strich.show();
		
		//this.root.getTransforms().add(new Rotate(1, Rotate.Y_AXIS));
	}
}