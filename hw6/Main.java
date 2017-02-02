import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws UnsupportedFileExn, FileNotFoundException {
        LinkedList<String> init=new LinkedList<>();
        SearchEngine B= new SearchEngine(init);
        BrowserWindow C=new BrowserWindow(B);
        C.screen();
    }

}
