package com.javaDwarf.dataStructure.generic;

public interface AbstractDataType {
	
	public int insert(int value);
	
	public int delete(int value);
	public int deleteAt(int index);
	public void deleteAll(int value);
	
	public int search(int value);
	
	public String display();
	
	
	
	

}
