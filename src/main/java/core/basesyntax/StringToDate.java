package core.basesyntax;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
    public Date stringToDate(String entry) throws ParseException {
        DateFormat sourceFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = sourceFormat.parse(entry);;
        return date;
    }
}
