package pac;

public class Camera extends main {
	public float x, y, z;
	public float FOV;
	public float rotx, roty, rotz;
	
	protected Camera(float startFOV){
		FOV = startFOV;
	}
}
