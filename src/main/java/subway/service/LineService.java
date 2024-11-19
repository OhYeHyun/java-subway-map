package subway.service;

import java.util.Arrays;
import subway.ErrorMessage.DataErrorMessage;
import subway.domain.Line;
import subway.domain.LineInfo;
import subway.domain.LineRepository;
import subway.domain.MapRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.SubwayOutputView;

public class LineService {

    public static void addLine(String lineName, String upward, String downward) {
        if (LineRepository.isLineAlreadyExist(lineName)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_UNIQUE_LINE.getMessage());
        }
        if (!StationRepository.isStationAlreadyExist(upward) || !StationRepository.isStationAlreadyExist(downward)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_EXISTING_STATION.getMessage());
        }

        Line line = generateLine(lineName);
        LineRepository.addLine(line);
        MapRepository.addLineInfo(generateLineInfo(line, upward, downward));
    }

    public static void deleteLine(String line) {
        if (!StationRepository.deleteStation(line)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_EXISTING_STATION.getMessage());
        }
    }

    public static void displayLine() {
        LineRepository.lines().forEach(line -> SubwayOutputView.print(line.getName()));
    }

    private static Line generateLine(String line) {
        return new Line(line);
    }

    private static LineInfo generateLineInfo(Line line, String upward, String downward) {
        return new LineInfo(line, Arrays.asList(findStation(upward), findStation(downward)));
    }

    private static Station findStation(String station) {
        return StationRepository.findStation(station);
    }
}
