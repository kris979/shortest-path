package com.agisoft.shortestpath;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.LinkedList;
import java.util.Queue;

public class Cell implements Comparable<Cell> {
	
	private int x;
	private int y;
	private int distance = 0;

	public Cell() {
		super();
	}

	public Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Cell(int x, int y, int distance) {
		super();
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + "," + distance + ")";
	}

	public boolean isWall() {
		return x == 0 || y == 0 || x >= 9 || y >= 9;
	}

	@JsonIgnore
	public Queue<Cell> getAdjacent() {
		Queue<Cell> adjacentCells = new LinkedList<>();
		int newDistance = distance + 1;
		Cell left = new Cell(x-1, y, newDistance);
		Cell right = new Cell(x+1, y, newDistance);
		Cell top = new Cell(x, y-1, newDistance);
		Cell bottom = new Cell(x, y+1, newDistance);
		
		adjacentCells.offer(left);
		adjacentCells.offer(top);
		adjacentCells.offer(right);
		adjacentCells.offer(bottom);
		
		return adjacentCells;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + distance;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (distance != other.distance)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public boolean equalsXY(Cell other) {
		return x == other.getX() && y == other.getY();
	}
	
	@Override
	public int compareTo(Cell o) {
		if (distance > o.getDistance()) {
			return -1;
		} else if (distance == o.getDistance()) {
			return 0;
		} else {
			return 1;
		}
	}

	@JsonIgnore
	public boolean isAdjacentTo(Cell last) {
		if (x == last.getX()-1 && y == last.getY()) {
			return true;
		} else if (x == last.getX()+1 && y == last.getY()) {
			return true;
		} else if (x == last.getX() && y == last.getY()-1) {
			return true;
		} else if (x == last.getX() && y == last.getY()+1) {
			return true;
		} else {
			return false;
		}
	}
	

}
