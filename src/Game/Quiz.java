package Game;

import Model.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private int score;
    private static Quiz instance;

    private Quiz() {
        this.questions = initQuestions();
        this.score = 0;
    }

    public static Quiz getInstance() {
        if (instance == null) {
            instance = new Quiz();
        }
        return instance;
    }

    private List<Question> initQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question.QuestionBuilder("Quelle est la capitale de la France ?")
                .options(Arrays.asList("Paris", "Lyon", "Marseille"))
                .correctAnswer("Paris")
                .build());
        questions.add(new Question.QuestionBuilder("Qui est l'auteur de 'Les Misérables' ?")
                .options(Arrays.asList("Victor Hugo", "Albert Camus", "Émile Zola"))
                .correctAnswer("Victor Hugo")
                .build());
        questions.add(new Question.QuestionBuilder("Quel est le plus grand océan du monde ?")
                .options(Arrays.asList("Océan Atlantique", "Océan Pacifique", "Océan Indien"))
                .correctAnswer("Océan Pacifique")
                .build());
        questions.add(new Question.QuestionBuilder("En quelle année l'homme a-t-il marché sur la Lune pour la première fois ?")
                .options(Arrays.asList("1969", "1972", "1965"))
                .correctAnswer("1969")
                .build());
        questions.add(new Question.QuestionBuilder("Quel est le métal dont le symbole chimique est 'Au' ?")
                .options(Arrays.asList("Argent", "Or", "Platine"))
                .correctAnswer("Or")
                .build());
        questions.add(new Question.QuestionBuilder("Qui a écrit 'Romeo et Juliette' ?")
                .options(Arrays.asList("William Shakespeare", "Charles Dickens", "Jane Austen"))
                .correctAnswer("William Shakespeare")
                .build());
        questions.add(new Question.QuestionBuilder("Quelle est la molécule principale de l'eau ?")
                .options(Arrays.asList("CO2", "H2O", "O2"))
                .correctAnswer("H2O")
                .build());
        questions.add(new Question.QuestionBuilder("Quelle est la couleur résultant du mélange du rouge et du bleu ?")
                .options(Arrays.asList("Violet", "Vert", "Orange"))
                .correctAnswer("Violet")
                .build());
        questions.add(new Question.QuestionBuilder("Quel est le plus grand pays du monde en superficie ?")
                .options(Arrays.asList("États-Unis", "Chine", "Russie"))
                .correctAnswer("Russie")
                .build());
        questions.add(new Question.QuestionBuilder("Qui est le fondateur de Microsoft ?")
                .options(Arrays.asList("Steve Jobs", "Bill Gates", "Mark Zuckerberg"))
                .correctAnswer("Bill Gates")
                .build());

        return questions;
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