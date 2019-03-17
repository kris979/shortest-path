package com.agisoft.shortestpath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

@Service
public class BoardServices {
	
	private Board board;

	@Autowired
	public BoardServices(Board board) {
		super();
		this.board = board;
	}
	
	public BoardServices() {
		super();
	}

	public Queue<Cell> getWalls() {
		return board.getWalls();
	}

	public void addStart(Cell start) {
		board.setStart(start);
	}
	
	public void setStart(Cell start) {
		board.setStart(start);
	}
	
	public void setEnd(Cell end) {
		board.setEnd(end);
	}

	public List<Cell> findShortestPath() {
		return board.getShortestPath();
	}
	
}
