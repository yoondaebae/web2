package net.toto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import net.toto.domain.BoardVO;
import net.toto.mapper.BoardMapper;


@Component
public class BoardRunner implements ApplicationRunner {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		//객체의 생성
		BoardVO board = new BoardVO();
		board.setTitle("NEW TEXT ");
	    board.setContent("INPUT NEW TEXT ");
	    board.setWriter("user00");
	    
	    //INSERT
	    System.out.println("==============================");
	    //boardMapper.create(board);
	    //SELECT
	    System.out.println("==============================");
	    //boardMapper.read(2);
	    //DELECT
	    System.out.println("==============================");
	    //boardMapper.delete(2);

	}

}
