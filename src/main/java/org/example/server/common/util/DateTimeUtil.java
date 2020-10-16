package org.example.server.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private DateTimeUtil(Long timestamp, String pattern) {
        if (timestamp == null || timestamp <= 0) {
            this.setValue("");
            return;
        }
        if (pattern == null) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        if (pattern.equals("")) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if (timestamp.toString().length() == 10) {
            timestamp *= 1000;
        }
        this.setValue(simpleDateFormat.format(new Date(timestamp)));
    }

    public static String formatValue(Long timestamp, String pattern) {
        return new DateTimeUtil(timestamp, pattern).getValue();
    }

    public static String formatValue(Long timestamp) {
        return new DateTimeUtil(timestamp, null).getValue();
    }

}
