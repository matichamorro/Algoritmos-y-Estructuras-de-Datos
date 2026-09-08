package tp3.ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import tp1.ejercicio8.Queue;
import tp3.ejercicio3.GeneralTree;

public class RecorridosAG {

	private List<Integer> numerosImparesMayoresQuePreOrdenRec(GeneralTree<Integer> a, Integer n, List<Integer> result){
		if (a.getData() % 2 != 0 && a.getData() > n)
			result.add(a.getData());
		
		if (a.hasChildren())
			for (GeneralTree<Integer> child: a.getChildren())
				numerosImparesMayoresQuePreOrdenRec(child,n,result);
		
		return result;
		
	}
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> result = new ArrayList<Integer>();
		if (a != null && !a.isEmpty()) numerosImparesMayoresQuePreOrdenRec(a,n,result);
		return result;
	}
	
	private List<Integer> numerosImparesMayoresQueInOrdenRec(GeneralTree<Integer> a, Integer n, List<Integer> result){
		if (a.hasChildren()) {
	        List<GeneralTree<Integer>> children = a.getChildren();
	        Iterator<GeneralTree<Integer>> it = children.iterator();
	        if (it.hasNext()) 
	            numerosImparesMayoresQueInOrdenRec(it.next(), n, result); 
	        if (a.getData() % 2 != 0 && a.getData() > n)
	            result.add(a.getData());
	        while (it.hasNext()) 
	            numerosImparesMayoresQueInOrdenRec(it.next(), n, result);
	    } 
		else if (a.getData() % 2 != 0 && a.getData() > n) 
			result.add(a.getData());
		
		return result;
	}

	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree <Integer> a, Integer n){
		List<Integer> result = new ArrayList<Integer>();
		if (a != null && !a.isEmpty()) numerosImparesMayoresQueInOrdenRec(a,n,result);
		return result;
	}
	
	private List<Integer> numerosImparesMayoresQuePostOrdenRec(GeneralTree<Integer> a, Integer n, List<Integer> result){
		if (a.hasChildren())
			for (GeneralTree<Integer> child: a.getChildren())
				numerosImparesMayoresQuePostOrdenRec(child,n,result);
		
	    if (a.getData() % 2 != 0 && a.getData() > n)
	        result.add(a.getData());
		
		return result;
	}
	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree <Integer> a, Integer n){
		List<Integer> result = new ArrayList<Integer>();
		if (a != null && !a.isEmpty()) numerosImparesMayoresQuePostOrdenRec(a,n,result);
		return result;
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){
		List<Integer> result = new ArrayList<Integer>();
		if (a != null && !a.isEmpty()) {
			Queue<GeneralTree<Integer>> q = new Queue<GeneralTree<Integer>>();
			GeneralTree<Integer> aux;
			q.enqueue(a);
			while (!q.isEmpty()) {
				for (int i=0; i < q.size(); i++) {
					aux = q.dequeue();
					if (aux.getData() % 2 != 0 && aux.getData() > n)
				        result.add(aux.getData());
					if (aux.hasChildren())
						for (GeneralTree<Integer> child: aux.getChildren())
							q.enqueue(child);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<GeneralTree<Integer>> childrenR = new ArrayList<GeneralTree<Integer>>();
		
		List<GeneralTree<Integer>> children1 = new ArrayList<GeneralTree<Integer>>();
		List<GeneralTree<Integer>> children2 = new ArrayList<GeneralTree<Integer>>();
		List<GeneralTree<Integer>> children3 = new ArrayList<GeneralTree<Integer>>();
		List<GeneralTree<Integer>> children4 = new ArrayList<GeneralTree<Integer>>();
		
		GeneralTree<Integer> t1 = new GeneralTree<Integer>(11,children1);
		GeneralTree<Integer> t2 = new GeneralTree<Integer>(21,children2);
		GeneralTree<Integer> t3 = new GeneralTree<Integer>(31,children3);
		GeneralTree<Integer> t4 = new GeneralTree<Integer>(41,children4);
		
		GeneralTree<Integer> r = new GeneralTree<Integer>(111,childrenR);
		
		childrenR.add(t1);
		childrenR.add(t2);
		childrenR.add(t3);
		childrenR.add(t4);
		
		children1.add(new GeneralTree<Integer>(5));
		children1.add(new GeneralTree<Integer>(9));
		children1.add(new GeneralTree<Integer>(7));
		children1.add(new GeneralTree<Integer>(3));
		
		children2.add(new GeneralTree<Integer>(61));
		children2.add(new GeneralTree<Integer>(80));
		children2.add(new GeneralTree<Integer>(35));

		children3.add(new GeneralTree<Integer>(77));
		children3.add(new GeneralTree<Integer>(21));
		
		children4.add(new GeneralTree<Integer>(1));
		children4.add(new GeneralTree<Integer>(2));
		children4.add(new GeneralTree<Integer>(56));
		children4.add(new GeneralTree<Integer>(101));
		
		RecorridosAG reco = new RecorridosAG();
		System.out.println(reco.numerosImparesMayoresQuePreOrden(r, 3));
		System.out.println(reco.numerosImparesMayoresQueInOrden(r, 3));
		System.out.println(reco.numerosImparesMayoresQuePostOrden(r, 3));
		System.out.println(reco.numerosImparesMayoresQuePorNiveles(r, 3));

	}

}
