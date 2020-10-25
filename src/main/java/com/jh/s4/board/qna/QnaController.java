package com.jh.s4.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jh.s4.board.BoardDTO;
import com.jh.s4.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@PostMapping("qnaReply")
	public ModelAndView setReply(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setReply(boardDTO);
		
		String message = "Reply Write Fail";
		
		if(result>0) {
			message ="Reply Write Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("qnaReply")
	public ModelAndView setReply()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardReply");
		mv.addObject("board", "qna");
		return mv;
	}
	
	
	
	@GetMapping("qnaSelect")
	public ModelAndView getOne(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getOne(boardDTO);
		
		if(boardDTO != null) {
			mv.setViewName("board/boardSelect");
			mv.addObject("dto", boardDTO);
			mv.addObject("board", "qna");
		}else {
			mv.setViewName("common/result");
			mv.addObject("msg", "No Data");
			mv.addObject("path", "./qnaList");
		}
		
		return mv;
				
	}
	
	@PostMapping(value = "qnaWrite")
	public ModelAndView setInsert(BoardDTO boardDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setInsert(boardDTO);
		String message ="Write Fail";
		
		if(result>0) {
			message = "Write Success";
						
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		
		mv.setViewName("common/result");
		
		return mv;
		
	}
	
	
	@GetMapping(value = "qnaWrite")
	public ModelAndView setInsert() throws Exception {
		
		ModelAndView mv= new ModelAndView();
		
		mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");
		
		return mv;
		
	}
	
	
	@GetMapping(value = "qnaList")
	public ModelAndView getList(Pager pager) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		
		mv.addObject("board", "qna");
		mv.addObject("lists", ar);
		mv.addObject("pager", pager);		
		mv.setViewName("board/boardList");
		
		
		return mv;
	}
}
