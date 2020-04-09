class Solution{
  
  public static void main (String [] ar){
    int[] arr1 = {3, 2, 1};
     int[] arr2 = {1, 2};
     int[] arr3 = {2, 2, 3, 1};
     
    
    Solution s = new Solution();

   System.out.println(s.thridLargest(arr1));
    System.out.println(s.thridLargest(arr2));
    System.out.println(s.thridLargest(arr3));
  }
    
    public int thridLargest(int[] arr){
      
      if(arr == null){
        return -1;
      }
      
      if(arr.length == 1){
        return arr[0];
      }
      
      if(arr.length == 2){
        return Math.max(arr[0], arr[1]);
      }
      
      int max1 = Integer.MIN_VALUE;
      int max2 = Integer.MIN_VALUE;
      int max3 = Integer.MIN_VALUE;
      
      for(int i=0; i<arr.length; i++){
        
        int num = arr[i];
        
        if(num > max1){
          max3 = max2;
          max2 = max1;
          max1 = num;
        }
        else if(num < max1 && num > max2){
          max3 = max2;
          max2 = num;
        }
         else if(num < max1 && num < max2 && num > max3){
          max3 = num;
        }
      }
      return max3;
      
    }
    
  }