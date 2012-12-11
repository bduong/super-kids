package com.ece.superkids.questions;

import com.ece.superkids.FileManager;
import com.ece.superkids.FileManagerImpl;
import com.ece.superkids.questions.entities.Question;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The <code>FileQuestionManager</code> manages custom questions stored on the local filesystem.
 * The questions are stored in JSON format on in the user's home directory.
 *
 * @author Ben Duong
 */
public class FileQuestionManager implements QuestionManager{

    private static File customQuestionsFile;
    private FileManager fileManager = FileManagerImpl.getInstance();
    private Gson gson;

    public FileQuestionManager() {
        determineSaveDirectory();
        gson = new Gson();
    }

    /**
     * Determine the directory to save and read files from.
     */
    private void determineSaveDirectory() {
        customQuestionsFile = fileManager.getCustomQuestionsFile();
    }

    @Override
    public void addQuestion(final Question question) {
        try {
            FileWriter writer = new FileWriter(customQuestionsFile, true);
            writer.write(gson.toJson(question) + '\n');
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteQuestion(final Question question) {
        String questionString = gson.toJson(question);
        try {
            File tempFile = File.createTempFile("customQuestions", ".new");
            FileWriter writer = new FileWriter(tempFile);
            BufferedReader reader = new BufferedReader(new FileReader(customQuestionsFile));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!questionString.equals(line)) {
                    writer.write(line + '\n');
                }
            }
            
            reader.close();
            writer.flush();
            writer.close();
            FileUtils.forceDelete(customQuestionsFile);
            FileUtils.copyFile(tempFile, customQuestionsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        customQuestionsFile =  fileManager.getCustomQuestionsFile();
    }

    @Override
    public void editQuestion(final Question oldQuestion, final Question newQuestion) {
        deleteQuestion(oldQuestion);
        addQuestion(newQuestion);
    }
}
