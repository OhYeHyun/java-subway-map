package subway.validator.serviceValidator;

import static subway.domain.LineRepository.isLineExist;
import static subway.domain.StationRepository.isStationExist;

import subway.ErrorMessage.DataErrorMessage;

public class LineValidator {
    public static final int LINE_NAME_LENGTH = 2;

    public static void checkLineToAdd(String line) {
        if (line.length() < LINE_NAME_LENGTH) {
            throw new IllegalArgumentException(DataErrorMessage.LINE_NAME_LENGTH_INVALID.getMessage());
        }

        if (isLineExist(line)) {
            throw new IllegalArgumentException(DataErrorMessage.ALREADY_EXIST_LINE.getMessage());
        }
    }

    public static void checkStationToAdd(String station) {
        if (!isStationExist(station)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_STATION.getMessage());
        }
    }

    public static void checkLineToDelete(String line) {
        if (!isLineExist(line)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_LINE.getMessage());
        }
    }
}
