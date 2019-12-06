import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RotateFromTextFile {
    private String dataFromFile;

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("sonnet18.txt").getFile());
        StringBuilder result = new StringBuilder();

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return result.toString();
    }

    private void encryptFile(){
        dataFromFile = loadFile();
       // ROT13 rot13 = new ROT13(dataFromFile);

    }

    private void decryptFile(){

    }
}
