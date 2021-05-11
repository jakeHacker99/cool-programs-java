package udemymasterclass.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

public class Challenge1 {
    public static void main(String[] args) {

        Runnable runnable= new Runnable() {
            @Override
            public void run() {
                String myString = "let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

            Runnable runnable1 =() ->{
                String myString = "let's split this up into an array";
                String[] parts = myString.split(" ");
                for(String part : parts){
                    System.out.println(part);
                }
            };
            Function<String, String> lambdaFunction = s -> {
                StringBuilder returnVal = new StringBuilder();
                for (int i = 0; i <s.length() ; i++) {
                    if( i % 2 ==1){
                        returnVal.append(s.charAt(i));
                    }
                }
                return returnVal.toString();
            };

            String result = everySecondCharacter(lambdaFunction, "112244");
            System.out.println(result);

            Supplier<String> iloveJava = () -> {return "I love java!";} ;
            String supplierResult = iloveJava.get();
        System.out.println(supplierResult);

    };
    public static String everySecondCharacter(Function<String, String> func, String source){
        return func.apply(source);
    }
}

