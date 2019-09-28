package com.oreilly.boot;

import static org.junit.Assert.*;

import java.awt.PageAttributes.MediaType;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
@WebAppConfiguration
public class ApplicationTest {
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp () {
		mockMvc = MockMvcBuilders.standaloneSetup(new Application()).build();
	}
	
	@Test
	public void testHomeController() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/").accept("text/plain"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Hello World")));
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
