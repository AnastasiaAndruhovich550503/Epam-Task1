package by.andruhovich.task.validation;

public class ValidationFileName {
    public boolean isRightFilename(String name) {
        String extension = name.substring(name.length() - 5, name.length());
        return extension.compareTo(".txt") == 0;
    }
}
