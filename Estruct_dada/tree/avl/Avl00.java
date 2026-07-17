public class Avl00{

	public int altura(Node no){
		if(no == null) return -1;
		else return 1 + Math.max(altura(no.right), altura(no.left));
	}

	public int balance(Node node){
		if(node != null){
			return altura(node.left) - altura(node.right);
		}

		return 0;
	}
}

class Node{
	int value;

	Node parent
	Node left;
	Node right;
	int value;

	public Node(int v){
		value = v;
	}
}