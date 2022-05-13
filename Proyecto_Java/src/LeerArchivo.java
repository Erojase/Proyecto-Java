import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerArchivo {
	
	private File miarchivo;
	private Scanner lector;
	
	public LeerArchivo() {
		super();
		try {
			miarchivo = new File("src/frases.txt");
			lector = new Scanner(miarchivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void siguente_linea() {
		while (lector.hasNextLine()) {
	        String data = lector.nextLine();
	        System.out.println(data);
	      }
	}
	public String get_frase(int linea) {
		int cont = 0;
		while (lector.hasNextLine()) {
	        String data = lector.nextLine();
	        cont++;
	        if(cont == linea) {
	        	return data;
	        }
	      }
		return "";
	}
	
	public static void main(String[] args) {  
		LeerArchivo run = new LeerArchivo();
		run.siguente_linea();
	}
}
