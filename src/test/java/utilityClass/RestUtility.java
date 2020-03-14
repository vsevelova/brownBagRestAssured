package utilityClass;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtility {
    public static String empName(){
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("ilyas" + generatedString);
    }

    public static String email(){
        String generatedString = RandomStringUtils.randomAlphabetic(8);
        return (generatedString+"@gmail.com");
    }

    public static String name(){
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return ("ilyas" + generatedString);
    }

    public static String phone(){
        String generatedAge = RandomStringUtils.randomNumeric(6);
        return (generatedAge);
    }

    public static String userName(){
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return ("ilyas" + generatedString);

    }
    public static String website(){
        String generatedString = RandomStringUtils.randomAlphabetic(9);
        return ("https://" + generatedString + ".com");
    }


    public static String street() {
        String generatedString = RandomStringUtils.randomAlphabetic(4);
        return ("maskavas-" + generatedString);
    }

    public static String city() {
        String generatedString = RandomStringUtils.randomAlphabetic(4);
        return ("Riga" + generatedString);
    }

        public static String suite() {
            String generatedString = RandomStringUtils.randomNumeric(3);
            return ("11-" + generatedString);
        }

    public static String zipcode() {
        String generatedString = RandomStringUtils.randomNumeric(4);
        return ("LV-" + generatedString);
    }

    public static String companyName() {
        String generatedString = RandomStringUtils.randomAlphabetic(4);
        return ("Riga-" + generatedString);
    }
}
