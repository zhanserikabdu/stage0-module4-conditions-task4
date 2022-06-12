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

class TernaryPrinterTest extends BaseIOTest {

    @Test
    void printWhichIsBiggerPrintsWhenFirstIsBigger() {
        TernaryPrinter printer = new TernaryPrinter();

        printer.printWhichIsBigger(1, 0);

        assertOutEquals("first\n");
    }

    @Test
    void printWhichIsBiggerPrintsWhenSecondIsBigger() {
        TernaryPrinter printer = new TernaryPrinter();

        printer.printWhichIsBigger(1, 10);

        assertOutEquals("second\n");
    }

    @Test
    void printWhichIsBiggerPrintsWhenSecondIsEqual() {
        TernaryPrinter printer = new TernaryPrinter();

        printer.printWhichIsBigger(1, 1);

        assertOutEquals("second\n");
    }

    @Test
    void notContainsIfOrObjects() throws IOException {
        Path path = Paths.get("src/main/java/school/mjc/stage0/conditions/task4/TernaryPrinter.java");
        List<String> strings = Files.readAllLines(path);
        List<String> ifLines = strings.stream()
                .filter(line -> line.contains("if"))
                .collect(Collectors.toList());

        List<String> soutAmount = strings.stream()
                .filter(line -> line.contains("System.out.println"))
                .collect(Collectors.toList());

        assertEquals(0, ifLines.size());
        assertEquals(1, soutAmount.size());
    }
}