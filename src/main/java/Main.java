import java.io.File;

public class Main {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\Lucas\\Documents\\criptografia");
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                System.out.println("É um diretorio");
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }
}
