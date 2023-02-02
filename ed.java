import java.util.Scanner;

public class ed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int exit=0;
        String name;

        // Encryption
        System.out.println("*******************************WELCOME TO MESSAGE ENCRYPTER -DECRYPTER*******************************");
        System.out.print("                                     Enter Your Name : ");
     while(exit!=404) {
        name = sc.nextLine();
         System.out.print("                                     Enter the message : ");
         String message = sc.nextLine();
         System.out.print("                                     Enter the shift value (1-25) : ");
         int shift = sc.nextInt();

         System.out.print("                                     Enter '1' for encrypt and '0' decrypt: ");
         int n = sc.nextInt();
         

         if (n == 1) {
//
             String encryptedMessage = encrypt(message, shift);
             System.out.println("                                     Encrypted message : " + encryptedMessage+"\n\n");
         }

         // Decryption
         else if (n == 0) {

//
             String decryptedMessage = decrypt(message, shift);
             System.out.println("                                     Decrypted message: " + decryptedMessage+"\n\n");
         }
         System.out.print("                                     Enter 404 to QUITE or any other key to CONTINUE : ");
         exit = sc.nextInt();
          

     }
      
        
     
    }

    public static String encrypt(String message, int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) (c + shift);
                if (Character.isLowerCase(message.charAt(i)) && c > 'z' || Character.isUpperCase(message.charAt(i)) && c > 'Z') {
                    c = (char) (c - 26);
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static String decrypt(String message, int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) (c - shift);
                if (Character.isLowerCase(message.charAt(i)) && c < 'a' || Character.isUpperCase(message.charAt(i)) && c < 'A') {
                    c = (char) (c + 26);
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
