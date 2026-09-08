package tp3.ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio5.GeneralTree;

public class Caminos {
	private GeneralTree<Integer> a;
	
	public Caminos() {
		
	}
	
	public Caminos(GeneralTree<Integer> a) {
		this.a = a;
	}
	
	private void caminoAHojaMasLejanaRec(GeneralTree<Integer> a, List<Integer> act, List<Integer> max) {
		act.add(a.getData());
		if ((a.isLeaf()) && (act.size() > max.size())) {
			max.clear();
			max.addAll(act);
		}
		else if (!a.isLeaf()) {
			for (GeneralTree<Integer> child: a.getChildren())
				caminoAHojaMasLejanaRec(child,act,max);
		}
		act.remove(act.size()-1);
			
	}
	
	public List<Integer> caminoAHojaMasLejana() {
		List<Integer> list = new LinkedList<Integer>();
		if ((a != null) && (!a.isEmpty())) 
			caminoAHojaMasLejanaRec(a, new LinkedList<Integer>(), list);
		return list;
	}
	
	public static void main(String[] args) {
		List<GeneralTree<Integer>> childrenR = new ArrayList<GeneralTree<Integer>>();
		
		List<GeneralTree<Integer>> children1 = new ArrayList<GeneralTree<Integer>>();
		List<GeneralTree<Integer>> children2 = new ArrayList<GeneralTree<Integer>>();
		List<GeneralTree<Integer>> children3 = new ArrayList<GeneralTree<Integer>>();
		
		GeneralTree<Integer> r = new GeneralTree<Integer>(12,childrenR);
		GeneralTree<Integer> t1 = new GeneralTree<Integer>(17,children1);
		GeneralTree<Integer> t2 = new GeneralTree<Integer>(9,children2);
		GeneralTree<Integer> t3 = new GeneralTree<Integer>(15,children3);
		GeneralTree<Integer> t4 = new GeneralTree<Integer>(6);
		GeneralTree<Integer> t5 = new GeneralTree<Integer>(14);
		
		childrenR.add(t1);
		childrenR.add(t2);
		childrenR.add(t3);
		children1.add(new GeneralTree<Integer>(10));
		children1.add(t4);
		children2.add(new GeneralTree<Integer>(8));
		children3.add(t5);
		children3.add(new GeneralTree<Integer>(18));
		
		t4.addChild(new GeneralTree<Integer>(1));
		t5.addChild(new GeneralTree<Integer>(16));
		t5.addChild(new GeneralTree<Integer>(7));

		r.recorridoPorNiveles();
		System.out.println();
		
		Caminos c = new Caminos(r);
		System.out.println(c.caminoAHojaMasLejana());
		
	}


	
}
