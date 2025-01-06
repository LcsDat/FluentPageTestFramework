public class RegexPattern {
    public static final String NO_UpperCase = "[a-z]{10}[0-9]{10}[!@#$%^&*()<>?{}]{10}";
    public static final String NO_LowerCase = "[A-Z]{10}[0-9]{10}[!@#$%^&*()<>?{}]{10}";
    public static final String NO_Number = "[A-Z]{10}[a-z]{10}[!@#$%^&*()<>?{}]{10}";
    public static final String NO_Special = "[A-Z]{10}[0-9]{10}[a-z]{10}";
    public static final String EXCEED_40Chars = "[A-Z]{10}[a-z]{11}[0-9]{10}[!@#$%^&*()<>?{}]{10}";
    public static final String EXCEED_64Chars = "[A-Z]{15}[a-z]{20}[0-9]{15}[!@#$%^&*()<>?{}]{15}";
    public static final String VALID_Password = "[A-Z]{10}[a-z]{10}[0-9]{10}[!@#$%^&*()<>?{}]{10}";
}
