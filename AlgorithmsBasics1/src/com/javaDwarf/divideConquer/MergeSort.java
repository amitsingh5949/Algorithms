package com.javaDwarf.divideConquer;

public class MergeSort {

	public static void main(String[] args) {
		
		int [] inputArr;
		
		if(args.length > 0){
			inputArr = new int[args.length];
			
			System.out.print("Input Array of Integers before sorting : ");
			
			try{
			for(int count = 0 ; count < args.length ; count++){
				inputArr[count] = Integer.parseInt(args[count]);
				System.out.print(inputArr[count] +"  ");
			}
			
			inputArr =  mergeSort(inputArr);
			
			System.out.print("\nInput Array of Integers after sorting : ");
			for(int count = 0 ; count < inputArr.length ; count++){
				System.out.print(inputArr[count] +"  ");
			}
			
			}
			catch(NumberFormatException ex){
				System.out.println("Please enter only integers");
			}
			catch(Exception ex){
				System.out.println("Exception caught : " + ex.getMessage());
			}
		}
		else{
			System.out.println("Please enter input integers to sort");
		}

	}

	private static int[] mergeSort(int[] inputArr) {
		return inputArr;
	}
	
	private static int[] merge(int []a, int []b){
		
		int []out;
		int i = 0;
		int j = 0;
		
		if(a.length > 0 && b.length > 0){
			out  = new int[a.length + b.length];
			
			for(int k=0 ; k<out.length ; k++){
				
				if(a[i] <= b[j]){
					out[k] = a[i];
					i++;
				}
				else if ( b[j] < a[i]){
					out[k] = b[j];
					j++;
				}
			}
			return out;
		}
		else{
			return null;
		}
		
	}

}
/*
 Hi,
 Thank you for showing interest in my profile. Please find my resume attached.
 Do let me know for any questions.
 
Total exp:-- 3.10 years
Relevant Total exp : 3.10 yrs
 CTC:- 13 lpa
Expected CTC -As per company standards
Notice period- 30 days
Reason for Job Change - Looking for new job opportunities
Present Location:bangalore
DOB: 13-04-1991
Education: Btech CSE
 
 Thank you
 Amit Singh
 9008173781
 */
