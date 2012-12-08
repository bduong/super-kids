/**
 * @author M4rc Adam
 */
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

public class MaxScoreTest {

    private User user;
    
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

    @Before
    public void setup() {
        user = new User("ScoreMaximizer");
    }
    
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
                int currentQuestionScore = score.nextInt()%10;
                user.saveScore(question, currentQuestionScore);
                currentScore+= currentQuestionScore;
            }
            if(currentScore>maximumScore) {
                maximumScore = currentScore;
            }
            user.endState();
        }
        History history = user.getHistory();
        State state = history.getMaximumScore(questionCategory, questionLevel);
        Integer actualScore = state.getTotalScore();
        assertEquals(actualScore, maximumScore);

    }

    @After
    public void cleanup() {
        user.deleteUser();
    }
}
