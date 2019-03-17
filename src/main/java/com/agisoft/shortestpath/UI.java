package com.agisoft.shortestpath;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private enum Selection {
		START, END, WALLS
	}

	private Selection selectedButton = Selection.WALLS;
	private Board board = new Board(11);
	private JPanel topPanel = new JPanel(new GridLayout(1, 3));
	private JPanel centerPanel = new JPanel(new GridLayout(10, 10));
	private JPanel bottomPanel = new JPanel(new GridLayout(1, 1));
	private List<JButton> cells = new ArrayList<>();

	public UI() throws HeadlessException {
		super();

		addRadioButtonToTopPanel();
		add(topPanel, BorderLayout.NORTH);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JButton b = new JButton(Integer.toString(i) + "," + Integer.toString(j));
				b.addActionListener(this);
				cells.add(b);
				centerPanel.add(b);
			}
		}
		add(centerPanel, BorderLayout.CENTER);

		JButton go = new JButton("Go!");
		go.addActionListener(this);
		bottomPanel.add(go);
		add(bottomPanel, BorderLayout.SOUTH);

		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		switch (actionCommand) {
		case "Add Start": {
			selectedButton = Selection.START;
			deselectOtherButtons("Add Start");
		}
			break;
		case "Add End": {
			selectedButton = Selection.END;
			deselectOtherButtons("Add End");
		}
			break;
		case "Add Walls": {
			selectedButton = Selection.WALLS;
			deselectOtherButtons("Add Walls");
		}
			break;
		case "Go!": {
			clearBoard();
			List<Cell> shortestPath = board.getShortestPath();
			drawShortestPath(shortestPath);
		}
			break;
		default: {
			JButton thatWasClicked = (JButton) e.getSource();
			markCell(thatWasClicked);
		}
			break;

		}
	}

	private void drawShortestPath(List<Cell> shortestPath) {
		for (Cell cell : shortestPath) {
			int tens = cell.getX();
			int ones = cell.getY();
			int index = 10 * tens + 1 * ones;
			JButton uiCell = cells.get(index);
			if (!(uiCell.getText().equals("START") || uiCell.getText().equals("END"))) {
				uiCell.setText(Integer.toString(cell.getDistance()));
			}
		}
	}

	private void clearBoard() {
		for (JButton jButton : cells) {
			if (!(jButton.getText().equals("START") || jButton.getText().equals("END")
					|| jButton.getText().equals("X"))) {
				jButton.setText("");
			}
		}
	}

	private void markCell(JButton buttonCell) {
		String[] split = buttonCell.getText().split(",");
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);
		Cell cell = new Cell(x, y);
		switch (selectedButton) {
		case START: {
			board.setStart(cell);
			buttonCell.setText("START");
			buttonCell.setBackground(Color.GREEN);
		}
			break;
		case END: {
			board.setEnd(cell);
			buttonCell.setText("END");
			buttonCell.setBackground(Color.YELLOW);
		}
			break;
		case WALLS: {
			board.addWall(x, y);
			buttonCell.setText("WALL");
			buttonCell.setBackground(Color.RED);
		}
			break;
		default:
			break;
		}
	}

	private void deselectOtherButtons(String txt) {
		Component[] components = topPanel.getComponents();
		for (Component component : components) {
			JRadioButton button = (JRadioButton) component;
			if (!button.getText().equals(txt)) {
				button.setSelected(false);
			}
		}
	}

	private void addRadioButtonToTopPanel() {
		JRadioButton startButton = new JRadioButton("Add Start");
		startButton.addActionListener(this);
		JRadioButton endButton = new JRadioButton("Add End");
		endButton.addActionListener(this);
		JRadioButton wallsButton = new JRadioButton("Add Walls");
		wallsButton.addActionListener(this);

		topPanel.add(startButton);
		topPanel.add(endButton);
		topPanel.add(wallsButton);
	}

	public static void main(String[] args) {
		UI ui = new UI();
	}

}
