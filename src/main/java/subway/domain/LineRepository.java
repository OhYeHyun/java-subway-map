package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void deleteLine(Line line) {
        lines.remove(line);
    }

    public static boolean isLineExist(String name) {
        return lines.stream().anyMatch(line -> Objects.equals(line.getName(), name));
    }

    public static Line findLine(String name) {
        return lines.stream().filter(line ->  Objects.equals(line.getName(), name)).findFirst().get();
    }
}
