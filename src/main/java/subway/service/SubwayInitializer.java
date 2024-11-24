package subway.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineInfo;
import subway.domain.MapRepository;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayInitializer {
    private static final String[] STATIONS = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static final String[] LINES = {"2호선", "3호선", "신분당선"};
    private static final String[] LINE_INFO1 = {"2호선", "교대역", "강남역", "역삼역"};
    private static final String[] LINE_INFO2 = {"3호선", "교대역", "남부터미널역", "양재역", "매봉역"};
    private static final String[] LINE_INFO3 = {"신분당선", "강남역", "양재역", "양재시민의숲역"};
    private static final String[][] LINE_INFOS = {LINE_INFO1, LINE_INFO2, LINE_INFO3};

    private final StationRepository stationRepository;
    private final LineRepository lineRepository;
    private final MapRepository mapRepository;

    public SubwayInitializer() {
        this.stationRepository = StationRepository.getInstance();
        this.lineRepository = LineRepository.getInstance();
        this.mapRepository = MapRepository.getInstance();
    }

    public void initialize() {
        initializeStation();
        initializeLine();
        initializeMap();
    }

    private void initializeStation() {
        for (String station : STATIONS) {
            stationRepository.addStation(generateStation(station));
        }
    }

    private void initializeLine() {
        for (String line : LINES) {
            lineRepository.addLine(generateLine(line));
        }
    }

    private void initializeMap() {
        for (String[] lineInfo : LINE_INFOS) {
            Line line = lineRepository.findLine(lineInfo[0]);
            String[] stations = Arrays.copyOfRange(lineInfo, 1, lineInfo.length);

            mapRepository.addLineInfo(generateLineInfo(line, findStations(stations)));
        }
    }

    private List<Station> findStations(String[] stations) {
        List<Station> stationList = new LinkedList<>();

        for (String station : stations) {
            stationList.add(stationRepository.findStation(station));
        }
        return stationList;
    }

    private Line generateLine(String line) {
        return new Line(line);
    }

    private Station generateStation(String station) {
        return new Station(station);
    }

    private LineInfo generateLineInfo(Line line, List<Station> stations) {
        return new LineInfo(line, stations);
    }
}
