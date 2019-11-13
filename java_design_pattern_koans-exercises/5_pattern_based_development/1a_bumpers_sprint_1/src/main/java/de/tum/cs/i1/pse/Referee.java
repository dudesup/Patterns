package de.tum.cs.i1.pse;

import java.applet.AudioClip;

import de.tum.cs.i1.pse.car.Car;


public class Referee implements Runnable {
	
	public static AudioClip MUSIC;
	private static int SLEEP_TIME = 200;

	private Thread theThread;
    private boolean isRunning;
    
    private GameBoard gameBoard;
    private ToolBar toolBar; 
    

	Referee(GameBoard gameBoard){
		setFramesPerSecond(25);
		this.gameBoard = gameBoard;
		this.gameBoard.setup();
		toolBar = new ToolBar(this);
	}
	
	public ToolBar refereeToolBar() {
		return this.toolBar;
	}
	
	public void initGame() {
		gameBoard.setup();
	}
	
	public void startGame() {
		if(isRunning){ return;}
		//TODO Start looping the music (Hint: Method loop())
		isRunning = true;
		theThread = new Thread(this);
		theThread.start();
		toolBar.enableButtons();
	}
	
    public void stopGame() {
		if(!isRunning){ return;}
		//TODO Stop the music (Hint: Method stop())
		isRunning = false;
		toolBar.enableButtons();
    }
	
	public void run() {
		while (isRunning) {
			try {
				Thread.sleep(SLEEP_TIME);
			}
			catch (InterruptedException e) { e.printStackTrace(); }
			moveCars();
		}
	}
	
	public void moveCars() {
		Car[] cars = gameBoard.getCars();
		
		int max_x = gameBoard.getSize().width;
		int max_y = gameBoard.getSize().height;
		
		for (int i = 0; i < cars.length; i++) {
			cars[i].updatePosition(max_x, max_y);
		}
		gameBoard.repaint();
	}
	
	public boolean isRunning(){
		return this.isRunning;
	}
	
	
	public static int getFramesPerSecond(){
		return 1000 / SLEEP_TIME;
	}
	
	public static void setFramesPerSecond(int framesPerSecond) throws IllegalArgumentException {
		if(framesPerSecond > 0){
			SLEEP_TIME = 1000 / framesPerSecond;
		}else{
			throw new IllegalArgumentException("Frames per second must be greater than 0.");
		}
	}
}