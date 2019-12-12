package net.toto.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	    service.create(board);

	    return "redirect:/board/listAll";
	  }
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	  public ModelAndView listAll() throws Exception {

	    List<BoardVO> boardList =  service.listAll();
        ModelAndView mv = new ModelAndView("/board/listAll");
        mv.addObject("boardList", boardList);
        return mv;
	  }
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String readGET(@RequestParam("bno") int bno, Model model) { 
		
		BoardVO board = service.read(bno);
		model.addAttribute("board",board);
		return "/board/read"; 
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		System.out.println(bno);
	    service.delete(bno);
	    rttr.addFlashAttribute("msg", "SUCCESS");

	    return "redirect:/board/listAll";
	}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateGET(@RequestParam("bno") int bno, Model model) { 
		BoardVO board = service.read(bno);
		model.addAttribute("board",board);

		return "/board/update"; 
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO board, RedirectAttributes rttr) throws Exception {
		System.out.println(board.toString());
	    service.update(board);
	    rttr.addFlashAttribute("msg", "SUCCESS");

	    return "redirect:/board/listAll";
	}
}
