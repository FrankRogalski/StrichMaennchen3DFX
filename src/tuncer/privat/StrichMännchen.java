package tuncer.privat;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.DrawMode;
import javafx.scene.transform.Rotate;

public class StrichMännchen {

	private XBox[] boxes  = new XBox[6];
	
	
	private boolean leftLeg = false, rightLeg = false;
	private boolean leftArm = false, rightArm = false;
	
	
	
	public StrichMännchen(double[] sizesX, double[] sizesY, double[] sizesZ, String[] imgs, Pane root) {	
		for (byte i=0;i<this.boxes.length;i++) {
			this.boxes[i] = new XBox(sizesX[i], sizesY[i], sizesZ[i], imgs[i]);
			this.boxes[i].setDrawMode(DrawMode.FILL);
		}
		root.getChildren().addAll(this.boxes);
		
		this.boxes[0].setX(0);
		this.boxes[0].setY(-root.getHeight()/4);
		
		this.boxes[1].setX(0);
		this.boxes[1].setY(this.boxes[0].getY() + this.boxes[0].getHeight()*2.5);
		
		this.boxes[2].setX(-(this.boxes[1].getWidth() + this.boxes[1].getWidth()*0.7));
		this.boxes[2].setY(-root.getHeight()/17);
		
		this.boxes[3].setX(this.boxes[1].getWidth() + this.boxes[1].getWidth()*0.7);
		this.boxes[3].setY(-root.getHeight()/17);
		
		this.boxes[4].setX(-this.boxes[1].getWidth());
		this.boxes[4].setY(this.boxes[1].getY() + this.boxes[1].getHeight()*1.5);
		
		this.boxes[5].setX(this.boxes[1].getWidth());
		this.boxes[5].setY(this.boxes[1].getY() + this.boxes[1].getHeight()*1.5);
	}
	
	public void move(KeyCode moveCode) {
		final double moveSpeed = 5;
		final double rotation = moveSpeed/3;
		
		switch (moveCode) {
			case W:
				for (byte i=0;i<this.boxes.length;i++) {
					this.boxes[i].addZ(-moveSpeed);
				}
				break;
			case A:
				for (byte i=0;i<this.boxes.length;i++) {
					this.boxes[i].addX(-moveSpeed);
				}
				break;
			case S:
				for (byte i=0;i<this.boxes.length;i++) {
					this.boxes[i].addZ(moveSpeed);
				}
				break;
			case D:
				for (byte i=0;i<this.boxes.length;i++) {
					this.boxes[i].addX(moveSpeed);
				}
				break;
			default: return;
		}


		
		if ((this.boxes[4].getZ() >= this.boxes[1].getDepth() + this.boxes[1].getZ() && !this.leftLeg) ||
				(this.boxes[4].getZ() <= -this.boxes[1].getDepth() + this.boxes[1].getZ() && this.leftLeg)) {
			this.leftLeg = !this.leftLeg;
		}
		
		if (!this.leftLeg) {
			this.boxes[4].addZ(moveSpeed);
			this.boxes[4].getTransforms().add(new Rotate(rotation, Rotate.X_AXIS));
		}else{
			this.boxes[4].addZ(-moveSpeed);
			this.boxes[4].getTransforms().add(new Rotate(-rotation, Rotate.X_AXIS));
		}
		
		
		if ((this.boxes[5].getZ() >= this.boxes[1].getDepth() + this.boxes[1].getZ() && this.rightLeg) ||
				(this.boxes[5].getZ() <= -this.boxes[1].getDepth() + this.boxes[1].getZ() && !this.rightLeg)) {
			this.rightLeg = !this.rightLeg;
		}
		
		if (!this.rightLeg) {
			this.boxes[5].addZ(-moveSpeed);
			this.boxes[5].getTransforms().add(new Rotate(-rotation, Rotate.X_AXIS));
		}else{
			this.boxes[5].addZ(moveSpeed);
			this.boxes[5].getTransforms().add(new Rotate(rotation, Rotate.X_AXIS));
		}

		//------------------------------------------------------------------------
		
		if ((this.boxes[2].getZ() >= this.boxes[1].getDepth() + this.boxes[1].getZ() && this.leftArm) ||
				(this.boxes[2].getZ() <= -this.boxes[1].getDepth() + this.boxes[1].getZ() && !this.leftArm)) {
			this.leftArm = !this.leftArm;
		}
		
		if (!this.leftArm) {
			this.boxes[2].addZ(-moveSpeed);
			this.boxes[2].getTransforms().add(new Rotate(-rotation, Rotate.X_AXIS));
		}else{
			this.boxes[2].addZ(moveSpeed);
			this.boxes[2].getTransforms().add(new Rotate(rotation, Rotate.X_AXIS));
		}
		
		
		if ((this.boxes[3].getZ() >= this.boxes[1].getDepth() + this.boxes[1].getZ() && !this.rightArm) ||
				(this.boxes[3].getZ() <= -this.boxes[1].getDepth() + this.boxes[1].getZ() && this.rightArm)) {
			this.rightArm = !this.rightArm;
		}
		
		if (!this.rightArm) {
			this.boxes[3].addZ(moveSpeed);
			this.boxes[3].getTransforms().add(new Rotate(rotation, Rotate.X_AXIS));
		}else{
			this.boxes[3].addZ(-moveSpeed);
			this.boxes[3].getTransforms().add(new Rotate(-rotation, Rotate.X_AXIS));
		}
	}
	
	public void show() {
		for (byte i=0;i<this.boxes.length;i++) {
			this.boxes[i].setTranslateX(this.boxes[i].getX());
			this.boxes[i].setTranslateY(this.boxes[i].getY());
			this.boxes[i].setTranslateZ(this.boxes[i].getZ());
		}
	}
}