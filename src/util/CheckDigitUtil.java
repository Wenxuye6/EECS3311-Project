package util;

import java.util.regex.Pattern;

/**
 * check digit
 */
public class CheckDigitUtil {

    private static final Pattern CD = Pattern.compile("^[0-9]+(.[0-9]{1,2})?$"); //Double
    private static final Pattern CI = Pattern.compile("^[1-9]d*$"); //Integer

    /**
     * Check if the string is a number
     * @param digit String to be tested
     * @return digit -> true / not digit -> false
     */
    public static boolean check(String digit) {
        return (CD.matcher(digit).matches() || CI.matcher(digit).matches());
    }
}
