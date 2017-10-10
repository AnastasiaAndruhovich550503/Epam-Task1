package by.bsu.task.validation;

public class ValidationFile {
    public boolean isRightName(String name) {
        String extension = name.substring(name.length() - 5, name.length());
        return extension.compareTo(".txt") == 0;
    }

    public boolean isRightString(String string) {
        
    }
}
