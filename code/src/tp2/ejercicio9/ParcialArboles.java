package tp2.ejercicio9;

import java.util.ArrayList;

import tp2.ejercicio2.BinaryTree;

public class ParcialArboles{

	private BinaryTree<ArrayList<Integer>> crearNuevoArbol(BinaryTree<Integer> arbol, int dataPadre, int total){
		BinaryTree<ArrayList<Integer>> aux = new BinaryTree<ArrayList<Integer>>();
		aux.setData(new ArrayList<Integer>());
		aux.getData().add(arbol.getData() + total);
		total += arbol.getData();
		aux.getData().add(dataPadre - arbol.getData());
		if (arbol.hasLeftChild())
			aux.addLeftChild(crearNuevoArbol(arbol.getLeftChild(),arbol.getData(),total));
		if (arbol.hasRightChild())
			aux.addRightChild(crearNuevoArbol(arbol.getRightChild(),arbol.getData(),total));
		return aux;
	}
	
	public BinaryTree<?> sumAndDif(BinaryTree<Integer> arbol){
		if (arbol == null)
			return null;
		if (arbol.isEmpty()) {
			BinaryTree<ArrayList<Integer>> aux = new BinaryTree<ArrayList<Integer>>();
			aux.setData(new ArrayList<Integer>());
			aux.getData().add(0);
			aux.getData().add(0);
			return aux;
		}
		return crearNuevoArbol(arbol,0,0);
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> r1 = new BinaryTree<Integer>(20);
		BinaryTree<Integer> r1t1 = new BinaryTree<Integer>(5);
		BinaryTree<Integer> r1t2 = new BinaryTree<Integer>(30);
		BinaryTree<Integer> r1tt1 = new BinaryTree<Integer>(-5);
		BinaryTree<Integer> r1tt2 = new BinaryTree<Integer>(10);
		BinaryTree<Integer> r1tt3 = new BinaryTree<Integer>(50);
		BinaryTree<Integer> r1tt4 = new BinaryTree<Integer>(-9);
		BinaryTree<Integer> r1ttt6 = new BinaryTree<Integer>(4);
		r1.addLeftChild(r1t1);
		r1.addRightChild(r1t2);
		r1t1.addLeftChild(r1tt1);
		r1t1.addRightChild(r1tt2);
		r1t2.addLeftChild(r1tt3);
		r1t2.addRightChild(r1tt4);
		r1tt3.addRightChild(r1ttt6);
		r1tt2.addLeftChild(new BinaryTree<Integer>(1));
		r1ttt6.addRightChild(new BinaryTree<Integer>(6));
		
		r1.entreNiveles(0, 4);
		
		ParcialArboles p = new ParcialArboles();
		p.sumAndDif(r1).entreNiveles(0, 4);;

	}

}
