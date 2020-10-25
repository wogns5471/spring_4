package com.jh.s4.board.notice;

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
@RequestMapping(value="/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getOne(boardDTO);
		
		if(boardDTO != null) {
			mv.setViewName("board/boardSelect");
			mv.addObject("dto", boardDTO);
			mv.addObject("board", "notice");
		}else {
			mv.setViewName("common/result");
			mv.addObject("msg", "No Data");
			mv.addObject("path", "./noticeList");
		}
		
		return mv;
				
	}
	
	
	
	@PostMapping(value = "noticeWrite")
	public ModelAndView setInsert(BoardDTO boardDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setInsert(boardDTO);
		String message ="Write Fail";
		
		if(result>0) {
			message = "Write Success";
						
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		
		mv.setViewName("common/result");
		
		return mv;
		
	}
	
	
	@GetMapping(value = "noticeWrite")
	public ModelAndView setInsert() throws Exception {
		
		ModelAndView mv= new ModelAndView();
		
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		
		return mv;
		
	}
	
	
	
	
	@GetMapping(value = "noticeList")
	public ModelAndView getList(Pager pager) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.getList(pager);
		
		mv.addObject("board", "notice");
		mv.addObject("lists", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		
		return mv;
		
	}
	
	
}
