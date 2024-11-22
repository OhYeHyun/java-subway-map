package subway.service;

import java.util.List;
import subway.domain.MapRepository;
import subway.domain.Station;

public class MapService {

    public static void displayMap() {
        MapRepository.map().forEach(lineInfo -> {
            printLineHead(lineInfo.getLine().getName());
            printStations(lineInfo.getStations());
        });
    }

    private static void printLineHead(String line) {
        print(DisplayInfo.FORMAT.getInfo(line));
        print(DisplayInfo.INFO_LINE.getInfo());
    }

    private static void printStations(List<Station> stations) {
        stations.forEach(station -> {
            print(DisplayInfo.FORMAT.getInfo(station.getName()));
        });
    }

    private static void print(String str) {
        System.out.println(str);
    }
}
