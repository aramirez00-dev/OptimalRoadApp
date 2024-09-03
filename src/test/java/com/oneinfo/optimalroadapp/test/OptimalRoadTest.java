package com.oneinfo.optimalroadapp.test;

import com.oneinfo.optimalroadapp.entity.Road;
import com.oneinfo.optimalroadapp.entity.Station;
import com.oneinfo.optimalroadapp.repository.RoadRepository;
import com.oneinfo.optimalroadapp.repository.StationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class OptimalRoadTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private RoadRepository roadRepository;

    @Autowired
    private StationRepository stationRepository;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        roadRepository.deleteAll();
        stationRepository.deleteAll();

        stationRepository.save(new Station(1L, "Buenos Aires"));
        stationRepository.save(new Station(2L, "Cordoba"));
        stationRepository.save(new Station(3L, "Montevideo"));
        stationRepository.save(new Station(4L, "Santiago"));

        roadRepository.save(new Road(1L, 5000, 2L, 4L));
        roadRepository.save(new Road(2L, 7500, 1L, 2L));
        roadRepository.save(new Road(3L, 6000, 3L, 4L));
        roadRepository.save(new Road(4L, 3000, 4L, 3L));
    }

    @Test
    void testFindOptimalPath() throws Exception {
        mockMvc.perform(get("/roads/4/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getContentAsString();
    }
}
