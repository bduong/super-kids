package com.ece.superkids;

import com.ece.superkids.builders.QuestionBuilder;
import com.ece.superkids.entities.Question;
import com.ece.superkids.enums.QuestionLevel;
import com.ece.superkids.enums.QuestionType;

public class FileQuestionDatabase implements QuestionDatabase{

    public Question getQuestion(final QuestionLevel level, final int number) {
        return QuestionBuilder.aQuestion()
                .asking("What has four sides?")
                .ofType(QuestionType.TEXT)
                .withChoices("Square", "Circle", "Triangle", "Oval")
                .withAnswer("Square")
                .withExplaination("A square has four equal sides")
                .build();
    }
}
