package com.peoplejob.dao;

import java.util.ArrayList;

import com.peoplejob.common.AbstractDAO;
import com.peoplejob.dto.ListDTO;
import com.peoplejob.dto.board.Board;
import com.peoplejob.dto.board.BoardFilter;
import com.peoplejob.dto.board.BoardPagingFilter;
import com.peoplejob.dto.response.LoginResponse;

public class BoardDAO extends AbstractDAO {
	public ArrayList<Board> SelectBoardList(BoardPagingFilter filter) throws Exception{
        return (ArrayList<Board>)selectList("Board.getBoardList",filter);
    }
	
	public Board GetBoard(BoardFilter filter){
		return (Board)selectOne("Board.getBoard",filter);
	}
	
	public int GetPageCount(BoardPagingFilter filter){
		return (int) selectOne("Board.getPageCount",filter);
	}

	public LoginResponse SetBoard(Board board) {
		// TODO Auto-generated method stub
		LoginResponse response = new LoginResponse();
		try{
			insert("Board.setBoard",board);
			response.setResult("Success");

		}catch(Exception e){		
			response.setReason(e.toString());
			response.setResult("Fail");
		}
		return response;
	}
}
