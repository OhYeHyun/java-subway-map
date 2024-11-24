package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final LineRepository instance = new LineRepository();
    private static final List<Line> lines = new ArrayList<>();

    private LineRepository() {}

    public static LineRepository getInstance() {
        return instance;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public void deleteLine(Line line) {
        lines.remove(line);
    }

    public boolean isLineExist(String name) {
        return lines.stream().anyMatch(line -> Objects.equals(line.getName(), name));
    }

    public Line findLine(String name) {
        return lines.stream().filter(line ->  Objects.equals(line.getName(), name)).findFirst().get();
    }
}
