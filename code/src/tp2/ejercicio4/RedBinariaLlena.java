package tp2.ejercicio4;

import tp2.ejercicio2.BinaryTree;

public class RedBinariaLlena {

	public int max(BinaryTree<Integer> r) {
		if (r.hasLeftChild() && r.hasRightChild())
			return r.getData() + maximo(max(r.getLeftChild()), max(r.getRightChild()));
		else if (r.hasLeftChild()) 
			return r.getData() + max(r.getLeftChild());
		else if (r.hasRightChild()) 
			return r.getData() + max(r.getRightChild());
		else 
			return r.getData();
	}
	
	public int maximo(int total1, int total2) {
		return (total1 > total2) ? total1 : total2;
	}
	
	public int retardoReenvio(BinaryTree<Integer> bt) {
		return max(bt);
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> r = new BinaryTree<Integer>(10);
		
		BinaryTree<Integer> t1 = new BinaryTree<Integer>(2);
		BinaryTree<Integer> t2 = new BinaryTree<Integer>(3);
		
		BinaryTree<Integer> tt1 = new BinaryTree<Integer>(5);
		BinaryTree<Integer> tt2 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> tt3 = new BinaryTree<Integer>(9);
		BinaryTree<Integer> tt4 = new BinaryTree<Integer>(8);
		
		r.addLeftChild(t1);
		r.addRightChild(t2);
		t1.addLeftChild(tt1);
		t1.addRightChild(tt2);
		t2.addLeftChild(tt3);
		t2.addRightChild(tt4);
		
		tt1.addLeftChild(new BinaryTree<Integer>(7));
		tt1.addRightChild(new BinaryTree<Integer>(8));
		tt2.addLeftChild(new BinaryTree<Integer>(5));
		tt2.addRightChild(new BinaryTree<Integer>(6));
		tt3.addLeftChild(new BinaryTree<Integer>(12));
		tt3.addRightChild(new BinaryTree<Integer>(8));
		tt4.addLeftChild(new BinaryTree<Integer>(2));
		tt4.addRightChild(new BinaryTree<Integer>(1));
		
		r.entreNiveles(0, 3);
		System.out.println();
		
		RedBinariaLlena aux = new RedBinariaLlena();
		System.out.println(aux.retardoReenvio(r));
	}

}
