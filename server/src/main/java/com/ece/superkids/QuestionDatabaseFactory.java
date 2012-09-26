package com.ece.superkids;

public final class QuestionDatabaseFactory {

    static QuestionDatabase questionDatabase;

    /**
     * Factory method to get the question database. Since the database can be expensive to load,
     * we create it in a singleton pattern.
     *
     * @return the question database
     */
    public static QuestionDatabase aQuestionDatabase() {
        if (questionDatabase == null) {
            questionDatabase = new FileQuestionDatabase();
        }
        return questionDatabase;
    }
}
