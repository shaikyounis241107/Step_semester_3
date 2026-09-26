import java.util.*;

abstract class Question {
    String question;
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String question, String correctAnswer,
             String studentAnswer, double points) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String q, String c, String s, double p) {
        super(q, c, s, p);
    }

    double grade() {
        return studentAnswer.equalsIgnoreCase(correctAnswer)
                ? points : 0;
    }
}

class TF extends Question {
    TF(String q, String c, String s, double p) {
        super(q, c, s, p);
    }

    double grade() {
        return studentAnswer.equalsIgnoreCase(correctAnswer)
                ? points : 0;
    }
}

class Essay extends Question {
    Essay(String q, String c, String s, double p) {
        super(q, c, s, p);
    }

    double grade() {
        String answer = studentAnswer.toLowerCase();
        String[] keywords = correctAnswer.split(",");

        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2)
            return points * 0.75;
        else if (count == 1)
            return points * 0.50;
        else
            return 0;
    }
}

public class Main {

    static List<String> extractQuoted(String line) {
        List<String> result = new ArrayList<>();

        boolean inside = false;
        StringBuilder current = new StringBuilder();

        for (char ch : line.toCharArray()) {
            if (ch == '"') {
                if (inside) {
                    result.add(current.toString());
                    current.setLength(0);
                }

                inside = !inside;
            } 
            else if (inside) {
                current.append(ch);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String type = line.substring(0, line.indexOf(' '));
            List<String> data = extractQuoted(line);

            double points =
                Double.parseDouble(data.get(3));

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQ(
                    data.get(0),
                    data.get(1),
                    data.get(2),
                    points
                );
            } 
            else if (type.equals("TF")) {
                question = new TF(
                    data.get(0),
                    data.get(1),
                    data.get(2),
                    points
                );
            } 
            else {
                question = new Essay(
                    data.get(0),
                    data.get(1),
                    data.get(2),
                    points
                );
            }

            double score = question.grade();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}
