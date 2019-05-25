import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a list of words separated by whitespace.");
        String list = scan.nextLine();
        WordCounter count = new WordCounter();
        count.setWordCount(list);
        System.out.println(count.getWordCount());
    }
}
