package subway.service;

import subway.domain.LineInfo;
import subway.domain.MapRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SectionService {
    private final StationRepository stationRepository;
    private final MapRepository mapRepository;

    public SectionService() {
        this.stationRepository = StationRepository.getInstance();
        this.mapRepository = MapRepository.getInstance();
    }

    public void addSection(String line, String stationName, int order) {
        LineInfo lineInfo = mapRepository.findLineInfo(line);
        Station station = stationRepository.findStation(stationName);

        lineInfo.addSection(station, order);
    }

    public void deleteSection(String line, String stationName) {
        LineInfo lineInfo = mapRepository.findLineInfo(line);
        Station station = stationRepository.findStation(stationName);

        lineInfo.deleteSection(station);
    }
}
