package tp1.ejercicio7;

import java.util.Iterator;
import java.util.LinkedList;

public class EjercicioI {

	public int sumarLinkedList(LinkedList<Integer> lista) {
		return sumarRecursivo(lista.iterator());
	}
	
	public int sumarRecursivo(Iterator<Integer> lista) {
		if (lista.hasNext())
			return lista.next() + sumarRecursivo(lista);
		else
			return 0;
	}
}
