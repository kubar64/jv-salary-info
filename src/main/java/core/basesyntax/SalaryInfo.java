package core.basesyntax;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

public class SalaryInfo {
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo)  {

        StringToDate stringToDate = new StringToDate();
        StringBuilder stringBuilder = new StringBuilder("Report for period "+dateFrom+" - "+dateTo);
        stringBuilder.append(System.getProperty("line.separator"));
        try {
            Date start = stringToDate.stringToDate(dateFrom);
            Date end = stringToDate.stringToDate(dateTo);
            for (String name:
                 names) {
                int salary = 0;
                for (int i = 0; i < data.length ; i++){
                String[] record = data[i].split(" ");
                Date actual = stringToDate.stringToDate(record[0]);
                if (name.equals(record[1]) && (actual.after(start) || actual.equals(start)) && (actual.before(end) || actual.equals(end))){
                    salary += Integer.valueOf(record[2])*Integer.valueOf(record[3]);
                }
                }
            stringBuilder.append(name).append(" - ").append(salary).append(System.getProperty("line.separator"));
            }

        }catch(ParseException ignored){
        }
        return stringBuilder.toString();
    }
}
