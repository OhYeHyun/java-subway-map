package subway.controller;

import static subway.view.SubwayInputView.getInput;

import java.util.Objects;
import subway.service.StationService;
import subway.validator.serviceValidator.StationValidator;
import subway.view.SubwayInputView;
import subway.view.SubwayOutputView;

public class StationController {
    private final StationService stationService;
    private final StationValidator stationValidator;

    public StationController(StationService stationService, StationValidator stationValidator) {
        this.stationService = stationService;
        this.stationValidator = stationValidator;
    }

    private static String selectOption() {
        return SubwayInputView.getOption();
    }

    public void run() {
        boolean isError = true;
        while (isError) {
            SubwayOutputView.printStation();
            String option = selectOption();
            try {
                if (Objects.equals(option, "1")) {
                    addStation();
                    isError = false;
                }
                if (Objects.equals(option, "2")) {
                    deleteStation();
                    isError = false;
                }
                if (Objects.equals(option, "3")) {
                    displayStation();
                    isError = false;
                }
                if (Objects.equals(option, "B")) {
                    isError = false;
                }
                if (isError) {
                    SubwayOutputView.noticeNotFoundOption();
                }
            } catch (IllegalArgumentException e) {
                SubwayOutputView.print(e.getMessage());
            }
        }
    }

    private void addStation() {
        SubwayOutputView.inputStationToAdd();
        String station = getInput();

        stationValidator.checkStationToAdd(station);

        stationService.addStation(station);
        SubwayOutputView.noticeStationAdded();
    }

    private void deleteStation() {
        SubwayOutputView.inputStationToDelete();
        String station = getInput();

        stationValidator.checkStationToDelete(station);

        stationService.deleteStation(station);
        SubwayOutputView.noticeStationDeleted();
    }

    private void displayStation() {
        SubwayOutputView.displayStation();
        stationService.displayStation();
    }
}
