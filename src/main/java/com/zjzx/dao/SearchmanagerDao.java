package com.zjzx.dao;


import java.util.List;

import org.springframework.stereotype.Component;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
@Component
public class SearchmanagerDao {
	private static String tableName = "searchmanager";
	/**
	 * 保存搜索记录
	 * @param record
	 */
	public void saveSearchmanager(Record record){
		Db.save(tableName, record);
	}
	
	/**
	 * 更新搜索记录次数
	 * @param record
	 */
	public void updateSearchmanager(Record record) {
		// TODO Auto-generated method stub
		Db.update(tableName,record);
	}
	
	/**
	 * 根据关键字找到记录
	 * @param keword
	 * @return
	 */
	public Record getRecordBykeyword(String keyword) {
		// TODO Auto-generated method stub
		String sql = "select * from "+tableName+" where keyword =?";
		Record record =Db.findFirst(sql,keyword);
		return record;
	}

	public List<Record> getHotKeyword() {
		// TODO Auto-generated method stub
		String sql = "select * from "+tableName+" order BY count DESC LIMIT 3";
		List<Record> list = Db.find(sql);
		return list;
	}
	public List<Record> getKeywoedList(String key) {
		// TODO Auto-generated method stub
		String sql = "select * from  "+ tableName +" where keyword like ?";
		List<Record> list = Db.find(sql,"%"+key+"%");
		return list;
	}


}
