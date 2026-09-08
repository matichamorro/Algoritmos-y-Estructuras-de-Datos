package tp1.ejercicio7;

import java.util.ArrayList;

public class EjercicioH {

	public void invertirArrayList(ArrayList<Integer> list) {
		if (list != null && !list.isEmpty()) {
			Integer first_elem = list.removeFirst();
			invertirArrayList(list);
			list.addLast(first_elem);
		}
	}
}
