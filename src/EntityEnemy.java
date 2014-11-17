import java.util.Random;

public class EntityEnemy extends EntityMovable{
	public String getClassID(){return "enemy";}
	
	public String debuggraphic(){return "E";}
	
	//lose the game if the player runs into an enemy
	public void onCollide(Entity ent){
		Game.getGame().loseGame();
	};
	
	public void think(){
		//super cheap 'ai' here
		
		//get the nearest player
		Entity[] playersarray=Game.getGame().getEntities().getByClass("player");
		Entity target=playersarray[0];
		double windist=999999;
		for(int i=0;i<playersarray.length;i++){
			double dist=this.distance(playersarray[i]);
			if(dist<windist){
				target=playersarray[i];
				windist=dist;
			}
		}
		
		int difx=target.getX()-this.getX();
		int dify=target.getY()-this.getY();
		
		//if we need to move both horizontally and vertically, choose one randomly
		if(difx!=0 && dify!=0){
			boolean rand=new Random().nextBoolean();
			if(rand){
				difx=0;
			}else{
				dify=0;
			}
		}
		
		if(difx>0){
			this.moveRight();
		}else if(difx<0){
			this.moveLeft();
		}else if(dify>0){
			this.moveDown();
		}else if(dify<0){
			this.moveUp();
		}
		
	}
};