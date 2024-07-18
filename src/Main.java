import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int count = 0;
        while (true){
            System.out.println("Введите путь к файлу");
            String path = new Scanner(System.in).nextLine();
            File file  = new File(path);
            boolean fileExist = file.exists();
            boolean isDirectory = file.isDirectory();
            if (!fileExist || file.isDirectory()) {
                System.out.println("Указанного файла не существует или указанный путь является путём к папке, а не к файлу.");
                //continue;
            }
            else {
                count++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + count);}
            //break;
        }

    }
}
