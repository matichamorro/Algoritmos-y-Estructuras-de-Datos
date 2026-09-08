package tp1.ejercicio1;

public class Calcular {
	
	public static int Suma1(int A, int B) {
		int total = 0;
		for (int x = A; x <= B; x++) 
			total = total + x;
		return total;
	}
	
	public static int Suma2(int A, int B) {
		int total = 0;
		int i = A;
		while (i <= B) {
			total = total + i;
			i++;
		}	
		return total;
	}
	
	public static int Suma3(int A, int B) {
		if (A + 1 <= B) return A + Suma3(A + 1, B); 
		else return A;
	}
	
}
