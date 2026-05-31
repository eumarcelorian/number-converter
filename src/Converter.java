package src;

import java.util.Scanner;

public class Converter {

    private static int binaryToDecimal(String binary) {

        int decimal = 0;

        for (int i = 0; i < binary.length(); i++) {
            char bit = binary.charAt(i);
            int value = bit - '0';
            decimal = decimal * 2 + value;
        }
        return decimal;
    }

    private static String decimalToBinary(int num) {

        if (num == 0) return "0";

        String binary = "";
        while (num > 0) {
            int remainder = num % 2;
            binary = remainder + binary;
            num = num / 2;
        }

        return binary;
    }

    private static String decimalToOctal(int num) {
        return Integer.toOctalString(num);
        /*Descobrir que a classe Integer existia enquanto desenvolvia esse projeto. Facilitou bastante.*/
    }

    private static String decimalToHex(int num) {
        return Integer.toHexString(num).toUpperCase();
    }

    private static int octalToDecimal(String octal) {
        return Integer.parseInt(octal, 8);
    }

    private static int hexToDecimal(String hex) {
        return Integer.parseInt(hex, 16);
    }

    private static boolean isBinary(String value) {
        return value.matches("[01]+");
    }

    private static boolean isOctal(String value) {
        return value.matches("[0-7]+");
    }

    private static boolean isDecimal(String value) {
        return value.matches("[0-9]+");
    }

    private static boolean isHex(String value) {
        return value.matches("[0-9A-Fa-f]+");
    }

    private static int readInt(Scanner scan) {
        while (true) {
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("---THE CONVERTER---");

            System.out.print("Which number system will you use?\n" +
                    "1 - BINARY\n" +
                    "2 - OCTAL\n" +
                    "3 - DECIMAL\n" +
                    "4 - HEXADECIMAL\n" +
                    "> ");
            int choice =  readInt(scan);

            switch (choice) {
                case 1:
                    System.out.print("Enter a number: ");
                    String binary = scan.nextLine();
                    if (!isBinary(binary)) {
                        System.out.println("Invalid binary number.\n");
                        continue;
                    }

                    System.out.print("Binary to... \n" +
                            "1 - OCTAL\n" +
                            "2 - DECIMAL\n" +
                            "3 - HEXADECIMAL\n" +
                            "> ");
                    int case_one_choice = readInt(scan);

                    if (case_one_choice == 1) {
                        System.out.println("Result: " + decimalToOctal(binaryToDecimal(binary)));
                    } else if (case_one_choice == 2) {
                        System.out.println("Result: " + binaryToDecimal(binary));

                    } else if (case_one_choice == 3) {
                        System.out.println("Result: " + decimalToHex(binaryToDecimal(binary)));
                    }

                    break;
                case 2:
                    System.out.print("Enter a number: ");
                    String octal = scan.nextLine();
                    if (!isOctal(octal)) {
                        System.out.println("Invalid octal number.\n");
                        continue;
                    }

                    System.out.print("Octal to... \n" +
                            "1 - BINARY\n" +
                            "2 - DECIMAL\n" +
                            "3 - HEXADECIMAL\n" +
                            "> ");
                    int case_two_choice = readInt(scan);

                    if (case_two_choice == 1) {
                        System.out.println("Result: " + decimalToBinary((octalToDecimal(octal))));
                    } else if (case_two_choice == 2) {
                        System.out.println("Result: " + octalToDecimal(octal));
                    } else if (case_two_choice == 3) {
                        System.out.println("Result: " + decimalToHex(octalToDecimal(octal)));
                    }

                    break;
                case 3:
                    System.out.print("Enter a number: ");
                    String decimalInput = scan.nextLine();

                    if (!isDecimal(decimalInput)) {
                        System.out.println("Invalid decimal number.\n");
                        continue;
                    }

                    int decimal = Integer.parseInt(decimalInput);

                    System.out.print("Decimal to... \n" +
                            "1 - BINARY\n" +
                            "2 - OCTAL\n" +
                            "3 - HEXADECIMAL\n" +
                            "> ");
                    int case_three_choice = readInt(scan);

                    if (case_three_choice == 1) {
                        System.out.println("Result: " + decimalToBinary(decimal));
                    } else if (case_three_choice == 2) {
                        System.out.println("Result: " + decimalToOctal(decimal));
                    } else if (case_three_choice == 3) {
                        System.out.println("Result: " + decimalToHex(decimal));
                    }

                    break;
                case 4:
                    System.out.print("Enter a number: ");
                    String hex_decimal = scan.nextLine();
                    if (!isHex(hex_decimal)) {
                        System.out.println("Invalid hexadecimal number.\n");
                        continue;
                    }

                    System.out.print("Hexadecimal to... \n" +
                            "1 - BINARY\n" +
                            "2 - OCTAL\n" +
                            "3 - DECIMAL\n" +
                            "> ");
                    int case_four_choice = readInt(scan);

                    if (case_four_choice == 1) {
                        System.out.println("Result: " + decimalToBinary((hexToDecimal(hex_decimal))));
                    } else if (case_four_choice == 2) {
                        System.out.println("Result: " + decimalToOctal(hexToDecimal(hex_decimal)));
                    } else if (case_four_choice == 3) {
                        System.out.println("Result: " + hexToDecimal(hex_decimal));
                    }

                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            System.out.println("Do you want to continue? [Y/N]");
            String answer = scan.nextLine();

            if (!answer.equalsIgnoreCase("Y")) {
                System.out.println("Exiting...");
                break;
            }

        }

        scan.close();
    }
}
