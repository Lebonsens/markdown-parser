import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;
import javax.swing.text.AbstractDocument.Content;

import org.junit.*;
public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void mytest() throws IOException{
        Path filepath = Paths.get("C:\\Users\\wei\\Documents\\GitHub\\markdown-parser\\test-file.md");
        String content =  Files.readString(filepath);
    

        ArrayList<String> res = MarkdownParse.getLinks(content);

        List<String> ans = List.of("https://something.com","some-thing.html");
        assertEquals(res,ans);

    }

    @Test
    public void mytest2() throws IOException{
        Path filepath = Paths.get("C:\\Users\\wei\\Documents\\GitHub\\markdown-parser\\test-file2.md");
        String content =  Files.readString(filepath);
    

        ArrayList<String> res = MarkdownParse.getLinks(content);

        List<String> ans = List.of("https://google.com","some-thing.html");
        assertEquals(res,ans);

    }
    

    @Test
    public void mytest3() throws IOException{
        Path filepath = Paths.get("C:\\Users\\wei\\Documents\\GitHub\\markdown-parser\\test-file3.md");
        String content =  Files.readString(filepath);
    

        ArrayList<String> res = MarkdownParse.getLinks(content);

        List<String> ans = List.of();
        assertEquals(res,ans);

    }

    @Test
    public void mytest4() throws IOException{
        Path filepath = Paths.get("C:\\Users\\wei\\Documents\\GitHub\\markdown-parser\\test-file4.md");
        String content =  Files.readString(filepath);
    

        ArrayList<String> res = MarkdownParse.getLinks(content);
        
        //List<String> ans = List.of("");
        assertEquals(res,new ArrayList<>());

    }//error

    @Test
    public void mytest5() throws IOException{
        Path filepath = Paths.get("C:\\Users\\wei\\Documents\\GitHub\\markdown-parser\\test-file5.md");
        String content =  Files.readString(filepath);
    

        ArrayList<String> res = MarkdownParse.getLinks(content);

        List<String> ans = List.of();
        assertEquals(res,ans);

    }

    @Test
    public void mytest6() throws IOException{
        Path filepath = Paths.get("C:\\Users\\wei\\Documents\\GitHub\\markdown-parser\\test-file6.md");
        String content =  Files.readString(filepath);
    

        ArrayList<String> res = MarkdownParse.getLinks(content);

        List<String> ans = List.of("cool.com");
        assertEquals(res,ans);

    }

    @Test
    public void mytest7() throws IOException{
        Path filepath = Paths.get("C:\\Users\\wei\\Documents\\GitHub\\markdown-parser\\test-file7.md");
        String content =  Files.readString(filepath);
    

        ArrayList<String> res = MarkdownParse.getLinks(content);

        //List<String> ans = List.of("");
        //System.out.println("here");
        //System.out.println(res);
        assertEquals(new ArrayList<>(),res);

    }

    @Test
    public void mytest8() throws IOException{
        Path filepath = Paths.get("C:\\Users\\wei\\Documents\\GitHub\\markdown-parser\\test-file8.md");
        String content =  Files.readString(filepath);
    

        ArrayList<String> res = MarkdownParse.getLinks(content);

        List<String> ans = List.of("a link on the first line");
        assertEquals(res,ans);

    }

    @Test
    public void mytest9() {
        String contents = "[title]   (should-not-count.com)";
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }




}


