/**
 * @author M4rc Adam
 */
package com.ece.superkids.users.entities;

import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.enums.QuestionCategory;

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class History {
    
    private Map<String, ArrayList<State>> questionToList;

    public History() {
        questionToList = new HashMap();
    }

    public void saveToHistory(QuestionCategory category, QuestionLevel level, State state) {
        String key = category.toString() + ":" + level.toString();
        if(questionToList.containsKey(key)) {
            // get array
            ArrayList<State> states = (ArrayList<State>)questionToList.get(key);
            states.add(state);
        } else {
            ArrayList<State> states = new ArrayList();
            states.add(state);
            questionToList.put(key, states);
        }
    }
    
    public Map<Question, ArrayList<Integer>> getHistory(QuestionCategory category, QuestionLevel level) {
        String key = category.toString() + ":" + level.toString();
        Map<Question, ArrayList<Integer>> questionToScores = new HashMap();
        if(questionToList.containsKey(key)) {
            ArrayList<State> states = (ArrayList<State>)questionToList.get(key);

            for(int i=0; i<states.size(); i++) {
                Iterator it = states.get(i).getAllScores().entrySet().iterator();
                while(it.hasNext()) {
                    Map.Entry pairs = (Map.Entry)it.next();
                    Question questionKey = (Question)pairs.getKey();
                    if(questionToScores.containsKey(questionKey)) {
                        ArrayList<Integer> listOfScores = (ArrayList<Integer>)questionToScores.get(questionKey);
                        listOfScores.add((Integer)pairs.getValue());
                        questionToScores.put(questionKey, listOfScores);
                    } else {
                        ArrayList<Integer> listOfScores = new ArrayList();
                        listOfScores.add((Integer)pairs.getValue());
                        questionToScores.put(questionKey, listOfScores);
                    }
                }
            }
            return questionToScores;
            
        } else {
            return null;
        }
    }

}