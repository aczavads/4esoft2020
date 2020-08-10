package aula20200810.arquivos;

import java.io.File;

public class AppArquivos {
	
	public static void main(String[] args) {
		File raiz = new File("/home/arthur/server");
		listarArquivosNoConsole(raiz, ">");
		System.out.println("Foi.");
		
	}

	private static void listarArquivosNoConsole(File diretório, String nível) {
		File[] arquivos = diretório.listFiles();
		for (File file : arquivos) {
			System.out.println(nível + " " + file.getName());
			if (file.isDirectory()) {
				listarArquivosNoConsole(file, nível + ">");
			}
		}
	}

}
