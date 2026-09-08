package tp2.ejercicio8;

import tp2.ejercicio2.BinaryTree;

public class ParcialArboles {
	
	private boolean recorrerArbol(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean aux = true;
		if (arbol1.hasLeftChild())
			if (arbol2.hasLeftChild())
				aux = recorrerArbol(arbol1.getLeftChild(),arbol2.getLeftChild());
			else 
				return false;
		if (aux && !arbol1.getData().equals(arbol2.getData()))
			aux = false;
		if (aux && arbol1.hasRightChild())
			if (arbol2.hasRightChild())
				aux = recorrerArbol(arbol1.getRightChild(),arbol2.getRightChild());
			else 
				return false;
		return aux;
	}
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if (arbol1 == null || arbol2 == null)
			return false;
		if (!arbol1.isEmpty() && arbol2.isEmpty())
			return false;
		else if (arbol1.isEmpty())
			return true;
		return recorrerArbol(arbol1,arbol2);
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> r1 = new BinaryTree<Integer>(65);
		BinaryTree<Integer> r1t1 = new BinaryTree<Integer>(37);
		BinaryTree<Integer> r1t2 = new BinaryTree<Integer>(81);
		BinaryTree<Integer> r1tt2 = new BinaryTree<Integer>(47);
		BinaryTree<Integer> r1tt4 = new BinaryTree<Integer>(93);
		
		r1.addLeftChild(r1t1);
		r1.addRightChild(r1t2);
		r1t1.addRightChild(r1tt2);
		r1t2.addRightChild(r1tt4);
		
		BinaryTree<Integer> r2 = new BinaryTree<Integer>(65);
		BinaryTree<Integer> r2t1 = new BinaryTree<Integer>(37);
		BinaryTree<Integer> r2t2 = new BinaryTree<Integer>(81);
		BinaryTree<Integer> r2tt1 = new BinaryTree<Integer>(22);
		BinaryTree<Integer> r2tt2 = new BinaryTree<Integer>(47);
		BinaryTree<Integer> r2tt3 = new BinaryTree<Integer>(76);
		BinaryTree<Integer> r2tt4 = new BinaryTree<Integer>(93);
		
		r2.addLeftChild(r2t1);
		r2.addRightChild(r2t2);
		r2t1.addLeftChild(r2tt1);
		r2t1.addRightChild(r2tt2);
		r2t1.addLeftChild(r2tt3);
		r2t2.addRightChild(r2tt4);
		
		r2tt1.addRightChild(new BinaryTree<Integer>(11));
		r2tt1.addLeftChild(new BinaryTree<Integer>(29));
		r2tt4.addRightChild(new BinaryTree<Integer>(85));
		r2tt4.addLeftChild(new BinaryTree<Integer>(94));
		
		BinaryTree<Integer> r3 = new BinaryTree<Integer>();
		
		ParcialArboles p = new ParcialArboles();
		System.out.println(p.esPrefijo(r3, r3));
		
	}
}
