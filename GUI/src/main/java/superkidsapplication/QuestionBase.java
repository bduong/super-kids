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
public class QuestionBase {

    int count;
    boolean startN;

    private QuestionBase(){
        count = 0;
    }

    private static class QuestionBaseHolder {
        public static final QuestionBase INSTANCE = new QuestionBase();
    }

    public static QuestionBase getInstance() {
        return QuestionBaseHolder.INSTANCE;
    }
    
    public void reset(){
        count=0;
    }

    //we need a better method where a new question is fetched in from the server when this method is called.
    public QuestionPanel createQuestionPanel(String category) {
        QuestionDatabase fqd = QuestionDatabaseFactory.aQuestionDatabase();

        Question q = fqd.getQuestion(QuestionLevel.LEVEL_1, QuestionCategory.SHAPES, 1);

        String qText = q.getQuestion();

        //print out question (testing)
        System.out.println(qText);

        List<String> choices = null;//q.getChoices();

        String answer = q.getAnswer(); // i think this should be an integer saying which choice in the list is the correct answer

        ////FOR NOW THE 5 QUESTIONS ARE HARD CODED AND ARE NOT FETCHED FROM SERVER
        List<Icon> icons;
        QuestionPanel qPanel;
        if (category == "shapes") {
            if (count == 0) {
                //pass the answer (integer) here
                qPanel = new QuestionPanel(3,category);
                //if there are icons we will need to add them manually for now. they are not stored in a database. 
                icons = new ArrayList<Icon>();

                Icon icon1 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/rectangle.png")));
                Icon icon2 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/triangle.png")));
                Icon icon3 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/square.png")));
                Icon icon4 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/circle.png")));

                icons.add(icon1);
                icons.add(icon2);
                icons.add(icon3);
                icons.add(icon4);

                qPanel.setQuestion("Which one is a square ?", null);
                qPanel.setChoices(choices, icons);
                count++;
                return qPanel;
            }
        }
        if (category == "colors") {
            if (count == 0) {
                qPanel = new QuestionPanel(1,category);
                //if there are icons we will need to add them manually for now. they are not stored in a database. 
                icons = new ArrayList<Icon>();
                Icon icon1 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/rectangle.png")));
                Icon icon2 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/triangle.png")));
                Icon icon3 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/square.png")));
                Icon icon4 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/circle.png")));
                icons.add(icon1);
                icons.add(icon2);
                icons.add(icon3);
                icons.add(icon4);

                qPanel.setQuestion("Which shape is Blue ?", null);
                qPanel.setChoices(choices, icons);
                count++;
                return qPanel;
            }

            if (count == 1) {
                qPanel = new QuestionPanel(3,category);
                //if there are icons we will need to add them manually for now. they are not stored in a database. 
                icons = new ArrayList<Icon>();
                Icon icon1 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/rectangle.png")));
                Icon icon2 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/triangle.png")));
                Icon icon3 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/square.png")));
                Icon icon4 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/circle.png")));
                icons.add(icon1);
                icons.add(icon2);
                icons.add(icon3);
                icons.add(icon4);

                qPanel.setQuestion("Which shape is Red?", null);
                qPanel.setChoices(choices, icons);
                count++;
                return qPanel;
            }
            if (count == 2) {
                qPanel = new QuestionPanel(2,category);
                //if there are icons we will need to add them manually for now. they are not stored in a database. 
                icons = new ArrayList<Icon>();
                Icon icon1 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/rectangle.png")));
                Icon icon2 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/triangle.png")));
                Icon icon3 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/square.png")));
                Icon icon4 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/circle.png")));
                icons.add(icon1);
                icons.add(icon2);
                icons.add(icon3);
                icons.add(icon4);

                qPanel.setQuestion("Which shape is Yellow?", null);
                qPanel.setChoices(choices, icons);
                count++;
                return qPanel;
            }

        }
        if (category == "animals") {
            if (count == 0) {
                qPanel = new QuestionPanel(4,category);
                //if there are icons we will need to add them manually for now. they are not stored in a database. 
                icons = new ArrayList<Icon>();
                Icon icon1 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/dog.jpeg")));
                Icon icon2 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/giraffe.jpeg")));
                Icon icon3 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/whale.jpeg")));
                Icon icon4 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/elephant.jpeg")));
                icons.add(icon1);
                icons.add(icon2);
                icons.add(icon3);
                icons.add(icon4);

                qPanel.setQuestion("Which is an Elephant?", null);
                qPanel.setChoices(choices, icons);
                count++;
                return qPanel;

            }
            if (count == 1) {
                qPanel = new QuestionPanel(2,category);
                //if there are icons we will need to add them manually for now. they are not stored in a database. 
                icons = new ArrayList<Icon>();
                Icon icon1 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/whale.jpeg")));
                Icon icon2 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/dog.jpeg")));
                Icon icon3 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/elephant.jpeg")));
                Icon icon4 = (new javax.swing.ImageIcon(getClass().getResource("/question/pictures/giraffe.jpeg")));
                icons.add(icon1);
                icons.add(icon2);
                icons.add(icon3);
                icons.add(icon4);

                qPanel.setQuestion("Which is a Dog?", null);
                qPanel.setChoices(choices, icons);
                count++;
                return qPanel;
            }
        }
        return null;
    }
}
