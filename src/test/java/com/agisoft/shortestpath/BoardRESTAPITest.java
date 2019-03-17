package com.agisoft.shortestpath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BoardRESTAPITest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/board/walls").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"x\":0,\"y\":0,\"distance\":0,\"wall\":true}," +
                        "{\"x\":0,\"y\":1,\"distance\":0,\"wall\":true},{\"x\":0,\"y\":2,\"distance\":0,\"wall\":true}," +
                        "{\"x\":0,\"y\":3,\"distance\":0,\"wall\":true},{\"x\":0,\"y\":4,\"distance\":0,\"wall\":true}," +
                        "{\"x\":0,\"y\":5,\"distance\":0,\"wall\":true},{\"x\":0,\"y\":6,\"distance\":0,\"wall\":true}," +
                        "{\"x\":0,\"y\":7,\"distance\":0,\"wall\":true},{\"x\":0,\"y\":8,\"distance\":0,\"wall\":true}," +
                        "{\"x\":0,\"y\":9,\"distance\":0,\"wall\":true},{\"x\":1,\"y\":0,\"distance\":0,\"wall\":true}," +
                        "{\"x\":1,\"y\":9,\"distance\":0,\"wall\":true},{\"x\":2,\"y\":0,\"distance\":0,\"wall\":true}," +
                        "{\"x\":2,\"y\":9,\"distance\":0,\"wall\":true},{\"x\":3,\"y\":0,\"distance\":0,\"wall\":true}," +
                        "{\"x\":3,\"y\":9,\"distance\":0,\"wall\":true},{\"x\":4,\"y\":0,\"distance\":0,\"wall\":true}," +
                        "{\"x\":4,\"y\":9,\"distance\":0,\"wall\":true},{\"x\":5,\"y\":0,\"distance\":0,\"wall\":true}," +
                        "{\"x\":5,\"y\":9,\"distance\":0,\"wall\":true},{\"x\":6,\"y\":0,\"distance\":0,\"wall\":true}," +
                        "{\"x\":6,\"y\":9,\"distance\":0,\"wall\":true},{\"x\":7,\"y\":0,\"distance\":0,\"wall\":true}," +
                        "{\"x\":7,\"y\":9,\"distance\":0,\"wall\":true},{\"x\":8,\"y\":0,\"distance\":0,\"wall\":true}," +
                        "{\"x\":8,\"y\":9,\"distance\":0,\"wall\":true},{\"x\":9,\"y\":0,\"distance\":0,\"wall\":true}," +
                        "{\"x\":9,\"y\":1,\"distance\":0,\"wall\":true},{\"x\":9,\"y\":2,\"distance\":0,\"wall\":true}," +
                        "{\"x\":9,\"y\":3,\"distance\":0,\"wall\":true},{\"x\":9,\"y\":4,\"distance\":0,\"wall\":true}," +
                        "{\"x\":9,\"y\":5,\"distance\":0,\"wall\":true},{\"x\":9,\"y\":6,\"distance\":0,\"wall\":true}," +
                        "{\"x\":9,\"y\":7,\"distance\":0,\"wall\":true},{\"x\":9,\"y\":8,\"distance\":0,\"wall\":true}," +
                        "{\"x\":9,\"y\":9,\"distance\":0,\"wall\":true}]")));
    }

    
}