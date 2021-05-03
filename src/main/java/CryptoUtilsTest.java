import java.io.File;
import org.apache.commons.io.FilenameUtils;

public class CryptoUtilsTest {
    public static void main(String[] args) {
        String username = System.getProperty("user.name");
        String file = "C:\\Users\\" + username + "\\Documents\\criptografia";
        String key = "Arquivo seguro!!";
        File inputFile = new File(file);
        try {
            for (final File fileEntry : inputFile.listFiles()) {
                String encryptedFilePath =  "C:\\Users\\" + username + "\\Documents\\criptografia\\encrypt\\";
                if(!new File(encryptedFilePath).exists()){
                    new File(encryptedFilePath).mkdir();
                }
                String decryptedFilePath = "C:\\Users\\" + username + "\\Documents\\criptografia\\decrypt\\";
                if(!new File(decryptedFilePath).exists()){
                    new File(decryptedFilePath).mkdir();
                }

                File encryptedFile = new File(encryptedFilePath + fileEntry.getName() + ".Encrypted");
                File decryptedFile = new File( decryptedFilePath + fileEntry.getName() + ".Decrypted.");
                if (!fileEntry.isDirectory()) {
                    String extension = FilenameUtils.getExtension(file + fileEntry.getName());
                    CryptoUtils.encrypt(key, new File(inputFile + "\\" + fileEntry.getName()), encryptedFile);
                    CryptoUtils.decrypt(key, encryptedFile, new File(decryptedFile + extension));
                }
            }

        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}