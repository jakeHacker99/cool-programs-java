package udemymasterclass.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenges {
    public static void main(String[] args) {

//      challenge 1
        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));



//      challenge 2
        String regExp= "I want a \\w+.";
        System.out.println(challenge1.matches(regExp));
        String challenge2= "I want a ball.";
        System.out.println(challenge2.matches(regExp));





//      challenge 3

        String regExp3 = "I want a \\w+.";
        Pattern pattern = Pattern.compile(regExp3);
        Matcher matcher = pattern.matcher((challenge1));
        System.out.println(matcher.matches());

        matcher= pattern.matcher(challenge2);
        System.out.println(matcher.matches());

//      challenge 4

        String challenge4 = "Replace all balnks with underscores.";
        System.out.println(challenge4.replaceAll(" ", "_"));
        System.out.println(challenge4.replaceAll("\\s", "_"));


//      challenge 5

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("[abcdefg]+"));
        System.out.println(challenge5.matches("[a-g]+"));

        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));
        System.out.println(challenge5.replaceAll("^a{3}bc{8}d{3}ef{3}g$", "Replaced" ));


//      challenge 6
        String challenge6 = "abcd.135";
        System.out.println(challenge6.matches("^[A-z][a-z]+\\.\\d+$"));
    }
}
