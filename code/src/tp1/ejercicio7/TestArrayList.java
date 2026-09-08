package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TestArrayList {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int num = s.nextInt();
		while (num != 0) {
			list.add(num);
			num = s.nextInt();
		}
		System.out.println(EjercicioF.esCapicua(list));
		
		num = s.nextInt();
		List<Integer> list2 = EjercicioG.calcularSucesion(num);
		for (int i: list2)
			System.out.println(i);
		s.close();
		
		System.out.println();
		EjercicioH h = new EjercicioH();
		h.invertirArrayList(list);
		for (int i: list)
			System.out.println(i);
		
		
		System.out.println();
		EjercicioI ejI = new EjercicioI();
		LinkedList<Integer> list3 = new LinkedList<Integer>();
		list3.addAll(list);
		System.out.println(ejI.sumarLinkedList(list3));
		
		
		System.out.println();
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		ArrayList<Integer> list5 = new ArrayList<Integer>();
		for (int i=1; i<6; i++) {
			list4.add(i);
			list5.add(i * 2);
		}
		EjercicioJ j = new EjercicioJ();
		System.out.println(j.combinarOrdenado(list4, list5));

	}

}
