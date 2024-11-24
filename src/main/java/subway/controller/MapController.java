package subway.controller;

import subway.service.MapService;
import subway.view.SubwayOutputView;

public class MapController {

    public void run() {
        SubwayOutputView.displayMap();
        MapService.displayMap();
    }
}
