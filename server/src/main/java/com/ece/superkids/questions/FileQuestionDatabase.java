package com.ece.superkids.questions;

import com.ece.superkids.FileManagerImpl;
import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionCategory;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.enums.QuestionMode;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The <code>FileQuestionDatabase</code> loads questions that are stored in JSON format
 * from files on the local file system. The default questions are read only but custom questions
 * are editable.
 *
 * @author Ben Duong
 */
public class FileQuestionDatabase implements QuestionDatabase{

    private static final String FILE_NAME = "/Questions.txt";
    private static File CUSTOM_FILE_NAME;
    private Gson gson = new Gson();
    private Map<QuestionLevel, Map<QuestionCategory,List<Question>>> questions = new HashMap<QuestionLevel,
            Map<QuestionCategory,List<Question>>>();

    public FileQuestionDatabase(QuestionMode mode) {
        CUSTOM_FILE_NAME = FileManagerImpl.getInstance().getCustomQuestionsFile();
        switchMode(mode);
    }

    @Override
    public void switchMode(QuestionMode mode) {
        questions.clear();
        try{
            switch(mode){
                case DEFAULT_ONLY:
                    loadQuestionsFromStream(getClass().getResourceAsStream(FILE_NAME));
                    break;
                case CUSTOM_ONLY:
                    loadQuestionsFromStream(new FileInputStream(CUSTOM_FILE_NAME));
                    break;
                case ALL:
                    loadQuestionsFromStream(getClass().getResourceAsStream(FILE_NAME));
                    loadQuestionsFromStream(new FileInputStream(CUSTOM_FILE_NAME));
                    break;
                default:
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getQuestionNumber(final Question question) {
        QuestionLevel level = question.getLevel();
        QuestionCategory category = question.getCategory();
        if (questions.containsKey(level) && questions.get(level).containsKey(category)) {
            int count = 0;
            for (Question q : questions.get(level).get(category)) {
                if (question.equals(q)) {
                    return count;
                }
                count++;
            }
        }
        return -1;
    }

    private void loadQuestionsFromStream(InputStream in) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                Question question = gson.fromJson(line, Question.class);
                addQuestionToList(question);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addQuestionToList(final Question question) {
        QuestionLevel level = question.getLevel();
        QuestionCategory category = question.getCategory();
        if (!questions.containsKey(level)) {
            questions.put(level, new HashMap<QuestionCategory, List<Question>>());
        }
        if(!questions.get(level).containsKey(category)) {
            questions.get(level).put(category, new ArrayList<Question>());
        }
        questions.get(level).get(category).add(question);
    }

    @Override
    public Question getQuestion(final QuestionLevel level, final QuestionCategory category, final int number) {
        if (questions.get(level).get(category).size() <= number) {
            return null;
        }
        return questions.get(level).get(category).get(number);
    }

    @Override
    public int getNumberOfQuestions(final QuestionLevel level, final QuestionCategory category) {
        if (!questions.containsKey(level)) {
            return 0;
        }
        if (!questions.get(level).containsKey(category)) {
            return 0;
        }
        return questions.get(level).get(category).size();
    }

    @Override
    public int getNumberOfQuestions(final QuestionLevel level) {
        int sum = 0;
        if (!questions.containsKey(level)) {
            return sum;
        }

        for (List<Question> category : questions.get(level).values()) {
            sum += category.size();
        }

        return sum;
    }
}
