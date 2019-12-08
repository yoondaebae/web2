package net.toto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.toto.domain.BoardVO;
import net.toto.service.BoardService;

@Controller
@RequestMapping("/board/*") 
public class BoardController {

	@Autowired
	BoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGET() { 
		
		return "/board/register"; 
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	  public String registPOST(BoardVO board) throws Exception {
		System.out.println("regist post ...........");
		System.out.println(board.toString());

	    service.create(board);

	    return "/board/success";
	  }
}
