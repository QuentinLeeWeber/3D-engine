package pac;
import java.awt.Color;
import java.awt.Graphics;

public class Poly {
	public PolyPoint poly1, poly2, poly3;
	
	//public float distanceCam;
	
	public Color col = new Color(255, 200, 113);
	
	public Poly(PolyPoint start1, PolyPoint start2, PolyPoint start3){
		poly1 = start1;
		poly2 = start2;
		poly3 = start3;
	}
	public void render(Graphics g) {
		
		int posx1 = Math.round(poly1.renderx(main.cam1.FOV)) + main.width / 2;
		int posy1 = main.height - (Math.round(poly1.rendery(main.cam1.FOV)) + main.height / 2);
		int posx2 = Math.round(poly2.renderx(main.cam1.FOV)) + main.width / 2;
		int posy2 = main.height - (Math.round(poly2.rendery(main.cam1.FOV)) + main.height / 2);
		int posx3 = Math.round(poly3.renderx(main.cam1.FOV)) + main.width / 2;
		int posy3 = main.height - (Math.round(poly3.rendery(main.cam1.FOV)) + main.height / 2);
		g.setColor(col);
		poly1.computePosition(main.cam1.x, main.cam1.y, main.cam1.z, main.cam1.rotx, main.cam1.roty, main.cam1.rotz);
		poly3.computePosition(main.cam1.x, main.cam1.y, main.cam1.z, main.cam1.rotx, main.cam1.roty, main.cam1.rotz);
		poly2.computePosition(main.cam1.x, main.cam1.y, main.cam1.z, main.cam1.rotx, main.cam1.roty, main.cam1.rotz);
		
		if(poly1.aftercamposz >= 0 && poly2.aftercamposz >= 0) {
			g.drawLine(posx1, posy1, posx2, posy2);
		}
		if(poly2.aftercamposz >= 0 && poly3.aftercamposz >= 0) {
			g.drawLine(posx2, posy2, posx3, posy3);
		}
		if(poly1.aftercamposz >= 0 && poly3.aftercamposz >= 0) {
			g.drawLine(posx3, posy3, posx1, posy1);
		}
	}
}
