/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.Seconds;

/**
 *
 * @author rhau
 */
public class DateUtils {
        
    public static Date toDate(String dataString, String mask) {
        SimpleDateFormat formatter = new SimpleDateFormat(mask);
        Date data = null;
        try {
            data = formatter.parse(dataString);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
       
    public static String toString(Date data, String mask) {
        SimpleDateFormat formatter = new SimpleDateFormat(mask);        
        return formatter.format(data);
    }

    public static String diffTime(Date start, Date end) {
        Period diff = new Period( new DateTime(start), new DateTime(end) );  
        return formatHour(diff.getHours(), diff.getMinutes(), diff.getSeconds());
    }

    public static String getHourForSecond(Integer seconds) {    
        Period period = new Period(Seconds.seconds(seconds));
        return formatHour(period.getHours(), period.getMinutes(), period.getSeconds());
    }

    private static String formatHour(Integer hours, Integer minutes, Integer seconds) {
        // garante que hora, min e seg estejam no formato correto (2 digitos)
        return ( (hours   < 10 ? "0" : "") + hours   + ":" +
                 (minutes < 10 ? "0" : "") + minutes + ":" +
                 (seconds < 10 ? "0" : "") + seconds );
    }
    
}