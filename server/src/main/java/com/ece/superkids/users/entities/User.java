package com.ece.superkids.users.entities;

import com.ece.superkids.achievements.entities.Achievements;
import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionCategory;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.users.UserDatabaseFactory;
import com.ece.superkids.users.FileUserManager;
import com.ece.superkids.users.UserManager;
import java.io.Serializable;

/**
 * The <code>User</code> class represents the user playing the game.
 * It holds all the information for id, name, current state of gameplay, scores history, image path, and a list of achievements
 * 
 * @author Marc Adam
 */
public class User implements Serializable {

    static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private State state;
    private History history;
    private String image;
    private Achievements achievements;

     /**
     * Create a new User.
      * @param name The name of the User.
     */
    public User(String name) {
        this.name = name;
        state = new State();
        history = new History();
        achievements = new Achievements();
    }

    /**
     * Get the ID of the user.
     * @return ID of the user.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the ID of the user.
     * @param id The new ID of the user.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name of the user.
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the user.
     * @param name New name for the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the state of the user.
     * @return State of the user.
     */
    public State getState() {
        return state;
    }

    /**
     * Set the state of the user.
     * @param state The state to the the current state to.
     */
    private void setState(State state) {
        this.state = state;
        saveUser();
    }

    public void copyState(State state) {
        this.state = state;
    }

    /**
     * Set the image path for the user image
     * @param image Image path for the image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get the image path of the user's image
     * @return Image path
     */
    public String getImage() {
        return image;
    }

    /**
     * Get the achievements of the user.
     * @return Achievements of the user.
     */
    public Achievements getAchievements() {
        return achievements;
    }

    /**
     * Set the achievements of the user.
     * @param achievements Achievements of the user.
     */
    public void setAchievements(final Achievements achievements) {
        this.achievements = achievements;
    }

    /**
     * Get the scores history of the user.
     * @return History of the user.
     */
    public History getHistory() {
        return history;
    }

    /**
     * Set the history of the user.
     * @param history of the user.
     */
    public void setHistory(final History history) {
        this.history = history;
    }

    /**
     * Call this function when the game is started to set the game started flag to true.
     * This function is automatically called when newGame() is called.
     * @param set Set value for game on
     */
    public void setGameOn(boolean set){
        this.history.setGameStarted();
        saveUser();
    }
    /**
     * Call this function when the game is started to set the game started flag to true.
     * This function is automatically called when newGame() is called
     */
    public void setGameOn() {
        this.history.setGameStarted();
        saveUser();
    }

    /**
     * Checks if the user has started a game.
     * @return Value indicating if the game is started.
     */
    public boolean isGameOn() {
        return history.getGameOn();
    }

    /**
     * Create a new game for the user, this clears all saved attributes of the user!
     */
    public void newGame() {
        state = new State();
        history = new History();
        setGameOn();
    }

    /**
     * Checks if the current level of the user is finished.
     * @return Current level finished.
     */
    public boolean isCurrentLevelFinished(){
        return history.isLevelFinished(this.state.getCurrentLevel());
    }

    /**
     * Checks if the level is finished.
     * @param questionLevel Level to check.
     * @return Level is/is not finished.
     */
    public boolean isLevelFinished(QuestionLevel questionLevel) {
        return history.isLevelFinished(questionLevel);
    }

    /**
     * Set the current question for the user state.
     * @param question Question to set as current.
     */
    public void setCurrentQuestion(Question question) {
        history.setGameStarted();
        state.setCurrentQuestion(question);
        state.setCurrentLevel(question.getLevel());
        state.setCurrentCategory(question.getCategory());
        saveUser();
    }

    /**
     * Save the score for a question in the state of the user.
     * @param question Question that was just answered.
     * @param score Score that he got on that question.
     */
    public void saveScore(Question question, Integer score) {
        state.addScore(question, score);
    }
    
    /**
     *  Create a new state for the user when the user goes to a new category and level
     *  Call this function whenever you click on a new category
     * @param category New category
     * @param level New level
     */
    public void newState(QuestionCategory category, QuestionLevel level) {
        /* clear the old state and create a new one */
        state = new State();

        /* set category and level to the new state */
        state.setCurrentCategory(category);
        state.setCurrentLevel(level);

        /* save the user into the ser file */
        saveUser();
    }

    /**
     * This function ends the current state of the user and saves it to the history.
     * Call this when you're done with a category and level. newState function needs to be called after this to recreate a state.
     */
    public void endState() {
        /* save the state to the history */
        history.saveToHistory(state);
        /* clear the category so that whenever the game loads again, the user goes to category selection */
        state.setCurrentCategory(null);
        /* save the user in the ser file */
        saveUser();
    }

    /**
     * Get the category the user is currently in.
     * Use this function when resuming a game
     * @return Current Question Category
     */
    public QuestionCategory getCurrentCategory() {
        return state.getCurrentCategory();
    }

    /**
     * Set the category you want the user to be in
     * @param currentCategory Current Question Category
     */
    public void setCurrentCategory(QuestionCategory currentCategory) {
        state.setCurrentCategory(currentCategory);
    }

    /**
     * Get the level the user is currently in.
     * Use this function when resuming a game
     * @return Current Question Level
     */
    public QuestionLevel getCurrentLevel() {
        return state.getCurrentLevel();
    }

    /**
     * Set the level you want the user to be in.
     * @param currentLevel Current Question Level
     */
    public void setCurrentLevel(QuestionLevel currentLevel) {
        state.setCurrentLevel(currentLevel);
    }

    /**
     * Save the user in the database file.
     * This function is automatically called when endState() and newState() functions are called
     */
    public void saveUser() {
        (new FileUserManager()).addUser(this);
        (new FileUserManager()).updateUser(this, this);
    }

    /**
     * Deletes the user from the database file
     */
    public void deleteUser() {
        (new FileUserManager()).deleteUser(name);
    }

    /**
     * Get the scores history of the user, given a question category and a question level.
     * @param questionCategory The question Category
     * @param questionLevel The question Level
     * @return Two dimensional array of scores, the array has 6 columns
     */
    public Object[][] getHistory(QuestionCategory questionCategory, QuestionLevel questionLevel) {
        return history.getHistory(questionCategory, questionLevel);
    }

    /**
     * Gets the fake scores history for the user, used for testing
     * @return Two dimensional array of scores, the array has 6 columns
     */
    public Object[][] getHistoryTest() {
        return history.getHistoryTest();
    }

    /**
     * Get the best attempt of a question category and a question level.
     * @param questionCategory The category of questions.
     * @param questionLevel The level of questions.
     * @return A State map from questions to scores.
     */
    public State getMaximumScoreState(QuestionCategory questionCategory, QuestionLevel questionLevel) {
        return history.getMaximumScoreState(questionCategory, questionLevel);
    }

    /**
     * Get the overall score of the user, the score is picked from the best attempts.
     * @return Overall user score.
     */
    public int getTotalScore() {
        return history.getTotalScore();
    }

    /**
     * Overrides the equals method to check if two users are similar.
     * @param obj The user to check.
     * @return Boolean value to indicate if both users are the same.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
           return false;
        }
        User user2 = (User)obj;
        if (!(id == user2.id))  return false;
        if (!name.equals(user2.name))  return false;

        return true;
    }


}

