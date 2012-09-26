package com.ece.superkids;

import com.ece.superkids.entities.Question;
import com.ece.superkids.enums.QuestionLevel;

public class FileQuestionDatabase implements QuestionDatabase{

    public Question getQuestion(final QuestionLevel level, final int number) {
        return new Question();
    }
}
