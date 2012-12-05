package com.ece.superkids.questions.enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.ece.superkids.questions.enums.QuestionCategory.*;

/**
 * <code>QuestionLevel</code> represents what level a question is in.
 *
 * @author Ben Duong
 */
public enum QuestionLevel {
    LEVEL_1(SHAPES, COLORS, ANIMALS),
    LEVEL_2(FOOD, GEOGRAPHY, PLANETS),
    LEVEL_3(STATIONARY, INSTRUMENTS, BODYPARTS);

    private List<QuestionCategory> categories;

    QuestionLevel(QuestionCategory ... levelCategories) {
        categories = new ArrayList<QuestionCategory>();
        Collections.addAll(categories, levelCategories);
    }

    public List<QuestionCategory> getCategories() {
        return categories;
    }

}
