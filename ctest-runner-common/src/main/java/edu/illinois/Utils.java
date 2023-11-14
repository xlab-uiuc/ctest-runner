package edu.illinois;
import org.junit.runners.model.FrameworkMethod;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Author: Shuai Wang
 * Date:  10/14/23
 */
public class Utils {

    public static String readStringFromFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    /**
     * Write a string to a file
     * @param path
     * @param content
     */
    public static void writeStringToFile(final String path, final String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * Write bytes to a file in a new thread
     * @param path the path of the file
     * @param bytes the bytes to write
     */
    public static void writeBytesToFile(final String path, final byte[] bytes) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    File file = new File(path);
                    if (!file.exists()) {
                        file.getParentFile().mkdirs();
                    }
                    Files.write(Paths.get(path), bytes);
                } catch (Throwable t){
                    t.printStackTrace();
                }
            }
        }).start();
    }

    public static List<String> getMethodDescriptorsFromString(String methodDescriptors) {
        if (methodDescriptors != null && !methodDescriptors.isEmpty()) {
            // Split with comma
            return new ArrayList<>(List.of(methodDescriptors.split(",")));
        }
        return null;
    }

    /**
     * Get the file type from the file name
     * @param file the file name
     * @return the file type
     * @throws IOException if the file name is invalid
     */
    public static String getFileType(String file)  {
        if (file != null && !file.isEmpty()) {
            String[] fileSplit = file.split("\\.");
            if (fileSplit.length > 1) {
                return fileSplit[fileSplit.length - 1];
            }
        }
        return null;
    }

    public static void writeParamSetToJson(Set<String> usedParam, Set<String> setParam, File targetJsonFile) {
        // No need to write if the set is empty
        if (usedParam.isEmpty() && setParam.isEmpty()) {
            return;
        }
        StringBuilder paramStr = new StringBuilder("{\"required\": [");
        for (String param : usedParam) {
            paramStr.append("\"").append(param).append("\",");
        }
        if (!usedParam.isEmpty()) {
            paramStr = new StringBuilder(paramStr.substring(0, paramStr.length() - 1));
        }
        paramStr.append("], \"set\": [");

        for (String param : setParam) {
            paramStr.append("\"").append(param).append("\",");
        }
        if (!setParam.isEmpty()) {
            paramStr = new StringBuilder(paramStr.substring(0, paramStr.length() - 1));
        }
        paramStr.append("]}");
        writeStringToFile(targetJsonFile.getAbsolutePath(), paramStr.toString());
    }

    /**
     * Get the full name of a test method as the format of "testClassName_testMethodName"
     * @param method
     * @return
     */
    public static String getTestMethodFullName(FrameworkMethod method) {
        return method.getMethod().getDeclaringClass().getName() + Names.TEST_CLASS_METHOD_SEPERATOR + method.getName();
    }

    public static String getTestMethodFullName(String className, String methodName) {
        return className + Names.TEST_CLASS_METHOD_SEPERATOR + methodName;
    }

    /** ========== Json file related methods ========== */


}