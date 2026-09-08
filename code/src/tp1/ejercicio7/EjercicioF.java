package tp1.ejercicio7;

import java.util.List;

public class EjercicioF {
	
	public static boolean esCapicua(List<Integer> lista) {
		boolean iguales = true;
		int mitad = lista.size() / 2;
		for (int i=0; i < mitad / 2; i++)
			if (lista.get(i) != lista.get(lista.size()-i-1)) iguales = false;
		return iguales;
		
	}
	
}
