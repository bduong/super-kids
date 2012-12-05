package com.ece.superkids.questions;

import com.ece.superkids.images.FileImageManager;
import com.ece.superkids.images.ImageManager;
import com.ece.superkids.questions.enums.QuestionMode;

/**
 * The <code>QuestionDatabaseFactory</code> allows the creation of question databases and database managers.
 *
 * @author Ben Duong
 */
public final class QuestionDatabaseFactory {

    private static QuestionDatabase questionDatabase;
    private static QuestionManager questionManager;
    private static ImageManager imageManager;

    /**
     * Factory method to get the question database. Since the database can be expensive to load,
     * we create it in a singleton pattern.
     *
     * This database contains both default and custom questions.
     *
     * @return The question database.
     */
    public static QuestionDatabase aQuestionDatabaseWithAllQuestions() {
        if (questionDatabase == null) {
            questionDatabase = new FileQuestionDatabase(QuestionMode.ALL);
        } else {
            questionDatabase.switchMode(QuestionMode.ALL);
        }
        return questionDatabase;
    }

    /**
     * Factory method to get the question database. Since the database can be expensive to load,
     * we create it in a singleton pattern.
     *
     * This database contains only default questions.
     *
     * @return The question database.
     */
    public static QuestionDatabase aQuestionDatabaseWithOnlyDefaultQuestions() {
        if (questionDatabase == null) {
            questionDatabase = new FileQuestionDatabase(QuestionMode.DEFAULT_ONLY);
        } else {
            questionDatabase.switchMode(QuestionMode.DEFAULT_ONLY);
        }
        return questionDatabase;
    }

    /**
     * Factory method to get the question database. Since the database can be expensive to load,
     * we create it in a singleton pattern.
     *
     * This database contains only custom questions.
     *
     * @return The question database.
     */
    public static QuestionDatabase aQuestionDatabaseWithOnlyCustomQuestions() {
        if (questionDatabase == null) {
            questionDatabase = new FileQuestionDatabase(QuestionMode.CUSTOM_ONLY);
        } else {
            questionDatabase.switchMode(QuestionMode.CUSTOM_ONLY);
        }
        return questionDatabase;
    }

    /**
     * Factory method to get the question manager.
     *
     * @return The question manager.
     */
    public static QuestionManager aQuestionManager() {
        if(questionManager == null) {
            questionManager = new FileQuestionManager();
        }
        return questionManager;
    }

    /**
     * Factory method to get the custom image manager.
     *
     * @return The image manager.
     */
    public static ImageManager anImageManager() {
        if (imageManager == null) {
            imageManager = new FileImageManager();
        }
        return imageManager;
    }
}
