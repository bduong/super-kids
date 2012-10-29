package com.ece.superkids;

import com.ece.superkids.entities.Question;
import com.ece.superkids.enums.QuestionCategory;
import com.ece.superkids.enums.QuestionLevel;

public interface QuestionManager {

    public void addQuestion(QuestionLevel level, QuestionCategory category, Question question);

    public void deleteQuestion(QuestionLevel level, QuestionCategory category, int questionNumber);

    public void editQuestion(QuestionLevel level, QuestionCategory category, int questionNumber, Question question);
}
