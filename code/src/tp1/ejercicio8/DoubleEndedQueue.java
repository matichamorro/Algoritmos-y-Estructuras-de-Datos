package tp1.ejercicio8;

import java.util.ArrayList;

public class DoubleEndedQueue<T> extends Queue<T> {

	public DoubleEndedQueue() {
		super.data = new ArrayList<T>();
	}
	
	public void enqueueFirst(T dato) {
		data.add(0, dato);
	}
}
