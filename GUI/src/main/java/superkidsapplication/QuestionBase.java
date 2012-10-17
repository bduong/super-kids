package superkidsapplication;

import com.ece.superkids.*;
import com.ece.superkids.entities.Question;
import com.ece.superkids.enums.QuestionLevel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author baris, marc //questionpanel factory(base)
 * creates a questionpanel getting the question and choices(answers) from the server
 */
public class QuestionBase {


    public QuestionBase() {
    
    }

    //we need a better method where a new question is fetched in from the server when this method is called.
    public QuestionPanel createQuestionPanel() {
        QuestionDatabase fqd = QuestionDatabaseFactory.aQuestionDatabase();

        Question q = fqd.getQuestion(QuestionLevel.LEVEL_1, 1);

        String qText = q.getQuestion();

        List<String> choices = q.getChoices();

        String answer = q.getAnswer(); // i think this should be an integer saying which choice in the list is the correct answer
        
        //pass the answer (integer) here
        QuestionPanel qPanel = new QuestionPanel(3);
        
        //if there are icons we will need to add them manual i guess for now. 
        List<Icon> icons = new ArrayList<Icon>();

        Icon icon1 = (new javax.swing.ImageIcon(getClass().getResource("/superkidsapplication/rectangle.png")));
        Icon icon2 = (new javax.swing.ImageIcon(getClass().getResource("/superkidsapplication/triangle.png")));
        Icon icon3 = (new javax.swing.ImageIcon(getClass().getResource("/superkidsapplication/square.png")));
        Icon icon4 = (new javax.swing.ImageIcon(getClass().getResource("/superkidsapplication/circle.png")));
        
        icons.add(icon1);
        icons.add(icon2);
        icons.add(icon3);
        icons.add(icon4);
            
        qPanel.setQuestion("Which one is a square ?", null);
        qPanel.setChoices(choices, icons);
        
        return qPanel;
    }
}
