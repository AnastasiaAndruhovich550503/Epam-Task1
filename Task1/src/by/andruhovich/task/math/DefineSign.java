package by.andruhovich.task.math;

public class DefineSign {
    public static int defineSign(double number) {
        if (number < 0) return -1;
        else if (number > 0) return 1;
        else if (number == 0) return 0;
        else return -2;
    }
}
