package core.basesyntax;

import java.text.ParseException;
import java.util.Date;

public class SalaryInfo {
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        StringToDate stringToDate = new StringToDate();
        StringBuilder stringBuilder = new StringBuilder("Report for period "
                + dateFrom
                + " - "
                + dateTo);
        try {
            Date start = stringToDate.stringToDate(dateFrom);
            Date end = stringToDate.stringToDate(dateTo);
            for (String name:
                    names) {
                int salary = 0;
                for (String datum : data) {
                    String[] record = datum.split(" ");
                    Date actual = stringToDate.stringToDate(record[0]);
                    if (name.equals(record[1])
                            && (actual.after(start) || actual.equals(start))
                            && (actual.before(end) || actual.equals(end))) {
                        salary += Integer.parseInt(record[2]) * Integer.parseInt(record[3]);
                    }
                }
                stringBuilder.append(System.getProperty("line.separator"))
                                .append(name)
                                .append(" - ")
                                .append(salary);
            }

        } catch (ParseException ignore) {
            super.notifyAll();
        }
        return stringBuilder.toString();
    }
}
