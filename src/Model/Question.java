package Model;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private String correctAnswer;

    private Question(QuestionBuilder builder) {
        this.questionText = builder.questionText;
        this.options = builder.options;
        this.correctAnswer = builder.correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public static class QuestionBuilder {
        private String questionText;
        private List<String> options;
        private String correctAnswer;

        public QuestionBuilder(String questionText) {
            this.questionText = questionText;
        }

        public QuestionBuilder options(List<String> options) {
            this.options = options;
            return this;
        }

        public QuestionBuilder correctAnswer(String correctAnswer) {
            this.correctAnswer = correctAnswer;
            return this;
        }

        public Question build() {
            return new Question(this);
        }
    }
}
