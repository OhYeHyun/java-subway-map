package subway.controller;

import static subway.view.SubwayInputView.getInput;

import java.util.Objects;
import subway.service.LineService;
import subway.validator.serviceValidator.LineValidator;
import subway.view.SubwayInputView;
import subway.view.SubwayOutputView;

public class LineController {

    private static String selectOption() {
        return SubwayInputView.getOption();
    }

    public void run() {
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
                if (isError) {
                    SubwayOutputView.noticeNotFoundOption();
                }
            } catch (IllegalArgumentException e) {
                SubwayOutputView.print(e.getMessage());
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
        SubwayOutputView.inputLineToDelete();
        String line = getInput();

        LineValidator.checkLineToDelete(line);

        LineService.deleteLine(line);
        SubwayOutputView.noticeLineDeleted();
    }

    private void displayLine() {
        SubwayOutputView.displayLine();
        LineService.displayLine();
    }
}
