package pac;

import java.awt.geom.Point2D;
import java.util.HashMap;

//https://www.w3schools.com/java/java_hashmap.asp

public class GameObject {
	
	public float x, y, z;
	public float rotx, rotz, roty;
	public boolean IsVisable;
	public  HashMap<Poly, Integer> VertexManager = new HashMap<Poly, Integer>();
	
	public GameObject(){
		
	}
	
	// pulblic
	
	public void ObjectUpate() {
		//manageRotation();
		main.renderer.AllPoly.putAll(VertexManager);
		//System.out.println(main.renderer.AllPoly);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void moveDir(float movex, float movey, float movez) {
		Point2D.Float point = new Point2D.Float();
		
		//first
		point = move(rotx);
		y += point.y * movez;
		z += point.x * movez; 
		point = move(rotx);
		z += point.y * movey;
		y += point.x * movey; 
		//second 	
		point = move(roty);
		x += point.y * movez;
		z += point.x * movez; 
		point = move(roty);
		x += point.x * movex;
		z += point.y * movex; 
		// 3.
		point = move(rotz);
		y += point.y * movex;
		x += point.x * movex; 
		point = move(rotz);
		x += point.y * movey;
		y += point.x * movey;
	}
	
	public void moveDirAxisX(float movex, float movey, float movez) {
		Point2D.Float point = new Point2D.Float();
		point = move(rotx);
		y += point.y * movez;
		z += point.x * movez; 
		point = move(rotx);
		z += point.y * movey;
		y += point.x * movey; 
	}
	public void moveDirAxisY(float movex, float movey, float movez) {
		z += Math.cos(roty) * movez;
		x += -Math.sin(roty) * movez;
		z += Math.sin(roty) * movex;
		x += Math.cos(roty) * movex;
		
		/*
		Point2D.Float point = new Point2D.Float();
		point = move(roty);
		x += point.y * movez;
		z += point.x * movez; 
		point = move(roty);
		x += point.x * movex;
		z += point.y * movex; 
		
		*/
	}
	public void moveDirAxisZ(float movex, float movey, float movez) {
		Point2D.Float point = new Point2D.Float(); 
		point = move(rotz);
		y += point.y * movex;
		x += point.x * movex; 
		point = move(rotz);
		x += point.y * movey;
		y += point.x * movey;
	}
	// private
	
	private void manageRotation() {
		/*rotx = rotation(rotx);
		rotz = rotation(rotz);*/
		//roty = rotation(roty);
	}
	
	
	private float rotation(float rot){
		while(!(rot >= 0 && rot <= 2 * Math.PI)) {
			System.out.println(rot);
			if(rot >= 2 * Math.PI) {
				rot = (float) (rot - Math.PI);
			} else if(rot <= 0) {
				rot = (float) (rot + Math.PI);
			}
		}
		if (rot < 0) {
			rot = (float) (2 * Math.PI - Math.abs(rot));
		}
		System.out.println("stop");
		return (float) 1;
	}
	
	private Point2D.Float move(float rotation) { 
		int dir = 0;
		Point2D.Float RETURN = new Point2D.Float();
		float rotationWithMax = 0; 
		
		if(rotation >= 0) {
			rotationWithMax = (float) (Math.abs(rotation) % (Math.PI * 2));
		} else {
			rotationWithMax = (float) (2 * Math.PI - (Math.abs(rotation) % (Math.PI * 2)));
		}
		
		if(rotationWithMax <= Math.PI * 0.5 && rotationWithMax >= 0) { 
			dir = 1; 
		} else
		if(rotationWithMax <= Math.PI * 1 && rotationWithMax >= Math.PI * 0.5) { 
			dir = 2; 
		} else 
		if(rotationWithMax <= Math.PI * 1.5 && rotationWithMax >= Math.PI * 1) { 
			dir = 3; 
		} else 
		if(rotationWithMax <= Math.PI * 2 && rotationWithMax >= Math.PI * 1.5) { 
			dir = 4; 
		} else {
			dir = 1;
		}
		
		
		
		if(dir == 1) {
			RETURN.x = (float) (Math.cos(rotationWithMax));
			RETURN.y = (float) (Math.sin(rotationWithMax));
		}
		if(dir == 2) {
			RETURN.x = (float) -(Math.sin(rotationWithMax - Math.PI * 0.5));
			RETURN.y = (float) (Math.cos(rotationWithMax - Math.PI * 0.5));
		}
		if(dir == 3) {
			RETURN.x = (float) -(Math.cos(rotationWithMax - Math.PI * 1));
			RETURN.y = (float) -(Math.sin(rotationWithMax - Math.PI * 1));
		}
		if(dir == 4) {
			RETURN.x = (float) (Math.sin(rotationWithMax - Math.PI * 1.5));
			RETURN.y = (float) -(Math.cos(rotationWithMax - Math.PI * 1.5));
		}
		//System.out.println(rotationWithMax);
		//System.out.println(RETURN + " " + dir);
		//System.out.println(rotation % (Math.PI * 2));
		return RETURN; //(if rotation = 0: (x = 100%, y = 0%)
	}
	
	
}
