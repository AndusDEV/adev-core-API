package pl.andus.cAPI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logging {
    static String APIprefix = "(cAPI Logger) ";

    public static void info(String input) {
        String prefix_info = "[INFO] ";
        System.out.println(APIprefix + prefix_info + getTimeAndDate() + ": " + input);
    }

    public static void warning(String input) {
        String prefix_warning = "[WARNING] ";
        System.out.println(APIprefix + prefix_warning + getTimeAndDate() + ": " + input);
    }

    public static void error(String input) {
        String prefix_error = "[ERROR] ";
        System.out.println(APIprefix + prefix_error + getTimeAndDate() + ": " + input);
    }

    private static String getTimeAndDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
