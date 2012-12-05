package com.ece.superkids.users;

import com.ece.superkids.FileManager;
import com.ece.superkids.FileManagerImpl;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The <code>FileParentManager</code> stores the parent account information on the local file
 * system in the user home directory.
 *
 * The parent password is heavily salted and then hashed before being stored anywhere on the file
 * system. This will prevent cracking of the password.
 *
 * @author Ben Duong
 */
public class FileParentManager implements ParentManager{

    private FileManager manager = FileManagerImpl.getInstance();
    private static final String PARENT_FILE_NAME = "parent.txt";
    private static final String SALT = "LetsSaltThisPasswordWithABunchOfSalt?!?!#$#@#$@$%#";

    @Override
    public boolean doesParentExist() {
        File parentFile = new File(createFileName());
        return parentFile.exists();
    }

    /**
     * Creates the file name for the parent file.
     *
     * @return The parent file name.
     */
    private String createFileName() {
        return manager.getDirectory() + File.separator + PARENT_FILE_NAME;
    }

    @Override
    public boolean checkParentPassword(String password) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(createFileName()));
            String hash = reader.readLine();
            return hash.equals(md5(password + SALT));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean changeParentPassword(final String newPass) {
        try{
            if(!doesParentExist()){
                File parentFile = new File(createFileName());
                parentFile.createNewFile();
            }
            if (!newPass.isEmpty()) {
                FileWriter writer = new FileWriter(createFileName());
                writer.write(md5(newPass + SALT) + '\n');
                writer.close();
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteParentAccount(boolean wait) {
        if (doesParentExist()) {
            if (wait) {
                new File(createFileName()).deleteOnExit();
            } else {
                new File(createFileName()).delete();
            }
        }
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
