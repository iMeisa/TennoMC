package com.meisa.tennomc.common.util;

public class StringRenamer {

    public static String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public static String snakeToText(String input) {
        final String[] splitText = input.split("_");
        StringBuilder outputText = new StringBuilder();
        for (String word : splitText) {
            final String upperCaseWord = word.substring(0, 1).toUpperCase() + word.substring(1) + " ";
            outputText.append(upperCaseWord);
        }

        return outputText.toString();
    }
}
