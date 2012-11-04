/**
 * @author M4rc Adam
 */
package com.ece.superkids.users.entities;

import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.enums.QuestionCategory;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

public class History implements Serializable {
    
    private Map<String, ArrayList<State>> questionToList;

    public History() {
        questionToList = new HashMap();
    }

    public void saveToHistory(QuestionCategory category, QuestionLevel level, State state) {
        String key = category.toString() + ":" + level.toString();
        if(questionToList.containsKey(key)) {
            ArrayList<State> states = (ArrayList<State>)questionToList.get(key);
            states.add(state);
        } else {
            ArrayList<State> states = new ArrayList();
            states.add(state);
            questionToList.put(key, states);
        }
        System.out.println("State added to history");
    }
    
    public Map<Question, ArrayList<Integer>> getHistorye(QuestionCategory category, QuestionLevel level) {
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
    
    public Object[][] getHistory(QuestionCategory category, QuestionLevel level) {
        
        Map<Question, ArrayList<Integer>> map = getHistorye(category, level);
        Iterator it = map.entrySet().iterator();
        int counter = 0;
        while(it.hasNext())  {
            Map.Entry pairs = (Map.Entry)it.next();
            counter ++;
        }
        Object o[][] = new Object[counter][6];
        it = map.entrySet().iterator();
        int index = 0;
        while(it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            ArrayList<Integer> scoresList = (ArrayList<Integer>)pairs.getValue();
            o[index][0] = pairs.getValue();
            for(int i=0; i<scoresList.size(); i++) {
                o[index][i] = scoresList.get(i);
            }
            index++;
        }
        return o;

    }

    public Object[][] getHistoryTest() {
        Object o[][] = new Object[10][6];
        for(int i=0; i<o.length; i++) {
            o[i][0] = "Question" + i;
            for(int j=1; j<6; j++) {
                o[i][j] = i*i;
            }
        }
        return o;
    }


}