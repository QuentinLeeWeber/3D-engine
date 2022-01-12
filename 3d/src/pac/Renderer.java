package pac;
import java.util.HashMap;
import java.awt.Graphics;

public class Renderer {
	
	public HashMap<Poly, Integer> AllPoly = new HashMap<Poly, Integer>();	
	Renderer(){
		
	}
	
	public void render(Graphics g) {
		main.testcube.CubePoly1.render(g);
		main.testcube.CubePoly2.render(g);
		main.testcube.CubePoly3.render(g);
		main.testcube.CubePoly4.render(g);
		main.testcube.CubePoly5.render(g);
		main.testcube.CubePoly6.render(g);
		main.testcube.CubePoly7.render(g);
		main.testcube.CubePoly8.render(g);
		main.testcube.CubePoly9.render(g);
		main.testcube.CubePoly10.render(g);
		main.testcube.CubePoly11.render(g);
		main.testcube.CubePoly12.render(g);
		
	}
	
	public void GetAllPolys() {
	    
	}
	
}
