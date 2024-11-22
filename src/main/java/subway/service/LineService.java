package subway.service;

import java.util.Arrays;
import java.util.List;
import subway.Constant.Service;
import subway.domain.Line;
import subway.domain.LineInfo;
import subway.domain.LineRepository;
import subway.domain.MapRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.SubwayOutputView;

public class LineService {

    public static void addLine(String lineName, String upward, String downward) {
        Line line = generateLine(lineName);
        List<Station> stations = Arrays.asList(findStation(upward), findStation(downward));

        MapRepository.addLineInfo(generateLineInfo(line, stations));
    }

    public static void deleteLine(String lineName) {
        Line line = LineRepository.findLine(lineName);
        LineRepository.deleteLine(line);

        LineInfo lineInfo = MapRepository.findLineInfo(lineName);
        MapRepository.deleteLineInfo(lineInfo);
    }

    public static void displayLine() {
        LineRepository.lines().forEach(line -> {
            SubwayOutputView.print(Service.FORMAT.getInfo(line.getName()));
        });
    }

    private static Line generateLine(String line) {
        return new Line(line);
    }

    private static LineInfo generateLineInfo(Line line, List<Station> stations) {
         return new LineInfo(line, stations);
    }

    private static Station findStation(String station) {
        return StationRepository.findStation(station);
    }
 }
