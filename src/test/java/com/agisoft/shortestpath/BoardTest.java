package com.agisoft.shortestpath;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/*

  0 1 2 3 4 5 6 7 8 9
0 x x x x x x x x x x
1 x S 5 - - - - - - x
2 x 5 4 - - - - - - x
3 x 4 3 - - - - - - x
4 x x 2 x - - - - - x
5 x E 1 2 3 - - - - x
6 x 1 2 3 - - - - - x
7 x 2 3 - - - - - - x
8 x 3 - - - - - - - x
9 x x x x x x x x x x



  0 1 2 3 4 5 6 7 8 9
0 x x x x x x x x x x
1 x - - - - - - - - x
2 x - - - - - - - - x
3 x - - - - - - - - x
4 x - - - - - - - - x
5 x - - - - - - - - x
6 x - - - - - - - - x
7 x - - - - - - - - x
8 x - - - - - - - - x
9 x x x x x x x x x x


*/
public class BoardTest {
	
	@Test
	public void testBoard() {
		
		Board tested = new Board(10);
		Queue<Cell> board = tested.getWalls();
		assertThat(board, hasSize(36));
		assertThat(Arrays.asList(board.stream().filter(c -> c.isWall() == true).toArray()), hasSize(36));
	}

	@Test
	public void testAdjacentCell() {
		
		Cell c1 = new Cell(4, 5);
		Cell c2 = new Cell(5, 5,1);
		Cell c3 = new Cell(6, 5);
		Cell c4 = new Cell(4, 4,1);
		
		assertThat(c1.isAdjacentTo(c2), is(true));
		assertThat(c3.isAdjacentTo(c2), is(true));
		assertThat(c2.isAdjacentTo(c4), is(false));
		assertThat(c1.isAdjacentTo(c4), is(true));
		
		assertThat(c1.getAdjacent(), hasItem(c2)); 
		assertThat(c1.getAdjacent(), hasItem(c4));
	}
	
	@Test
	public void testFindPaths() {

		Board tested = new Board(10);
		Cell start = new Cell(1, 1, 4);
		Cell end = new Cell(1, 5, 0);
		tested.setStart(start);
		tested.setEnd(end);
		List<Cell> paths = tested.findPaths();
		assertThat(paths, hasItem(start));
		assertThat(paths, hasItem(new Cell(1,2,3)));
		assertThat(paths, hasItem(new Cell(1,3,2)));
		assertThat(paths, hasItem(new Cell(1,4,1)));
		assertThat(paths, hasItem(end));
	}
	
	@Test
	public void testFindShortestPaths() {

		Cell end = new Cell(3, 1);
		Cell start = new Cell(1, 1);
		Board tested = new Board(10);
		tested.setStart(start);
		tested.setEnd(end);
		tested.addWall(2,1);
		
		List<Cell> shortestPath = tested.getShortestPath();
	/*	
		    0 1 2 3 4 5 6 7 8 9
		  0 x x x x x x x x x x
		  1 x S x E 1 2 3 4 - x
		  2 x 3 2 1 2 3 4 - - x
		  3 x - 3 2 3 4 - - - x
		  4 x - - 3 4 - - - - x
		  5 x - - - - - - - - x
		  6 x - - - - - - - - x
		  7 x - - - - - - - - x
		  8 x - - - - - - - - x
		  9 x x x x x x x x x x
		*/  
		assertThat(shortestPath, hasSize(5));
		assertThat(shortestPath, hasItem(new Cell(1,1,4)));
		assertThat(shortestPath, hasItem(new Cell(1,2,3)));
		assertThat(shortestPath, hasItem(new Cell(2,2,2)));
		assertThat(shortestPath, hasItem(new Cell(3,2,1)));
		assertThat(shortestPath, hasItem(new Cell(3,1,0)));
	}
	
	@Test
	public void testFindShortestPaths1() {
		
		Cell start = new Cell(1, 1);
		Cell end = new Cell(1, 5);
		Board tested = new Board(10);
		tested.setStart(start);
		tested.setEnd(end);
		tested.addWall(3,4);
		tested.addWall(1,4);
		
		List<Cell> paths = tested.getShortestPath();
		assertThat(paths, hasSize(7));
		assertThat(paths, hasItem(new Cell(1,1,6)));
		assertThat(paths, hasItem(new Cell(1,2,5)));
		assertThat(paths, hasItem(new Cell(1,3,4)));
		assertThat(paths, hasItem(new Cell(2,3,3)));
		assertThat(paths, hasItem(new Cell(2,4,2)));
		assertThat(paths, hasItem(new Cell(2,5,1)));
		assertThat(paths, hasItem(new Cell(1,5,0)));
	}
	
}

