package tp2.ejercicio5;

import tp1.ejercicio8.Queue;
import tp2.ejercicio2.BinaryTree;


public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> bt;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> bt) {
		this.bt = bt;
	}
	
	public int sumaElementosProfundidad(int p) {
		BinaryTree<Integer> aux;
		Queue<BinaryTree<Integer>> q = new Queue<BinaryTree<Integer>>();
		int prof = 0;
		int suma = 0;
		q.enqueue(bt);
		q.enqueue(null);
		while (!q.isEmpty()) {
			aux = q.dequeue();
			if (aux != null) {
				if (prof == p) 
					suma += aux.getData();
				if (aux.hasLeftChild())
					q.enqueue(aux.getLeftChild());
				if (aux.hasRightChild())
					q.enqueue(aux.getRightChild());
			} 
			else {
				prof++;
				if (prof > p)
					break;
				if (!q.isEmpty()) 
					q.enqueue(null);
			}
		}
		return suma;
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
		
		ProfundidadDeArbolBinario profR = new ProfundidadDeArbolBinario(r);
		System.out.println(profR.sumaElementosProfundidad(2));

	}

}
