package com.jh.s4.board;

import java.util.List;

import com.jh.s4.util.Pager;

public interface BoardDAO {
	
	//abstract 메서드은 선언부
	//insert
	public int setInsert(BoardDTO boardDTO) throws Exception;
	
	//update
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	//list
	public List<BoardDTO> getList(Pager pager) throws Exception;
		
	//seletOne	
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception;
	
	//count
	public long getCount(Pager pager)throws Exception;
	
}
