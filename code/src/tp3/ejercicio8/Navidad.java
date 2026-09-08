package tp3.ejercicio8;

import java.util.ArrayList;
import java.util.List;

import tp3.ejercicio5.GeneralTree;

public class Navidad {
	private GeneralTree<?> a;
	
	public Navidad(GeneralTree<?> a) {
		this.a = a;
	}
	
	public Navidad() {

	}
	
	public String esAbetoNavidenio() {
		if ((a != null) && (!a.isEmpty()) && (esAbetoNavidenioRec(a) >= 3)) return "Es abeto";
		return "No es abeto";
	}
	
	private int esAbetoNavidenioRec(GeneralTree<?> a) {
		return 0;
	}
	
	public static void main(String[] args) {
		List<GeneralTree<Integer>> childrenR = new ArrayList<GeneralTree<Integer>>();
		
		GeneralTree<Integer> r = new GeneralTree<Integer>(1,childrenR);
		GeneralTree<Integer> t1 = new GeneralTree<Integer>(2);
		GeneralTree<Integer> t2 = new GeneralTree<Integer>(3);
		GeneralTree<Integer> t3 = new GeneralTree<Integer>(4);
		GeneralTree<Integer> t4 = new GeneralTree<Integer>(5);
		
		childrenR.add(t1);
		childrenR.add(t2);
		childrenR.add(t3);
		childrenR.add(t4);

		t2.addChild(new GeneralTree<Integer>(6));
		t2.addChild(new GeneralTree<Integer>(7));

		r.recorridoPorNiveles();
		System.out.println();
		
		Navidad n = new Navidad(r);
		System.out.println(n.esAbetoNavidenio());
		
	}

}

