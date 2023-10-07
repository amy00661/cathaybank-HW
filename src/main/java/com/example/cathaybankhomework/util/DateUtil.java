package com.example.cathaybankhomework.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Slf4j
public class DateUtil {

    /**
     * 將UTC格式的時間轉換成一般可閱讀的時間格式 <br/>
     * EX: 時間格式yyyy-MM-dd'T'HH:mm:ssZZZ轉換為yyyy-MM-dd HH:mm:ss
     * @param date
     * @param format
     * @return
     */
    public static String transUTCToNormalDate(final String date, final String format) {
        log.info("date= " + date);
        String normalDate = null;
        if (StringUtils.hasLength(date)) {
            LocalDateTime localDate = LocalDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            normalDate = localDate.format(DateTimeFormatter.ofPattern(format));

        }
        return normalDate;
    }

}
