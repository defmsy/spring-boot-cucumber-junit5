package com.example.springbootcucumberjunit5.bdd;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SayHelloStepdefs {

    @Autowired
    private MockMvc mockMvc;

    private ResultActions resultActions;

    @When("name is {string}")
    public void nameIs(String arg0) throws Exception {
        resultActions = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/hello/{name}", arg0)
                .accept(MediaType.APPLICATION_JSON));
    }

    @Then("should say hello")
    public void shouldSayHello() throws Exception {
        this.resultActions.andExpect(status().isOk());
    }
}
