package subway.service;

import subway.constant.Service;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.SubwayOutputView;

public class StationService {
    private final StationRepository stationRepository;

    public StationService() {
        this.stationRepository = StationRepository.getInstance();
    }

    public void addStation(String station) {
        stationRepository.addStation(generateStation(station));
    }

    public void deleteStation(String stationName) {
        Station station = stationRepository.findStation(stationName);
        stationRepository.deleteStation(station);
    }

    public void displayStation() {
        stationRepository.stations().forEach(station -> SubwayOutputView.print(Service.FORMAT.getInfo(station.getName())));
    }

    private Station generateStation(String station) {
        return new Station(station);
    }
}
