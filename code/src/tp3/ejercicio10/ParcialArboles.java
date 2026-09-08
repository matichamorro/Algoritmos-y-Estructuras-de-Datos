package tp3.ejercicio10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio5.GeneralTree;

public class ParcialArboles {

	private static int resolverRec(GeneralTree<Integer> arbol, int nivel, int actual, List<Integer> actCamino, List<Integer> maxCamino, int maximo) {
		
		if (arbol.getData() == 1) {
			actCamino.add(1);
			actual += nivel;
		}
		
		if (arbol.isLeaf()) {
			if (actual > maximo) {
				maximo = actual;
				maxCamino.clear();
				maxCamino.addAll(actCamino); 
			}
		} 
		else for (GeneralTree<Integer> child : arbol.getChildren()) 
				maximo = resolverRec(child, nivel + 1, actual, actCamino, maxCamino, maximo);
		
		if (arbol.getData() == 1) 
			actCamino.remove(actCamino.size() - 1);

		return maximo;
	}
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol) {
		List<Integer> mejorCamino = new LinkedList<>();
		
		if (arbol != null && !arbol.isEmpty()) {
			int maxGlobal = Integer.MIN_VALUE; 
			resolverRec(arbol, 0, 0, new LinkedList<>(), mejorCamino, maxGlobal);
		}
		
		return mejorCamino;
	}
	
		
	public static void main(String[] args) {
		List<GeneralTree<Integer>> childrenR = new ArrayList<GeneralTree<Integer>>();
		List<GeneralTree<Integer>> children1 = new ArrayList<GeneralTree<Integer>>();
		List<GeneralTree<Integer>> children2 = new ArrayList<GeneralTree<Integer>>();
		
		GeneralTree<Integer> r = new GeneralTree<Integer>(1,childrenR);
		GeneralTree<Integer> t1 = new GeneralTree<Integer>(0,children1);
		GeneralTree<Integer> t2 = new GeneralTree<Integer>(1,children2);
		GeneralTree<Integer> t3 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> t4 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> t7 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> t8 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> t12 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> t13 = new GeneralTree<Integer>(0);

		childrenR.add(t1);
		childrenR.add(t2);
		childrenR.add(t3);
		
		children1.add(t4);
		children1.add(new GeneralTree<Integer>(1));
		
		children2.add(new GeneralTree<Integer>(1));
		children2.add(t7);
		
		t3.addChild(t8);
		t4.addChild(new GeneralTree<Integer>(0));
		t4.addChild(new GeneralTree<Integer>(0));
		t4.addChild(new GeneralTree<Integer>(1));
		
		t7.addChild(t12);
		t8.addChild(t13);
		
		t12.addChild(new GeneralTree<Integer>(1));
		t13.addChild(new GeneralTree<Integer>(0));
		t13.addChild(new GeneralTree<Integer>(0));
		
		r.recorridoPorNiveles();
		System.out.println();
		System.out.println(ParcialArboles.resolver(r));

	}

}
