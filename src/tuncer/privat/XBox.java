package tuncer.privat;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

public class XBox extends MeshView {
	
	private double x, y, z, width,height, depth;
	
    private final float tex[] = {
    		0.25f, 0f,
    		0.5f, 0f,
    		0f, 0.33f,
    		0.25f, 0.33f,
    		0.5f, 0.33f,
    		0.75f, 0.33f,
    		1f, 0.33f,
    		0f, 0.66f,
    		0.25f, 0.66f,
    		0.5f, 0.66f,
    		0.75f, 0.66f,
    		1f, 0.66f,
    		0.25f, 1f,
    		0.5f, 1f
    		};
	
	private final int[] faces = {
            0, 10, 2, 5, 1, 9,
            2, 5, 3, 4, 1, 9,
            4, 7, 5, 8, 6, 2,
            6, 2, 5, 8, 7, 3,
            0, 13, 1, 9, 4, 12,
            4, 12, 1, 9, 5, 8,
            2, 1, 6, 0, 3, 4,
            3, 4, 6, 0, 7, 3,
            0, 10, 4, 11, 2, 5,
            2, 5, 4, 11, 6, 6,
            1, 9, 3, 4, 5, 8,
            5, 8, 3, 4, 7, 3
        };
	
	public XBox(double width, double height, double depth, String image) {
	    Image img = new Image(Main.class.getResourceAsStream(image));

	    PhongMaterial material = new PhongMaterial();
	    material.setDiffuseMap(img);
	    material.setDiffuseColor(Color.BISQUE);
	    
	    width /= 2;
	    height /= 2;
	    depth /= 2;
	    
	    final float points[] = {
	            (float) width, (float) height, (float) depth,
	            (float) width, (float) height, (float) -depth,
	            (float) width, (float) -height, (float) depth,
	            (float) width, (float) -height, (float) -depth,
	            (float) -width, (float) height, (float) depth,
	            (float) -width, (float) height, (float) -depth,
	            (float) -width, (float) -height, (float) depth,
	            (float) -width, (float) -height, (float) -depth,
	            };
	    
	    TriangleMesh mesh = new TriangleMesh();
	    mesh.getPoints().addAll(points);
	    mesh.getTexCoords().addAll(this.tex);
	    mesh.getFaces().addAll(this.faces);

	    this.setMesh(mesh);
	    this.setMaterial(material);
	    
	    this.width = width;
	    this.height = height;
	    this.depth = depth;
	}
	
	
	public void addX(double addX) {
		this.x += addX;
	}
	public void addY(double addY) {
		this.y += addY;
	}
	public void addZ(double addZ) {
		this.z += addZ;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setZ(double z) {
		this.z = z;
	}
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getZ() {
		return this.z;
	}
	public double getWidth() {
		return this.width;
	}
	public double getHeight() {
		return this.height;
	}
	public double getDepth() {
		return this.depth;
	}
}