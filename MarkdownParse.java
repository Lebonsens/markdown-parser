//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if(closeParen == -1 || openBracket == -1|| openParen == -1 || closeBracket == -1|| currentIndex == -1){return toReturn;}
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            
            System.out.println(currentIndex+" currentIndex");
            System.out.println(closeParen+" closeParen");
            System.out.println(openBracket+" openBracket" );
            System.out.println(closeBracket+" closeBracket");
            if(openBracket!=0){
                if(markdown.charAt(openBracket-1)=='!'){toReturn.remove(toReturn.size()-1);};
            }
            
            if(markdown.charAt(closeBracket+1)!='('){toReturn.remove(toReturn.size()-1);};
            //
            //

            //
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
