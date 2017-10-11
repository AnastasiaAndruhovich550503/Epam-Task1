package by.andruhovich.task.validation;

public class ValidationFileName {
    public boolean isRightFilename(String name) {
        String extension = new String();
        try {
            extension = name.substring(name.length() - 5, name.length());
        }
        catch (IndexOutOfBoundsException e) {
            return false;
        }
        return extension.compareTo(".txt") == 0;
    }
}
