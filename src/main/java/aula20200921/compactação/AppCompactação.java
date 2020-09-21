package aula20200921.compactação;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class AppCompactação {

    public static void main(String[] args) throws Exception {
        //exemploGzipArquivoTextoMaisConsole();
        exemploComSerialização();
    }

    private static void exemploComSerialização() throws Exception {
        List<Date> datas = new ArrayList<>();
    
        for (int i = 0; i < 2; i++) {
            datas.add(new Date());
        }

        // Insumo basagram =  new Insumo("Basagram 5L");

        File arquivoDeInsumos = new File("/home/arthur/unicesumar/4esoft2020/insumos.dat");
        // ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(arquivoDeInsumos));
        // output.writeObject(basagram);
        // output.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivoDeInsumos));
        Insumo recuperadoDoArquivo = (Insumo)input.readObject();
        System.out.println(recuperadoDoArquivo.toString());

    }

    private static void exemploGzipArquivoTextoMaisConsole() throws Exception {
        StringBuffer texto = new StringBuffer();
        for (int i = 0; i < 20000; i++) {
            texto.append("Formandos 2020 Engenharia de Software UniCesumar! \n");
        }
        File arquivoTexto = new File("/home/arthur/unicesumar/4esoft2020/arquivo.txt");
        //PrintWriter output =  new PrintWriter(new GZIPOutputStream(new FileOutputStream(arquivoTexto)));
        PrintWriter output =  new PrintWriter(new GZIPOutputStream(System.out));
        output.print(texto);
        output.close();        
    }
    
}
