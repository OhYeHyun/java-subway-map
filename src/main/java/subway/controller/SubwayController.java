package subway.controller;

import java.util.Objects;
import subway.service.SubwayInitializer;
import subway.view.SubwayInputView;
import subway.view.SubwayOutputView;

public class SubwayController {
    private final StationController stationController;
    private final LineController lineController;
    private final SectionController sectionController;
    private final MapController mapController;
    private final SubwayInitializer initializer;

    public SubwayController(StationController stationController, LineController lineController, SectionController sectionController, MapController mapController, SubwayInitializer initializer) {
        this.stationController = stationController;
        this.lineController = lineController;
        this.sectionController = sectionController;
        this.mapController = mapController;
        this.initializer = initializer;
    }

     public void run() {
         initializer.initialize();

        boolean done = false;
        while (!done) {
            SubwayOutputView.printMain();
            String input = selectOption();

            processOption(input);

            if (Objects.equals(input, "Q")) {
                done = true;
            }
        }
    }

    private String selectOption() {
         return SubwayInputView.getOption();
    }

    private void processOption(String option) {
         boolean isMatch = false;
        if (Objects.equals(option, "1")) {
            stationController.run();
            isMatch = true;
        }
        if (Objects.equals(option, "2")) {
            lineController.run();
            isMatch = true;
        }
        if (Objects.equals(option, "3")) {
            sectionController.run();
            isMatch = true;
        }
        if (Objects.equals(option, "4")) {
            mapController.run();
            isMatch = true;
        }
        if (Objects.equals(option, "Q")) {
            isMatch = true;
        }
        if (!isMatch) {
            SubwayOutputView.noticeNotFoundOption();
        }
    }
}