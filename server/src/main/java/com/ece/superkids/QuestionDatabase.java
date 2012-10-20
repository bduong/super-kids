package com.ece.superkids;

import com.ece.superkids.entities.Question;
import com.ece.superkids.enums.QuestionCategory;
import com.ece.superkids.enums.QuestionLevel;

public interface QuestionDatabase {

    public Question getQuestion(QuestionLevel level, QuestionCategory category, int number);

    public void saveQuestion(QuestionLevel level, QuestionCategory category, Question question);

	public int getNumberOfQuestions(QuestionLevel level, QuestionCategory category);

	public int getNumberOfQuestions(QuestionLevel level);
}
