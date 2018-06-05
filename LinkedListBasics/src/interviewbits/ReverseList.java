package interviewbits;

public class ReverseList {

/*	public ListNode reverseList(ListNode a){
		ListNode temp = null;
		if(a!=null && a.next!=null){
			temp= reverse(a, a.next);
			a.next=null;
		}
		else{
		    temp=a;
		}
		return temp;
	}

	public  ListNode reverse(ListNode prev, ListNode nxt){

		if(nxt.next ==null){
			nxt.next = prev;
			return nxt;
		}
		else{
			ListNode temp = null;
			temp = reverse(nxt, nxt.next);
			nxt.next = prev;
			return temp;
		}
	}
	
	*/
	
	public ListNode reverseList(ListNode a){
		
		ListNode prev = null;
		ListNode current = a;
		
		ListNode temp = null;
		while(current!=null && current.next!=null){
			temp =prev;
			prev=current;
			current = current.next;
			prev.next=temp;
			temp =null;
		}
      return a;
	}

}
