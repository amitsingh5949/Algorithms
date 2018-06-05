package com.javadwarf.stackbasics.gfg;

public class MergeTwoStackO1 {

	public static void main(String[] args) {
		
		NodeStack ns1 = new NodeStack();
		ns1.push(3);
		ns1.push(32);
		ns1.push(13);
		ns1.push(38);
		ns1.pop();
		ns1.push(56);
		
		NodeStack ns2 = new NodeStack();
		ns1.push(4);
		ns1.push(66);
		ns1.push(32);
		ns1.push(12);
		ns1.pop();
		ns1.push(99);
		
		ns1.merge(ns2);
		ns1.print();

	}

}






class Node{
	
	public Integer data;
	public Node next;
	
	public Node(Integer data){
		this.data = data;
		this.next = null;
	}
}

class NodeStack{
	
	public Node top;
	public Node bottom;
	
	public NodeStack(){
		this.top = null;
		this.bottom = null;
	}
	
    public void push(Integer i){
    	Node n = new Node(i);
    	if(this.top == null && this.bottom == null){
    		this.top = n;
    		this.bottom = n;
    	}
    	else{
    		n.next = top;
    		top = n;
    	}
	}
    
    public Integer pop(){
    	
    	if(this.top == null && this.bottom == null){
    		return -1;
    	}
        if(top == bottom){
    		Node temp = top;
    		this.top = null;
    		this.bottom = null;
    		return temp.data;
    		
    	}
        else{
        	Node temp = top;
    		this.top = top.next;
    		return temp.data;
        }
	}
    
    public void  merge(NodeStack ns){
    	if(ns != null){
    		if(ns.bottom != null && this.top != null){
    			ns.bottom.next = this.top;
    			this.top = ns.top;
    		}
    		else if (ns.bottom != null && this.top == null){
    			this.top = ns.top;
    			this.bottom = ns.bottom;
    		}
    	}
    }
    
    public void print(){
    	Node temp = this.top;
    	while(temp != null){
    		System.out.print(temp.data + " ");
    		temp = temp.next;
    	}
    }
	
}