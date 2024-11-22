package subway.constant;

public enum Instruction {
    TITLE("%s 화면"),
    SELECT_OPTION("원하는 기능을 선택하세요."),
    INPUT_SECTION("%s 입력하세요."),
    INPUT_TO_ADD("등록할 %s을 입력하세요."),
    INPUT_TO_DELETE("삭제할 %s을 입력하세요."),
    DISPLAY("%s");

    private static final String PREFIX = "## ";
    private final String instruction;

    Instruction(String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return PREFIX + instruction;
    }

    public String getInstruction(String target) {
        return String.format(PREFIX + instruction, target);
    }
}
