import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Scanner;

public class FileEncryption {

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }

    public static byte[] encryptFile(byte[] fileData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(fileData);
    }

    public static byte[] decryptFile(byte[] encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(encryptedData);
    }

    public static void saveToFile(String fileName, byte[] data) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(data);
        }
    }

    public static byte[] readFromFile(String filePath) throws Exception {
        File file = new File(filePath);
        return Files.readAllBytes(file.toPath());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:\n1. Encrypt a file\n2. Decrypt a file");
        int choice = scanner.nextInt();
        scanner.nextLine();

        try {
            if (choice == 1) {
                System.out.print("Enter the path of the file to encrypt: ");
                String filePath = scanner.nextLine();
                SecretKey key = generateKey();
                byte[] fileData = readFromFile(filePath);
                byte[] encryptedData = encryptFile(fileData, key);

                System.out.print("Enter name for encrypted file: ");
                String encryptedFileName = scanner.nextLine();
                saveToFile(encryptedFileName, encryptedData);

                System.out.println("File encrypted and saved as: " + encryptedFileName);
                System.out.println("Encryption Key (Base64): " + Base64.getEncoder().encodeToString(key.getEncoded()));
            } else if (choice == 2) {
                System.out.print("Enter the path of the file to decrypt: ");
                String filePath = scanner.nextLine();
                System.out.print("Enter the key for decryption (Base64): ");
                String keyString = scanner.nextLine();
                SecretKey key = new SecretKeySpec(Base64.getDecoder().decode(keyString), "AES");

                byte[] encryptedData = readFromFile(filePath);
                byte[] decryptedData = decryptFile(encryptedData, key);

                System.out.print("Enter name for decrypted file: ");
                String decryptedFileName = scanner.nextLine();
                saveToFile(decryptedFileName, decryptedData);

                System.out.println("File decrypted and saved as: " + decryptedFileName);
            } else {
                System.out.println("Invalid choice. Please select either 1 or 2.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
// clX+RX3Rt74GusQHCFjY5PwdrKnZNRhuTlCsdcomRQA=