package superkidsapplication;

import com.ece.superkids.*;
import com.ece.superkids.entities.Question;
import com.ece.superkids.enums.QuestionCategory;
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
 * @author baris, marc //questionpanel factory(base) creates a questionpanel
 * getting the question and choices(answers) from the server
 *
 */
public class TutorialBase {

    int count;
    boolean startN;

    private TutorialBase(){
        count = 0;
    }

    private static class TutorialBaseHolder {
        public static final TutorialBase INSTANCE = new TutorialBase();
    }

    public static TutorialBase getInstance() {
        return TutorialBaseHolder.INSTANCE;
    }
    
    public void reset(){
        count=0;
    }

    //we need a better method where a new question is fetched in from the server when this method is called.
    public TutorialPanel createTutorialPanel(String category) {
        TutorialPanel qPanel;
        System.out.println("create tutorial panel");
        qPanel = new TutorialPanel(category);
        count++;
        return qPanel;
    }
}
