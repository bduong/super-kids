package com.ece.superkids;

import com.ece.superkids.entities.Question;
import com.ece.superkids.enums.QuestionCategory;
import com.ece.superkids.enums.QuestionLevel;

public interface QuestionManager {

    public void addQuestion(Question question);

    public void deleteQuestion(Question question);

    public void editQuestion(Question oldQuestion, Question newQuestion);
}
