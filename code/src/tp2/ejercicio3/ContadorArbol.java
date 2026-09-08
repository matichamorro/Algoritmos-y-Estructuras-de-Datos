package tp2.ejercicio3;

import java.util.ArrayList;
import java.util.List;

import tp2.ejercicio2.BinaryTree;

public class ContadorArbol {
	private BinaryTree<Integer> arbol;
	
	public ContadorArbol() {
		
	}
	
	public ContadorArbol(BinaryTree<Integer> arbol) {
		this.setArbol(arbol);
	}
	
	public List<Integer> numerosParesInOrden() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		numerosParesInOrdenRecursivo(this.getArbol(), lista);
		return lista;
	}
	
	private void numerosParesInOrdenRecursivo(BinaryTree<Integer> arbol, ArrayList<Integer> lista) {
		if (arbol.isLeaf()) {
			lista.add(arbol.getData());
		}
		else {
			if (arbol.hasLeftChild())
				numerosParesInOrdenRecursivo(arbol.getLeftChild(), lista);
			lista.add(arbol.getData());
			if (arbol.hasRightChild())
				numerosParesInOrdenRecursivo(arbol.getRightChild(), lista);
		}
	}
	
	public List<Integer> numerosParesPostOrden() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		numerosParesPostOrdenRecursivo(this.getArbol(), lista);
		return lista;
	}
	
	private void numerosParesPostOrdenRecursivo(BinaryTree<Integer> arbol, ArrayList<Integer> lista) {
		if (arbol.isLeaf()) {
			lista.add(arbol.getData());
		}
		else {
			if (arbol.hasLeftChild())
				numerosParesPostOrdenRecursivo(arbol.getLeftChild(), lista);
			
			if (arbol.hasRightChild())
				numerosParesPostOrdenRecursivo(arbol.getRightChild(), lista);
			lista.add(arbol.getData());
		}
	}

	public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(8);
		BinaryTree<Integer> b1 = new BinaryTree<Integer>(7);
		BinaryTree<Integer> b2 = new BinaryTree<Integer>(12);
		BinaryTree<Integer> b3 = new BinaryTree<Integer>(14);
		BinaryTree<Integer> b4 = new BinaryTree<Integer>(9);
		BinaryTree<Integer> b5 = new BinaryTree<Integer>(4);
		
		bt.addLeftChild(b1);
		bt.addRightChild(b2);
		b1.addRightChild(b3);
		b2.addRightChild(b4);
		b1.addLeftChild(b5);
		
		ContadorArbol c = new ContadorArbol(bt);
		System.out.println(c.numerosParesInOrden());
		System.out.println(c.numerosParesPostOrden());
	}
	
}
