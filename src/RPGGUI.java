import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RPGGUI extends JFrame implements KeyListener, ActionListener {
	private static int mapPanelSizeOffset=180;
	private static int defaultWidth=800;
	private static int defaultHeight=600;
	private JTextArea textbox=new JTextArea();
	private String[] buttonText={"Attack","Defend","Start Game","Pause Game"};
	private int textboxMaxLines=6;
	private JButton buttons[]= new JButton[buttonText.length];
	//private JLabel maplabel=new JLabel("<html>RPG Game of AWESOMENESS!!<br>Made by: T04-03<br>Press Space Bar to continue</html>",JLabel.CENTER);
	private MapPanel mapPanel;
	private boolean[] keyDownArray=new boolean[256];
	private boolean gamePaused = false;
	
    public RPGGUI() {
    	super(Game.title);
		
		//add key listener, make frame focusable so it works properly
		this.addKeyListener(this);
		this.setFocusable(true);
	
		//make a new jpanel on our form
		JPanel p = new JPanel();
		JPanel p2 = new JPanel(new BorderLayout());
		
		//add the map panel
		mapPanel=new MapPanel();
		mapPanel.setSize(RPGGUI.defaultWidth,RPGGUI.defaultHeight-RPGGUI.mapPanelSizeOffset);
		add(mapPanel,BorderLayout.SOUTH);
		
		//set up the combat log textbox
		for(int i=0;i<textboxMaxLines-1;i++){
			textbox.append(" \n");
		}
		textbox.setEditable(false);
		textbox.setFocusable(false);
		p2.add(textbox,BorderLayout.NORTH);
		
		//set up the buttons
		for(int i=0;i<buttonText.length;i++){
			buttons[i]=new JButton(buttonText[i]);
			buttons[i].setFocusable(false);
			p.add(buttons[i]);
		}
		
		buttons[0].setActionCommand(Combat.attackActionCommand);
		buttons[0].addActionListener(Game.getGame().getCombat());
		buttons[0].setEnabled(false);
		buttons[1].setActionCommand(Combat.defendActionCommand);
		buttons[1].addActionListener(Game.getGame().getCombat());
		buttons[1].setEnabled(false);
		buttons[2].setActionCommand("Start");
		buttons[2].addActionListener(this);
		buttons[3].setActionCommand("Pause");
		buttons[3].addActionListener(this);
		
		
		p2.add(p,BorderLayout.SOUTH);
		add(p2,BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(RPGGUI.defaultWidth,RPGGUI.defaultHeight));
		
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    /**
     * Checks if a specific key is being held down on the keyboard
     * @param key int id of the key
     * @return returns true if the key is down
     */
    public boolean isKeyDown(int key){
    	if(key<0||key>255){
    		return false;
    	}
    	return keyDownArray[key];
    }
    
    /**
     * Prints a line into the text area of the gui
     * @param line
     */
    public void printLine(String line){
    	String[] textboxLines=textbox.getText().split("\n");
		textbox.setText(line);
		for(int i=0;i<textboxMaxLines-1;i++){
			textbox.append("\n"+textboxLines[i]);
		}
    }

	public void keyPressed(KeyEvent e) {
		int keycode=e.getKeyCode();
		keyDownArray[keycode]=true;
	}

	public void keyReleased(KeyEvent e) {
		int keycode=e.getKeyCode();
		keyDownArray[keycode]=false;
	}

	public void keyTyped(KeyEvent e) {
	
	}
	
	/**
	 * Redraws the map panel
	 */
	public void redrawMap(){
		mapPanel.setSize(getSize().width,getSize().height-RPGGUI.mapPanelSizeOffset);
		mapPanel.repaint();
	}
	
	public void actionPerformed(ActionEvent event) {
		String command=event.getActionCommand();
		//When you press the button "Start Game" it checks if the command Start was sent, then disables the button, disables title screen, and starts the game timer
		if (command == "Start"){
			printLine("You have started your adventure!");
			buttons[2].setEnabled(false);
			Game.getGame().getGUI().getMapPanel().setTitleScreenShown(true);
			Game.getGame().pauseTimer(false);
		}
		if (command == "Pause"){
			if(Game.getGame().getCombat().isInCombat() == false && Game.getGame().getGUI().getMapPanel().titleScreenShown()){
				if (gamePaused == false){
				Game.getGame().pauseTimer(true);
				gamePaused = true;
				redrawMap();
				}
				else{
				Game.getGame().pauseTimer(false);
				gamePaused = false;
				}
			}
		}
    }
	
	public MapPanel getMapPanel() {
		return mapPanel;
	}
	
	public void enableButton(int a){
		buttons[a].setEnabled(true);
	}
	
	public void disableButton(int a){
		buttons[a].setEnabled(false);
	}

	public boolean isGamePaused(){
		return gamePaused;
	}
}
