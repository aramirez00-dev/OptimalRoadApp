package com.oneinfo.optimalroadapp.test;

import com.oneinfo.optimalroadapp.entity.Road;
import com.oneinfo.optimalroadapp.repository.RoadRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class RoadTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private RoadRepository roadRepository;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        roadRepository.deleteAll();
    }

    // tests básicos del controlador de Road
    @Test
    void testAddRoad() throws Exception {
        String roadJson = "{ \"cost\": 100, \"source_id\": 1, \"destination_id\": 2 }";

        mockMvc.perform(put("/roads/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(roadJson))
                .andExpect(status().isOk());

        Optional<Road> road = Optional.ofNullable(roadRepository.findById(1L));
        assertTrue(road.isPresent(), "El camino debe estar presente");
        assertEquals(100, road.get().getCost(), "El camino debería costar 100");
    }
}
