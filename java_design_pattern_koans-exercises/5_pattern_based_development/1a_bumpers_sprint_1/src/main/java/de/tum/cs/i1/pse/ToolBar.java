package de.tum.cs.i1.pse;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import javax.swing.JOptionPane;
import javax.swing.JToolBar;


public class ToolBar extends JToolBar {


	private static final long serialVersionUID = 1L;
	
	private Referee referee;
	
    private Action startAction;
    private Action stopAction;

    public ToolBar(Referee referee) {
        super();

        setFloatable(false);
        initActions();
        add(startAction);
        add(stopAction);
        addSeparator();

        this.referee = referee;
        referee.initGame();
        enableButtons();
    }

    private void initActions() {
    	startAction = new AbstractAction("start") {

            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                referee.startGame();
            }
        };

        stopAction = new AbstractAction("stop") {

            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                referee.stopGame();
                int ret = JOptionPane.showConfirmDialog(null,
                        "Do you really want to stop the game ?",
                        "Stop Game Confirmation", JOptionPane.YES_NO_OPTION);
                if (ret == 0) {
                	referee.initGame();
                } else {
                   referee.startGame();
                }
            }
        };
    }

	public void enableButtons() {
		startAction.setEnabled(!referee.isRunning());
		stopAction.setEnabled(referee.isRunning());
    }

}
