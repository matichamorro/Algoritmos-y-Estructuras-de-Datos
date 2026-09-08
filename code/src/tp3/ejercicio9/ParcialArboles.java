package tp3.ejercicio9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tp3.ejercicio5.GeneralTree;

public class ParcialArboles {

	private static int devolverMin(List<GeneralTree<Integer>> l) {
		Iterator<GeneralTree<Integer>> children = l.iterator();
		int min = Integer.MAX_VALUE;
		while (children.hasNext()) {
			int act = children.next().getData();
			if (act < min) min = act;
		}
		return min;
	}
	
	public static boolean esDeSeleccionRec(GeneralTree<Integer> arbol) {
		boolean result = true;
		if (!arbol.isLeaf()) { 
			int minChild = devolverMin(arbol.getChildren());
	
	        if (minChild != arbol.getData()) result = false;
	        else 
	        	for (GeneralTree<Integer> child : arbol.getChildren()) 
		            if (!esDeSeleccionRec(child)) {
		                result = false;
		                break;
		            }
		}    
	    return result;
		
	}
	
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		if ((arbol != null) && (!arbol.isEmpty())) return esDeSeleccionRec(arbol);
		else return false;
	}
	
	public static void main(String[] args) {
		List<GeneralTree<Integer>> childrenR = new ArrayList<GeneralTree<Integer>>();
		List<GeneralTree<Integer>> children1 = new ArrayList<GeneralTree<Integer>>();
		List<GeneralTree<Integer>> children4 = new ArrayList<GeneralTree<Integer>>();
		List<GeneralTree<Integer>> children9 = new ArrayList<GeneralTree<Integer>>();
		
		GeneralTree<Integer> r = new GeneralTree<Integer>(12,childrenR);
		GeneralTree<Integer> t1 = new GeneralTree<Integer>(12,children1);
		GeneralTree<Integer> t2 = new GeneralTree<Integer>(25);
		GeneralTree<Integer> t3 = new GeneralTree<Integer>(35);
		GeneralTree<Integer> t4 = new GeneralTree<Integer>(12,children4);
		GeneralTree<Integer> t5 = new GeneralTree<Integer>(35);
		GeneralTree<Integer> t9 = new GeneralTree<Integer>(33,children9);

		childrenR.add(t1);
		childrenR.add(t2);
		
		children1.add(t3);
		children1.add(t4);
		
		t2.addChild(new GeneralTree<Integer>(25));
		t3.addChild(t5);
		
		children4.add(new GeneralTree<Integer>(14));
		children4.add(new GeneralTree<Integer>(12));
		children4.add(t9);
		
		t5.addChild(new GeneralTree<Integer>(35));

		children9.add(new GeneralTree<Integer>(35));
		children9.add(new GeneralTree<Integer>(83));
		children9.add(new GeneralTree<Integer>(90));
		children9.add(new GeneralTree<Integer>(33));
		
		r.recorridoPorNiveles();
		System.out.println();
		System.out.println(ParcialArboles.esDeSeleccion(r));
	}

}
