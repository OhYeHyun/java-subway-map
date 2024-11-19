package subway.config;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineInfo;
import subway.domain.MapRepository;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationAddedRepository;
import subway.domain.StationRepository;

public class SubwayInitializer {
    public static final String[] STATIONS = {"교대역", "강남역", "역삼역", "남부터미널역", "양재시민의숲역", "매봉역"};
    public static final String[] LINES = {"2호선", "3호선", "신분당선"};
    public static final String[] LINE_INFO1 = {"2호선", "교대역", "강남역", "역삼역"};
    public static final String[] LINE_INFO2 = {"3호선", "교대역", "남부터미널역", "양재역", "매봉역"};
    public static final String[] LINE_INFO3 = {"신분당선", "강남역", "양재역", "양재시민의숲역"};
    public static final String[][] LINE_INFOS = {LINE_INFO1, LINE_INFO2, LINE_INFO3};


    public static void initialize() {
        initializeStation();
        initializeLine();
        initializeMap();
    }

    private static void initializeStation() {
        for (String station : STATIONS) {
            StationRepository.addStation(generateStation(station));
        }
    }

    private static void initializeLine() {
        for (String line : LINES) {
            LineRepository.addLine(generateLine(line));
        }
    }

    private static void initializeMap() {
        for (String[] lineInfo : LINE_INFOS) {
            Line line = generateLine(lineInfo[0]);
            String[] stations = Arrays.copyOfRange(lineInfo, 1, lineInfo.length);

            MapRepository.addLineInfo(generateLineInfo(line, makeStations(stations)));
        }
    }

    private static List<Station> makeStations(String[] stations) {
        List<Station> stationList = new LinkedList<>();

        for (String station : stations) {
            stationList.add(generateStation(station));
            StationAddedRepository.addStation(generateStation(station));
        }
        return stationList;
    }

    private static Line generateLine(String line) {
        return new Line(line);
    }

    private static Station generateStation(String station) {
        return new Station(station);
    }

    private static LineInfo generateLineInfo(Line line, List<Station> stations) {
        return new LineInfo(line, stations);
    }
}
