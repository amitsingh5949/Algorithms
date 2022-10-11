package com.whatfix.packageItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String fileName=null;
		System.out.println("Please enter a file path");// in format eg : C:\\Dev Workspace\\eclipse\\input.txt or C:/Dev Workspace/eclipse/input.txt
		Scanner scan = new Scanner(System.in);
		fileName = scan.nextLine();
		scan.close();
		if(fileName != null ){
			List<ItemsInfo> list = FileReaderUtil.readFile(fileName);

			for(ItemsInfo itemsInfo : list){
				sendpackage(itemsInfo);
			}
		}
	}

	private static void sendpackage(ItemsInfo itemsInfo) {

		int permissibleWeight = itemsInfo.getMaxWeight();
		float packageWeight  = 0;
		int packagePrice = 0;
		List<Item> allowedItems = new ArrayList<Item>();

		for(Item item : itemsInfo.getItems()){

			if(item.getWeight() > permissibleWeight || (item.getWeight() + packageWeight) > permissibleWeight){
				continue;
			}
			else{
				packageWeight = packageWeight + item.getWeight();
				packagePrice = packagePrice + item.getPrice();
				allowedItems.add(item);
			}
		}
		if(allowedItems.size() > 0){
			System.out.print( allowedItems.size() + " - ");
			boolean flag = true;
			for(Item item : allowedItems){
				if(flag){
					System.out.print(item.getItemIndex());
					flag = false;
				}
				else{
					System.out.print( "," + item.getItemIndex() );
				}	
			}
			System.out.println();
		}
		else{
			System.out.println("0 - 0");
		}
	}
}
