package com.agisoft.shortestpath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping("/board")
public class BoardController {

    private BoardServices boardServices;

    @Autowired
    public BoardController(BoardServices boardServices){
        super();
        this.boardServices = boardServices;
    }

    @GetMapping("/shortestPath")
    public List<Cell> findShortestPath(){
        return this.boardServices.findShortestPath();
    }

	@RequestMapping(value = "/walls", method = RequestMethod.GET)
    public Queue<Cell> walls() {
		return boardServices.getWalls();
    }

	@RequestMapping(value = "/start", method = RequestMethod.PUT)
    public void setStart(@RequestBody Cell start) {
		boardServices.setStart(start);
    }

	@RequestMapping(value = "/end", method = RequestMethod.PUT)
    public void setEnd(@RequestBody Cell end) {
		boardServices.setEnd(end);
    }

}
