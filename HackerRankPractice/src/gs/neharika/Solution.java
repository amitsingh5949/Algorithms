package gs.neharika;

import java.util.ArrayList;
import java.util.List;

public class Solution{
	
	public static void main(String[] args) {
		
		StringCollections stringCollections = new StringCollections();	
		String[][]  input = { {"11","12"},
				{"21","22","23"},
				{"31","32"},
				
		};
		int threadCound =  3;
		for(int i=0; i<threadCound; i++) {
			Thread t = new MyThread(i, stringCollections, input[i]);
			t.start();
		}
	}
}

 class StringCollections {
	
	List<String> collections;
	
	public StringCollections() {
		super();
		collections = new ArrayList<String>();
	}

	synchronized void addString(String string) {
		collections.add(string);
	}
	
	synchronized List<String> getStringCollections(){
		return collections;
	}

}

class MyThread extends Thread{
	
	Integer id; 
	StringCollections stringCollections;
	String[] inputStrArr;
	
	public MyThread(Integer id, StringCollections stringCollections, String[] inputStrArr) {
		super();
		this.id = id;
		this.stringCollections = stringCollections;
		this.inputStrArr = inputStrArr;
	}

	@Override
	public void run() {
		System.out.println("Thread " + id + " stringCount = " + inputStrArr.length);
		for(String str : inputStrArr) {
			stringCollections.addString(str);
		}
		System.out.println("Size of stringCollection " + stringCollections.getStringCollections().size());
	}
	
}
