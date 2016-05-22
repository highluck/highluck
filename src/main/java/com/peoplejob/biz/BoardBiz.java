package com.peoplejob.biz;

import java.util.ArrayList;

import com.peoplejob.dao.BoardDAO;
import com.peoplejob.dto.board.Board;
import com.peoplejob.dto.board.BoardFilter;
import com.peoplejob.dto.board.BoardPagingFilter;
import com.peoplejob.dto.response.LoginResponse;

public class BoardBiz {

	private BoardDAO boardDao;

	public void setBoardDao(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}
	
	public ArrayList<Board> SelectBoardList(BoardPagingFilter filter) throws Exception{	
		return boardDao.SelectBoardList(filter);
	}
	
	public int GetPageCount(BoardPagingFilter filter){
		return boardDao.GetPageCount(filter);
	}
	
	public Board GetBoard(BoardFilter filter){
		return boardDao.GetBoard(filter);
	}
	public LoginResponse SetBoard(Board board){
		return boardDao.SetBoard(board);
	}
}
