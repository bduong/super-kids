package com.ece.superkids;

import com.ece.superkids.builders.QuestionBuilder;
import com.ece.superkids.entities.Question;
import com.ece.superkids.enums.QuestionCategory;
import com.ece.superkids.enums.QuestionLevel;
import com.ece.superkids.enums.QuestionType;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileQuestionDatabase implements QuestionDatabase{

    private static String FILE_NAME = "Questions.txt";
    private Gson gson = new Gson();
    private Map<QuestionLevel, Map<QuestionCategory,List<Question>>> questions = new HashMap<QuestionLevel,
            Map<QuestionCategory,List<Question>>>();

    public FileQuestionDatabase() {
        File file = new File(getClass().getResource("/" + FILE_NAME).getFile());
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                Question question = gson.fromJson(line, Question.class);
                addQuestionToList(question);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
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
        return questions.get(level).get(category).get(number);

        //        return QuestionBuilder.aQuestion()
//                .asking("What has four sides?")
//                .ofType(QuestionType.TEXT)
//                .withChoices("Square", "Circle", "Triangle", "Oval")
//                .withAnswer("Square")
//                .withExplaination("A square has four equal sides")
//                .build();
    }

    @Override
    public void saveQuestion(final QuestionLevel level, final QuestionCategory category, final Question question) {
        File file = new File(getClass().getResource("/" + FILE_NAME).getFile());

        question.setLevel(level);
        question.setCategory(category);
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(gson.toJson(question));
            writer.write('\n');
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
