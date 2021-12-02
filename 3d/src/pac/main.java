package pac;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import pac.Camera;
import pac.PolyPoint;



public class main extends JPanel {
    public static int width = 1000;
    public static int height = 1000;
    private int frameCounter;
    
    public main() { //dont forget: construktor
        
    }

    public void move() { //aka draw in processing
    	frameCounter++;
    	System.out.println("draw... frame:" + frameCounter + " fps: ");
    
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {// Things to draw here please
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, width, height);
        g.setColor(new Color(255, 255, 255));
        //g.fillRect(Math.round(test.renderx(cam1.FOV)), Math.round(test.rendery(cam1.FOV)), 2, 2);
        //g.drawRect(topLeft.x, topLeft.y, 100, 100);
    }

    public void startAnimation() {
        SwingWorker<Object, Object> sw = new SwingWorker<Object, Object>() {
            @Override
            protected Object doInBackground() throws Exception {
                while (true) {
                    move();
                    Thread.sleep(0);
                }
            }
        };

        sw.execute();
    }

    public static void main(String[] args) {
    	PolyPoint test = new PolyPoint(0, 0, 0);
        Camera cam1 = new Camera(90 / 2);
    	System.out.println("start...");
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("3D");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(width + 16, height + 39);

                main repainter = new main();

                frame.add(repainter);

                repainter.startAnimation();
                frame.setVisible(true);
            }
        });
    }

}



/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
 
// Damit Objekte der Klasse BeispielListener
// zum ActionListener werden kann, muss das Interface
// ActionListener implementiert werden
public class main extends JFrame implements ActionListener
{
    JButton button1;
    JButton button2;
    JButton button3;
    JLabel label;
    JPanel panel;
 
    public main(){
        this.setTitle("ActionListener Beispiel");
        this.setSize(400, 200);
        panel = new JPanel();
 
        // Leeres JLabel-Objekt wird erzeugt
        label = new JLabel();
 
        //Drei Buttons werden erstellt
        button1 = new JButton("Button 1");
        button2 = new JButton ("Button 2");
        button3 = new JButton ("Button 3");
 
        //Buttons werden dem Listener zugeordnet
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
 
        //Buttons werden dem JPanel hinzugefügt
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
 
        //JLabel wird dem Panel hinzugefügt
        panel.add(label);
        this.add(panel);
    }
 
    public static void main(String[] args)
    {
        // Ein neues Objekt der Klasse BeispielListener wird erzeugt
        // und sichtbar gemacht
        main bl = new main();
        bl.setVisible(true);
    }
 
    public void actionPerformed (ActionEvent ae){
        // Die Quelle wird mit getSource() abgefragt und mit den
        // Buttons abgeglichen. Wenn die Quelle des ActionEvents einer
        // der Buttons ist, wird der Text des JLabels entsprechend geändert
        if(ae.getSource() == this.button1){
            label.setText(("Button 1 wurde betätigt"));
        }
        else if(ae.getSource() == this.button2){
            label.setText("Button 2 wurde betätigt");
        }
        else if (ae.getSource() == this.button3){
            label.setText(("Button 3 wurde betätigt"));
        }
    }
}*/

/*import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class main extends JPanel {
	int i;
	
	public static void main(String[] args) {
	  TestObject ob = new TestObject();
      JFrame frame = new JFrame();
      frame.getContentPane().add(new main());

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1000, 500);
      frame.setVisible(true);
      frame.setTitle("jb");
   }

   public void paint(Graphics g) {
      Image img = createBufferedImage();
      g.drawImage(img, 0, 0, this);
      g.fillRect(10, 100 ,100, 100);
      System.out.println("mahle...");
      
   }
   
   public void draw(Graphics g) {
	   Image img = createBufferedImage();
	   g.fillRect(i, i, 100, 100);
	   g.setColor(new Color(0, 255, 255));
	   repaint();
	   System.out.println("nochmal...");
   }

   private Image createBufferedImage() {
      BufferedImage bufferedImage = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
      Graphics g = bufferedImage.getGraphics();
      Color c = new Color(255, 0, 0);
      g.setColor(c);
      g.fillRect(0, 0, 200, 200);
      Color c2 = new Color(0, 0, 0);
      g.setColor(c2);
      g.drawLine(0, 0, 100, 100);
      
      return bufferedImage;
   }
   
   public void run() {
		try {
			while(true) {
				move();
				Thread.sleep(8);
				System.out.println("jaja");
			}
		}catch(Exception e) { System.err.println(e.getMessage()); }

	}
   
   void move() {
	   i++;
   }
   
   
}
/*import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class main extends Frame{
	BufferedImage img = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
	
	public static void main (String[] args) {
		main m = new main();
		m.dings();
		
	}
	public void dings() {
		System.out.println("1");
		JFrame fenster = new JFrame();
		fenster.getContentPane().add(new main());
		int h = 1000;
		int b = 1000;
		fenster.setSize(b, h);
		fenster.setVisible(true);
		Graphics g = img.getGraphics();
		g.drawLine(0, 0, 100, 100);
		fenster.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				fenster.dispose();
				System.out.println("Fertig");
				System.exit(0);
			}
		});
		drawFenster(g);
		Color k = new Color(255, 0, 0);
		g.setColor(k);
		g.drawRect(0, 0, 100, 100);
		g.fillRect(0, 0, 100, 100);
		fenster.repaint();
		
		
	}

	public void drawFenster(Graphics g) {
		Image dasbild = bild();
		Color c = new Color(255, 0, 0);
		g.setColor(c);
		g.drawImage(dasbild, 100, 100,this);
		System.out.println("2");
		
	}
	public Image bild() {
		BufferedImage Bimage = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
		Graphics g = Bimage.getGraphics();
		g.drawString("bjhbkjbkjbjkbjkbkjb", 20, 20);
		
		return Bimage;
	}
}*/