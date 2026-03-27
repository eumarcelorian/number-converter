import java.util.Scanner;

public class converter {

    static int binaryToDecimal(String binary) {

        int decimal = 0;

        for (int i = 0; i < binary.length(); i++) {
            char bit = binary.charAt(i);
            int value = bit - '0';
            decimal = decimal * 2 + value;
        }
        return decimal;
    }

    static String decimalToBinary(int num){

        if (num == 0) return "0";

        String binary = "";
        while (num > 0){
            int remainder = num % 2;
            binary = remainder + binary;
            num = num / 2;
        }

        return binary;
    }

    static String decimalToOctal(int num) {
        return Integer.toOctalString(num);
        /*Descobrir que a classe Integer existia enquanto desenvolvia esse projeto. Facilitou bastante.*/
    }

    static String decimalToHex(int num) {
        return Integer.toHexString(num).toUpperCase();
    }

    static int octalToDecimal(String octal) {
        return Integer.parseInt(octal, 8);
    }

    static int hexToDecimal(String hex) {
        return Integer.parseInt(hex, 16);
    }

    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("---THE CONVERTER---");

        System.out.print("Which number system will you use?\n" +
                "1 - BINARY\n" +
                "2 - OCTAL\n" +
                "3 - DECIMAL\n" +
                "4 - HEXADECIMAL\n" +
                "> ");
        int choice = scan.nextInt();
        scan.nextLine();

        switch(choice){
            case 1:
                System.out.print("Enter a number: ");
                String binary = scan.nextLine();

                System.out.print("Binary to... \n" +
                        "1 - OCTAL\n" +
                        "2 - DECIMAL\n" +
                        "3 - HEXADECIMAL\n" +
                        "> ");
                int case_one_choice = scan.nextInt();

                if (case_one_choice == 1){
                    System.out.println("Result: " + decimalToOctal(binaryToDecimal(binary)));
                }
                else if (case_one_choice == 2){
                        System.out.println("Result: " + binaryToDecimal(binary));

                }
                else if (case_one_choice == 3){
                    System.out.println("Result: " + decimalToHex(binaryToDecimal(binary)));
                }

                break;
            case 2:
                System.out.print("Enter a number: ");
                String octal = scan.nextLine();

                System.out.print("Octal to... \n" +
                        "1 - BINARY\n" +
                        "2 - DECIMAL\n" +
                        "3 - HEXADECIMAL\n" +
                        "> ");
                int case_two_choice = scan.nextInt();

                if (case_two_choice == 1){
                    System.out.println("Result: " + decimalToBinary((octalToDecimal(octal))));
                }
                else if (case_two_choice == 2){
                    System.out.println("Result: " + octalToDecimal(octal));
                }
                else if (case_two_choice == 3){
                    System.out.println("Result: " + decimalToHex(octalToDecimal(octal)));
                }

                break;
            case 3:
                System.out.print("Enter a number: ");
                int decimal = scan.nextInt();
                scan.nextLine();

                System.out.print("Decimal to... \n" +
                        "1 - BINARY\n" +
                        "2 - OCTAL\n" +
                        "3 - HEXADECIMAL\n" +
                        "> ");
                int case_three_choice = scan.nextInt();

                if (case_three_choice == 1){
                    System.out.println("Result: " + decimalToBinary(decimal));
                }
                else if (case_three_choice == 2){
                    System.out.println("Result: " + decimalToOctal(decimal));
                }
                else if (case_three_choice == 3){
                    System.out.println("Result: " + decimalToHex(decimal));
                }

                break;
            case 4:
                System.out.print("Enter a number: ");
                String hex_decimal = scan.nextLine();

                System.out.print("Hexadecimal to... \n" +
                        "1 - BINARY\n" +
                        "2 - OCTAL\n" +
                        "3 - DECIMAL\n" +
                        "> ");
                int case_four_choice = scan.nextInt();

                if (case_four_choice == 1){
                    System.out.println("Result: " + decimalToBinary((hexToDecimal(hex_decimal))));
                }
                else if (case_four_choice == 2){
                    System.out.println("Result: " + decimalToOctal(hexToDecimal(hex_decimal)));
                }
                else if (case_four_choice == 3){
                    System.out.println("Result: " + hexToDecimal(hex_decimal));
                }

                break;

        }
    }
}
