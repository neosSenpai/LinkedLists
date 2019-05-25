import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    private Object wordCount;

    public WordCounter() {
    }

    public Object getWordCount() {
        return wordCount;
    }

    public void setWordCount(String list) {
        String l = list;
        String[] words = l.split(" ");
        Map<String, Integer> m = new HashMap<>();

        for (int i = 0; i < words.length; i++){
             int count = 1;
            for (int j = 0; j < words.length; j++){
                if(words[i].equals(words[j]) && i != j){
                    count++;
                    m.put(words[i],count);
                }
                else {
                    m.put(words[i],count);
                }
            }
        }
        wordCount = m;
    }
}
