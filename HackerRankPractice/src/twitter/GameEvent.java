package twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameEvent {

	public static void main(String[] args) {

		List<String> event1 = new ArrayList<>();
		event1.add("Mo Sa 45+2 Y");
		event1.add("A 13 G F");
		event1.add("A 90+1 G");
		event1.add("X 0 G");
		event1.add("gh hh 90 S");

		List<String> event2 = new ArrayList<>();
		event2.add("A 13 G X");
		event2.add("Z 46 G");
		event2.add("D 23 S F");
		event2.add("D 90 Y");
		event2.add("D 90+1 S F");
		event2.add("x 45 S y");

		List<String> result = getEventsOrder("AB CD EF", "XY z", event1, event2);
		System.out.println(result);

	}

	public static List<String> getEventsOrder(String team1, String team2, List<String> event1, List<String> event2){
		List<String> eventsTeam = new ArrayList<>();
		for(String temp : event1) {
			eventsTeam.add(team1+" "+temp);
		}
		for(String temp : event2) {
			eventsTeam.add(team2+" "+temp);
		}
		Collections.sort(eventsTeam, new GameComparator());
		return eventsTeam;
	}

}

/*class GameComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {

		String[] arr1 = s1.split(" ");
		String[] arr2 = s2.split(" ");

		String currTime1 = getTime(arr1);
		String currTime2 = getTime(arr2);

		if(!currTime1.contains("+") && !currTime2.contains("+")) {
			int x =  currTime1.compareTo(currTime2);
			if(x == 0) {
				String event1 = getEventName(arr1);
				String event2 = getEventName(arr2);
				int y = compareEvents(event1, event2);
				if(y == 0) {
					String playerTeam1 = getTeamAndPlayerName(arr1);
					String playerTeam2 = getTeamAndPlayerName(arr2);
					return playerTeam1.compareTo(playerTeam2);
				}
				return y;
			}
			return x;
		}
		else if(currTime1.contains("+") && !currTime2.contains("+")){
			String[] time =  {currTime1.substring(0,2),currTime1.substring(3)};
			int[] timeInt = {Integer.parseInt(time[0]), Integer.parseInt(time[1])};
			int time2 = Integer.parseInt(currTime2);
			
			if(timeInt[0] != time2) {
				return Integer.compare(timeInt[0], time2);
			}
			else {
				return  Integer.compare(timeInt[0]+timeInt[1], time2);
			}
		}
		else if(!currTime1.contains("+") && currTime2.contains("+")){
			int time1 = Integer.parseInt(currTime1);
			String[] time =  {currTime2.substring(0,2),currTime2.substring(3)};
			int[] timeInt = {Integer.parseInt(time[0]), Integer.parseInt(time[1])};			
			if(timeInt[0] != time1) {
				return Integer.compare(time1, timeInt[0]);
			}
			else {
				return Integer.compare(time1, timeInt[0]+timeInt[1]);
			}
		}
		else {
			String[] time1 =   {currTime1.substring(0,2),currTime1.substring(3)};
			int[] timeInt1 = {Integer.parseInt(time1[0]), Integer.parseInt(time1[1])};
			String[] time2 =  {currTime2.substring(0,2),currTime2.substring(3)};
			int[] timeInt2 = {Integer.parseInt(time2[0]), Integer.parseInt(time2[1])};
			if(timeInt1[0] != timeInt2[0]) {
				return Integer.compare(timeInt1[0], timeInt2[0]);
			}
			else {
				int x =  Integer.compare(timeInt1[0]+timeInt1[1], timeInt2[0]+timeInt2[1]);
				if(x == 0) {
					String event1 = getEventName(arr1);
					String event2 = getEventName(arr2);
					int y = compareEvents(event1, event2);
					if(y == 0) {
						String playerTeam1 = getTeamAndPlayerName(arr1);
						String playerTeam2 = getTeamAndPlayerName(arr2);
						return playerTeam1.compareTo(playerTeam2);
					}
					return y;
				}
				return x;
			}
		}
	}

	public String getTime(String[] arr) {
		for(String str : arr) {
			boolean isTime = true;
			for(char ch : str.toCharArray()) {
				if(!Character.isDigit(ch) && ch != '+') {
					isTime = false;
					break;
				}
			}
			if(isTime) {
				return str;
			}
		}
		return "";
	}
	
	public String getEventName(String[] arr) {
		for(int i =0; i< arr.length; i++) {
			String str = arr[i];
			boolean isTime = true;
			for(char ch : str.toCharArray()) {
				if(!Character.isDigit(ch) && ch != '+') {
					isTime = false;
					break;
				}
			}
			if(isTime) {
				return arr[i+1];
			}
		}
		return "";
	}
	
	public String getTeamAndPlayerName(String[] arr) {
		String name = "";
		int i =0 ;
		for( i =0; i< arr.length; i++) {
			String str = arr[i];
			
			boolean isTime = true;
			for(char ch : str.toCharArray()) {
				if(!Character.isDigit(ch) && ch != '+') {
					isTime = false;
					break;
				}
			}
			if(isTime) {
				break;
			}
			name +=str;
		}
		for(int x = i+2 ; x<arr.length; x++) {
			name += arr[x];
		}
		return name;
	}
	
	public int compareEvents(String event1, String event2) {
		Map<String, Integer> map = new HashMap<>();
		map.put("G",0);
		map.put("Y",1);
		map.put("R",2);
		map.put("S",3);
		return Integer.compare(map.get(event1), map.get(event2));
	}

}*/
