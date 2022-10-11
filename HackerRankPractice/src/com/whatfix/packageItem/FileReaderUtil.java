package com.whatfix.packageItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReaderUtil {

	public static List<ItemsInfo> readFile(String fileName){

		List<ItemsInfo> itemList= new ArrayList<ItemsInfo>();
		BufferedReader br = null;
		FileReader fr = null;

		try {
			br = new BufferedReader(new FileReader(fileName));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				itemList.add(createItemInfo(sCurrentLine));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return itemList;
	}

	private static ItemsInfo createItemInfo(String sCurrentLine) {
		
		ItemsInfo itemsInfo = new ItemsInfo();
		itemsInfo.setItems(new ArrayList<Item>());
		String[] arr = sCurrentLine.split(":");
		
		if(arr != null && arr.length == 2){
			itemsInfo.setMaxWeight(Integer.parseInt(arr[0].trim()));
			sCurrentLine = arr[1].trim();
			String[] itemArr = sCurrentLine.split(" ");
			
			for(String temp : itemArr){
				temp = temp.substring(1,temp.length()-1);
				String[] itemDetails = temp.split(",");
				Item item = null;
				if(itemDetails != null && itemDetails.length == 3){
					item = new Item();
					item.setItemIndex(Integer.parseInt(itemDetails[0].trim()));
					item.setWeight(Float.parseFloat(itemDetails[1].trim()));
					item.setPrice(Integer.parseInt(itemDetails[2].trim().substring(1)));
					itemsInfo.getItems().add(item);
				}
			}
		}
		Collections.sort(itemsInfo.getItems(),Collections.reverseOrder());;
		return itemsInfo;
	}
}
