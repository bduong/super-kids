package com.ece.superkids;

import com.ece.superkids.entities.Question;
import com.ece.superkids.enums.QuestionLevel;

public interface QuestionDatabase {

    public Question getQuestion(QuestionLevel level, int number);

    public void saveQuestion(QuestionLevel level, int number, Question question);
}
