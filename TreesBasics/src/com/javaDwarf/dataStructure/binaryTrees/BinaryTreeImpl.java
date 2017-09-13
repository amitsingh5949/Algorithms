package com.javaDwarf.dataStructure.binaryTrees;
/*
 * can have utmost 2 children
 * there is only one path from root to any particular node
 * key value of right child is always greater or equal than parent
 * key value of left child is always less than parent
 */
public class BinaryTreeImpl {

	private Node root;

	public BinaryTreeImpl() {
		this.setRoot(null);
	}

	public void insert(Employee emp){
		Node newNode = new Node(emp);
		if(this.getRoot() == null){
			this.setRoot(newNode);
		}
		else{
			Node current = this.getRoot();
			while(current != null){
				if(current.getEmployee().getEmpId() < emp.getEmpId()){
					if(current.getRightChild() == null){
						current.setRightChild(newNode);
						current = null;
						break;
					}
					else{
						current= current.getRightChild();
					}
				}
				else if(current.getEmployee().getEmpId() >= emp.getEmpId()){
					if(current.getLeftChild() == null){
						current.setLeftChild(newNode);
						current = null;
						break;
					}
					else{
						current = current.getLeftChild();
					}
				}
			}
		}
	}


	public Node delete(int empId) throws BinaryTreeEmptyexception {
		if(!isBinaryTreeEmpty()){
			Node parent = this.getRoot();
			Node current = this.getRoot();
			while(current != null){
				if(current.getEmployee().getEmpId() == empId){

					//case 1 : when no node has no children
					if(current.getLeftChild() == null && current.getRightChild() == null){
						if(current == this.getRoot()){
							this.setRoot(null);
						}
						else{
							if(current.getEmployee().getEmpId() < parent.getEmployee().getEmpId()){
								parent.setLeftChild(null);
								break;
							}
							else{
								parent.setRightChild(null);
								break;
							}
						}
					}
					//Case 2 : when node has 1 child
					else if((current.getLeftChild() != null && current.getRightChild() == null) || (current.getLeftChild() == null && current.getRightChild() != null)){
						if(current == this.getRoot()){
							if(current.getLeftChild() !=null){
								this.setRoot(current.getLeftChild());
								break;
							}else{
								this.setRoot(current.getRightChild());
								break;
							}
						}
						else{
							if(current.getEmployee().getEmpId() < parent.getEmployee().getEmpId()){
								if(current.getLeftChild() !=null){
									parent.setLeftChild(current.getLeftChild());
									break;
								}else{
									parent.setLeftChild(current.getRightChild());
									break;
								}
							}
							else{
								if(current.getLeftChild() !=null){
									parent.setRightChild(current.getLeftChild());
									break;
								}else{
									parent.setRightChild(current.getRightChild());
									break;
								}
							}
						}
					}
					//case 3 : when node has 2 children
					else if(current.getLeftChild() != null && current.getRightChild() != null){
						Node successorNode = getSuccessor(current);
						if(current == this.getRoot()){
							if(successorNode == current.getRightChild()){
								successorNode.setLeftChild(current.getLeftChild());
								this.setRoot(successorNode);
								break;
							}
							else{
								successorNode.setLeftChild(current.getLeftChild());
								successorNode.setRightChild(current.getRightChild());
								this.setRoot(successorNode);
								break;
							}
						}
						else{
							if(current.getEmployee().getEmpId() < parent.getEmployee().getEmpId()){
								if(successorNode == current.getRightChild()){
									successorNode.setLeftChild(current.getLeftChild());
									parent.setLeftChild(successorNode);
									break;
								}
								else{
									successorNode.setLeftChild(current.getLeftChild());
									successorNode.setRightChild(current.getRightChild());
									parent.setLeftChild(successorNode);
									break;
								}
							}
							else{
								if(successorNode == current.getRightChild()){
									successorNode.setLeftChild(current.getLeftChild());
									parent.setRightChild(successorNode);
									break;
								}
								else{
									successorNode.setLeftChild(current.getLeftChild());
									successorNode.setRightChild(current.getRightChild());
									parent.setRightChild(successorNode);
									break;
								}
							}
						}
					}

				}
				else if(current.getEmployee().getEmpId() < empId){
					parent = current;
					current = current.getRightChild();
				}
				else if(current.getEmployee().getEmpId() > empId){
					parent = current;
					current = current.getLeftChild();
				}
			}
			return current;
		}
		else{
			throw new BinaryTreeEmptyexception("Binary Tree is empty");
		}

	}

	public Node getSuccessor(Node delNode){
		if(delNode.getRightChild().getLeftChild() == null){
			return delNode.getRightChild();
		}
		else{
			Node successorParent = delNode.getRightChild().getLeftChild();
			Node successor  = delNode.getRightChild().getLeftChild();
			while(successor != null){
				if(successor.getLeftChild() == null){
					successorParent.setLeftChild(successor.getRightChild());// taking care of successor subtree as successor is going to deleted from here and added to delNode
					break;
				}
				else{
					successorParent = successor;
					successor = successor.getLeftChild();
				}
			}
			return successor;
		}
	}

	public Node find(int empId) throws BinaryTreeEmptyexception {
		if(!isBinaryTreeEmpty()){
			Node current = this.getRoot();
			while(current != null){
				if(current.getEmployee().getEmpId() == empId){
					return current;
				}
				else if(current.getEmployee().getEmpId() < empId){
					current = current.getRightChild();
				}
				else if(current.getEmployee().getEmpId() > empId){
					current = current.getLeftChild();
				}
			}
			return current;
		}
		else{
			throw new BinaryTreeEmptyexception("Binary Tree is empty");
		}
	}

	public void inOrderTraversal(Node localRoot){

		if(localRoot != null){

			/* this syso could have been after inOrderTraversal(localRoot.getRightChild()); but we have written above right child traversal because
			 order of value of node is leftChild < parent <= rightChild, So we write syso above the right child traversal, we will be able to print
			 nodes in ascending order */

			inOrderTraversal(localRoot.getLeftChild());
			System.out.println("Current is : " + localRoot.displayNode());
			inOrderTraversal(localRoot.getRightChild());

			/*
			 * if we want to print in descending  order
			 * inOrderTraversal(localRoot.getRightChild());
			 * System.out.println("Current is : " + localRoot.displayNode());
			 * inOrderTraversal(localRoot.getLeftChild());
			 */

		}
	}
	/*
	 * It is used to generate prefix algebraic notations like *A+BC
	 */
	public void preOrderTraversal(Node localRoot){

		if(localRoot != null){
			System.out.println("Current is : " + localRoot.displayNode());
			inOrderTraversal(localRoot.getLeftChild());
			inOrderTraversal(localRoot.getRightChild());
		}
	}

	/*
	 * It is used to generate postfix algebraic notations like ABC+*
	 */
	public void postOrderTraversal(Node localRoot){

		if(localRoot != null){
			inOrderTraversal(localRoot.getLeftChild());
			inOrderTraversal(localRoot.getRightChild());
			System.out.println("Current is : " + localRoot.displayNode());
		}
	}

	public Employee minBinaryTree() throws BinaryTreeEmptyexception{
		if(!isBinaryTreeEmpty()){
			Node current = this.getRoot();
			while(current.getLeftChild() != null){
				current = current.getLeftChild();
			}
			return current.getEmployee();
		}
		else{
			throw new BinaryTreeEmptyexception("Binary Tree is empty");
		}
	}

	public Employee maxBinaryTree() throws BinaryTreeEmptyexception{
		if(!isBinaryTreeEmpty()){
			Node current = this.getRoot();
			while(current.getRightChild() != null){
				current = current.getRightChild();
			}
			return current.getEmployee();
		}
		else{
			throw new BinaryTreeEmptyexception("Binary Tree is empty");
		}
	}

	public boolean isBinaryTreeEmpty(){
		return (this.getRoot() == null);
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}









}

