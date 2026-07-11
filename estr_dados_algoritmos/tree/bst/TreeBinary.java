public class TreeBinary{
	private No root;
	
	public boolean isEmpty(){
		return this.root == null;
	}
	
	public void add(int v){
		
		No novoNo = new No(v);
		
		if(isEmpty()) this.root = novoNo;
		else{
			No aux = this.root;
			while(aux != null){
				if(v < aux.value){
					if(aux.left == null){
						aux.left = novoNo;
						novoNo.parent = aux;
						return;
					}
					aux = aux.left;
				}else{
					if(aux.right == null){
						aux.right = novoNo;
						novoNo.parent = aux;
						return;
					}
					aux = aux.right;
				}
			}
		}
	}
	
	public void addRecursive(int v){
		if(isEmpty()) this.root = new No(v);
		else addRecursive(this.root, v);
	}
	
	private void addRecursive(No current,  int v){
		if(v < current.value){
			if(current.left == null){
				No novoNo = new No(v);
				current.left = novoNo;
				novoNo.parent = current;
				return;
			} else addRecursive(current.left, v);
		}else{
			if(current.right == null){
				No novoNo = new No(v);
				current.right = novoNo;
				novoNo.parent = current;
				return;
			}else addRecursive(current.right, v);
		}
	}
		
		public No min(){
			if(isEmpty()) return null;
			else return min(this.root);
		}
		
		private No min(No current){
			if(current.left == null){
				return current;
			}else return min(current.left);
		}
		
		public No max(){
			if(isEmpty()) return null;
			else return max(this.root);
		}
		
		private No max(No current){
			if(current.right == null){
				return current;
			}else return max(current.right);
		}
		
		public No search(int v){
			if(isEmpty()) return null;
			else return search(this.root, v);
		}
		
		private No search(No current, int v){
			if(v == current.value){
				return current;
			}else if(v < current.value){
				if(current.left == null) return null;
				return search(current.left, v);
			}else{
				if(current.right == null) return null;
				return search(current.right, v);
			}
		}
		
		public No sucessor(int v){
			if(isEmpty()) return null;
			
			No no = search(v);
			
			if(no == null) return null;
			
			if(no.right != null) return min(no.right);
			
			No aux = no.parent;
			
			while(aux != null && aux.parent.value < no.value) 
				aux = aux.parent;
				
			return aux;
			
			
		}
	}
	

class No{
	int value;
	No left;
	No right;
	No parent;
	
	public No(int value){
		this.value =  value;
		}
}
