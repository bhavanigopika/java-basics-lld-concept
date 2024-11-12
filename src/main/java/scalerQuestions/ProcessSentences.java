package scalerQuestions;

import java.util.Arrays;
import java.util.List;

public class ProcessSentences {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Java is a programming language.",
                "Python is also a good language.",
                "Java stream processing is powerful.",
                "C++ is not as popular as Java."
        );

        int averageLength = processSentences(sentences);
        System.out.println(averageLength);

        sentences = Arrays.asList(
                "Python is a programming language.",
                "JS is used for web development.",
                "Ruby is known for its simplicity.",
                "java is good"
        );

        averageLength = processSentences(sentences);
        System.out.println(averageLength);

        sentences = Arrays.asList(
                "Python is a programming language.",
                "JavaScript is used for web development.",
                "Ruby is known for its simplicity."
        );

        long wordCount = countWords(sentences);
        System.out.println(wordCount);
    }

    public static int processSentences(List<String> sentences) {
        //code here
        int ans = (int)sentences.stream()
                .filter(w -> w.contains("Java"))
                .mapToInt(String::length)
                .average()
                .orElse(0);
        return ans;
    }

    public static long countWords(List<String> sentences) {
        long ans = sentences.stream()
                .filter(w -> !w.contains("Java"))
                .map(z -> z.split("\\s+"))
                .flatMap(Arrays::stream)
                .distinct()
                .count();
        return ans;
    }

}
