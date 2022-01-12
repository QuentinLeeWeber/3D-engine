package pac;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import game.*;


public class main extends JPanel{
    public static int width = 1920;
    public static int height = 1014;
    private int frameCounter;
    
    static Camera cam1 = new Camera(90 / 2);
    
    public static Cube testcube = new Cube();
    public static Renderer renderer = new Renderer();
    
    public static MyMouseListener mouse = new MyMouseListener();
    public static MyMouseMotionListener motion = new MyMouseMotionListener();
    
    public static Time Time = new Time();
    
    public main() { //Don't forget: constructor
        
    }
    
    private void setup() {
    	
    }
    
    private void updateForAll() {
    	Time.update();
    	motion.update();
    	cam1.update();
    	testcube.update();
    	//System.out.println(cam1.x + "  " + cam1.y + "  " + cam1.z);
    }

    public void move() { //aka draw in processing
    	frameCounter++;
    	
    	updateForAll();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {// Things to draw here please
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, width, height);
        g.setColor(new Color(255, 255, 255));
        renderer.render(g);
        g.setColor(new Color(255, 255, 255));
    	g.drawOval(width / 2 - 3, height / 2 - 3, 6, 6);
    }

    public void startAnimation() {
    	setup();
        SwingWorker<Object, Object> sw = new SwingWorker<Object, Object>() {
            @Override
            protected Object doInBackground() throws Exception {
                while (true) {
                    move();
                    Thread.sleep(1);
                }
            }
        };

        sw.execute();
    }
    
    public static void main(String[] args) {
    	System.out.println("start...");
    	KeyboardFocusManager m = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        MyKeyEventDispatcher dispatcher = new MyKeyEventDispatcher();
        m.addKeyEventDispatcher(dispatcher);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("3D");
                frame.setLocation(-8, -6);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(width + 16, height + 39); 

                main repainter = new main();
                repainter.addMouseMotionListener(motion);
                repainter.addMouseListener(mouse);
                frame.add(repainter);

                repainter.startAnimation();
                frame.setVisible(true);
              
               // frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
               
            }
        });
    }
}