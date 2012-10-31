package com.ece.superkids;

import com.ece.superkids.enums.QuestionMode;

public final class QuestionDatabaseFactory {

    private static QuestionDatabase questionDatabase;
    private static QuestionManager questionManager;

    /**
     * Factory method to get the question database. Since the database can be expensive to load,
     * we create it in a singleton pattern.
     *
     * @return the question database
     */
    public static QuestionDatabase aQuestionDatabaseWithAllQuestions() {
        if (questionDatabase == null) {
            questionDatabase = new FileQuestionDatabase(QuestionMode.ALL);
        } else {
            questionDatabase.switchMode(QuestionMode.ALL);
        }
        return questionDatabase;
    }

    public static QuestionDatabase aQuestionDatabaseWithOnlyDefaultQuestions() {
        if (questionDatabase == null) {
            questionDatabase = new FileQuestionDatabase(QuestionMode.DEFAULT_ONLY);
        } else {
            questionDatabase.switchMode(QuestionMode.DEFAULT_ONLY);
        }
        return questionDatabase;
    }

    public static QuestionDatabase aQuestionDatabaseWithOnlyCustomQuestions() {
        if (questionDatabase == null) {
            questionDatabase = new FileQuestionDatabase(QuestionMode.CUSTOM_ONLY);
        } else {
            questionDatabase.switchMode(QuestionMode.CUSTOM_ONLY);
        }
        return questionDatabase;
    }

    public static QuestionManager aQuestionManager() {
        if(questionManager == null) {
            questionManager = new FileQuestionManager();
        }
        return questionManager;
    }
}
