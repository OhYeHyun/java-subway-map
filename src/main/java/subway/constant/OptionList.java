package subway.constant;

public enum OptionList {
    OPTION("%s. %s"),
    QUIT("Q. 종료"),
    BACK("B. 돌아가기");

    private final String option;

    OptionList(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public String getOption(String number, String target) {
        return String.format(option, number, target);
    }
}
