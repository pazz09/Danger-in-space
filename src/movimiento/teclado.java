package movimiento;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class teclado implements KeyListener {
	
	private boolean[] keys = new boolean[256];
	
	public static boolean UP, LEFT, RIGHT, DISPARO;
	
	
	public teclado()
	{
		UP = false;
		LEFT = false;
		RIGHT = false;
		DISPARO = false;
	}
	
	public void actualizar()
	{
		UP = keys[KeyEvent.VK_UP];
		LEFT = keys[KeyEvent.VK_LEFT];
		RIGHT = keys[KeyEvent.VK_RIGHT];
		DISPARO = keys[KeyEvent.VK_SPACE];
	}
	 
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	 
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
