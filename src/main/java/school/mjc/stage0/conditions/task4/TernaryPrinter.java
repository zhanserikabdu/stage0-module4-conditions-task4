package school.mjc.stage0.conditions.task4;

public class TernaryPrinter {
    public void printWhichIsBigger(int first, int second) {
        int max;
        max = (first > second) ? first : second;
        System.out.println(max);
    }
}
