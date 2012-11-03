/**
 * @author M4rc Adam
 */
package com.ece.superkids.users.entities;

import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.enums.QuestionCategory;

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class History {
    // category and level map //
    private Map<String, ArrayList<State>> questionToList;

    public History() {
        questionToList = new HashMap();
    }

    public void saveToHistory(QuestionCategory category, QuestionLevel level, State state) {
        String key = category + ":" + level;
        if(questionToList.containsKey(key)) {
            ArrayList<State> arrayList = questionToList.get(key);
            if(arrayList.size()>5) {
                arrayList.remove(0);
            }
            arrayList.add(state);
        } else {
            ArrayList<State> arrayList = new ArrayList();
            arrayList.add(state);
            questionToList.put(key, arrayList);
        }
    }

    public Map<String, ArrayList<Integer>> getHistory(QuestionCategory category, QuestionLevel level) {
        return null;
    }

}