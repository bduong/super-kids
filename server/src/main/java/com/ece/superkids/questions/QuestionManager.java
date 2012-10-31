package com.ece.superkids.questions;

import com.ece.superkids.questions.entities.Question;

public interface QuestionManager {

    public void addQuestion(Question question);

    public void deleteQuestion(Question question);

    public void editQuestion(Question oldQuestion, Question newQuestion);
}
