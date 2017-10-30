package problems.algorithms.implementaion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class DayOfProgrammer {

	static String solve(int year){
		String date ="";
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		/*Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR,year);
		c.set(Calendar.DAY_OF_YEAR,256);
		date = sdf.format(c.getTime());
		System.out.println(date);*/
		
		
		int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		if(year > 1918){
			if((year%4 == 0 && year%100 != 0) || (year%400 == 0)){
				daysInMonth[1] = 29;
			}
		}
		else if(year < 1918){
			if(year%4 == 0){
				daysInMonth[1] = 29;
			}
		}
		else{
			daysInMonth[1] = daysInMonth[1]-13;
		}

		int daysCount =0;
		int monthCount = 0 ;
		for(int i=0; i<daysInMonth.length;i++){
			
			if(daysCount < 256){
				if(256 - daysCount >=31){
				daysCount += daysInMonth[i];
				}
				else{
					daysCount = 256 - daysCount;
					monthCount = i+1;
					break;
				}
			}
        }
		String days = Integer.valueOf(daysCount).toString();
		String month = Integer.valueOf(monthCount).toString();
		month = (month.length()==1) ? ("0"+month) : month;
		
		return (days +"."+month+"."+year);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int year = in.nextInt();
		String result = solve(year);
		System.out.println(result);
	}

}
