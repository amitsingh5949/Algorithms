package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//Samuel.Butter@gs.com

public class ThreatDetector {

	public static void main(String[] args) {



		List<String> list = new ArrayList<>();
		list.add("xxxayyySPY");
		list.add("xxxxxxbzzzzzzIVV");
		list.add("xxAyyDJI");

		threatDetector(list);
		
		//palindromeSubStrs("xxxxxxbzzzzzz");



	}

	public static void threatDetector(List<String> textMessages) {

		if(textMessages == null || textMessages.size() == 0) return;

		for(String text : textMessages){
			
			String p = text.substring(0, text.length()-3).toLowerCase();
			String code = text.substring(text.length()-3);

			if(p.length() < 7) {
				System.out.println(code + " Ignore");
			}
			else {

				int start = 0;
				int end = p.length()-1;

				char startChar = p.charAt(0);
				char endChar = p.charAt(end);

				boolean isPallindrom = true;

				while(start<end) {

					if(p.charAt(start) == startChar && p.charAt(end) == endChar) {
						start++;
						end--;
					}
					else {
						isPallindrom = false;
						break;
					}
				}

				if(!isPallindrom) {
					System.out.println(code + " Ignore");
				}
				else {
					
					int x = p.length();
					
					Map<String, Integer> m = palindromeSubStrs(p);
					
					
					
					for (Map.Entry<String, Integer> ii:m.entrySet()) {
						if(ii.getKey().length() >= 3) {
							x += ii.getKey().length();
						}
					}
				         
					
					if(x<=10) {
						System.out.println(code + " Possible");
					}
					else if (x>=11 && p.length()<=40) {
						System.out.println(code + " Probable");
					}
					else if(x>=41 && p.length()<=150) {
						System.out.println(code + " Escalate");
					}
				}
			}


		}

	}
	
	public static Map<String, Integer> palindromeSubStrs(String s) 
    { 
        TreeMap<String , Integer> m = new TreeMap<>(); 
        int n = s.length(); 
       
        int[][] R = new int[2][n+1]; 
       
        s = "@" + s + "#"; 
       
        for (int j = 0; j <= 1; j++) 
        { 
            int rp = 0;   
            R[j][0] = 0; 
       
            int i = 1; 
            while (i <= n) 
            { 
                while (s.charAt(i - rp - 1) == s.charAt(i +  
                                                j + rp)) 
                    rp++;  
                R[j][i] = rp; 
                int k = 1; 
                while ((R[j][i - k] != rp - k) && (k < rp)) 
                { 
                    R[j][i + k] = Math.min(R[j][i - k],  
                                              rp - k); 
                    k++; 
                } 
                rp = Math.max(rp - k,0); 
                i += k; 
            } 
        } 
       
        s = s.substring(1, s.length()-1); 
       
        m.put(s.substring(0,1), 1); 
        for (int i = 1; i < n; i++) 
        { 
            for (int j = 0; j <= 1; j++) 
                for (int rp = R[j][i]; rp > 0; rp--) 
                   m.put(s.substring(i - rp - 1,  i - rp - 1 
                                       + 2 * rp + j), 1); 
            m.put(s.substring(i, i + 1), 1); 
        } 
       
        return m;
    } 
}
