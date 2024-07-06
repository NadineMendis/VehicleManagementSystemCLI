import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.text.DecimalFormat;

public class Util
{   
    // Ref - web URL , book 
    public static String getCurrentMonth()
    {       
        return new DateFormatSymbols().getMonths()[Calendar.getInstance().get(Calendar.MONTH)];
    }
    
    public static String format(double value)
    {
        return new DecimalFormat("0.00").format(value);
    }
}
