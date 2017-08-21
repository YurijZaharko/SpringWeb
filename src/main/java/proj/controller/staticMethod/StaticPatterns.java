package proj.controller.staticMethod;

import java.util.regex.Pattern;

/**
 * Created by SC on 11.03.2017.
 */
public class StaticPatterns {
    public static final Pattern EMAIL_PATTERN = Pattern.compile(".+@.+\\.[a-z]+");

    public static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9._-]{3,15}$");

    public static final Pattern PHONE_PATTERN = Pattern.compile("^\\(\\d{3}\\)\\d{3}-\\d{4}$");

//    public static final Pattern DIGITAL_PATTERN = Pattern.compile("^d{10}$");

    public static final Pattern DIGITAL_PATTERN = Pattern.compile("^([1-9][0-9]{0,9}?)$");

    public static final Pattern QUANTITY_PATTERN = Pattern.compile("^([1-9][0-9]{0,9}?|1000000000)$");
}
