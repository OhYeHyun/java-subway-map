package subway.view;

import subway.ErrorMessage.ValidatorErrorMessage;
import subway.constant.Instruction;
import subway.constant.Menu;
import subway.constant.OptionList;
import subway.constant.Service;
import subway.constant.Target;

public class SubwayOutputView {

    public static void print(String text) {
        System.out.println(text);
    }

    public static void printLineSpace() {
        System.out.print(System.lineSeparator());
    }

    public static void printWithLineSpace(String text) {
        printLineSpace();
        print(text);
    }

    public static void selectOption() {
        printWithLineSpace(Instruction.SELECT_OPTION.getInstruction());
    }

    public static void displayStation() {
        printWithLineSpace(Instruction.DISPLAY.getInstruction(Target.STATION_LIST.getTarget()));
    }

    public static void displayLine() {
        printWithLineSpace(Instruction.DISPLAY.getInstruction(Target.LINE_LIST.getTarget()));
    }

    public static void displayMap() {
        printWithLineSpace(Instruction.DISPLAY.getInstruction(Target.MAP_LIST.getTarget()));
    }

    public static void inputStationToAdd() {
        printWithLineSpace(Instruction.INPUT_TO_ADD.getInstruction(Target.STATION_NAME.getTarget()));
    }

    public static void inputStationToDelete() {
        printWithLineSpace(Instruction.INPUT_TO_DELETE.getInstruction(Target.STATION_NAME.getTarget()));
    }

    public static void inputLineToAdd() {
        printWithLineSpace(Instruction.INPUT_TO_ADD.getInstruction(Target.LINE_NAME.getTarget()));
    }

    public static void inputUpwardToAdd() {
        printWithLineSpace(Instruction.INPUT_TO_ADD.getInstruction(Target.UPWARD_STATION_NAME.getTarget()));
    }

    public static void inputDownwardToAdd() {
        printWithLineSpace(Instruction.INPUT_TO_ADD.getInstruction(Target.DOWNWARD_STATION_NAME.getTarget()));
    }

    public static void inputLineToDelete() {
        printWithLineSpace(Instruction.INPUT_TO_DELETE.getInstruction(Target.LINE_NAME.getTarget()));
    }

    public static void inputLineToAddSection() {
        printWithLineSpace(Instruction.INPUT_SECTION.getInstruction(Target.LINE.getTarget()));
    }

    public static void inputStationToAddSection() {
        printWithLineSpace(Instruction.INPUT_SECTION.getInstruction(Target.STATION.getTarget()));
    }

    public static void inputOrderToAddSection() {
        printWithLineSpace(Instruction.INPUT_SECTION.getInstruction(Target.ORDER.getTarget()));
    }

    public static void inputLineToDeleteSection() {
        printWithLineSpace(Instruction.INPUT_TO_DELETE.getInstruction(Target.LINE_OF_SECTION.getTarget()));
    }

    public static void inputStationToDeleteSection() {
        printWithLineSpace(Instruction.INPUT_TO_DELETE.getInstruction(Target.STATION_OF_SECTION.getTarget()));
    }

    public static void noticeNotFoundOption() {
        printWithLineSpace(ValidatorErrorMessage.MUST_BE_NUMBER_IN_MENU.getMessage());
    }

    public static void noticeStationAdded() {
        printWithLineSpace(Service.ADD.getInfo(Target.STATION_OF_SUBWAY.getTarget()));
    }

    public static void noticeStationDeleted() {
        printWithLineSpace(Service.DELETE.getInfo(Target.STATION_OF_SUBWAY.getTarget()));
    }

    public static void noticeLineAdded() {
        printWithLineSpace(Service.ADD.getInfo(Target.LINE_OF_SUBWAY.getTarget()));
    }

    public static void noticeLineDeleted() {
        printWithLineSpace(Service.DELETE.getInfo(Target.LINE_OF_SUBWAY.getTarget()));
    }

    public static void noticeSectionAdded() {
        printWithLineSpace(Service.ADD.getInfo(Target.SECTION_OF_SUBWAY.getTarget()));
    }

    public static void noticeSectionDeleted() {
        printWithLineSpace(Service.DELETE.getInfo(Target.SECTION_OF_SUBWAY.getTarget()));
    }

    public static void printMenu(Menu menu) {
        printWithLineSpace(Instruction.TITLE.getInstruction(menu.getTitle()));

        for (int i = 0; i < menu.getOptions().length; i++) {
            print(OptionList.OPTION.getOption(String.valueOf(i + 1), menu.getOptions()[i]));
        }

        if (menu.isIncludeBack()) {
            print(OptionList.BACK.getOption());
        }
    }

    public static void printMain() {
        printMenu(Menu.MAIN);
        print(OptionList.QUIT.getOption());
    }

    public static void printStation() {
        printMenu(Menu.STATION);
    }

    public static void printLine() {
        printMenu(Menu.LINE);
    }

    public static void printsSection() {
        printMenu(Menu.SECTION);
    }
}
