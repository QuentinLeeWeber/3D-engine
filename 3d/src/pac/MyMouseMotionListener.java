package pac;

import java.awt.event.*;
import java.awt.Point;


public class MyMouseMotionListener implements MouseMotionListener {
	
	public Point MouseField = new Point();
	
	private Point oldPos = new Point();
	private Point calcField = new Point();
	private Point newPos = new Point();
	MouseEvent E;
	public int test = 1;
	public void mouseMoved(MouseEvent e) {
		E = e;
	}
	
	public void mouseDragged(MouseEvent e) {
		E = e;
		if(main.mouse.rightPressed == true) {
			newPos.x = e.getX() - oldPos.x; newPos.y = e.getY() - oldPos.y;	
		}
	}
	
	public void RightPressed() {
		oldPos.x = E.getX(); oldPos.y = E.getY();
	}
	
	public void RightReleased() {
		calcField.x += E.getX() - oldPos.x; calcField.y += E.getY() - oldPos.y;
	}
	
	public void update() {
		if(main.mouse.rightPressed == true) {
			MouseField.x = calcField.x + newPos.x; MouseField.y = calcField.y + newPos.y;
			
		} else {}
		/*if(MouseField.y <= -Math.PI / 2) {
			MouseField.y = (int) -(Math.PI / 2);
		} else if(MouseField.y >= Math.PI / 2) {
			//MouseField.y = (int) (Math.PI / 2);
		}
		System.out.println(MouseField.y);*/
	}
}