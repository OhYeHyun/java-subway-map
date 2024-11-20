package subway.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Station;
import subway.domain.StationRepository;

class StationServiceTest {

    @Test
    @DisplayName("역 추가가 올바르게 되는지 확인")
    void 역_추가_테스트() {
        StationRepository.clear();

        StationService.addStation("교대역");
        StationService.addStation("강남역");

        List<Station> result = StationRepository.stations();

        assertThat(result.stream().map(Station::getName)).containsExactly("교대역", "강남역");
    }

    @Test
    @DisplayName("역 삭제가 올바르게 되는지 확인")
    void 역_삭제_테스트() {
        StationRepository.clear();

        StationService.addStation("교대역");
        StationService.addStation("강남역");
        StationService.deleteStation("교대역");
        StationService.deleteStation("강남역");

        List<Station> result = StationRepository.stations();

        assertThat(result.stream().map(Station::getName)).containsExactly();
    }
}