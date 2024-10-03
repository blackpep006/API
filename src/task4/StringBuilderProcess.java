package task4;

import common.Helper;
import common.CustomException;

public class StringBuilderProcess { 
    public StringBuilder createBuilder() {
        return new StringBuilder();
    }

    public StringBuilder createBuilder(String inputString) throws CustomException {
        Helper.validate(inputString);
        return new StringBuilder(inputString);
    }

    public int length(StringBuilder inputString) throws CustomException {
        Helper.validate(inputString);
        return inputString.length();
    }

    public StringBuilder addString(StringBuilder string, String inputString) throws CustomException {
        Helper.validate(string);
        Helper.validate(inputString);
        return string.append(inputString);
    }

    public StringBuilder addStringAtIndex(int position, StringBuilder string, String inputString) throws CustomException {
        Helper.validate(string);
        Helper.validate(inputString);
        return string.insert(position, inputString);
    }

    public StringBuilder addStrings(StringBuilder oldBuilder, String[] inputString, String delimiter) throws CustomException {
        Helper.validate(oldBuilder);
        Helper.validate(inputString);
        Helper.validate(delimiter);
        for (String str : inputString) {
            addString(addString(oldBuilder, delimiter), str);
        }
        return oldBuilder;
    }

    public StringBuilder delete(int start, int end, StringBuilder builder) throws CustomException {
        Helper.validateTheLength(length(builder), end);
        return builder.delete(start, end);
    }

    public StringBuilder change(StringBuilder builder, Character oldDelimiter, Character newDelimiter) throws CustomException {
        Helper.validate(oldDelimiter);
        Helper.validate(newDelimiter);
        int length = length(builder);
        for (int i = 0; i < length; i++) {
            if (builder.charAt(i) == oldDelimiter) {
                builder.setCharAt(i, newDelimiter);
            }
        }
        return builder;
    }

    public StringBuilder reverse(StringBuilder builder) throws CustomException {
        Helper.validate(builder);
        return builder.reverse();
    }

    public StringBuilder replace(int start, int end, StringBuilder builder, String replaceWith) throws CustomException {
        Helper.validateTheLength(length(builder), end);
        Helper.validate(replaceWith);
        return builder.replace(start, end, replaceWith);
    }

    public int indexOf(StringBuilder builder, String delimiter) throws CustomException {
        Helper.validate(builder);
        Helper.validate(delimiter);
        return builder.indexOf(delimiter);
    }

    public int lastIndexOf(StringBuilder builder, String delimiter) throws CustomException {
        Helper.validate(builder);
        Helper.validate(delimiter);
        return builder.lastIndexOf(delimiter);
    }
}
