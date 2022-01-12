package pac;

import java.awt.*;

public class Camera extends GameObject{
	
	//Settings
	private float rotationspeed = 0.002f;
	private float speed = 30f;
	
	public float FOV;
	private boolean w, s, a, d, space, c;
	Point location = new Point();
	
	Camera(float startFOV){
		FOV = startFOV;
	}
	
	public void hallo() {
		System.out.println("hallo");
	}
	
	public void update() {
		ObjectUpate();
		roty = (float) ((-main.motion.MouseField.x * rotationspeed) % Math.PI * 2);
		if (roty < 0) {
			roty = (float) (2 * Math.PI - Math.abs(roty));
		}
		
		rotx = (float) ((main.motion.MouseField.y * rotationspeed) % Math.PI * 2);
		if (rotx < 0) {
			rotx = (float) (2 * Math.PI - Math.abs(rotx));
		}
		//rotx += 0.000001;

		
		
		if (w) {
			//z -= speed;
			moveDirAxisY(0f, 0f, speed * (float) (main.Time.deltaTime));
		} 
		if (s) {
			//z += speed;
			moveDirAxisY(0f, 0f, -speed * (float) (main.Time.deltaTime));
		}
		if (a) {
			moveDirAxisY(-speed * (float) (main.Time.deltaTime), 0f, 0f);
		} 
		if (d) {
			moveDirAxisY(speed * (float) (main.Time.deltaTime), 0f, 0f);
		}
		if (c) {
			y -= speed * (float) (main.Time.deltaTime);
		}
		if (space) {
			y += speed * (float) (main.Time.deltaTime);
		}
		//System.out.println(x +"  " +y+"  "+z);
		//System.out.println(rotx +"  " +roty +"  "+rotz);//wfwfweewfwefsdfw	FEFffsffFDFDasdfAafd
		
		
		/*System.out.println(rotx * rotationspeed);
		if(rotx % 2 * Math.PI / rotationspeed>= 0.5 * Math.PI) {
			System.out.println("aha");
			rotx = (float) (0.5 * Math.PI);
		} else if(rotx % 2 * Math.PI  / rotationspeed>= 1.5 * Math.PI) {  //System for max rotx rotation
			rotx = (float) (1.5 * Math.PI);
		}*/
	}
	
	public void keyPress() {
		
		location = MouseInfo.getPointerInfo().getLocation();	
	}
	
	public void push(char key) {
		if(key == 'w' || key == 'W') {w = true;}
		if(key == 'a' || key == 'A') {a = true;}
		if(key == 's' || key == 'S') {s = true;}
		if(key == 'd' || key == 'D') {d = true;}
		if(key == ' ' || key == ' ') {space = true;}
		if(key == 'c' || key == 'C') {c = true;}
	}
	
	public void release(char key) {
		if(key == 'w' || key == 'W') {w = false;}
		if(key == 'a' || key == 'A') {a = false;}
		if(key == 's' || key == 'S') {s = false;}
		if(key == 'd' || key == 'D') {d = false;}
		if(key == ' ' || key == ' ') {space = false;}
		if(key == 'c' || key == 'C') {c = false;}
	}
}