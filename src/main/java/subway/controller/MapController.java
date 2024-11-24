package subway.controller;

import subway.service.MapService;
import subway.view.SubwayOutputView;

public class MapController {
    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    public void run() {
        SubwayOutputView.displayMap();
        mapService.displayMap();
    }
}
