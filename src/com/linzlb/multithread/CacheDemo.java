package com.linzlb.multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {
    private Map<String, Object> cache = new HashMap<String, Object>();
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	public Object getData(String key){
		rwl.readLock().lock();
		Object value = null;
		try{
			value = cache.get(key);
			if(value == null){
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				try{
					value = "select * from DB where name = "+key;	
					cache.put(key, value);
				}finally{
					rwl.writeLock().unlock();
				}
				rwl.readLock().lock();
			}
		}finally{
			rwl.readLock().unlock();
		}
		return value;
	}
	
	public static void main(String[] args) {
		CacheDemo cd = new CacheDemo();
		System.out.println(cd.getData("linzlb"));
		System.out.println(cd.getData("linzlb"));
		System.out.println(cd.getData("linzlb"));
	}
}