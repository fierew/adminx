package com.fierew.adminxcontroller;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AdminxControllerApplication.class})
@AutoConfigureMockMvc
@Slf4j
public class IndexControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void testBefore(){
        log.info("测试前");
    }

    @After
    public void testAfter(){
        log.info("测试后");
    }

    @Test
    public void indexTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        log.info("状态码=" + status);
        Assert.assertEquals(200, status);
    }
}
