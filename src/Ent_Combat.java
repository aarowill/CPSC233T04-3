public class Ent_Combat extends Ent_Movable {
	private int entEND = 5;
	private int entSTR = 5;
	private int entLCK = 5;
	private int entHP = entEND * 10;
	private int entHIT = (80 + (entLCK / 2)) - 1;
	private int entCRIT = entLCK - 1;
	private int entBlock = 0;
	private boolean isDead = false;
	private String name;

	public void turn() {

	}
	
	/**
	 * Getter Function for entEND (Endurance stat)
	 * 
	 * @return entEND the player's endurance stat
	 */
	public int getEntEND() {
		return entEND;
	}

	/**
	 * Getter Function for entSTR (Strength stat)
	 * 
	 * @return entSTR the player's strength stat
	 */
	public int getEntSTR() {
		return entSTR;
	}

	/**
	 * Getter Function for entLCK (Luck stat)
	 * 
	 * @return entLCK the player's luck stat
	 */
	public int getEntLCK() {
		return entLCK;
	}

	/**
	 * Getter Function for entHP (Health stat)
	 * 
	 * @return entHP the player's health stat
	 */
	public int getEntHP() {
		return entHP;
	}

	/**
	 * Getter Function for entHIT (Hit chance stat)
	 * 
	 * @return entHIT the player's hit chance stat
	 */
	public int getEntHIT() {
		return entHIT;
	}

	/**
	 * Getter Function for entCRIT (Critical hit chance stat)
	 * 
	 * @return entCRIT the player's critical hit chance stat
	 */
	public int getEntCRIT() {
		return entCRIT;
	}

	/**
	 * Setter Function for entEND (Endurance stat)
	 * 
	 * @param endurance the player's endurance stat
	 */
	public void setEntEND(int endurance) {
		entEND = endurance;
	}

	/**
	 * Getter Function for entSTR (Strength stat)
	 * 
	 * @param strength the player's strength stat
	 */
	public void setEntSTR(int strength) {
		entSTR = strength;
	}

	/**
	 *  Function for entLCK (Luck stat)
	 * 
	 * @param luck the player's luck stat
	 */
	public void setEntLCK(int luck) {
		entLCK = luck;
	}

	/**
	 * Setter funciton for entHP (Health stat)
	 *
	 * @param health the value health should be set to
	 */
	public void setEntHP(int health) {
		entHP = health;
	}

	/**
	 * Setter function for entHIT (Hit chance stat)
	 * 
	 * @param hitChance the player's hit chance stat
	 */
	public void setEntHIT(int hitChance) {
		entHIT = hitChance;
	}

	/**
	 * Setter function for entCRIT (Critical hit chance stat)
	 * 
	 * @param critical the player's critical hit chance stat
	 */
	public void setEntCRIT(int critical) {
		entCRIT = critical;
	}

	/**
	 * Getter function for isAlive (Whether or not the entity is alive)
	 *
	 * @return isAlive the life status of this entity
	 */
	public boolean getIsAlive() {
		return isAlive;
	}

	/**
	 * Setter function for isAlive (Whether or not the entity is alive)
	 *
	 * @param alive specifies whether or not the entity is alive
	 */
	public void setIsAlive(boolean alive) {
		isAlive = alive;
	}

	/**
	 * Setter function for name (Entities name)
	 *
	 * @param aName the desired name
	 */
	public void setName(String aName) {
		name = aName;
	}

	/**
	 * Getter function for Name (Entities name)
	 *
	 * @return name the entities name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter function for entBlock (Entities blocking)
	 *
	 * @param block the desired block value
	 */
	public void setEntBlock(int block) {
		entBlock = block;
	}

	/**
	 * Getter function for entBlock (Entities blocking)
	 *
	 * @return entBlock the entities name
	 */
	public String getEntBlock() {
		return entBlock;
	}
}