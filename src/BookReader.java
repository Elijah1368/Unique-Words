import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BookReader {
    public String book;
    public MyLinkedList<String> words;


    public BookReader(String filename) {
        readBook(filename);
        parseWords();
    }

    public void readBook(String filename){
        long start = System.currentTimeMillis();
        StringBuilder bookBuilder = new StringBuilder();
        try {
            FileReader fr = new FileReader(filename);   
            BufferedReader br = new BufferedReader(fr);  
            int c = 0;             
            while((c = br.read()) != -1)        
            {
                bookBuilder.append((char) c);
            }

        } catch (IOException e){
            System.out.println("invalid input: " + e);
        }

        book = bookBuilder.toString();
        long time = System.currentTimeMillis() - start;
        System.out.println("Time elapsed in (ms): " + time);
    }
    
    public void parseWords(){
     
        words = new MyLinkedList<>();

        Pattern p = Pattern.compile("[^a-zA-Z0-9' ]");
        book = p.matcher(book).replaceAll(" ").toLowerCase();
        Scanner sc = new Scanner(book).useDelimiter("\\s+");    
        
        while (sc.hasNext()) {
            words.addBefore(sc.next());
        }
       
        sc.close();

    }
    
}
