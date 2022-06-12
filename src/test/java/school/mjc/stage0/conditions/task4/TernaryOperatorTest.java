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

class TernaryOperatorTest extends BaseIOTest {

    public static final String TERNARY_REGEXP = ".+(=).+(<).+(?).+(:)";
    public static final String ROW_ASSIGNMENT_REGEXP = "(b)\\s*(=)\\s*23";
    private static final String RAW_NUMBER_SOUT = "^.+(System\\.out\\.println\\D+\\d+\\D+);";


    @Test
    void mainPrintsExpected() {
        TernaryOperator.main(null);

        assertOutEquals("23\n");
    }

    @Test
    void containsTernary() throws IOException {
        Path path = Paths.get("src/main/java/school/mjc/stage0/conditions/task4/TernaryOperator.java");
        List<String> strings = Files.readAllLines(path);
        List<String> result = strings.stream()
                .filter(line -> line.matches(TERNARY_REGEXP))
                .collect(Collectors.toList());

        List<String> assignmentLine = strings.stream()
                .filter(line -> line.matches(ROW_ASSIGNMENT_REGEXP))
                .collect(Collectors.toList());

        List<String> rawNumbersPrinted = strings.stream()
                .filter(line ->
                        line.matches(RAW_NUMBER_SOUT))
                .collect(Collectors.toList());

        assertEquals(0, rawNumbersPrinted.size());
        assertEquals(1, result.size());
        assertEquals(0, assignmentLine.size());
    }
}