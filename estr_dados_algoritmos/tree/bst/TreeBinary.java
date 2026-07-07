public class TreeBinary{
	private Node root;
	
	public isEmpty(){
		return this.root == null;
	}
	
	public void add(int v){
		
		Node novoNo = new Node(v);
		
		if(isEmpty()) this.root = novoNo;
		else{
			Node aux = this.root;
			while(aux != null){
				if(v < aux.value){
					if(aux.left == null){
						aux.left = novoNo;
						return;
					}
					aux = aux.left;
				}else{
					if(aux.right == null){
						aux.right = novoNo;
						return;
					}
					aux = aux.right;
				}
			}
		}
	}
	
	
}

class Node{
	int value;
	Node left;
	Node right;
	Node parent;
	
	public Node(int value){
		this.value =  value;
		}
}
