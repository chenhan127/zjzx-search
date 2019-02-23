package com.zjzx.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

@Component
public class SearchrecordDao {
	
	private static final String tableName = "searchrecord";
	/**
	 * 保存用户搜索记录
	 * @param record
	 */
	public void saveSearchrecord(Record record){
		Db.save(tableName, record);
	}
	/**
	 * 更新用户搜索记录次数
	 * @param record
	 */
	public void updateSearchrecord(Record record){
		Db.update(tableName, record);
	}
	/**
	 * 根据关键字和用户id 查找搜索记录
	 * @param userid
	 * @param keyword
	 * @return
	 */
	public Record getRecordBykeyword(Integer userid,String keyword){
		String sql = "select * from "+tableName+" where keyword=? and userid=?";
		Record record = Db.findFirst(sql, keyword,userid);
		return record;
	}
	/**
	 * 获取用户搜索记录
	 * @param userid
	 * @param count
	 * @return
	 */
	public List<Record> getUserKeywordList(Integer userid, Integer count) {
		// TODO Auto-generated method stub
		String sql = "select * from "+tableName +" where userid =? order by count desc,id desc limit ?";
		List<Record> records = Db.find(sql, userid,count);
		return records;
	}
	/**
	 * 
	 * @param records
	 * @param userid
	 */
	public void deleteSearchRecord(List<Integer> records, Integer userid) {
		// TODO Auto-generated method stub
		String sql = "delete from "+tableName+" where id=? and userid=? ";
		for(int id:records){
			Db.update(sql, id,userid);
		}
	}
	

}
