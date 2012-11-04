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
import static org.junit.Assert.assertNull;


import com.ece.superkids.questions.entities.*;
import com.ece.superkids.questions.enums.*;

import com.ece.superkids.users.FileUserManager;
import com.ece.superkids.users.entities.User;

public class UserDatabaseTests {
    private FileUserManager fileUserManager = new FileUserManager();
    private User expected;

    private Question expectedQuestion;
    private QuestionLevel expectedLevel;

    @Before
    public void setup() {

        // setup user
        expected = new User("xuser");
        expected.setId(1234);

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
        expected.saveScore(expectedQuestion ,3);
        expected.setCurrentQuestion(expectedQuestion);
        expected.setCurrentLevel(expectedLevel);

        // create a new state
//        expected.newState(QuestionCategory.SHAPES, QuestionLevel.LEVEL_1);

        fileUserManager.addUser(expected);
    }

    @Test
    public void usersAreAdded() {
        User actual = fileUserManager.getUser("xuser");
        assertEquals(actual.getName(), expected.getName());
        assertEquals(actual.getId(), expected.getId());
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
    public void usersAreDeleted() {
        fileUserManager.deleteUser("xuser");
        User testUser = fileUserManager.getUser("xuser");
        assertEquals(testUser, null);
    }

}