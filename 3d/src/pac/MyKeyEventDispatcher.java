package pac;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;


public class MyKeyEventDispatcher implements KeyEventDispatcher 
{
	public boolean dispatchKeyEvent(KeyEvent e) {

		if (e.getID() == KeyEvent.KEY_TYPED) {
			main.cam1.keyPress();
		} else if (e.getID() == KeyEvent.KEY_PRESSED) 
			{
			main.cam1.push(e.getKeyChar());
		} else if (e.getID() == KeyEvent.KEY_RELEASED) {
			main.cam1.release(e.getKeyChar());
		}
		
		return false;
	}
	
}