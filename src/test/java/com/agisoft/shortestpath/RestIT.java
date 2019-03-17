package com.agisoft.shortestpath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/board/walls");
    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        assertThat(response.getBody(), equalTo("[{\"x\":0,\"y\":0,\"distance\":0,\"wall\":true}," +
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
                "{\"x\":9,\"y\":9,\"distance\":0,\"wall\":true}]"));
    }
}