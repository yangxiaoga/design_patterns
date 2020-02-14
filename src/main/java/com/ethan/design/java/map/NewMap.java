package com.ethan.design.java.map;

import com.ethan.design.java.list.NewLinkedList;

/**
 * 自定义实现Map功能 
 * 根据键KEY找VALUE
 */
public class NewMap {
	
	static final int DAFAULT_VALUE = 1000;
	
	//Map的底层结构就是数组加链表
	private NewLinkedList[] list;
	
	private int size;
	
	public int getSize() {
		return size;
	}
	public NewMap() {
		list = new NewLinkedList[DAFAULT_VALUE];
	}
	
    public static void main(String[] args) {
    	
    	NewMap map = new NewMap();
    	System.out.println(map.getSize());
    	map.put("arr", "是胜多负少的爽肤水");
    	map.put("arr", "是胜多负少的爽肤水1");
    	System.out.println(map.get("arr"));
    	System.out.println(map.getSize());
	
    }
    
    /**
     * 获取元素
     * @param key 元素的键
     * @return 存在则返回，否null
     */
    public Object get(Object key) {
    	int hashCode = key.hashCode() % DAFAULT_VALUE;
    	if (list[hashCode] != null) {
    		NewLinkedList temp = list[hashCode];
    		
    		for (int i=0; i < temp.size(); i++) {
    			MapEntry entry = (MapEntry)temp.get(i);
    			
    			if (entry.getKey().equals(key)) {
    				return entry.getValue();
    			}
    		}
    	}
    	return null;
    }
    
    /**
     * 放置对象
     * @param key 键
     * @param value 值
     * haCode有可能返回负值 
     */
    public void put(Object key, Object value) {
    	
    	MapEntry entry = new MapEntry(key, value);
    	
    	//哈希值对1000取余，对应具体数组的下标
    	//hashCode返回值有可能是负数
    	int temp = key.hashCode() < 0 ? -key.hashCode() : key.hashCode();
    	int hashCode = temp % DAFAULT_VALUE;
    	if (list[hashCode] == null) {
    		NewLinkedList linkedList = new NewLinkedList();
    		linkedList.add(entry);
    		list[hashCode] = linkedList;
    		size++;
    	} else {//做是否存在该key的判断，进行替换
    		NewLinkedList tempList = list[hashCode];
    		for(int i = 0; i < tempList.size(); i++) {
    			MapEntry e = (MapEntry)tempList.get(i);
    			if (e.getKey().equals(key)) {//键重复，直接覆盖
    				e.setValue(value);
    				return;
    			}
    		}
    		size++;
    		list[hashCode].add(entry);
    	}
    	
    }
    
    static class MapEntry {
		Object key;
    	Object value;
    	public MapEntry() {}
    	
    	public MapEntry (Object key, Object value) {
    		this.key = key;
    		this.value = value;
    	}
    	public Object getKey() {
			return key;
		}
		public void setKey(Object key) {
			this.key = key;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}
    }
}
