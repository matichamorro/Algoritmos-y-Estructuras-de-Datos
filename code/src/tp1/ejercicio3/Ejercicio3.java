package tp1.ejercicio3;

public class Ejercicio3 {

	public static void main(String[] args) {
		Estudiante[] est = new Estudiante[2];
		Profesor[] prof = new Profesor[3];
		prof[0] = new Profesor();
		prof[0].setNombre("Juan");
		prof[0].setApellido("Perez");
		prof[0].setEmail("juaPerz@gmail.com");
		prof[0].setCatedra(3);
		prof[0].setFacultad("UNLP");
		
		prof[1] = new Profesor();
		prof[1].setNombre("Juan");
		prof[1].setApellido("Gomez");
		prof[1].setEmail("juanGom@gmail.com");
		prof[1].setCatedra(2);
		prof[1].setFacultad("UNLP");
		
		prof[2] = new Profesor();
		prof[2].setNombre("Carlos");
		prof[2].setApellido("Fernandez");
		prof[2].setEmail("CarlFdez@gmail.com");
		prof[2].setCatedra(1);
		prof[2].setFacultad("UTN");
		
		est[0] = new Estudiante();
		est[0].setNombre("Pedro");
		est[0].setApellido("Picapiedra");
		est[0].setComision(6);
		est[0].setEmail("PePica@gmail.com");
		est[0].setDireccion("15 num6054");
		
		est[1] = new Estudiante();
		est[1].setNombre("Matias");
		est[1].setApellido("Chamorro");
		est[1].setComision(3);
		est[1].setEmail("maticham@gmail.com");
		est[1].setDireccion("462 num1543");
		
		for(int i=0; i < 2; i++)
			System.out.println(est[i].tusDatos());
		
		for(int i=0; i < 3; i++)
			System.out.println(prof[i].tusDatos());
	}
	
	

}
