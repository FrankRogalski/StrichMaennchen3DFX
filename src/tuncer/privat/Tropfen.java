package tuncer.privat;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.transform.Rotate;

public class Tropfen {
	
	private Box box;
	private double x, y;
	private Pane root;
	
	public Tropfen(double size, Pane root) {
		this.box = new Box(size, size, size);
		this.box.setDrawMode(DrawMode.LINE);
		
		this.x = root.getWidth()/2;
		this.y = root.getHeight()/2;
		
		this.box.getTransforms().addAll(new Rotate(20, Rotate.X_AXIS), new Rotate(20, Rotate.Y_AXIS), new Rotate(20, Rotate.Z_AXIS));
		
		root.getChildren().add(this.box);
		
		this.root = root;
	}
	
	public void update() {
		this.y += 1;
	}
	
	public void show() {
		this.root.setTranslateX(this.x);
		this.root.setTranslateY(this.y);
	}
}