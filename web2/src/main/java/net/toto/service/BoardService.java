package net.toto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.toto.domain.BoardVO;
import net.toto.mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	BoardMapper mapper;
	
	public void create(BoardVO vo) {
		mapper.create(vo);
	}
	public BoardVO read(Integer bno) {
		return mapper.read(bno);
	}
	public void update(BoardVO vo) {
		mapper.update(vo);
	}
	public void delete(Integer bno) {
		mapper.delete(bno);
	}
	public List<BoardVO> listAll(){
		return mapper.listAll();
	}
}
