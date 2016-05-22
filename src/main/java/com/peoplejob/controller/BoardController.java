package com.peoplejob.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peoplejob.common.IocContainer;

import com.peoplejob.dto.account.AccountFilter;
import com.peoplejob.dto.board.Board;
import com.peoplejob.dto.board.BoardFilter;
import com.peoplejob.dto.board.BoardPagingFilter;
import com.peoplejob.dto.board.BoardWrite;
import com.peoplejob.library.Json;


@Controller
public class BoardController {

	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private IocContainer ioc;

	
	  @RequestMapping(value="/board/list.do", method = RequestMethod.GET)
	  public void GetBoardList(@ModelAttribute BoardPagingFilter filter, HttpServletResponse response) throws Exception{
		  filter.setColumnNumber(8);
		  filter.setColumnIndex(filter.getColumnIndex() * filter.getColumnNumber());
		  Json.getJson().ReturnJSON(response, ioc.getBoardBiz().SelectBoardList(filter));
	  }
	  	  
	  @RequestMapping(value="/board/contents.do", method = RequestMethod.GET)
	  public void GetBoard(@ModelAttribute BoardFilter filter, HttpServletResponse response) throws Exception{
		  Json.getJson().ReturnJSON(response, ioc.getBoardBiz().GetBoard(filter));
	  }
	  
	  @RequestMapping(value="/board/pagecount.do", method = RequestMethod.GET)
	  public void GetPageCount(HttpServletResponse response) throws Exception{
		  BoardPagingFilter filter = new BoardPagingFilter();
		  filter.setColumnNumber(8);
		  Json.getJson().ReturnJSON(response, ioc.getBoardBiz().GetPageCount(filter) + 1);	 
	  }
	  
	  @RequestMapping(value="/board.do", method = RequestMethod.POST)
	  public void SetBoard(@RequestBody Board board, HttpServletResponse response) throws Exception{
		  Json.getJson().ReturnJSON(response, ioc.getBoardBiz().SetBoard(board));		  
	  }
}
