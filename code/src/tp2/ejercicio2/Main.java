package tp2.ejercicio2;

public class Main {

	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(8);
		System.out.println(bt.contarHojas());
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
		System.out.println(bt.contarHojas());
		
		System.out.println();
		bt.entreNiveles(0, 1);
		
		System.out.println();
		bt.espejo().entreNiveles(0, 2);
		
	}

}
