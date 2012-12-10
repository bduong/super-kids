package com.ece.superkids.testing;

import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionCategory;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.enums.QuestionType;
import com.ece.superkids.users.entities.User;
import com.ece.superkids.users.entities.History;
import com.ece.superkids.users.entities.State;

import java.util.ArrayList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The <code>MaxScoreTest</code> has tests to check if the maximum scores are being fetched from the history correctly, and check if the total score is being computed correctly.
 *
 * @author Marc Adam
 */
public class MaxScoreTest {

    private User user;
    
    /**
     * Generate a fake random question.
     * @param questionLevel Level for the question.
     * @param questionCategory Category for the question.
     * @return Question object.
     */
    private Question createRandomQuestion(QuestionLevel questionLevel, QuestionCategory questionCategory) {

        Question question = new Question();
        Random random = new Random();
        int randomInt = random.nextInt();
        question.setQuestion("Question " + randomInt);
        question.setAnswer("Answer " + randomInt);
        ArrayList choices = new ArrayList();
        choices.add("Choice 1");
        choices.add("Choice 2");
        choices.add("Choice 3");
        choices.add("Choice 4");
        question.setChoices(choices);
        question.setExplaination("This is a test question");
        question.setLevel(questionLevel);
        question.setCategory(questionCategory);
        question.setType(QuestionType.TEXT);

        return question;
    }

    /**
     * Create test user.
     */
    @Before
    public void setup() {
        user = new User("ScoreMaximizer");
    }

    /**
     * Have the user do several attempts for the same category and level, and check for the maximum score.
     */
    @Test
    public void TestMaximumScore() {
        /* repeat same category and level 3 times */
        QuestionLevel questionLevel = QuestionLevel.LEVEL_1;
        QuestionCategory questionCategory = QuestionCategory.ANIMALS;
        Random score = new Random();
        Integer maximumScore = 0;
        int currentScore;
        for(int i=0; i<3; i++) {
            currentScore = 0;
            user.newState(questionCategory, questionLevel);
            for(int j=0; j<6; j++) {
                Question question = createRandomQuestion(questionLevel, questionCategory);
                int currentQuestionScore = score.nextInt(10);
                user.saveScore(question, currentQuestionScore);
                currentScore+= currentQuestionScore;
            }
            if(currentScore>maximumScore) {
                maximumScore = currentScore;
            }
            user.endState();
        }
        History history = user.getHistory();
        State state = history.getMaximumScoreState(questionCategory, questionLevel);
        Integer actualScore = state.getTotalScore();
        assertEquals(actualScore, maximumScore);


        /* create a state with different level and different category */
        questionLevel = QuestionLevel.LEVEL_2;
        questionCategory = QuestionCategory.FOOD;
        /* create state and add several questions to that state */
        user.newState(questionCategory, questionLevel);
        /* add 10 questions */
        int secondQuestionScore = 0;
        for (int i = 0; i < 10; i++) {
            Question question = createRandomQuestion(questionLevel, questionCategory);
            int currentQuestionScore = score.nextInt(10);
            user.saveScore(question, currentQuestionScore);
            secondQuestionScore += currentQuestionScore;
        }
        user.endState();

        int expectedMaximumTotalScore = secondQuestionScore + maximumScore;
        System.out.println("second question Score: " + secondQuestionScore);
        System.out.println("First Maximum score: " + maximumScore);
        int actualTotalScore = user.getTotalScore();
        assertEquals(actualTotalScore, expectedMaximumTotalScore);
    }

    /**
     * Delete the user from the database.
     */
    @After
    public void cleanup() {
        user.deleteUser();
    }
}
