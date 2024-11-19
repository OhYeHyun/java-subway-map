package subway.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.LineInfo;
import subway.domain.MapRepository;
import subway.domain.Station;

class SubwayInitializerTest {

    @Test
    @DisplayName("초기 정보로 역, 노선, 노선도가 잘 생성되는지 확인")
    void 초기_생성_테스트() {
        SubwayInitializer.initialize();

        List<LineInfo> result = MapRepository.map();

        assertThat(result.get(0).getLine().getName()).isEqualTo("2호선");
        assertThat(result.get(0).getStations().stream().map(Station::getName))
                .containsExactly("교대역", "강남역", "역삼역");

        assertThat(result.get(1).getLine().getName()).isEqualTo("3호선");
        assertThat(result.get(1).getStations().stream().map(Station::getName))
                .containsExactly("교대역", "남부터미널역", "양재역", "매봉역");

        assertThat(result.get(2).getLine().getName()).isEqualTo("신분당선");
        assertThat(result.get(2).getStations().stream().map(Station::getName))
                .containsExactly("강남역", "양재역", "양재시민의숲역");
    }
}