package tp1.ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> extends Sequence {
	protected List<T> data;
	
	public Queue() {
		data = new ArrayList<T>();
	}
	
	public int size() {
		return data.size();
	}
	
	public boolean isEmpty() {
		return data.size() == 0;
	}
	
	public void enqueue(T dato) {
		data.add(data.size(), dato);
	}
	
	public T dequeue() {
		return data.remove(0);
	}
	
	public T head() {
		return data.get(0);
	}
	
	public String toString(){
		String aux = "[";
		if (!this.isEmpty()) {
		for (int i=0; i < this.size() - 1; i++) {
			aux += data.get(i).toString() + ", ";
		}
		aux += data.get(data.size() - 1).toString();
		}
		aux += "]";
		return aux;
	}
}
