package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class MapRepository {
    private static final List<LineInfo> map = new ArrayList<>();

    public static void addLineInfo(LineInfo lineInfo) {
        map.add(lineInfo);
    }
}
