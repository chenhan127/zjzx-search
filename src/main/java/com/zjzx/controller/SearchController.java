package com.zjzx.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.zjzx.annotation.TokenAop;
import com.zjzx.service.SearchService;

@Controller
@RequestMapping("/search")
@ResponseBody
public class SearchController {
	@Autowired
	private SearchService searchService;

	@RequestMapping("/addSearchRecord")
	public JSONObject addSearchRecord( String keyword, final Integer userid) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		searchService.saveSearchManager(keyword);
		searchService.saveSearchrecord(keyword, userid);
		JSONObject resMap = new JSONObject();
		resMap.put("status", "success");
		return resMap;
	}

	/**
	 * 获取最热的关键字
	 * 
	 * @return
	 */
	@RequestMapping("/getHotKeyword")
	public JSONObject getHotKeyword() {
		JSONObject resMap = searchService.getHotKeyword();
		return resMap;
	}

	/**
	 * 获取关键字列表
	 * 
	 * @return
	 */
	@RequestMapping("/getKeywordList")
	public JSONObject getKeywordList(String keyword) {
		JSONObject resMap = searchService.getKeywoedList(keyword);
		return resMap;
	}

	/**
	 * 获取用户常用的关键词
	 * 
	 * @param userid
	 * @param count
	 * @return
	 */
	@RequestMapping("/getUserKeywordList")
	public JSONObject getUserKeywordList(Integer userid, Integer number) {
		JSONObject resMap = searchService.getUserKeywordList(userid, number);
		return resMap;
	}

}
