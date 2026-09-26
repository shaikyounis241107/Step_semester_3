class Scorecard {
    private boolean[] answers;
    private int count;

    Scorecard(int questions) {
        answers = new boolean[questions];
        count = 0;
    }

    void recordAnswer(boolean answer) {
        if (count < answers.length) {
            answers[count] = answer;
            count++;
        }
    }

    int getScore() {
        int score = 0;

        for (boolean answer : answers) {
            if (answer) {
                score++;
            }
        }

        return score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score = " + sc.getScore());
    }
}
