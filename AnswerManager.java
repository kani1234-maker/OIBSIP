public class AnswerManager {

    private int[] selectedAnswers;

    public AnswerManager(int totalQuestions) {

        selectedAnswers = new int[totalQuestions];

        for (int i = 0; i < totalQuestions; i++) {
            selectedAnswers[i] = -1;
        }
    }

    public void saveAnswer(int questionIndex, int answerIndex) {
        selectedAnswers[questionIndex] = answerIndex;
    }

    public int getAnswer(int questionIndex) {
        return selectedAnswers[questionIndex];
    }

    public int[] getAllAnswers() {
        return selectedAnswers;
    }

}
