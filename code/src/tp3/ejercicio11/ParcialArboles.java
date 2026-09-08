package tp3.ejercicio11;

import java.util.ArrayList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp3.ejercicio5.GeneralTree;

public class ParcialArboles {

	public static boolean resolver(GeneralTree<Integer> arbol) {
		if ((arbol == null) || (arbol.isEmpty())) return false;
		else {
			boolean result = true;
			Queue<GeneralTree<Integer>> q = new Queue<GeneralTree<Integer>>();
			GeneralTree<Integer> aux;
			
			q.enqueue(arbol);
			while ((!q.isEmpty()) && (result)) {
				int size = q.size();
				for (int i=0; i < size; i++) {
					aux = q.dequeue();
					if (aux.hasChildren())
						for (GeneralTree<Integer> child: aux.getChildren())
							q.enqueue(child);
				}
				//EL ARBOL TIENE QUE SER CRECIENTE, ES DECIR, LA CANTIDAD DE NODOS DE UN NIVEL DEBE SER MAYOR EN 1 A LA ANTERIOR
				if ((!q.isEmpty()) && (q.size() != size + 1))
					result = false;
			}
			return result;
		}
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
		System.out.println(ParcialArboles.resolver(r));
	}

}
