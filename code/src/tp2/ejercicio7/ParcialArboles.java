package tp2.ejercicio7;

import tp2.ejercicio2.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	private BinaryTree<Integer> encontrarNum (BinaryTree<Integer> a, int num) {
		if (a.getData().equals(num)) 
			return a;
		BinaryTree<Integer> aux = null;
		if (a.hasLeftChild())
			aux = encontrarNum(a.getLeftChild(),num);
		if (aux == null && a.hasRightChild()) 
			aux = encontrarNum(a.getRightChild(),num);
		return aux;
		// si aux = null entonces num no existe
	}
	
	
	public int contarHijosUnicos (BinaryTree<Integer> a) {
		int total = 0;
		if (a.hasLeftChild() ^ a.hasRightChild())
			total = 1;
		if (a.hasLeftChild()) total += contarHijosUnicos(a.getLeftChild());
		if (a.hasRightChild()) total += contarHijosUnicos(a.getRightChild());
		
		return total;
	}
	
	
	public boolean isLeftTree(int num) {
		if (this.arbol != null && !this.arbol.isEmpty()) {
			BinaryTree<Integer> aux = encontrarNum(this.arbol, num);
			if (aux == null) return false;
			
			int totalL = -1, totalR = -1;
			if (aux.hasLeftChild()) totalL = contarHijosUnicos(aux.getLeftChild());
			System.out.println(totalL);
			if (aux.hasRightChild()) totalR = contarHijosUnicos(aux.getRightChild());
			System.out.println(totalR);
			return totalL > totalR;
		}
		return false;
	}

	
	public static void main(String[] args) {
		BinaryTree<Integer> r = new BinaryTree<Integer>(2);
		
		BinaryTree<Integer> t1 = new BinaryTree<Integer>(7);
		BinaryTree<Integer> t2 = new BinaryTree<Integer>(-5);
		
		BinaryTree<Integer> tt1 = new BinaryTree<Integer>(23);
		BinaryTree<Integer> tt2 = new BinaryTree<Integer>(6);
		BinaryTree<Integer> tt3 = new BinaryTree<Integer>(19);
		
		BinaryTree<Integer> ttt1 = new BinaryTree<Integer>(4);
		
		r.addLeftChild(t1);
		r.addRightChild(t2);
		t1.addLeftChild(tt1);
		t1.addRightChild(tt2);
		t2.addLeftChild(tt3);
		tt3.addRightChild(ttt1);
		
		tt1.addRightChild(new BinaryTree<Integer>(-3));
		tt2.addLeftChild(new BinaryTree<Integer>(55));
		tt2.addRightChild(new BinaryTree<Integer>(11));
		ttt1.addLeftChild(new BinaryTree<Integer>(18));
		
		r.entreNiveles(0, 4);
		System.out.println();
		
		ParcialArboles p = new ParcialArboles(r);
		System.out.println(p.isLeftTree(-3));
		
	}
}
