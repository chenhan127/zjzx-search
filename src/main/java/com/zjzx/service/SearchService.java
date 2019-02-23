package com.zjzx.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Record;
import com.zjzx.dao.SearchmanagerDao;
import com.zjzx.dao.SearchrecordDao;
import com.zjzx.util.JSONUtil;
public class  SearchService{
	@Autowired
	private SearchmanagerDao searchmanagerDao;
	@Autowired
	private SearchrecordDao searchrecordDao;
	
	
	
	@Async
	public synchronized JSONObject saveSearchManager(String keyword) {
		// TODO Auto-generated method stub
		if(keyword == null || "".equals(keyword)){
			return null;
		}
		
		Record record = searchmanagerDao.getRecordBykeyword(keyword);
		if(record == null){
			record = new Record();
			record.set("keyword", keyword);
			record.set("count", 1);
			searchmanagerDao.saveSearchmanager(record);
		}else{
			record.set("count", record.getLong("count")+1);
			searchmanagerDao.updateSearchmanager(record);
		}
		
		JSONObject resMap = new JSONObject();
		resMap.put("status", "success");
		return resMap;
	}
	@Async
	public synchronized  JSONObject saveSearchrecord(String keyword, Integer userid) {
		if(keyword == null || "".equals(keyword)){
			return null;
		}
		
		if(userid == null){
			return null;
		}
		
		// TODO Auto-generated method stub
		Record record = searchrecordDao.getRecordBykeyword(userid, keyword);
		if(record == null){
			record = new Record();
			record.set("keyword", keyword);
			record.set("count", 1);
			record.set("userid", userid);
			searchrecordDao.saveSearchrecord(record);
		}else{
			record.set("count", record.getLong("count")+1);
			searchrecordDao.updateSearchrecord(record);
		}
		JSONObject resMap = new JSONObject();
		resMap.put("status", "success");
		return resMap;
	}

	public JSONObject getHotKeyword() {
		// TODO Auto-generated method stub
		List<Record> recordList = searchmanagerDao.getHotKeyword();
		JSONObject resMap = new JSONObject();
		resMap.put("recordList", recordList);
		resMap.put("status", "success");
		return JSONUtil.parseJSON(resMap) ;
	}

	public JSONObject getKeywoedList(String key) {
		// TODO Auto-generated method stub
		List<Record> recordList = searchmanagerDao.getKeywoedList(key);
		JSONObject resMap = new JSONObject();
		resMap.put("status", "success");
		resMap.put("recordList", recordList);
		return JSONUtil.parseJSON(resMap) ;
	}

	public JSONObject getUserKeywordList(Integer userid, Integer number) {
		// TODO Auto-generated method stub
		List<Record> records = searchrecordDao.getUserKeywordList(userid,number);
		JSONObject resMap = new JSONObject();
		resMap.put("status", "success");
		resMap.put("recordList", records);
		return JSONUtil.parseJSON(resMap) ;
	}

	public JSONObject deleteSearchRecord(List<Integer> records, Integer userid) {
		// TODO Auto-generated method stub
		searchrecordDao.deleteSearchRecord(records,userid);
		return null;
	}

}
