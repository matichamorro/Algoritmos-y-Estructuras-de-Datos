package tp1.ejercicio5;

import java.util.List;

public class Calcular {
	private static int max;
	private static int min;
	private static double prom;
	
	
	public static Datos datosA(List<Integer> v) {
		int max = Integer.MIN_VALUE; int min = Integer.MAX_VALUE;
		int total = 0;
		for (int i=0; i < v.size(); i++) {
			if (v.get(i) > max) max = v.get(i);
			if (v.get(i) < min) min = v.get(i);
			total = total + v.get(i);
		}
		double prom = total / v.size();
		Datos d = new Datos();
		d.setMax(max);
		d.setMin(min);
		d.setProm(prom);
		return d;
	}
	
	public static void datosB(List<Integer> v, Datos d) {
		int max = Integer.MIN_VALUE; int min = Integer.MAX_VALUE;
		int total = 0;
		for (int i=0; i < v.size(); i++) {
			if (v.get(i) > max) max = v.get(i);
			if (v.get(i) < min) min = v.get(i);
			total = total + v.get(i);
		}
		double prom = total / v.size();
		d.setMax(max);
		d.setMin(min);
		d.setProm(prom);
	}
	
	public static void datosC(List<Integer> v) {
		int max = Integer.MIN_VALUE; int min = Integer.MAX_VALUE;
		int total = 0;
		for (int i=0; i < v.size(); i++) {
			if (v.get(i) > max) max = v.get(i);
			if (v.get(i) < min) min = v.get(i);
			total = total + v.get(i);
		}
		double prom = total / v.size();
		Calcular.setMax(max);
		Calcular.setMin(min);
		Calcular.setProm(prom);
	}

	public static int getMax() {
		return max;
	}

	public static void setMax(int max) {
		Calcular.max = max;
	}

	public static int getMin() {
		return min;
	}

	public static void setMin(int min) {
		Calcular.min = min;
	}

	public static double getProm() {
		return prom;
	}

	public static void setProm(double prom) {
		Calcular.prom = prom;
	}
	
	
}
