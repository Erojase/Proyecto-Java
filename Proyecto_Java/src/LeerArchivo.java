import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerArchivo {
	
	private File miarchivo, historia;
	private Scanner lectorP, lectorH;
	
	public LeerArchivo() {
		super();
		try {
			miarchivo = new File("src/frases.txt");
			historia = new File("src/historia.txt");
			lectorP = new Scanner(miarchivo);
			lectorH = new Scanner(historia);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	public String get_frase(int linea) {
		int cont = 0;
		while (lectorP.hasNextLine()) {
	        String data = lectorP.nextLine();
	        cont++;
	        if(cont == linea) {
	        	return data;
	        }
	      }
		return "";
	}

}
