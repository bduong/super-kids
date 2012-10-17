package com.ece.superkids.testing;

import com.ece.superkids.QuestionDatabase;
import com.ece.superkids.QuestionDatabaseFactory;
import com.ece.superkids.builders.QuestionBuilder;
import com.ece.superkids.entities.Question;
import com.ece.superkids.enums.QuestionCategory;
import com.ece.superkids.enums.QuestionLevel;
import com.ece.superkids.enums.QuestionType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestionDatabaseTests {

    QuestionDatabase questionDatabase;
    private Question expected;

    @Before
    public void setup() {
        questionDatabase = QuestionDatabaseFactory.aQuestionDatabase();
        expected = QuestionBuilder.aQuestion()
                .asking("What has four sides?")
                .ofType(QuestionType.TEXT)
                .withChoices("Square", "Circle", "Triangle", "Oval")
                .withAnswer("Square")
                .withExplaination("A square has four equal sides")
                .ofLevel(QuestionLevel.LEVEL_1)
                .inCategory(QuestionCategory.SHAPES)
                .build();
    }

//    @Test
//    public void questionDatabaseReturnsKnownValue() {
//        Question question = questionDatabase.getQuestion(QuestionLevel.LEVEL_1, 1);
//        assertEquals(expected, question);
//    }

    @Test
    public void writeToJSONWorksCorrectly() {
//        questionDatabase.saveQuestion(QuestionLevel.LEVEL_1, 1, expected);
        Question actual = questionDatabase.getQuestion(QuestionLevel.LEVEL_1, QuestionCategory.SHAPES, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void listQuestions() {
        System.out.println(questionDatabase.getQuestion(QuestionLevel.LEVEL_1, QuestionCategory.SHAPES, 2).getQuestion());
        System.out.println(questionDatabase.getQuestion(QuestionLevel.LEVEL_1, QuestionCategory.PLANETS, 2).getQuestion());
    }
}
