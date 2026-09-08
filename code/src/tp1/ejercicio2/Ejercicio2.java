package tp1.ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] nue_arreglo = Generar.arreglo(s.nextInt());
		for (int elto: nue_arreglo)
			System.out.println(elto);
		s.close();
	}
		
}
