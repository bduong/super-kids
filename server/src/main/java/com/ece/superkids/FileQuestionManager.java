package com.ece.superkids;

import com.ece.superkids.entities.Question;
import com.ece.superkids.enums.QuestionCategory;
import com.ece.superkids.enums.QuestionLevel;

public class FileQuestionManager implements QuestionManager{

    @Override
    public void addQuestion(final QuestionLevel level, final QuestionCategory category, final Question question) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteQuestion(final QuestionLevel level, final QuestionCategory category, final int questionNumber) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void editQuestion(final QuestionLevel level, final QuestionCategory category, final int questionNumber,
                             final Question question) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
