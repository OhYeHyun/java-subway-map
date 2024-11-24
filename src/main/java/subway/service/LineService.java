package subway.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import subway.constant.Service;
import subway.domain.Line;
import subway.domain.LineInfo;
import subway.domain.LineRepository;
import subway.domain.MapRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.SubwayOutputView;

public class LineService {
    private final StationRepository stationRepository;
    private final LineRepository lineRepository;
    private final MapRepository mapRepository;

    public LineService() {
        this.stationRepository = StationRepository.getInstance();
        this.lineRepository = LineRepository.getInstance();
        this.mapRepository = MapRepository.getInstance();
    }

    public void addLine(String lineName, String upward, String downward) {
        Line line = generateLine(lineName);
        lineRepository.addLine(line);

        List<Station> stations = new LinkedList<>(Arrays.asList(findStation(upward), findStation(downward)));

        mapRepository.addLineInfo(generateLineInfo(line, stations));
    }

    public void deleteLine(String lineName) {
        Line line = lineRepository.findLine(lineName);
        lineRepository.deleteLine(line);

        LineInfo lineInfo = mapRepository.findLineInfo(lineName);
        mapRepository.deleteLineInfo(lineInfo);
    }

    public void displayLine() {
        lineRepository.lines().forEach(line -> {
            SubwayOutputView.print(Service.FORMAT.getInfo(line.getName()));
        });
    }

    private Line generateLine(String line) {
        return new Line(line);
    }

    private LineInfo generateLineInfo(Line line, List<Station> stations) {
         return new LineInfo(line, stations);
    }

    private Station findStation(String station) {
        return stationRepository.findStation(station);
    }
 }
