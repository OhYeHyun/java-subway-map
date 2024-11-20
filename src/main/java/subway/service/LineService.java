package subway.service;

import java.util.Arrays;
import java.util.List;
import subway.ErrorMessage.DataErrorMessage;
import subway.domain.Line;
import subway.domain.LineInfo;
import subway.domain.LineRepository;
import subway.domain.MapRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.SubwayOutputView;

public class LineService {

    public static void addLine(String line, String upward, String downward) {
        MapRepository.addLineInfo(generateLineInfo(line, upward, downward));
    }

    public static void deleteLine(String line) {
        StationRepository.deleteStation(line);
    }

    public static void displayLine() {
        LineRepository.lines().forEach(line -> SubwayOutputView.print(line.getName()));
    }

    private static Line generateLine(String line) {
        return new Line(line);
    }

    private static LineInfo generateLineInfo(String lineName, String upward, String downward) {
        Line line = generateLine(lineName);
        List<Station> stations = Arrays.asList(findStation(upward), findStation(downward));

        LineRepository.addLine(line);

        return new LineInfo(line, stations);
    }

    private static Station findStation(String station) {
        return StationRepository.findStation(station);
    }

    private static void checkAddLine(String line) {
        if (LineRepository.isLineExist(line)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_UNIQUE_LINE.getMessage());
        }
    }

    private static void checkAddUpward(String upward) {
        if (!StationRepository.isStationExist(upward)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_EXISTING_STATION.getMessage());
        }
    }

    private static void checkAddDownward(String downward) {
        if (!StationRepository.isStationExist(downward)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_EXISTING_STATION.getMessage());
        }
    }

    private static void checkDeleteLine(String line) {
        if (!StationRepository.isStationExist(line)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_EXISTING_STATION.getMessage());
        }
    }
 }
