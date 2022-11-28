package br.edu.utfpr.formataData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormataData {

    public static String localDateToString(LocalDate data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String text = data.format(dtf);
        return text;
    }

    public static LocalDate stringToLocalDate(String data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataForm = LocalDate.parse(data, dtf);
        return dataForm;
    }
}
