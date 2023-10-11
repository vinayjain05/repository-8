import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        String piInDate; //input date 
        int piAdj; //adjustment amount
        String piAdjType; //adjustment type
        String piInFmt; //input date format
        String piOutFmt; //output date format

        SimpleDateFormat inFormat;
        SimpleDateFormat outFormat;
        Date date;

        // handle special input format values
        if (piInFmt.equals("*JOBFMT")) {
            piInFmt = getJobFormat(); 
        } else if (piInFmt.equals("*SYSTEM")) {
            piInFmt = getSystemFormat();
        }

        // handle special output format values
        if (piOutFmt.equals("*JOBFMT")) {
            piOutFmt = getJobFormat();
        } else if (piOutFmt.equals("*SYSTEM")) {
            piOutFmt = getSystemFormat();
        } else if (piOutFmt.equals("*INFMT")) {
            piOutFmt = piInFmt;
        }

        // handle special input date values  
        if (piInDate.equals("*SYSTEM")) {
            piInDate = getSystemDate();
        } else if (piInDate.equals("*JOBDATE")) {
            piInDate = getJobDate();
        }

        // convert input date to Date object
        inFormat = new SimpleDateFormat(piInFmt);
        date = inFormat.parse(piInDate);

        // adjust date
        if (piAdjType.equals("D")) {
            // adjust days
            date.setDate(date.getDate() + piAdj);
        } else if (piAdjType.equals("M")) {
            // adjust months
            date.setMonth(date.getMonth() + piAdj);
        } else if (piAdjType.equals("Y")) {
            // adjust years  
            date.setYear(date.getYear() + piAdj);
        }

        // format output date 
        outFormat = new SimpleDateFormat(piOutFmt);
        String outputDate = outFormat.format(date);

        // handle errors
        if (date == null) {
            // invalid date
            sendErrorMessage();
        }

        // return output date
        return outputDate;

    }

    // utility methods
    static String getJobFormat() {
        // implementation
    }

    static String getSystemFormat() {
        // implementation 
    }

    static String getSystemDate() {
        // implementation
    }

    static String getJobDate() {
        // implementation
    }

    static void sendErrorMessage() {
        // implementation
    }

}
