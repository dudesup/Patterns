package de.tum.cs.i1.pse;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import de.tum.cs.i1.pse.collision.CollisionStrategy;


public class ToolBar extends JToolBar implements ItemListener {

	private static final long serialVersionUID = 1L;
	
	private Referee referee;
	
    private Action startAction;
    private Action stopAction;

	private JComboBox<Object> strategyBox = new JComboBox<Object>();

    public ToolBar(Referee referee) {
        super();
        

        ArrayList<Object> strategies = CollisionStrategy.getSTRATEGIES();
        Iterator<Object> iter = strategies.iterator();
        while (iter.hasNext()) {
            strategyBox.addItem(iter.next());
        }
        strategyBox.setSelectedItem(referee.getCollisionStrategy());
        strategyBox.addItemListener(this);

        setFloatable(false);
        initActions();
        add(startAction);
        add(stopAction);
        addSeparator();
        
        add(new JLabel("Collision Strategy:"));
        add(strategyBox);

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

	@Override
	public void itemStateChanged(ItemEvent e) {
		//TODO: Set the selected Strategy in the Referee class
	}

}
