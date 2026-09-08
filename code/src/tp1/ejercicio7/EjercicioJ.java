package tp1.ejercicio7;

import java.util.ArrayList;

public class EjercicioJ {

	public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
		ArrayList<Integer> listaOrdenada = new ArrayList<Integer>();
		int i=0;
		int j=0;
		while ((i < lista1.size()) && (j < lista2.size())) {
			if (lista1.get(i) < lista2.get(i)) {
				
			}
			else {
				listaOrdenada.add(lista2.get(j));
				j++;
			}
		}
		while (i < lista1.size()) {
			listaOrdenada.add(lista1.get(i));
			i++;
		}
		while (i < lista2.size()) {
			listaOrdenada.add(lista2.get(j));
			j++;
		}
		return listaOrdenada;
		
	}
	
	
}
