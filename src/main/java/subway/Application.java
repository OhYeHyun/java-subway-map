package subway;

import subway.config.SubwayInitializer;
import subway.controller.LineController;
import subway.controller.MapController;
import subway.controller.SectionController;
import subway.controller.StationController;
import subway.controller.SubwayController;

public class Application {
    public static void main(String[] args) {
        StationController stationController = new StationController();
        LineController lineController = new LineController();
        SectionController sectionController = new SectionController();
        MapController mapController = new MapController();

        SubwayController controller = new SubwayController(stationController, lineController, sectionController, mapController);
        controller.run();
    }
}
