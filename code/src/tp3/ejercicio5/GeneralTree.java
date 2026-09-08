package tp3.ejercicio5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		Queue<GeneralTree<T>> q = new Queue<GeneralTree<T>>();
		GeneralTree<T> aux;
		int h = 0;
		q.enqueue(this);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i=0; i < size; i++) {
				aux = q.dequeue();
				if (aux.hasChildren())
					for (GeneralTree<T> child: aux.getChildren())
						q.enqueue(child);
			}
			h++;
		}
		return h - 1;
	}
	
	public int nivel(T dato){
		Queue<GeneralTree<T>> q = new Queue<GeneralTree<T>>();
		GeneralTree<T> aux;
		int h = 0; boolean data_found = false;
		q.enqueue(this);
		while (!q.isEmpty() && !data_found) {
			int i=0; 
			int size = q.size();
			while (i < size && !data_found){
				i++;
				aux = q.dequeue();
				if (aux.getData() == dato) data_found = true;
				else if (aux.hasChildren())
					for (GeneralTree<T> child: aux.getChildren())
						q.enqueue(child);
			}
			h++;
		}
		if (!data_found) h = 0;
		return h - 1;
	  }

	public int ancho(){
		Queue<GeneralTree<T>> q = new Queue<GeneralTree<T>>();
		GeneralTree<T> aux = new GeneralTree<T>();
		int max = Integer.MIN_VALUE;
		q.enqueue(this);
		while (!q.isEmpty()) {
			int size = q.size();
			if (size > max) max = size;
			for (int i=0; i < size; i++) {
				aux = q.dequeue();
				if (aux.hasChildren())
					for (GeneralTree<T> child: aux.getChildren())
						q.enqueue(child);
			}
		}
		return max;
	}
	
	public void recorridoPorNiveles() {
		Queue<GeneralTree<T>> q = new Queue<GeneralTree<T>>();
		GeneralTree<T> aux;
		q.enqueue(this);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i=0; i < size; i++) {
				aux = q.dequeue();
				System.out.print(aux.getData() + " ");
				if (aux.hasChildren())
					for (GeneralTree<T> child: aux.getChildren())
						q.enqueue(child);
			}
			System.out.println();
		}
	}
	
	private boolean esAncestroRec(GeneralTree<T> r, T a, T b, boolean encontro_n, boolean encontro_m) {
		return true;
	}
	
	public boolean esAncestro(T a, T b) {
		if (this.isEmpty()) return false;
		else if (this == a) return esAncestroRec(this,a,b,true,false);
		else return esAncestroRec(this,a,b,false,false);
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
		
		GeneralTree<Integer> r = new GeneralTree<Integer>(1,childrenR);
		
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
		
		children4.add(new GeneralTree<Integer>(3));
		children4.add(new GeneralTree<Integer>(2));
		children4.add(new GeneralTree<Integer>(56));
		children4.add(new GeneralTree<Integer>(101));
		
		System.out.println(r.altura());
		System.out.println(r.ancho());
		System.out.println(r.nivel(56));
		System.out.println();
		r.recorridoPorNiveles();
	}
}