package com.jh.s4.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jh.s4.MyTestCase;
import com.jh.s4.board.BoardDTO;
import com.jh.s4.util.Pager;

public class QnaDAOTest extends MyTestCase {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void getListTest() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();		
		List<BoardDTO> ar = qnaDAO.getList(pager);
		System.out.println(ar.size());
		assertEquals(10, ar.size());
		
		
	}	
	
	
	
	//@Test
	public void setInsertTest() throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setTitle("Title Test9");
		boardDTO.setWriter("writer Test9");
		boardDTO.setContents("contents Test9");		
		
		int result = qnaDAO.setInsert(boardDTO);
		
		assertEquals(1, result);
		
	}

}
