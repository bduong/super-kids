package com.ece.superkids;

import com.ece.superkids.builders.QuestionBuilder;
import com.ece.superkids.entities.Question;
import com.ece.superkids.enums.QuestionLevel;
import com.ece.superkids.enums.QuestionType;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileQuestionDatabase implements QuestionDatabase{

    private static String FILE_NAME = "Questions.txt";
    private Gson gson = new Gson();
    private List<Question> questions;

    public FileQuestionDatabase() {
        questions = new ArrayList<Question>();
        File file = new File(getClass().getResource("/" + FILE_NAME).getFile());
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                questions.add(gson.fromJson(line, Question.class));
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    @Override
    public Question getQuestion(final QuestionLevel level, final int number) {
        if (number <= questions.size()) {
            return questions.get(number-1);
        }
        return null;
        //        return QuestionBuilder.aQuestion()
//                .asking("What has four sides?")
//                .ofType(QuestionType.TEXT)
//                .withChoices("Square", "Circle", "Triangle", "Oval")
//                .withAnswer("Square")
//                .withExplaination("A square has four equal sides")
//                .build();
    }

    @Override
    public void saveQuestion(final QuestionLevel level, final int number, final Question question) {
        File file = new File(getClass().getResource("/" + FILE_NAME).getFile());

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
