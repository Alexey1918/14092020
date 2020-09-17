import java.io.File;
import java.util.Scanner;

public class Main {
    //    public static String folder; //лишнее
    public static void main(String[] args) {

        System.out.println("Введите путь папки");
        Scanner scanner = new Scanner(System.in);
        String folder = scanner.nextLine();
        System.out.println("Размер каталога - " + folderSize(new File(folder)) + " байт ");
        if(folderSize(new File(folder))>1024 && folderSize(new File(folder))<1024*1024){
            System.out.println("Размер папки - " + folderSize(new File(folder)) / 1024 + " Кб ");
        }else if(folderSize(new File(folder))>1024*1024 && folderSize(new File(folder))<1024*1024*1024){
            System.out.println("Размер папки - " + folderSize(new File(folder)) /1024/1024 + " Mб ");
        }else if (folderSize(new File(folder))>1024*1024*1024){
            System.out.println("Размер папки - " + folderSize(new File(folder)) /1024/1024/1024  + " Гб ");
        }
    }

    public static long folderSize(File folder) {
        long length = 0;
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                length += file.length();
            } else
                length += folderSize(file);
        }
        return length;
    }
}








