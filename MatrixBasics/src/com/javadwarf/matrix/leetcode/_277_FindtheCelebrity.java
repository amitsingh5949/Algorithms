package com.javadwarf.matrix.leetcode;

public class _277_FindtheCelebrity  extends Relation  {

	public int findCelebrity(int n) {
		
		/*
		 By default we assume our candidate for celebrity is 0
		 
		 we run a loop for all other n-1 people in party to verify if our candidate is celebrity or not
		 
		 if knows(candidate,i) == false that is if candidate doesn't know i, that mean i cannot be celebrity
		      because everyone must know celebrity. In this case our current candidate could be celebrity
		 
		 if knows(candidate, i) == true i.e. if current candidate knows i that means current candidate can't be celebrity
		     because  celebrity must not know anyone, so we make i as our new candidate
		*/
		int candidate  = 0;
		for(int i=1; i<n; i++) {
			if(knows(candidate, i)) {
				candidate = i;
			}
		}
		/*
		  now that we have found a possible candidate, we want to check if this candidate is indeed celebrity 
		     else there are no celebrities in party
		     
		  To check this we run a loop to check if candidate knows anyone or anyone doesn't know candidate
		     then our candidate is not celebrity, in this case return -1;
		 */
		
		for(int i=0; i<n; i++) {
			
			if(i!= candidate && (knows(candidate,i) || !knows(i, candidate))) {
				return -1;
			}
		}
		return candidate;
	}
}


class Relation {
	boolean knows(int a, int b) {
		return true;// dummy implementation
	}
}

