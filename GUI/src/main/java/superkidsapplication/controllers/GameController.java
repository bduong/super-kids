/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superkidsapplication.controllers;

import com.ece.superkids.questions.QuestionDatabase;
import com.ece.superkids.questions.QuestionDatabaseFactory;
import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.users.entities.State;
import com.ece.superkids.users.entities.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import superkidsapplication.events.Session;
import superkidsapplication.panels.NewGamePanel;
import superkidsapplication.panels.QuestionPanel;
import superkidsapplication.panels.StartScreenPanel;
import superkidsapplication.panels.SubjectSelectionPanel;

/**
 *
 * @author baris
 */
public class GameController {

    private QuestionController qController;
    private PanelController controller;
    private Session session;
    private QuestionDatabase qD;

    //a Facade object
    private GameController() {
        qController = QuestionController.getInstance();
        controller = PanelController.getInstance();
        session = Session.aSession();
        qD = QuestionDatabaseFactory.aQuestionDatabaseWithAllQuestions();

    }

    private static class GameControllerHolder {
        public static final GameController INSTANCE = new GameController();
    }

    public static GameController getInstance() {
        return GameController.GameControllerHolder.INSTANCE;
    }

    /*
     * Create a new game
     */
    public void newGame() {
        //set gameOn
        session.getLoggedInUser().setGameOn(true);
        //create a new game panel
        NewGamePanel gamePanel = new NewGamePanel();
        //add new panel
        controller.addPanel(gamePanel);
    }

    /*
     * New subject is selected 
     */
    public void newSubject(QuestionLevel level, int categoryNum) {
        //create a new state for the logged inuser
        session.getLoggedInUser().newState(level.getCategories().get(categoryNum), level);
        try {
            //reset question Controller
            qController.reset();
            //get the question panel
            QuestionPanel q = qController.createQuestionPanel(level, level.getCategories().get(categoryNum));
            //add it to panel
            controller.addPanel(q);
        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Continue the game where we left off
     */
    public void continueGame() {
        try {
            // TODO add your handling code here:
            //get the user that is logged in
            User user = session.getLoggedInUser();
            //if the current level is finished go to level selection
            if (user.isCurrentLevelFinished()) {
                QuestionLevel lev = user.getState().getCurrentLevel();
                controller.addPanel(new NewGamePanel("Continue"));
                return;
            }
            //if the level is not finished
            //get the state of user
            State s = user.getState();
            //if the category is finished then go to the subject selection
           
            if (s.getCurrentCategory() == null) {
                QuestionLevel lev = user.getState().getCurrentLevel();
                controller.addPanel(new SubjectSelectionPanel(lev));
                return;
            }
            
            
            //if the category is not finished get the current question
            Question q;
            //get question number
            int number;
            //if returned q is null, then no saved current question
            if (s != null) {
                q = s.getCurrentQuestion();
                number = qD.getQuestionNumber(q);
            } else {
                return;
            }
            //if returned number is -1, then question is not found in the database
            if (number != -1) {
                System.out.println("Continue question:" + q.getQuestion() + " index:" + number);
                //and set number in question controller
                qController.setCount(number);
                //create the question panel
                QuestionPanel qPanel = qController.createQuestionPanel(q.getLevel(), q.getCategory());
                //display the questionpanel
                controller.addPanel(qPanel);
                //if cannot find the question go to subject selection
            } else if (number == -1) {
                user.getState().getCurrentLevel();
                QuestionLevel lev = user.getState().getCurrentLevel();
                controller.addPanel(new SubjectSelectionPanel(lev));
                System.out.println("Cannot find saved question.");
            }
        } catch (IOException ex) {
            Logger.getLogger(StartScreenPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
