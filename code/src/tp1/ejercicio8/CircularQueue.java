package tp1.ejercicio8;

import java.util.ArrayList;

public class CircularQueue<T> extends Queue<T> {

	public CircularQueue() {
		super.data = new ArrayList<T>();
	}
	
	public T shift() {
		if (!data.isEmpty()) {
			T aux = data.remove(data.size() - 1);
			data.add(0, aux);
			return aux;
		}
		else return null;
	}
	
}
