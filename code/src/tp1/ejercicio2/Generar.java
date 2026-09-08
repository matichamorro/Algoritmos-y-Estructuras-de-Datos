package tp1.ejercicio2;

public class Generar {
	
	public static int[] arreglo(int N) {
		int[] nue = new int[N];
		for (int i=0; i<N; i++)
			nue[i] = N * (i + 1);
		return nue;
	}
}
