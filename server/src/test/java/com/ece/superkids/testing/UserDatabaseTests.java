/**
 * @author M4rc Adam
 */
package com.ece.superkids.testing;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import static org.junit.Assert.assertEquals;

import com.ece.superkids.questions.entities.*;
import com.ece.superkids.questions.enums.*;

import com.ece.superkids.users.FileUserManager;
import com.ece.superkids.users.entities.User;
import java.util.HashMap;
import java.util.Map;

public class UserDatabaseTests {
    private FileUserManager fileUserManager = new FileUserManager();
    private User expectedUser;

    private Question expectedQuestion;
    private QuestionLevel expectedLevel;

    @Before
    public void setup() {

        // setup user
        expectedUser = new User("xuser");
        expectedUser.setId(1234);

        // setup level
        expectedLevel = QuestionLevel.LEVEL_1;

        // setup question
        expectedQuestion = new Question();
        expectedQuestion.setAnswer("xanswer");
        expectedQuestion.setType(QuestionType.TEXT);
        expectedQuestion.setCategory(QuestionCategory.SHAPES);
        List<String> choices = new ArrayList();
        choices.add("apple");
        choices.add("orange");
        choices.add("banana");
        choices.add("cherry");
        expectedQuestion.setChoices(choices);
        expectedQuestion.setLevel(expectedLevel);
        expectedQuestion.setQuestion("xquestion");
        expectedQuestion.setExplaination("xplanation");

        // set current question and level for user
        expectedUser.setCurrentQuestion(expectedQuestion);
        expectedUser.setCurrentLevel(expectedLevel);

        // create a new state


        fileUserManager.addUser(expectedUser);
    }

    @Test
    public void usersAreAdded() {
        User actual = fileUserManager.getUser("xuser");
        assertEquals(actual.getName(), expectedUser.getName());
        assertEquals(actual.getId(), expectedUser.getId());
    }

    @Test
    public void statesAreSaved() {
        User actual = fileUserManager.getUser("xuser");
        Question actualQuestion = actual.getState().getCurrentQuestion();
        QuestionLevel actualLevel = actual.getState().getCurrentLevel();

        assertEquals(actualQuestion, expectedQuestion);
        assertEquals(actualLevel, expectedLevel);

    }



    @Test
    public void addScore() {
        Integer expectedScore = 4;
        expectedUser.saveScore(expectedQuestion, expectedScore);
        Map<Question, Integer> map = new HashMap();
        map = expectedUser.getState().getAllScores();
        Integer actualScore = map.get(expectedQuestion);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void newState() {

    }

    @Test
    public void checkHistory() {
        
    }
    
    @After
    public void usersAreDeleted() {
        fileUserManager.deleteUser("xuser");
        User testUser = fileUserManager.getUser("xuser");
        assertEquals(testUser, null);
    }


}