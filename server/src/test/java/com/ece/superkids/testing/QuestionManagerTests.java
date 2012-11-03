package com.ece.superkids.testing;

import com.ece.superkids.questions.QuestionDatabase;
import com.ece.superkids.questions.QuestionDatabaseFactory;
import com.ece.superkids.questions.QuestionManager;
import com.ece.superkids.questions.builders.QuestionBuilder;
import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionCategory;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.enums.QuestionMode;
import com.ece.superkids.questions.enums.QuestionType;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class QuestionManagerTests {

    private QuestionDatabase questionDatabase;
    private QuestionManager questionManager;
    private Question question;

    @Before
    public void setup() {
        questionDatabase = QuestionDatabaseFactory.aQuestionDatabaseWithOnlyCustomQuestions();
        questionManager = QuestionDatabaseFactory.aQuestionManager();
        question = QuestionBuilder.aQuestion()
                .asking("What has four sides?")
                .ofType(QuestionType.TEXT)
                .withChoices("Square", "Circle", "Triangle", "Oval")
                .withAnswer("Square")
                .withExplaination("A square has four equal sides")
                .ofLevel(QuestionLevel.LEVEL_1)
                .inCategory(QuestionCategory.SHAPES)
                .build();
    }

    @Test
    public void canAddQuestion() {
        questionManager.addQuestion(question);
        questionDatabase.switchMode(QuestionMode.CUSTOM_ONLY);
        int number = questionDatabase.getNumberOfQuestions(question.getLevel()) - 1;
        Question loadedQuestion = questionDatabase.getQuestion(question.getLevel(), question.getCategory(), number);
        assertEquals("Questions do not match", question, loadedQuestion);
        questionManager.deleteQuestion(question);
    }
}
