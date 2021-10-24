import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number {
    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }
}
