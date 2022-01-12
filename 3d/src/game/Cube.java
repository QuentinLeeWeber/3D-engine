package game;
import java.awt.Color;

import pac.GameObject;
import pac.Poly;
import pac.PolyPoint;


public class Cube extends GameObject{
	
	PolyPoint p1 = new PolyPoint(1, 1, 1);
	PolyPoint p2 = new PolyPoint(1, -1, 1);
	PolyPoint p3 = new PolyPoint(1, 1, -1);
	PolyPoint p4 = new PolyPoint(1, -1, -1);
	PolyPoint p5 = new PolyPoint(-1, 1, 1);
	PolyPoint p6 = new PolyPoint(-1, 1, -1);
	PolyPoint p7 = new PolyPoint(-1, -1, 1);
	PolyPoint p8 = new PolyPoint(-1, -1, -1);
	public Poly CubePoly1 = new Poly(p8, p6, p4);
	public Poly CubePoly2 = new Poly(p3, p6, p4);
	public Poly CubePoly3 = new Poly(p8, p6, p7);
	public Poly CubePoly4 = new Poly(p6, p5, p7);
	public Poly CubePoly5 = new Poly(p7, p2, p1);
	public Poly CubePoly6 = new Poly(p7, p5, p1);
	public Poly CubePoly7 = new Poly(p8, p4, p6);
	public Poly CubePoly8 = new Poly(p4, p3, p2);
	public Poly CubePoly9 = new Poly(p4, p3, p5);
	public Poly CubePoly10 = new Poly(p6, p5, p3);
	public Poly CubePoly11 = new Poly(p2, p4, p7);
	public Poly CubePoly12 = new Poly(p8, p4, p7);
	

	public Cube(){
		updatePoly();
	} 
	
	private void updatePoly() {
		CubePoly1.poly1 = p1;CubePoly1.poly2 = p2;CubePoly1.poly3 = p3;
		//CubePoly1.col = new Color(255, 0, 0);
	}
	
	public void update() {
		ObjectUpate();	
		
	}
	
}
