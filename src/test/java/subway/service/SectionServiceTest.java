package subway.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.config.SubwayInitializer;
import subway.domain.LineInfo;
import subway.domain.MapRepository;
import subway.domain.Station;

class SectionServiceTest {

    @Test
    @DisplayName("구간 삭제가 올바르게 되는지 확인")
    void 구간_삭제_테스트() {
        SubwayInitializer.initialize();

        SectionService.addSection("2호선", "양재역", 3);
        List<LineInfo> result = MapRepository.map();

        assertThat(result.get(0).getStations().stream().map(Station::getName)).containsExactly("교대역", "강남역", "양재역", "역삼역");
    }
}