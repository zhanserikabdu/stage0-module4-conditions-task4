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

class TernaryGreatestNumberPrinterTest extends BaseIOTest {

    @Test
    void printGreatestFirstWhenBigger() {
        TernaryGreatestNumberPrinter printer = new TernaryGreatestNumberPrinter();

        printer.printGreatest(12, -400);

        assertOutEquals("12\n");
    }

    @Test
    void printGreatestSecondWhenBigger() {
        TernaryGreatestNumberPrinter printer = new TernaryGreatestNumberPrinter();

        printer.printGreatest(-400, 1);

        assertOutEquals("1\n");
    }

    @Test
    void notContainsIfOrObjects() throws IOException {
        Path path = Paths.get("src/main/java/school/mjc/stage0/conditions/task4/TernaryGreatestNumberPrinter.java");
        List<String> strings = Files.readAllLines(path);
        List<String> ifLines = strings.stream()
                .filter(line -> line.contains("if"))
                .collect(Collectors.toList());

        List<String> objectCreation = strings.stream()
                .filter(line -> line.contains("new GreatestNumberPrinter"))
                .collect(Collectors.toList());

        assertEquals(0, objectCreation.size());
        assertEquals(0, ifLines.size());
    }
}

