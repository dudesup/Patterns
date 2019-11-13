package de.tum.cs.i1.pse;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Game extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel content = new JPanel(new BorderLayout(), true);
	
	private GameBoard gameBoard;

	public Game() {
		super("Bumpers Sprint 1");

		ActionListener exitMenuItemListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.this.close();
			}};
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(exitMenuItemListener);
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(exitMenuItem);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		
		this.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						Game.this.close();
					}});
		
		gameBoard = new GameBoard();
		
		getContentPane().setLayout(new BorderLayout());
		
		content.add(gameBoard.referee.refereeToolBar(), BorderLayout.NORTH);
		content.add(gameBoard, BorderLayout.CENTER);
		
		getContentPane().add(content, BorderLayout.CENTER);
	}

	
	@Override
	public void setVisible(boolean b) {
		Dimension size = getPreferredSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds
		(
			(screenSize.width - size.width) / 2,
			(screenSize.height - size.height) / 2,
			size.width,
			size.height
		);
		super.setVisible(b);
	}
	
	public void doLayout(){
		super.doLayout();
		content.doLayout();
		this.getContentPane().doLayout();
	}
	
	private void close() {
		setVisible(false);
		System.exit(0);
	}
}