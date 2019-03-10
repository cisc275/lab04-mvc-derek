import java.awt.image.BufferedImage;

/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/
public class Model{
	Direction direct;
	private int xloc = 0;
	private int yloc = 0;
	private final int xIncr = 8;
    private final int yIncr = 2;
    private int xMult = 1;
    private int yMult = 1;
	private int frameWidth;
	private int frameHeight;
	private int imgWidth;
	private int imgHeight;
	
	public Model(int width, int height, int imgWidth, int imgHeight){
		frameWidth=width;
		frameHeight=height;
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
	}
	public int getX(){
		return xloc;
	}
	public int getY(){
		return yloc;
	}

	public void updateLocationAndDirection(){
		if(xloc>=(frameWidth-imgWidth)){
			xMult=-1;
		}
		if(yloc>=(frameHeight-imgHeight)){
			yMult=-1;
		}
		if(xloc+xIncr<0){
			xMult=1;
		}
		if(yloc+yIncr<0){
			yMult=1;
		}
		updateDirection();
		xloc+=xIncr*xMult;
		yloc+=yIncr*yMult;
		
	}
	public void updateDirection(){
		if(xMult == 1 && yMult == 1){
			direct=Direction.SOUTHEAST;
    	}else if(xMult == 1 && yMult == -1){
    		direct=Direction.NORTHEAST;
    	}else if(xMult==-1&&yMult==1){
    		direct = Direction.SOUTHWEST;
    	}else{
    		direct = Direction.NORTHWEST;
    	}
	}

	public Direction getDirect() {
		return direct;
	}

	public int getXloc() {
		return xloc;
	}

	public int getYloc() {
		return yloc;
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public int getImgWidth() {
		return imgWidth;
	}

	public int getImgHeight() {
		return imgHeight;
	}
	
	
	
}
