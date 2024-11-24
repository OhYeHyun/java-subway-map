package subway;

import subway.controller.LineController;
import subway.controller.MapController;
import subway.controller.SectionController;
import subway.controller.StationController;
import subway.controller.SubwayController;
import subway.service.LineService;
import subway.service.MapService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.service.SubwayInitializer;
import subway.validator.serviceValidator.LineValidator;
import subway.validator.serviceValidator.SectionValidator;
import subway.validator.serviceValidator.StationValidator;

public class Application {
    public static void main(String[] args) {
        StationController stationController = generateStationController();
        LineController lineController = generateLineController();
        SectionController sectionController = generateSectionController();
        MapController mapController = generateMapController();

        SubwayInitializer initializer = new SubwayInitializer();

        SubwayController controller = new SubwayController(stationController, lineController, sectionController, mapController, initializer);
        controller.run();
    }

    private static StationController generateStationController() {
        StationService service = new StationService();
        StationValidator validator = new StationValidator();

        return new StationController(service, validator);
    }

    private static LineController generateLineController() {
        LineService service = new LineService();
        LineValidator validator = new LineValidator();

        return new LineController(service, validator);
    }

    private static SectionController generateSectionController() {
        SectionService service = new SectionService();
        SectionValidator validator = new SectionValidator();

        return new SectionController(service, validator);
    }

    private static MapController generateMapController() {
        MapService service = new MapService();

        return new MapController(service);
    }
}
