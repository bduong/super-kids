/**
 * @author M4rc Adam
 */
package com.ece.superkids.testing;

import java.util.Random;
import com.ece.superkids.questions.entities.Question;
import java.util.Arrays;
import java.util.ArrayList;
import com.ece.superkids.questions.enums.QuestionCategory;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.enums.QuestionType;
import com.ece.superkids.users.entities.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class OverallGameTests {

    User user;
    
    /* whenever new categories are added these lists need to be updated, else the history won't be able to know if the user is done with the level */
    private QuestionCategory level1Categories[] = {QuestionCategory.SHAPES, QuestionCategory.COLORS, QuestionCategory.ANIMALS};
    private QuestionCategory level2Categories[] = {QuestionCategory.FOOD, QuestionCategory.GEOGRAPHY, QuestionCategory.PLANETS};
    private QuestionCategory level3Categories[] = {QuestionCategory.STATIONARY, QuestionCategory.INSTRUMENTS, QuestionCategory.BODYPARTS};

    /* whenever new levels are added this needs to be updated, else the history won't be able to know if the user is done with the game */
    private QuestionLevel gameLevels[] = {QuestionLevel.LEVEL_1, QuestionLevel.LEVEL_2, QuestionLevel.LEVEL_3};
    
    @Before
    public void setup() {
        user = new User("GameTester");
    }

    @Test
    public void gameStarted() {
        boolean gameStarted = user.isGameOn();
        assertFalse(gameStarted);
        user.newGame();
        assertTrue(user.isGameOn());
    }
    @Test
    public void answerEverything() {
        ArrayList<QuestionCategory> categories1 = new ArrayList<QuestionCategory>(Arrays.asList(level1Categories));
        ArrayList<QuestionCategory> categories2 = new ArrayList<QuestionCategory>(Arrays.asList(level2Categories));
        ArrayList<QuestionCategory> categories3 = new ArrayList<QuestionCategory>(Arrays.asList(level3Categories));
        ArrayList<QuestionLevel> levels = new ArrayList<QuestionLevel>(Arrays.asList(gameLevels));

        Random random = new Random();
        for (int i= 0; i < categories1.size(); i++) {
            user.newState(categories1.get(i), QuestionLevel.LEVEL_1);
            Question question = createRandomQuestion(QuestionLevel.LEVEL_1, categories1.get(i));
            user.saveScore(question, random.nextInt());
            user.endState();
        }

        /* check if level 1 is completed successfully */
        assertTrue(user.isLevelFinished(QuestionLevel.LEVEL_1));
        for (int i= 0; i < categories2.size(); i++) {
            user.newState(categories2.get(i), QuestionLevel.LEVEL_2);
            Question question = createRandomQuestion(QuestionLevel.LEVEL_2, categories1.get(i));
            user.saveScore(question, random.nextInt());
            user.endState();
        }

        /* check if level 2 is completed successfully */
        assertTrue(user.isLevelFinished(QuestionLevel.LEVEL_2));
        for (int i= 0; i < categories3.size(); i++) {
            user.newState(categories3.get(i), QuestionLevel.LEVEL_3);
            Question question = createRandomQuestion(QuestionLevel.LEVEL_3, categories1.get(i));
            user.saveScore(question, random.nextInt());
            user.endState();
        }

         /* check if level 3 is completed successfully */
        assertTrue(user.isLevelFinished(QuestionLevel.LEVEL_3));

        /* check if whole game is completed successfully */
        assertFalse(user.isGameOn());
    }

    @After
    public void cleanUp() {
        user.deleteUser();
    }


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

}
