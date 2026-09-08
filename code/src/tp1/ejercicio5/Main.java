package tp1.ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		List<Integer> v = new ArrayList<Integer>();
		for (int i=1; i < 10; i++)
			v.add(i);
		
		Datos d1 = Calcular.datosA(v);
		System.out.println("El maximo es: " + d1.getMax());
		System.out.println("El minimo es: " + d1.getMin());
		System.out.println("El promedio es: " + d1.getProm());
		
		System.out.println("----------------------------------");
		
		Datos d2 = new Datos();
		Calcular.datosB(v, d2);
		System.out.println("El maximo es: " + d2.getMax());
		System.out.println("El minimo es: " + d2.getMin());
		System.out.println("El promedio es: " + d2.getProm());
		
		System.out.println("----------------------------------");
		
		Calcular.datosC(v);
		System.out.println("El maximo es: " + Calcular.getMax());
		System.out.println("El minimo es: " + Calcular.getMin());
		System.out.println("El promedio es: " + Calcular.getProm());
	}

}
