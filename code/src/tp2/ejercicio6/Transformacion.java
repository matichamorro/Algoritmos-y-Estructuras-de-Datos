package tp2.ejercicio6;

import tp2.ejercicio2.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> bt;
	
	public Transformacion(BinaryTree<Integer> bt) {
		this.bt = bt;
	}
	
	public int reemplazar(BinaryTree<Integer> r){
		int aux = 0, total = 0;
		aux = r.getData();
		if (r.isLeaf()) {
			r.setData(0);
		}
		else {
			if (r.hasLeftChild())
				total += reemplazar(r.getLeftChild());
			if (r.hasRightChild())
				total += reemplazar(r.getRightChild());
			r.setData(total);
		}
		return aux;
	}
	
	public BinaryTree<Integer> suma() {
		reemplazar(bt);
		return bt;
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

		
		r.entreNiveles(0, 3);
		System.out.println();
		
		Transformacion transf = new Transformacion(r);
		System.out.println(transf.suma());
		System.out.println();
		
		r.entreNiveles(0, 3);
		System.out.println();
	}

}
