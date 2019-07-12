package com.javaDwarf.graphs.gfg.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawlerMain {
	public static void main(String[] args){
		new WebCrawler().crawl("https://www.booking.com/");
	}
}

class WebCrawler{
	Queue<String> queue = null;

	List<String> discoveredWebsites=null;

	public WebCrawler(){
		queue =  new LinkedList<>();
		discoveredWebsites = new ArrayList<>();
	}

	public void crawl(String urlStr){

		queue.add(urlStr);
		while(!queue.isEmpty()){

			try{
				String rawURLResponse = readRawURLResponse(queue.remove());
				String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(rawURLResponse);
				while(m.find()){
					String url = m.group();
					if(!discoveredWebsites.contains(url)){
						discoveredWebsites.add(url);
						queue.add(url);
						System.out.println("Crawled URL : "+url);
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public String readRawURLResponse(String urlStr){
		String rawURL ="";
		try {
			URL url = new URL(urlStr);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String temp=br.readLine();
			while(temp != null){
				rawURL +=temp;
				temp=br.readLine();
			}
			br.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rawURL;
	}



}