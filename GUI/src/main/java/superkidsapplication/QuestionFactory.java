package superkidsapplication;

import com.ece.superkids.*;
import com.ece.superkids.entities.Question;
import com.ece.superkids.enums.QuestionLevel;
import java.util.List;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author baris
 */
public class QuestionFactory {
    
public QuestionPanel createQuestionPanel(){
    FileQuestionDatabase fqd =  new FileQuestionDatabase();
    
    Question q = fqd.getQuestion(QuestionLevel.LEVEL_1, 1);
    
    String qText = q.getQuestion();
    
    List<String> choices = q.getChoices();
    
    QuestionPanel qPanel = new QuestionPanel();
    
    String anwser = q.getAnswer();
    
    qPanel.setQuestion(qText);
    return qPanel;
}
    
}
