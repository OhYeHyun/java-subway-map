package subway.controller;

import static subway.view.SubwayInputView.getNumber;

import java.util.Objects;
import subway.config.SubwayInitializer;
import subway.service.LineService;
import subway.service.MapService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.validator.serviceValidator.LineValidator;
import subway.validator.serviceValidator.SectionValidator;
import subway.validator.serviceValidator.StationValidator;
import subway.view.SubwayInputView;
import subway.view.SubwayOutputView;

public class SubwayController {

     public void run() {
        SubwayInitializer.initialize();

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
        SubwayOutputView.selectOption();
        return getInput();
    }



    private String getInput() {
        return SubwayInputView.getInput();
    }

    private void processOption(String option) {
        if (Objects.equals(option, "1")) {
            processStation();
        }
        if (Objects.equals(option, "2")) {
            processLine();
        }
        if (Objects.equals(option, "3")) {
            processSection();
        }
        if (Objects.equals(option, "4")) {
            processMap();
        }
    }

    private void processStation() {
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
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void addStation() {
        SubwayOutputView.inputStationToAdd();
        String station = getInput();

        StationValidator.checkStationToAdd(station);

        StationService.addStation(station);
        SubwayOutputView.noticeStationAdded();
    }

    private void deleteStation() {
        SubwayOutputView.inputStationToDelete();
        String station = getInput();

        StationValidator.checkStationToDelete(station);

        StationService.deleteStation(station);
        SubwayOutputView.noticeStationDeleted();
    }

    private void displayStation() {
        SubwayOutputView.displayStation();
        StationService.displayStation();
    }

    private void processLine() {
        boolean isError = true;
        while (isError) {
            SubwayOutputView.printLine();
            String option = selectOption();
            try {
                if (Objects.equals(option, "1")) {
                    addLine();
                    isError = false;
                }
                if (Objects.equals(option, "2")) {
                    deleteLine();
                    isError = false;
                }
                if (Objects.equals(option, "3")) {
                    displayLine();
                    isError = false;
                }
                if (Objects.equals(option, "B")) {
                    isError = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void addLine() {
        SubwayOutputView.inputLineToAdd();
        String line = getInput();

        LineValidator.checkLineToAdd(line);

        SubwayOutputView.inputUpwardToAdd();
        String upward = getInput();

        LineValidator.checkStationToAdd(upward);

        SubwayOutputView.inputDownwardToAdd();
        String downward = getInput();

        LineValidator.checkStationToAdd(downward);

        LineService.addLine(line, upward, downward);
        SubwayOutputView.noticeLineAdded();
    }

    private void deleteLine() {
        SubwayOutputView.inputStationToDelete();
        String line = getInput();

        LineValidator.checkLineToDelete(line);

        LineService.deleteLine(line);
        SubwayOutputView.noticeLineDeleted();
    }

    private void displayLine() {
        SubwayOutputView.displayLine();
        LineService.displayLine();
    }

    private void processSection() {
        boolean isError = true;
        while (isError) {
            SubwayOutputView.printsSection();
            String option = selectOption();
            try {
                if (Objects.equals(option, "1")) {
                    addSection();
                    isError = false;
                }
                if (Objects.equals(option, "2")) {
                    deleteSection();
                    isError = false;
                }
                if (Objects.equals(option, "B")) {
                    isError = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void addSection() {
        SubwayOutputView.inputLineToAddSection();
        String line = getInput();

        SectionValidator.checkLineToAdd(line);

        SubwayOutputView.inputStationToAddSection();
        String station = getInput();

        SectionValidator.checkStationToAdd(line, station);

        SubwayOutputView.inputOrderToAddSection();
        int order = getNumber();

        SectionValidator.checkOrderToAdd(line,order);

        SectionService.addSection(line, station, order);
        SubwayOutputView.noticeSectionAdded();
    }

    private void deleteSection() {
        SubwayOutputView.inputLineToDelete();
        String line = getInput();

        SectionValidator.checkLineToDelete(line);

        SubwayOutputView.inputStationToDeleteSection();
        String station = getInput();

        SectionValidator.checkStationToDelete(line, station);

        SectionService.deleteSection(line, station);
        SubwayOutputView.noticeSectionDeleted();
    }

    private void processMap() {
        SubwayOutputView.displayMap();
        MapService.displayMap();
    }
}
