import java.io.Console;
import java.util.Scanner;

public class Main {

    public static StringBuilder password = new StringBuilder();

    public static void main(String[] args){

        Scanner myScan = new Scanner(System.in);
        System.out.print("Please select your password length (recommended min 12): ");
        int passswordLength = 12;

        String input = myScan.nextLine();

        if ((input.matches("[A-Z]*") || (input.matches("[a-z]*")))){
            System.out.println("Contain letters, so we use the default length: 12 characters");
        }

        char downCase[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'l', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'w', 'x', 'y', 'z'};
        char uperCase[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','L','Ñ','O','P','Q','R','S','T','W','X','Y','Z'};
        char numbers[] = {'1','2','3','4','5','6','7','8','9','0'};
        char specialChars[] = {'!','@','#','$','%','^','&','*','(',')','-','_','=','+','[',']', '{', '}', ';', ':', ',', '<', '.', '>'};

        for (int i = 0; i < passswordLength; i++){

            int randChar = (int)(Math.random() * 4);

            if (randChar == 0)
                buildPassword(downCase);
            else if (randChar == 1)
                buildPassword(uperCase);
            else if (randChar == 2)
                buildPassword(numbers);
            else
                buildPassword(specialChars);

        }

        System.out.println(password.toString());

    }

    private static void buildPassword(char[] chars){
        int charsLength = chars.length;
        password.append(chars[(int)(Math.random() * charsLength)]);
        if ((password.toString().replace("-", "")).length() % 3 == 0){
            password.append("-");
        }
    }

}