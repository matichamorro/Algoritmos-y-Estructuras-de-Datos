package tp2.ejercicio2;

import tp1.ejercicio8.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public int contarHojas() {
		return this.contarHojasRecursivo(this);	
	}
		
	private int contarHojasRecursivo(BinaryTree<T> bt) {
		if (bt.isLeaf())
			return 1;
		else {
			int aux = 0;
			if (bt.hasLeftChild()) 
				aux += contarHojasRecursivo(bt.getLeftChild());
			if (bt.hasRightChild()) 
				aux += contarHojasRecursivo(bt.getRightChild());
			return aux;
		}
		
	}
		
    	 
    public BinaryTree<T> espejo(){
    	return espejoRecursivo(this);
    		
    }
    
    public BinaryTree<T> espejoRecursivo(BinaryTree<T> bt) {
    	if (this.hasLeftChild() && this.hasRightChild()) {
    		BinaryTree<T> aux = this.getLeftChild();
    		this.addLeftChild(espejoRecursivo(this.getRightChild()));
    		this.addRightChild(espejoRecursivo(aux));
    	}
    	else if (this.hasLeftChild()) {
    		this.addRightChild(espejoRecursivo(this.getLeftChild()));
    		this.removeLeftChild();
    	}
    	else if (this.hasRightChild()) {
    		this.addLeftChild(espejoRecursivo(this.getRightChild()));
    		this.removeRightChild();
    	}
    	return this;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		BinaryTree<T> aux = null;
		Queue<BinaryTree<T>> q = new Queue<BinaryTree<T>>();
		int nivel = 0;
		q.enqueue(this);
		q.enqueue(null);

		while (!q.isEmpty()) {
			aux = q.dequeue();
			if (aux != null) {
				if (aux.hasLeftChild()) 
					q.enqueue(aux.getLeftChild());
				
				if (aux.hasRightChild()) 
					q.enqueue(aux.getRightChild());
				
				if (n <= nivel && nivel <= m)
					System.out.print(aux + " ");
			}
			else {
				nivel++;
				System.out.println();
				if (!q.isEmpty()) 
					q.enqueue(null);
			}
		}
			
	}
    }
		

