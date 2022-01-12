package pac;

import java.awt.Graphics;
import java.awt.geom.Point2D;

public class PolyPoint{
	float x, y, z;
	float aftercamposx, aftercamposy, aftercamposz;
	
	public PolyPoint(float startx, float starty, float startz){//constructer
		x = startx;
		y = starty;
		z = startz;
	}
	
	public void paint(Graphics g) {
		if(aftercamposz >= 0) {
			g.drawOval(Math.round(renderx(main.cam1.FOV)) + main.width / 2, main.height - (Math.round(rendery(main.cam1.FOV)) + main.height / 2), 2, 2);
		}
	}

	public void computePosition(float camposx, float camposy, float camposz, float rotx, float roty, float rotz) {	
		Point2D.Float myPoint = new Point2D.Float();
		
		aftercamposx = (x - camposx);
		aftercamposy = (y - camposy);
		aftercamposz = (z - camposz);
		
		//step3 (x, z, Axis: y)
		myPoint = rotateOnAxis(aftercamposx, aftercamposz, roty);
		aftercamposx = myPoint.x;
		aftercamposz = myPoint.y;
		
		// step1 (x, y, Axis: z)	
		myPoint = rotateOnAxis(aftercamposx, aftercamposy, rotz);
		aftercamposx = myPoint.x;
		aftercamposy = myPoint.y;
		
		//step2 (y, z, Axis: x)
		myPoint = rotateOnAxis(aftercamposy, aftercamposz, rotx);
		aftercamposy = myPoint.x;
		aftercamposz = myPoint.y;
	}
	
	float specialRound(float start){
		float value = 0;
		if(start < 0) {
			value = -1;
		} else if (start > 0) {
			value = 1;
		} else  if(start == 0) {
			value = 0;
		}
		return value;
	}
	
	private Point2D.Float rotateOnAxis(float inputx, float inputy, float plusangle) {// AxisRotation
		float hy;
		float angle;
		Point2D.Float myPoint = new Point2D.Float();
		
		hy = (float) (Math.sqrt(Math.pow(inputx, 2) + Math.pow(inputy, 2)));
		angle = (float) Math.asin(inputx / hy);
		
		if(inputx >= 0 && inputy >= 0) {
			angle = angle + plusangle;
			myPoint.x = (float) Math.sin(angle) * hy;
			myPoint.y = (float) -Math.cos(angle) * hy; // YEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEET das musste dir merken
			
		} else 
		if(inputx <= 0 && inputy >= 0) {
			angle = angle + plusangle;
			myPoint.x = (float) Math.sin(angle) * hy;
			myPoint.y = (float) -Math.cos(angle) * hy;
	
		} else 
		if(inputx <= 0 && inputy <= 0) {
			angle = angle - plusangle;
			myPoint.x = (float) Math.sin(angle) * hy;
			myPoint.y = (float) Math.cos(angle) * hy;
	
		} else
		if(inputx >= 0 && inputy <= 0) {
			angle = angle - plusangle;
			myPoint.x = (float) Math.sin(angle) * hy;
			myPoint.y = (float) Math.cos(angle) * hy;
		
		} else 
		if(inputx == 0 && inputy == 0) {
			myPoint.x = inputx;
			myPoint.y = inputy;

		}
		
		return myPoint;
	}
	
	public float renderx(float FOV) {//translation to 2d x
		if (aftercamposx == 0) {
			return 0;
		} else {
			return (float) ((main.width / 2) * (aftercamposx / (Math.tan((FOV / 360 ) * 2 * Math.PI) * aftercamposz)));
		}
	}
	public float rendery(float FOV) { // translation to 2d y
		if (aftercamposy == 0) {
			return 0;
		} else {
			return (float) ((main.width / 2) * -(aftercamposy / (Math.tan((FOV / 360 ) * 2 * Math.PI) * aftercamposz)));
		}
	}
}