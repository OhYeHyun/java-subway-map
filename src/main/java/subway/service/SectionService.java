package subway.service;

import subway.domain.LineInfo;
import subway.domain.MapRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SectionService {

    public static void addSection(String line, String stationName, int order) {
        LineInfo lineInfo = MapRepository.findLineInfo(line);
        Station station = StationRepository.findStation(stationName);

        lineInfo.addSection(station, order);
    }

    public static void deleteSection(String line, String stationName) {
        LineInfo lineInfo = MapRepository.findLineInfo(line);
        Station station = StationRepository.findStation(stationName);

        lineInfo.deleteSection(station);
    }
}
