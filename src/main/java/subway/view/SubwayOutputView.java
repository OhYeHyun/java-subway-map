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

    public static void selectOption() {
        printLineSpace();
        print(Instruction.SELECT_OPTION.getInstruction());
    }

    public static void displayStation() {
        printLineSpace();
        print(Instruction.DISPLAY.getInstruction(Target.STATION_LIST.getTarget()));
    }

    public static void displayLine() {
        printLineSpace();
        print(Instruction.DISPLAY.getInstruction(Target.LINE_LIST.getTarget()));
    }

    public static void displayMap() {
        printLineSpace();
        print(Instruction.DISPLAY.getInstruction(Target.MAP_LIST.getTarget()));
    }

    public static void inputStationToAdd() {
        printLineSpace();
        print(Instruction.INPUT_TO_ADD.getInstruction(Target.STATION_NAME.getTarget()));
    }

    public static void inputStationToDelete() {
        printLineSpace();
        print(Instruction.INPUT_TO_DELETE.getInstruction(Target.STATION_NAME.getTarget()));
    }

    public static void inputLineToAdd() {
        printLineSpace();
        print(Instruction.INPUT_TO_ADD.getInstruction(Target.LINE_NAME.getTarget()));
    }

    public static void inputUpwardToAdd() {
        printLineSpace();
        print(Instruction.INPUT_TO_ADD.getInstruction(Target.UPWARD_STATION_NAME.getTarget()));
    }

    public static void inputDownwardToAdd() {
        printLineSpace();
        print(Instruction.INPUT_TO_ADD.getInstruction(Target.DOWNWARD_STATION_NAME.getTarget()));
    }

    public static void inputLineToDelete() {
        printLineSpace();
        print(Instruction.INPUT_TO_DELETE.getInstruction(Target.LINE_NAME.getTarget()));
    }

    public static void inputLineToAddSection() {
        printLineSpace();
        print(Instruction.INPUT_SECTION.getInstruction(Target.LINE.getTarget()));
    }

    public static void inputStationToAddSection() {
        printLineSpace();
        print(Instruction.INPUT_SECTION.getInstruction(Target.STATION.getTarget()));
    }

    public static void inputOrderToAddSection() {
        printLineSpace();
        print(Instruction.INPUT_SECTION.getInstruction(Target.ORDER.getTarget()));
    }

    public static void inputLineToDeleteSection() {
        printLineSpace();
        print(Instruction.INPUT_TO_DELETE.getInstruction(Target.LINE_OF_SECTION.getTarget()));
    }

    public static void inputStationToDeleteSection() {
        printLineSpace();
        print(Instruction.INPUT_TO_DELETE.getInstruction(Target.STATION_OF_SECTION.getTarget()));
    }

    public static void noticeNotFoundOption() {
        printLineSpace();
        print(ValidatorErrorMessage.MUST_BE_NUMBER_IN_MENU.getMessage());
    }

    public static void noticeStationAdded() {
        printLineSpace();
        print(Service.ADD.getInfo(Target.STATION_OF_SUBWAY.getTarget()));
    }

    public static void noticeStationDeleted() {
        printLineSpace();
        print(Service.DELETE.getInfo(Target.STATION_OF_SUBWAY.getTarget()));
    }

    public static void noticeLineAdded() {
        printLineSpace();
        print(Service.ADD.getInfo(Target.LINE_OF_SUBWAY.getTarget()));
    }

    public static void noticeLineDeleted() {
        printLineSpace();
        print(Service.DELETE.getInfo(Target.LINE_OF_SUBWAY.getTarget()));
    }

    public static void noticeSectionAdded() {
        printLineSpace();
        print(Service.ADD.getInfo(Target.SECTION_OF_SUBWAY.getTarget()));
    }

    public static void noticeSectionDeleted() {
        printLineSpace();
        print(Service.DELETE.getInfo(Target.SECTION_OF_SUBWAY.getTarget()));
    }

    public static void printMenu(Menu menu) {
        printLineSpace();
        print(Instruction.TITLE.getInstruction(menu.getTitle()));

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
