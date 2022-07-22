package school.mjc.stage0.conditions.task4;

public class TernaryAssignment {
    public void assignAndPrintBasedOnWhichBigger(int first, int second) {
        int result;
        result = (first > 10) ? second : -10;
        System.out.println(result);
    }
}
