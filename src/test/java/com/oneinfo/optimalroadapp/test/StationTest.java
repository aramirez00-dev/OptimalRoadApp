package com.oneinfo.optimalroadapp.test;

import com.oneinfo.optimalroadapp.repository.StationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class StationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private StationRepository stationRepository;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        stationRepository.deleteAll();
    }

    @Test
    void testAddStation() throws Exception {
        String stationJson = "{ \"name\": \"Amsterdam\" }";

        mockMvc.perform(put("/stations/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(stationJson))
                .andExpect(status().isOk());

        assertTrue(stationRepository.findById(1L).getName().equals("Amsterdam"));
    }
}