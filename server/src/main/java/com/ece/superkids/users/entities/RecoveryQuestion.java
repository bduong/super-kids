package com.ece.superkids.users.entities;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RecoveryQuestion {

    private String question;
    private String answer;

    private static final String SALT="ERGMAHGERDThisSaltIsSoCrazzzzzzzzy2342143(**#*#(@(";

    public RecoveryQuestion(final String question, final String answer) {
        this.question = question;
        this.answer = md5(answer + SALT);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(final String question) {
        this.question = question;
    }

    public boolean checkAnswer(final String ans) {
        return (answer.equals(md5(ans + SALT)));
    }

    public void setAnswer(final String ans) {
        answer = md5(ans + SALT);
    }

    /**
     * Do the MD5 hash of a given string.
     *
     * @param input the string to hash.
     * @return The MD5 of the input string.
     */
    private String md5(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(input.getBytes(), 0, input.length());
            return new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
