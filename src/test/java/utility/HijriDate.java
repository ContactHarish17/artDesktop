package utility;

import org.joda.time.Chronology;
import org.joda.time.LocalDate;
import org.joda.time.chrono.IslamicChronology;
import org.joda.time.chrono.ISOChronology;

import java.io.IOException;

public class HijriDate
{
    public static void main(String[] args) throws Exception {
        Chronology iso = ISOChronology.getInstanceUTC();
        Chronology hijri = IslamicChronology.getInstanceUTC();



//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//        String data = dateFormat.format("21-08-1971");
//
//
//        LocalDate todayIso = new LocalDate(data, iso);
//        LocalDate todayHijri = new LocalDate(todayIso.toDateTimeAtStartOfDay(),
//                hijri);
//        System.out.println(todayHijri); // 1434-05-19




        try {
           String ownerDOB = ReadExcel.getOwnerDOB(Constant.createQuoteSheet,1,3);
            // ReadExcel.getOnwerDate(1,2);

        System.out.println("the English DOB is "+ ownerDOB);
        String hijridate = hijriDate(String.valueOf(ownerDOB));
        System.out.println("the Hijri DOB is "+ String.valueOf(hijridate));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String hijriDate(String gregorianDate)
    {
        Chronology iso = ISOChronology.getInstanceUTC();
        Chronology hijri = IslamicChronology.getInstanceUTC();
        String data = "21-08-1971";
        LocalDate todayIso = new LocalDate(gregorianDate, iso);
        LocalDate todayHijri = new LocalDate(todayIso.toDateTimeAtStartOfDay(),
                hijri);
        System.out.println(todayHijri); // 1434-05-19
        return String.valueOf(todayHijri);
    }
}
