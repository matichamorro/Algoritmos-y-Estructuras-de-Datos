package tp3.ejercicio4;

import java.util.ArrayList;
import java.util.List;
import tp1.ejercicio8.Queue;
import tp3.ejercicio3.GeneralTree;

public class AnalizadorArbol {
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol) {
		double maxProm = -1;
		if (arbol != null && !arbol.isEmpty()) {
			Queue<GeneralTree<AreaEmpresa>> q = new Queue<GeneralTree<AreaEmpresa>>();
			GeneralTree<AreaEmpresa> aux;
			q.enqueue(arbol);
			while (!q.isEmpty()) {
				double actProm = 0;
				int size = q.size();
				for (int i=0; i < size; i++) {
					aux = q.dequeue();
					actProm += aux.getData().getTime();
					if (aux.hasChildren()) 
						for (GeneralTree<AreaEmpresa> child: aux.getChildren())
							q.enqueue(child);
				}
				actProm = actProm / size;
				if (actProm > maxProm) maxProm = actProm;
			}
		}
		return maxProm;
	}

	public static void main(String[] args) {
		List<GeneralTree<AreaEmpresa>> childrenR = new ArrayList<GeneralTree<AreaEmpresa>>();
		
		List<GeneralTree<AreaEmpresa>> children1 = new ArrayList<GeneralTree<AreaEmpresa>>();
		List<GeneralTree<AreaEmpresa>> children2 = new ArrayList<GeneralTree<AreaEmpresa>>();
		List<GeneralTree<AreaEmpresa>> children3 = new ArrayList<GeneralTree<AreaEmpresa>>();
		
		GeneralTree<AreaEmpresa> r = new GeneralTree<AreaEmpresa>(new AreaEmpresa("M",14),childrenR);
		GeneralTree<AreaEmpresa> t1 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("J",13),children1);
		GeneralTree<AreaEmpresa> t2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("K",25),children2);
		GeneralTree<AreaEmpresa> t3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("L",10),children3);
		childrenR.add(t1);
		childrenR.add(t2);
		childrenR.add(t3);
		
		children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("A",4)));
		children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("B",7)));
		children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("C",5)));
		
		children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("D",6)));
		children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("E",10)));
		children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("F",18)));
		
		children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("G",9)));
		children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("H",12)));
		children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("I",19)));
		
		r.recorridoPorNiveles();
		
		AnalizadorArbol a = new AnalizadorArbol();
		System.out.println(a.devolverMaximoPromedio(r));
	}

}
