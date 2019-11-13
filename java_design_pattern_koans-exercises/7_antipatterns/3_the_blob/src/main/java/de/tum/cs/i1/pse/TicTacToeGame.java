package de.tum.cs.i1.pse;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TicTacToeGame {
	private JFrame frame;
	private JPanel panel;
	private GridBagLayout layout;
	private TicTacToeGame game;

	private MouseListener mouseListener;
	private KeyListener keyListener;

	private ThreadPoolExecutor executor;

	private String user;
	private Map<Integer, Map<Integer, Character>> gameBoard;
	private List<TicTacToeAction> userActions;

	private int gameState;

	private static final int PLAYER = 1;
	private static final int PC = 2;
	private static final int DRAW = 3;

	public TicTacToeGame() {
		game = this;
	}

	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
		game.init();
	}

	public void init() {
		this.user = "Player";
		if (user == null)
			user = "undefined player";
		if (frame == null)
			frame = new JFrame("TicTacToe Game");
		Dimension d = new Dimension(400, 450);
		frame.setSize(d);
		frame.setResizable(false);

		panel = new JPanel();
		panel.setMinimumSize(d);
		panel.setBackground(Color.black);
		this.keyListener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		};
		this.panel.addKeyListener(this.keyListener);
		this.panel.addMouseListener(this.mouseListener);
		this.layout = new GridBagLayout();
		this.panel.setLayout(this.layout);
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 1.0;
		constraint.weighty = 1.0;

		Character playerCharacter = 'X';
		JButton button;
		this.gameBoard = new HashMap<Integer, Map<Integer, Character>>();
		this.userActions = new ArrayList<TicTacToeAction>(3 * 3);
		for (int i = 0; i < 3; i++) {
			this.gameBoard.put(i, new HashMap<Integer, Character>());
			for (int j = 0; j < 3; j++) {
				TicTacToeAction action = new TicTacToeAction(i, j,
						playerCharacter);
				action.setUser(user);
				this.userActions.add(action);
				button = new JButton();
				constraint.gridx = i;
				constraint.gridy = j;
				button.setAction(action);
				this.panel.add(button, constraint);
			}
		}

		aicharacter = 'O';
		mode = ADVANCED;

		if (executor == null) {
			executor = new ThreadPoolExecutor(1, 10, 10, TimeUnit.SECONDS,
					new LinkedBlockingDeque<Runnable>());
		}
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public class TicTacToeAction extends AbstractAction implements Runnable {
		private static final long serialVersionUID = 1L;
		private int column;
		private int row;
		private Character character = 'O';
		private String user;

		private Event e;

		public TicTacToeAction(int x, int y) {
			this.column = x;
			this.row = y;
			this.putValue(Action.SMALL_ICON,
					TicTacToeGame.getIconForCharacter('E'));
		}

		public TicTacToeAction(int i, int j, Character playerCharacter) {
			this(i, j);
			character = playerCharacter;
		}

		public void updateImage() {
			final Character c = gameBoard.get(row).get(column);
			if (c != null) {
				this.putValue(Action.SMALL_ICON,
						TicTacToeGame.getIconForCharacter(c));
			}

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (SwingUtilities.isEventDispatchThread()) {
				run();
			} else {
				try {
					SwingUtilities.invokeAndWait(this);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					e1.printStackTrace();
				}
			}
		}

		@Override
		public void run() {
			if (gameBoard.get(row).get(column) != null) {
				return;
			}
			gameBoard.get(row).put(column, character);
			changeImageIcon();
			userActionPerformed(user);
		}

		public void changeImageIcon() {
			Character c = gameBoard.get(row).get(column);
			this.putValue(Action.SMALL_ICON,
					TicTacToeGame.getIconForCharacter((c == null) ? 'E' : c));

		}

		public void userActionPerformed(String userName) {
			TreeMap<String, Integer> x = getCrossSums();
			String maxKey = null;
			String minKey = null;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (Entry<String, Integer> s : x.entrySet()) {
				Integer value = s.getValue();
				if (max < value) {
					max = value;
					maxKey = s.getKey();
				}
				if (min > value) {
					min = value;
					minKey = s.getKey();
				}
			}
			boolean gameFinished = false;
			if (max == 3) {
				System.out.println("Computer player wins");
				gameFinished = true;
			}
			if (min == -3) {
				System.out.println("Human player wins");
				gameFinished = true;
			}

			if (gameFinished) {
				disableAllActions();
				return;
			} else {
				if (userName.equals(getAIUser())) {
					aiTurnFinished();
				} else {
					disableAllActions();
					performAITurn();
				}
			}
		}

		public void reenableIfPerformeable() {
			if (gameBoard.get(row).get(column) == null) {
				this.setEnabled(true);
			} else {
				changeImageIcon();
			}
		}

		public int getColumn() {
			return column;
		}

		public void setColumn(int x) {
			this.column = x;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int y) {
			this.row = y;
		}

		public Character getCharacter() {
			return character;
		}

		public void setCharacter(Character character) {
			this.character = character;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}
	}

	private void disableAllActions() {
		for (TicTacToeAction action : userActions) {
			action.setEnabled(false);
		}
	}

	public void performAITurn() {
		executor.execute(aiturn);
	}

	private Runnable aiturn = new Runnable() {
		@Override
		public void run() {
			aiPerformTurn();
		}
	};

	public void setNextAvailable() {
		for (int i = 0; i < gameBoard.size(); i++) {
			boolean br = false;
			Map<Integer, Character> row = gameBoard.get(i);
			for (int j = 0; j < gameBoard.size(); j++) {
				if (row.get(j) == null) {
					row.put(j, aicharacter);
					br = true;
					break;
				}
			}
			if (br)
				break;
		}
	}

	private Character aicharacter = 'O';
	private Random airandom = new Random(System.currentTimeMillis());
	private String aiuser = "AI";

	private int mode;
	public static final int STUPID = 0;
	public static final int RANDOM = 1;
	public static final int ADVANCED = 2;

	public void aiPerformTurn() {
		boolean gameover = false;
		switch (mode) {
		case STUPID:
			setNextAvailable();
			break;
		case RANDOM:
			int i = 100;
			boolean fieldSet = false;
			while (i > 0) {
				int row = airandom.nextInt(3);
				int column = airandom.nextInt(3);
				if (gameBoard.get(row).get(column) == null) {
					gameBoard.get(row).put(column, aicharacter);
					fieldSet = true;
					break;
				}
				i--;
			}
			if (!fieldSet) {
				setNextAvailable();
			}
			break;
		case ADVANCED:
			TreeMap<String, Integer> x = game.getCrossSums();
			String maxKey = null;
			String minKey = null;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (Entry<String, Integer> s : x.entrySet()) {
				Integer value = s.getValue();
				if (max < value) {
					max = value;
					maxKey = s.getKey();
				}
				if (min > value) {
					min = value;
					minKey = s.getKey();
				}
			}
			fieldSet = false;
			if (max == 2) {
				putAICharacter(maxKey);
				fieldSet = true;
			}
			if (!fieldSet) {
				if (min < 0) {
					putAICharacter(minKey);
					fieldSet = true;
				}
			}
			if (!fieldSet) {
				setNextAvailable();
			}

			if (max == 3) {
				System.out.println("Computer player wins");
				break;
			}
			if (min == -3) {
				System.out.println("Human player wins");
				break;
			}
			break;
		}
		game.aiTurnFinished();
	}

	public void putAICharacter(String key) {
		int row = -1;
		int column = -1;
		if (key.equals("z0")) {
			row = 0;
		}
		if (key.equals("z1")) {
			row = 1;
		}
		if (key.equals("z2")) {
			row = 2;
		}
		if (key.equals("s0")) {
			column = 0;
		}
		if (key.equals("s1")) {
			column = 1;
		}
		if (key.equals("s2")) {
			column = 2;
		}
		if (key.equals("d0")) {
			row = 0;
			column = 0;
		}
		if (key.equals("d1")) {
			row = 2;
			column = 2;
		}
		boolean fieldSet = false;
		if (row < 0) {
			for (int i = 0; i < 3; i++) {
				row = i;
				if (gameBoard.get(row).get(column) == null) {
					gameBoard.get(row).put(column, aicharacter);
					fieldSet = true;
					break;
				}
			}
		}
		if (!fieldSet) {
			if (column < 0) {
				for (int i = 0; i < 3; i++) {
					column = i;
					if (gameBoard.get(row).get(column) == null) {
						gameBoard.get(row).put(column, aicharacter);
						fieldSet = true;
						break;
					}
				}
			}
		}
		if (!fieldSet) {
			if (row == 0) {
				for (int i = 0; i < 3; i++) {
					column = i;
					row = i;
					if (gameBoard.get(row).get(column) == null) {
						gameBoard.get(row).put(column, aicharacter);
						fieldSet = true;
						break;
					}
				}
			} else {
				if (gameBoard.get(0).get(2) == null) {
					row = 0;
					column = 2;
				}
				if (gameBoard.get(1).get(1) == null) {
					row = 1;
					column = 1;
				}
				if (gameBoard.get(2).get(0) == null) {
					row = 2;
					column = 0;
				}
				gameBoard.get(row).put(column, aicharacter);
				fieldSet = true;
			}
		}
		if (!fieldSet) {
			setNextAvailable();
		}
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public Character getAICharacter() {
		return aicharacter;
	}

	public void setAICharacter(Character character) {
		this.aicharacter = character;
	}

	public Random getAIRandom() {
		return airandom;
	}

	public void setAIRandom(Random random) {
		this.airandom = random;
	}

	public String getAIUser() {
		return aiuser;
	}

	public void setAIUser(String user) {
		this.aiuser = user;
	}

	/**
	 * Calculates sums of values in rows, columns and 2 diagonals of the
	 * gameboard
	 * 
	 * can be optimised
	 * 
	 * @return a TreeMap with String key to know which sum belongs to what
	 */
	public TreeMap<String, Integer> getCrossSums() {
		TreeMap<String, Integer> crossSums = new TreeMap<String, Integer>();
		crossSums.put("z0", getSum(0, 0, 0, 1, 0, 2));
		crossSums.put("z1", getSum(1, 0, 1, 1, 1, 2));
		crossSums.put("z2", getSum(2, 0, 2, 1, 2, 2));
		crossSums.put("s0", getSum(0, 0, 1, 0, 2, 0));
		crossSums.put("s1", getSum(0, 1, 1, 1, 2, 1));
		crossSums.put("s2", getSum(0, 2, 1, 2, 2, 2));
		crossSums.put("d0", getSum(0, 0, 1, 1, 2, 2));
		crossSums.put("d1", getSum(0, 2, 1, 1, 2, 0));
		return crossSums;
	}

	/**
	 * helper method of getCrossSums()
	 * 
	 * can be optimised
	 * 
	 * @param row0
	 * @param column0
	 * @param row1
	 * @param column1
	 * @param row2
	 * @param column2
	 * @return sum of 3 elements from the gameboard on given positions
	 */
	public int getSum(int row0, int column0, int row1, int column1, int row2,
			int column2) {
		int sum = 0;
		Character c = gameBoard.get(row0).get(column0);
		if (c != null) {
			if (c == 'O') {
				sum = sum + 1;
			} else if (c == 'X') {
				sum = sum - 1;
			}
		}
		c = gameBoard.get(row1).get(column1);
		if (c != null) {
			if (c == 'O') {
				sum = sum + 1;
			} else if (c == 'X') {
				sum = sum - 1;
			}
		}
		c = gameBoard.get(row2).get(column2);
		if (c != null) {
			if (c == 'O') {
				sum = sum + 1;
			} else if (c == 'X') {
				sum = sum - 1;
			}
		}
		return sum;
	}

	public void aiTurnFinished() {
		Runnable r = new Runnable() {
			public void run() {
				if (!isGameFinished())
					for (TicTacToeAction action : userActions) {
						action.reenableIfPerformeable();
					}
			}
		};
		if (SwingUtilities.isEventDispatchThread()) {
			r.run();
		} else {
			SwingUtilities.invokeLater(r);
		}
	}

	public boolean isGameFinished() {
		boolean finished = false;
		TreeMap<String, Integer> x = this.getCrossSums();
		String maxKey = null;
		String minKey = null;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (Entry<String, Integer> s : x.entrySet()) {
			Integer value = s.getValue();
			if (max < value) {
				max = value;
				maxKey = s.getKey();
			}
			if (min > value) {
				min = value;
				minKey = s.getKey();
			}
		}

		if (max == 3) {
			System.out.println("PC winns");
			gameState = PC;
			finished = true;
		}
		if (min == -3) {
			System.out.println("Player winns");
			gameState = PLAYER;
			finished = true;
		}
		int occupied = 0;
		for (Map<Integer, Character> row : this.gameBoard.values()) {
			for (Character c : row.values()) {
				if (c != null)
					occupied++;
			}
		}
		if (occupied == 9) {
			gameState = DRAW;
			System.out.println("Draw.");
			finished = true;
		}

		if (finished) {
			updateAllActionImages();
		}

		return finished;
	}

	public void updateAllActionImages() {
		for (TicTacToeAction a : userActions) {
			a.updateImage();
		}
	}

	private static final Map<Character, String> CharacterFilenameMap;
	private static final Map<Character, ImageIcon> CharacterImageMap;
	static {
		CharacterFilenameMap = new HashMap<Character, String>();
		CharacterFilenameMap.put('X', "red.png");
		CharacterFilenameMap.put('O', "lg.png");
		CharacterFilenameMap.put('E', "empty.png");

		CharacterImageMap = new HashMap<Character, ImageIcon>();
	}

	private static ImageIcon getIconForCharacter(Character c) {
		ImageIcon image = CharacterImageMap.get(c);
		if (image != null) {
			return image;
		}
		synchronized (CharacterImageMap) {
			final ClassLoader cl = Thread.currentThread()
					.getContextClassLoader();
			final URL url = cl.getResource(CharacterFilenameMap.get(c));

			image = new ImageIcon(url);
			CharacterImageMap.put(c, image);
			return image;
		}
	}
}