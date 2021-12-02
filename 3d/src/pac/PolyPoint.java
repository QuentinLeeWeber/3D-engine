package pac;

import pac.main;

public class PolyPoint extends main{
	float x, y, z;
	float aftercamposx, aftercamposy, aftercamposz;
	//float renderx, rendery, renderz;
	
	public PolyPoint(float startx, float starty, float startz){
		x = startx;
		y = starty;
		z = startz;
	}
	protected void computeRotationPosition(float camposx, float camposy, float camposz) {
		
	}
	
	protected void computeRender(float FOV, float width) {
		//rendery = (float) ((width / 2) * ((Math.tan(FOV) * aftercamposz) / aftercamposy));
		//renderx = (float) ((width / 2) * ((Math.tan(FOV) * aftercamposz) / aftercamposx));
	}
	
	protected void renderPoint() {
		
	}
	
	public float renderx(float FOV) {
		return (float) ((width / 2) * ((Math.tan(FOV) * aftercamposz) / aftercamposx));
	}
	public float rendery(float FOV) {
		return (float) ((width / 2) * ((Math.tan(FOV) * aftercamposz) / aftercamposy));
	}
}
