package formataData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormataData {

    public static String formataDataString(LocalDate data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String text = data.format(dtf);
        return text;
    }

    public static LocalDate formataDataLocalDate(String data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataForm = LocalDate.parse(data, dtf);
        return dataForm;
    }

    public static LocalDate formataDataAmbos(String data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataForm = LocalDate.parse(data, dtf);
        return dataForm;
    }
}
