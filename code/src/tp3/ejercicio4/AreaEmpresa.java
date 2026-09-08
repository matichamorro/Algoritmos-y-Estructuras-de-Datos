package tp3.ejercicio4;

public class AreaEmpresa {
	private String id;
	private int time;
	
	public AreaEmpresa() {
		
	}
	
	public AreaEmpresa(String id, int time) {
		this.id = id;
		this.time = time;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public String toString() {
		return "|" + this.getId() + ": " + this.getTime() + "|";
	}
	
}
