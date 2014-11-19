import java.awt.*;

public class EntityPlayerSpawn extends Entity{
	public String getClassID(){return "playerspawn";}
	private Image  image=Toolkit.getDefaultToolkit().getImage("../img/invisible.png");
	
	public Image getImage(){
		return image;
	}
	public EntityPlayerSpawn(int xcoord, int ycoord) {
		super(xcoord, ycoord);
	}
};