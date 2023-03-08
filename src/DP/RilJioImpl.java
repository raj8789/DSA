package DP;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RilJioImpl {

    public static void main(String[] args) {
        String regexLowercase = "[a-z]+";
        String regexUppercase = "^(?!^[A-Z])(?=.*[A-Z]).*[^A-Z]$";
        String regexDigit = "^(?!\\d+$)[\\w\\d]+$";
        String regexSpecial = "^(?![@#%&?])[a-zA-Z0-9@#%&?]+(?<![@#%&?])$";
        String regexTenChar = "^.{10,}$";
        String regex[]={regexLowercase,regexDigit,regexUppercase,regexSpecial,regexTenChar};
        System.out.println(isValidPassword(regex,"qwA@123utye"));
    }
    public static boolean isValidPassword(String regex[],String password){
        for(int i=0;i< regex.length;i++) {
            Pattern pattern = Pattern.compile(regex[i]);
            Matcher matcher = pattern.matcher(password);
            if(!matcher.matches()){
                System.out.println("Hiii");
                return false;
            }else {
                System.out.println(regex[i]);
            }
        }
        return true;
    }
}
