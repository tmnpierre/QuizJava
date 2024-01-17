package Game;

import Model.Question;

import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private int score;
    private static Quiz instance;

    private Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public static Quiz getInstance(List<Question> questions) {
        if (instance == null) {
            instance = new Quiz(questions);
        }
        return instance;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            int index = 1;
            for (String option : question.getOptions()) {
                System.out.println(index++ + ": " + option);
            }
            System.out.print("Votre réponse (numéro) : ");
            int answer = scanner.nextInt();
            if (question.getOptions().get(answer - 1).equals(question.getCorrectAnswer())) {
                score++;
            }
        }
        scanner.close();
        System.out.println("Votre score est : " + score + "/" + questions.size());
    }
}
