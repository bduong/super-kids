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
import javax.swing.*;
import superkidsapplication.panels.QuestionPanel;
import superkidsapplication.providers.ImageProvider;
import superkidsapplication.providers.ResourceProviderFactory;
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
public class QuestionController {

    private int count;
    private List<Icon> icons;
    private QuestionPanel qPanel;
    private ImageProvider iconProvider;

    private QuestionController() {
        count = 0;
        iconProvider = ResourceProviderFactory.anImageProvider();
    }

    private static class QuestionBaseHolder {

        public static final QuestionController INSTANCE = new QuestionController();
    }

    public static QuestionController getInstance() {
        return QuestionBaseHolder.INSTANCE;
    }

    //resets count
    //this is called switching between categories in subjectselectionframe
    public void reset() {
        count = 0;
    }

    //questions are fetched from the database
    public QuestionPanel createQuestionPanel(QuestionLevel level, QuestionCategory category) throws IOException {
        //get the database
        QuestionDatabase qd = QuestionDatabaseFactory.aQuestionDatabase();

        //get number of question in the category
        int n = qd.getNumberOfQuestions(level, category);

        //get level questions
        while (count < n) {
            //initally icons is null
            //if the question type is PICTURE then a new arraylist is created.
            icons = null;

            //get a new question
            Question q = qd.getQuestion(level, category, count);

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
                    ImageIcon icon = iconProvider.getImage(q.getChoices().get(j));
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

    public List getListOfQuestions(QuestionLevel level) {
        //get the database
        QuestionDatabase qd = QuestionDatabaseFactory.aQuestionDatabase();

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
}
