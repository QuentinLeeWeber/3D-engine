package pac;

import java.awt.event.*;


public class MyMouseListener implements MouseListener {
	
	public boolean rightPressed = false;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == 3) {
			rightPressed = true;
			main.motion.RightPressed();
		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
		if(e.getButton() == 3) {
			rightPressed = false;
			main.motion.RightReleased();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}