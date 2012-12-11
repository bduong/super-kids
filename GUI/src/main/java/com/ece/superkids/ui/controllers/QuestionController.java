package com.ece.superkids.ui.controllers;

import com.ece.superkids.questions.QuestionDatabase;
import com.ece.superkids.questions.QuestionDatabaseFactory;
import com.ece.superkids.questions.QuestionManager;
import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionCategory;
import com.ece.superkids.questions.enums.QuestionLevel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.ece.superkids.ui.user.panels.QuestionPanel;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The <code>QuestionController</code> controls the questions 
 *
 * @author baris
 */
public class QuestionController {

    private int count;
    private QuestionPanel qPanel;

    private QuestionController() {
        count = 0;
    }

    private static class QuestionBaseHolder {

        public static final QuestionController INSTANCE = new QuestionController();
    }

    public static QuestionController getInstance() {
        return QuestionBaseHolder.INSTANCE;
    }

    /**
     *resets count, this is called switching between categories in subjectselectionframe
     * 
     */
    public void reset() {
        count = 0;
    }
    
    /**
     * sets the count
     * @param number number to set
     */
    public void setCount(int number){
        count = number;
    }

    /**
     * Questions are fetched from the database and new question panel is created.
     */
    public QuestionPanel createQuestionPanel(QuestionLevel level, QuestionCategory category) throws IOException {
        //get the database
        QuestionDatabase qd = QuestionDatabaseFactory.aQuestionDatabaseWithAllQuestions();

        //get number of question in the category
        int n = qd.getNumberOfQuestions(level, category);

        //get level questions
        while (count < n) {
            //get a new question
            Question q = qd.getQuestion(level, category, count);

            //create new question panel
            qPanel = new QuestionPanel(q);

            //increment counter
            count++;

            //return the panel
            return qPanel;
        }
        //if returned is null then no more questions in the category of that level available.
        return null;
    }

    /**
     * 
     * get list of custom question for given level
     * @param level level to get custom questions from
     * @return a list of custom questions
     */
    public List getListOfCustomQuestions(QuestionLevel level) {
        //get the database of custom questions
        QuestionDatabase qd = QuestionDatabaseFactory.aQuestionDatabaseWithOnlyCustomQuestions();

        int i = 0;

        List<Question> qList = new ArrayList<Question>();

        for (QuestionCategory c : QuestionCategory.values()) {
            //get number of question in the category
            int n = qd.getNumberOfQuestions(level, c);
            while (i < n) {
                //get the question
                Question q = qd.getQuestion(level, c, i);
                //add to list
                qList.add(q);
                i++;
            }
            i = 0;
        }
        return qList;
    }

    /**
     * use with caution, deletes all custom added questions
     */
    public void deleteAllCustomQuestions() {
        QuestionDatabase qd = QuestionDatabaseFactory.aQuestionDatabaseWithOnlyCustomQuestions();

        QuestionManager qm = QuestionDatabaseFactory.aQuestionManager();

        int i = 0;

        for (QuestionLevel l : QuestionLevel.values()) {
            for (QuestionCategory c : QuestionCategory.values()) {
                //get number of question in the category
                int n = qd.getNumberOfQuestions(l, c);
                while (i < n) {
                    //get the question
                    Question q = qd.getQuestion(l, c, i);
                    //delete the question
                    qm.deleteQuestion(q);
                    i++;
                }
                i = 0;
            }
        }
    }
}
