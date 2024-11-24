package subway.validator.serviceValidator;

import subway.ErrorMessage.DataErrorMessage;
import subway.domain.MapRepository;
import subway.domain.StationRepository;

public class SectionValidator {
    private final StationRepository stationRepository;
    private final MapRepository mapRepository;

    public SectionValidator() {
        this.stationRepository = StationRepository.getInstance();
        this.mapRepository = MapRepository.getInstance();
    }

    public void validateLineToAdd(String line) {
        if (!mapRepository.isLineInfoExist(line)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_LINE.getMessage());
        }
    }

    public void validateStationToAdd(String line, String station) {
        if (!stationRepository.isStationExist(station)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_STATION.getMessage());
        }

        if (mapRepository.findLineInfo(line).isStationExistInLineInfo(station)) {
            throw new IllegalArgumentException(DataErrorMessage.CANNOT_ADD_ALREADY_ADDED_STATION_TO_LINE.getMessage());
        }
    }

    public void validateOrderToAdd(String line, int order) {
        if (!mapRepository.findLineInfo(line).canAddStation(order)) {
            throw new IllegalArgumentException(DataErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    public void validateLineToDelete(String line) {
        if (!mapRepository.isLineInfoExist(line)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_LINE.getMessage());
        }

        if (!mapRepository.findLineInfo(line).canDeleteStation()) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_ENOUGH_STATION_TO_DELETE.getMessage());
        }
    }

    public void checkStationToDelete(String line, String station) {
        if (!mapRepository.findLineInfo(line).isStationExistInLineInfo(station)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_STATION.getMessage());
        }
    }
}
