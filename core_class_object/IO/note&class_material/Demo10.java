package zuoye;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Demo10 {
    public static void main(String[] args) throws IOException {
        //reader
        FileReader fr = new FileReader("b.txt");
        while (true){
            int c = fr.read();
            if(c==-1){
                break;
            }
            System.out.println((char)c);
        }
        char[] chars = new char[100];
        //fr.read(chars);
        System.out.println(chars[0]);

        fr.close();
    }
}
