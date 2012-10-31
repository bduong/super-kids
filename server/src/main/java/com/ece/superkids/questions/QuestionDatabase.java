package com.ece.superkids.questions;

import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionCategory;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.enums.QuestionMode;

public interface QuestionDatabase {

    public Question getQuestion(QuestionLevel level, QuestionCategory category, int number);

    public void saveQuestion(QuestionLevel level, QuestionCategory category, Question question);

	public int getNumberOfQuestions(QuestionLevel level, QuestionCategory category);

	public int getNumberOfQuestions(QuestionLevel level);

    public void switchMode(QuestionMode mode);

    public int getQuestionNumber(Question question);
}
