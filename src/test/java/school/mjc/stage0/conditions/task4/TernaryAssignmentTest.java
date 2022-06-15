package school.mjc.stage0.conditions.task4;

import school.mjc.stage0.base.BaseIOTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TernaryAssignmentTest extends BaseIOTest {

    private static final String RAW_NUMBER_SOUT = "^.+(System\\.out\\.println\\D+);";


    @Test
    void assignAndPrintBasedOnWhichBiggerPrint10WhenFirstIsBigger() {
        TernaryAssignment assignment = new TernaryAssignment();

        assignment.assignAndPrintBasedOnWhichBigger(10, 9);

        assertOutEquals("10\n");
    }

    @Test
    void assignAndPrintBasedOnWhichBiggerPrintWhenSecondIsBigger() {
        TernaryAssignment assignment = new TernaryAssignment();

        assignment.assignAndPrintBasedOnWhichBigger(10, 19);

        assertOutEquals("-10\n");
    }


    @Test
    void notContainsIfOrRawPrint() throws IOException {
        Path path = Paths.get("src/main/java/school/mjc/stage0/conditions/task4/TernaryAssignment.java");
        List<String> strings = Files.readAllLines(path);
        List<String> ifLines = strings.stream()
                .filter(line -> line.contains("if"))
                .collect(Collectors.toList());

        List<String> rawNumbersPrinted = strings.stream()
                .filter(line ->
                        line.matches(RAW_NUMBER_SOUT))
                .collect(Collectors.toList());

        assertEquals(0, ifLines.size());
        assertEquals(1, rawNumbersPrinted.size());
    }
}