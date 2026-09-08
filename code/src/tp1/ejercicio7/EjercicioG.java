package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class EjercicioG {
	
	public static List<Integer> calcularSucesion (int n) {
		double aux = n;
		List<Integer> listAux = new ArrayList<Integer>();
		listAux.add((int) aux);
		while (aux != 1) {
			if (aux % 2 == 0) aux = aux / 2.0;
			else aux = 3 * aux + 1;
			listAux.add((int) aux);
		}
		return listAux;
	}
}
