package subway.service;

import java.util.List;
import subway.domain.MapRepository;
import subway.domain.Station;
import subway.view.SubwayOutputView;

public class MapService {

    public static void displayMap() {
        MapRepository.map().forEach(lineInfo -> {
            printLineHead(lineInfo.getLine().getName());
            printStations(lineInfo.getStations());
        });
    }

    private static void printLineHead(String line) {
        SubwayOutputView.print(DisplayInfo.FORMAT.getInfo(line));
        SubwayOutputView.print(DisplayInfo.INFO_LINE.getInfo());
    }

    private static void printStations(List<Station> stations) {
        stations.forEach(station -> {
            SubwayOutputView.print(DisplayInfo.FORMAT.getInfo(station.getName()));
        });
    }
}
