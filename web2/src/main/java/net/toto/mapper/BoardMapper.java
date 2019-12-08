package net.toto.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.toto.domain.BoardVO;

@Mapper
public interface BoardMapper {

	BoardVO read(Integer bno);
	void create(BoardVO vo);
	void update(BoardVO vo);
	void delete(Integer bno);
	List<BoardVO> listAll();
}
