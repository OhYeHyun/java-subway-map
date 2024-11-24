package subway.validator.serviceValidator;

import subway.ErrorMessage.DataErrorMessage;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class LineValidator {
    private static final int LINE_NAME_LENGTH = 2;

    private final StationRepository stationRepository;
    private final LineRepository lineRepository;

    public LineValidator() {
        this.stationRepository = StationRepository.getInstance();
        this.lineRepository = LineRepository.getInstance();
    }

    public void checkLineToAdd(String line) {
        if (line.length() <= LINE_NAME_LENGTH) {
            throw new IllegalArgumentException(DataErrorMessage.LINE_NAME_LENGTH_INVALID.getMessage());
        }

        if (lineRepository.isLineExist(line)) {
            throw new IllegalArgumentException(DataErrorMessage.ALREADY_EXIST_LINE.getMessage());
        }
    }

    public void checkStationToAdd(String station) {
        if (!stationRepository.isStationExist(station)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_STATION.getMessage());
        }
    }

    public void checkLineToDelete(String line) {
        if (!lineRepository.isLineExist(line)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_LINE.getMessage());
        }
    }
}
