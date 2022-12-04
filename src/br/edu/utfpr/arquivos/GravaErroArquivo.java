package br.edu.utfpr.arquivos;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class GravaErroArquivo {

    public GravaErroArquivo() {
    }

    public void gravar(File file, String conteudo) {
        try (OutputStream output = new FileOutputStream(file); BufferedOutputStream buffer = new BufferedOutputStream(output)) {
            buffer.write(conteudo.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
