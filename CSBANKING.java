import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSBANKING {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File accountsFile = new File("D:\\User\\Documents\\Project\\ITC\\CSBANKING\\accounts.txt");
        String choice;
        System.out.println("=== CSBANKING ===");
        System.out.println("1. Login\n2. Create an Account\n3. Exit\nEnter Choice: ");
        choice = input.nextLine();
        while (true) {
        switch (choice) {
            case "1":
                System.out.println("Login selected.");
                // LOGIN DITO NEXT TIME NA PAGTAPOS NG CREATE ACCOUNT
                break;
            case "2":
                try {
                    if (!accountsFile.exists()) {
                         accountsFile.createNewFile();
                         }
                    System.out.print("Enter username: ");
                    String username = input.nextLine();

                    if (username.trim().isEmpty()) {
                        System.out.println("No input provided for username.");
                    break;
            }

                Scanner finder = new Scanner(accountsFile);
                boolean exists = false;
                while (finder.hasNextLine()) {
                    String line = finder.nextLine();
                    if (!line.isBlank() && line.split(",")[0].equals(username)) {
                    exists = true;
                    break;
            }
                }
                finder.close();
            if (username.contains(",") || username.contains(" ") || username.contains("=") || username.contains("+") || username.contains("-") || username.contains("*") || username.contains("/") || username.contains("%") || username.contains("&") || username.contains("|") || username.contains("^") || username.contains("~") || username.contains("!") || username.contains("@") || username.contains("#") || username.contains("$") || username.contains("(") || username.contains(")") || username.contains("{") || username.contains("}") || username.contains("[") || username.contains("]") || username.contains("<") || username.contains(">") || username.contains("?") || username.contains(":") || username.contains(";") || username.contains("'") || username.contains("\"") || username.contains("\\") || username.contains("`")|| username.contains("\"")) {
                    System.out.println("Username cannot contain special characters. Please choose a different username.");
                    break; 
                }
                if (exists) {
                System.out.println("Username already exists. Please choose a different username.");
                break; 
                }

        System.out.print("Enter password: ");
        String password = input.nextLine();

        FileWriter writer = new FileWriter(accountsFile, true);
        writer.write(username + "," + password + "\n");
        writer.close();
        System.out.println("Account created successfully.");
        break;
    }
    catch (FileNotFoundException e) {
        System.out.println("Accounts not found.");
    }
    catch (IOException e) {
        System.out.println("An error occurred while creating the account.");
    }
    break;

            case "3":
                System.out.println("Exiting the program.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    }
}
