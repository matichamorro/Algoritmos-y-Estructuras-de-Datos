package tp3.ejercicio6;

import java.util.ArrayList;
import java.util.List;

import tp3.ejercicio5.GeneralTree;

public class RedDeAguaPotable {
	private GeneralTree<Character> red;
	
	public RedDeAguaPotable() {
		
	}
	
	public RedDeAguaPotable(GeneralTree<Character> red) {
		this.red = red;
	}
	
	public GeneralTree<Character> getRed() {
		return red;
	}

	public void setRed(GeneralTree<Character> red) {
		this.red = red;
	}

	private double minimoCaudalRec(GeneralTree<Character> t, double caudal, double min) {
		if (t.isLeaf() && (caudal < min)) min = caudal;
		else if (!t.isLeaf()) {
			double size = t.getChildren().size();
			for (GeneralTree<Character> child: t.getChildren())
				min = minimoCaudalRec(child, caudal / size, min);
		}
		return min;
	}
	
	public double minimoCaudal(double caudal) {
		if ((this.getRed() != null) && !this.getRed().isEmpty())
			return minimoCaudalRec(red,caudal,Integer.MAX_VALUE);
		else return caudal;
	}
	
	public static void main(String[] args) {
		List<GeneralTree<Character>> childrenR = new ArrayList<GeneralTree<Character>>();
	
		List<GeneralTree<Character>> children2 = new ArrayList<GeneralTree<Character>>();
		List<GeneralTree<Character>> children3 = new ArrayList<GeneralTree<Character>>();
		
		GeneralTree<Character> a = new GeneralTree<Character>('A',childrenR);
		GeneralTree<Character> b = new GeneralTree<Character>('B');
		GeneralTree<Character> c = new GeneralTree<Character>('C',children2);
		GeneralTree<Character> d = new GeneralTree<Character>('D',children3);
		GeneralTree<Character> e = new GeneralTree<Character>('E');
		GeneralTree<Character> g = new GeneralTree<Character>('G');
		GeneralTree<Character> j = new GeneralTree<Character>('J');
		
		childrenR.add(b);
		childrenR.add(c);
		childrenR.add(d);
		childrenR.add(e);
		
		children2.add(new GeneralTree<Character>('F'));
		children2.add(g);

		children3.add(new GeneralTree<Character>('H'));
		children3.add(new GeneralTree<Character>('I'));
		children3.add(j);
		children3.add(new GeneralTree<Character>('K'));
		children3.add(new GeneralTree<Character>('P'));
		
		g.addChild(new GeneralTree<Character>('L'));
		j.addChild(new GeneralTree<Character>('M'));
		j.addChild(new GeneralTree<Character>('N'));
		
		RedDeAguaPotable r = new RedDeAguaPotable(a);
		System.out.println(r.minimoCaudal(1000));
	}

}
