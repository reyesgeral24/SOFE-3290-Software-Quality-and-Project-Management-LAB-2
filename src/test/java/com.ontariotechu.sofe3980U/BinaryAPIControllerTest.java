package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void add() throws Exception {
        mvc.perform(get("/add")
                .param("operand1", "111")
                .param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("10001"));
    }

    @Test
    public void addJson() throws Exception {
        mvc.perform(get("/add_json")
                .param("operand1", "111")
                .param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operand1").value("111"))
                .andExpect(jsonPath("$.operand2").value("1010"))
                .andExpect(jsonPath("$.result").value("10001"))
                .andExpect(jsonPath("$.operator").value("add"));
    }

    @Test
    public void multiplyString() throws Exception {
        mvc.perform(get("/mul")
                .param("operand1", "11")
                .param("operand2", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("110"));
    }

    @Test
    public void multiplyJson() throws Exception {
        mvc.perform(get("/mul_json")
                .param("operand1", "11")
                .param("operand2", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operand1").value("11"))
                .andExpect(jsonPath("$.operand2").value("10"))
                .andExpect(jsonPath("$.result").value("110"))
                .andExpect(jsonPath("$.operator").value("multiply"));
    }

    @Test
    public void andString() throws Exception {
        mvc.perform(get("/and")
                .param("operand1", "1101")
                .param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(content().string("1001"));
    }

    @Test
    public void andJson() throws Exception {
        mvc.perform(get("/and_json")
                .param("operand1", "1101")
                .param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operand1").value("1101"))
                .andExpect(jsonPath("$.operand2").value("1011"))
                .andExpect(jsonPath("$.result").value("1001"))
                .andExpect(jsonPath("$.operator").value("and"));
    }

    @Test
    public void orString() throws Exception {
        mvc.perform(get("/or")
                .param("operand1", "1101")
                .param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(content().string("1111"));
    }

    @Test
    public void orJson() throws Exception {
        mvc.perform(get("/or_json")
                .param("operand1", "1101")
                .param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operand1").value("1101"))
                .andExpect(jsonPath("$.operand2").value("1011"))
                .andExpect(jsonPath("$.result").value("1111"))
                .andExpect(jsonPath("$.operator").value("or"));
    }
}
