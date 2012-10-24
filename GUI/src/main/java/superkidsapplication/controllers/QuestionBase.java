package superkidsapplication.controllers;

import com.ece.superkids.*;
import com.ece.superkids.entities.Question;
import com.ece.superkids.enums.QuestionCategory;
import com.ece.superkids.enums.QuestionLevel;
import com.ece.superkids.enums.QuestionType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.Icon;
import superkidsapplication.panels.QuestionPanel;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author baris //questionpanel factory(base) creates a questionpanel getting
 * the question and choices(answers) from the server
 *
 */
public class QuestionBase {

    private int count;
    private List<Icon> icons;
    private QuestionPanel qPanel;

    private QuestionBase() {
        count = 0;
    }

    private static class QuestionBaseHolder {

        public static final QuestionBase INSTANCE = new QuestionBase();
    }

    public static QuestionBase getInstance() {
        return QuestionBaseHolder.INSTANCE;
    }

    //resets count
    //this is called switching between categories in subjectselectionframe
    public void reset() {
        count = 0;
    }

    //questions are fetched from the database
    public QuestionPanel createQuestionPanel(String level, String category) throws IOException {
        //get the database
        QuestionDatabase qd = QuestionDatabaseFactory.aQuestionDatabase();
        
        //get number of question in the category
        int n = qd.getNumberOfQuestions(QuestionLevel.valueOf(level), QuestionCategory.valueOf(category));

        //get level questions
        while (count < n) {
            //initally icons is null
            //if the question type is PICTURE then a new arraylist is created.
            icons = null;

            //get a new question
            Question q = qd.getQuestion(QuestionLevel.valueOf(level), QuestionCategory.valueOf(category), count);

            //shuffle choices
            Collections.shuffle(q.getChoices());
         
            //find answer
            int ans = findAnswer(q.getAnswer(), q.getChoices());

            //create new question panel
            qPanel = new QuestionPanel(ans, level, category);

            //set the question, question can have an icon as well. it is set to null for now.
            qPanel.setQuestion(q.getQuestion(), null);

            //if the type is PICTURES then create icons
            if (q.getType() == QuestionType.PICTURE) {
                //create a new list
                icons = new ArrayList<Icon>();
                for (int j = 0; j < 4; j++) {
                    //all pictures about questions should go to this path
                    //make all of them png's.
                    String path = "/question/pictures/" + q.getChoices().get(j) + ".png";
                    Icon icon = (new javax.swing.ImageIcon(getClass().getResource(path)));
                    icons.add(icon);
                }
            }
            //set the choices 
            qPanel.setChoices(q.getChoices(), icons);
            count++;
            //return the panel
            return qPanel;
        }
        //if returned is null then no more questions in the category of that level available.
        return null;
    }

    //find the index of answer
    private int findAnswer(String answer, List<String> choices) {
        for (int i = 0; i < choices.size(); i++) {
            if (choices.get(i).equals(answer)) {
                return i + 1;
            }
        }
        return 0;
    }
}
