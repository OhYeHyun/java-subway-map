package subway.controller;

import static subway.view.SubwayInputView.getInput;

import java.util.Objects;
import subway.service.SectionService;
import subway.validator.serviceValidator.SectionValidator;
import subway.view.SubwayInputView;
import subway.view.SubwayOutputView;

public class SectionController {

    private static String selectOption() {
        return SubwayInputView.getOption();
    }

    public void run() {
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
                if (isError) {
                    SubwayOutputView.noticeNotFoundOption();
                }
            } catch (IllegalArgumentException e) {
                SubwayOutputView.print(e.getMessage());
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
        int order = SubwayInputView.getOrder();

        SectionValidator.checkOrderToAdd(line,order);

        SectionService.addSection(line, station, order);
        SubwayOutputView.noticeSectionAdded();
    }

    private void deleteSection() {
        SubwayOutputView.inputLineToDeleteSection();
        String line = getInput();

        SectionValidator.checkLineToDelete(line);

        SubwayOutputView.inputStationToDeleteSection();
        String station = getInput();

        SectionValidator.checkStationToDelete(line, station);

        SectionService.deleteSection(line, station);
        SubwayOutputView.noticeSectionDeleted();
    }
}
