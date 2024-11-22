package subway.view;

import subway.Constant.Instruction;
import subway.Constant.Menu;
import subway.Constant.Option;
import subway.Constant.Target;

public class SubwayOutputView {

    public static void print(String text) {
        System.out.println(text);
    }

    public static void printLineSpace() {
        System.out.print(System.lineSeparator());
    }

    public static void selectOption() {
        print(Instruction.SELECT_OPTION.getInstruction());
    }

    public static void displayStation() {
        print(Instruction.DISPLAY.getInstruction(Target.STATION_LIST.getTarget()));
    }

    public static void displayLine() {
        print(Instruction.DISPLAY.getInstruction(Target.LINE_LIST.getTarget()));
    }

    public static void displayMap() {
        print(Instruction.DISPLAY.getInstruction(Target.MAP_LIST.getTarget()));
    }

    public static void inputStationToAdd() {
        print(Instruction.INPUT_TO_ADD.getInstruction(Target.STATION_NAME.getTarget()));
    }

    public static void inputStationToDelete() {
        print(Instruction.INPUT_TO_DELETE.getInstruction(Target.STATION_NAME.getTarget()));
    }

    public static void inputLineToAdd() {
        print(Instruction.INPUT_TO_ADD.getInstruction(Target.LINE_NAME.getTarget()));
    }

    public static void inputUpwardToAdd() {
        print(Instruction.INPUT_TO_ADD.getInstruction(Target.UPWARD_STATION_NAME.getTarget()));
    }

    public static void inputDownwardToAdd() {
        print(Instruction.INPUT_TO_ADD.getInstruction(Target.DOWNWARD_STATION_NAME.getTarget()));
    }

    public static void inputLineToDelete() {
        print(Instruction.INPUT_TO_DELETE.getInstruction(Target.LINE_NAME.getTarget()));
    }

    public static void inputLineToAddSection() {
        print(Instruction.INPUT_SECTION.getInstruction(Target.LINE.getTarget()));
    }

    public static void inputStationToAddSection() {
        print(Instruction.INPUT_SECTION.getInstruction(Target.STATION.getTarget()));
    }

    public static void inputOrderToAddSection() {
        print(Instruction.INPUT_SECTION.getInstruction(Target.ORDER.getTarget()));
    }

    public static void inputLineToDeleteSection() {
        print(Instruction.INPUT_TO_DELETE.getInstruction(Target.LINE_OF_SECTION.getTarget()));
    }

    public static void inputStationToDeleteSection() {
        print(Instruction.INPUT_TO_DELETE.getInstruction(Target.STATION_OF_SECTION.getTarget()));
    }

    public static void printMenu(Menu menu) {
        print(Instruction.TITLE.getInstruction(menu.getTitle()));

        for (int i = 0; i < menu.getOptions().length; i++) {
            print(Option.OPTION.getOption(String.valueOf(i + 1), menu.getOptions()[i]));
        }

        if (menu.isIncludeBack()) {
            print(Option.BACK.getOption());
        }
    }

    public static void printMain() {
        printMenu(Menu.MAIN);
        print(Option.QUIT.getOption());
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
