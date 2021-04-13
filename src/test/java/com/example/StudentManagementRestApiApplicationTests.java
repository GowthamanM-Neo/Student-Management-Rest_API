package com.example;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class StudentManagementRestApiApplicationTests {

	@Autowired
    private MockMvc mockMvc;	

	//Add A New Student
	@Test
    public void TestCase1() throws Exception {
		
		String dataOne = "{\"studentId\":\"12881\",\"studentName\":\"Jack\",\"studentClass\":\"10\",\"studentSection\":\"A\",\"rollNo\":\"17CSR049\",\"feesPaid\":\"true\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/addStudent")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(dataOne)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andReturn();
	 	
    }
	
	//Get All Students
	@Test
    public void TestCase2() throws Exception {
		
	 	mockMvc.perform(MockMvcRequestBuilders.get("/getAllStudents")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$[*].studentName").exists())
		        .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
	        	.andReturn();
	 	
    }

	//Get A Student by Id
	@Test
	public void TestCase3() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/getStudent/12881")
				.contentType(MediaType.APPLICATION_JSON)
		 		.accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.studentName").value("Jack"))
		        .andExpect(jsonPath("$.studentClass").value("10"))
		        .andExpect(jsonPath("$.studentSection").value("A"))
		        .andExpect(jsonPath("$.rollNo").value("17CSR049"))
		        .andReturn();
		
	}
	
	//Edit the Student Details
	@Test
    public void TestCase4() throws Exception {
		
		String dataOne = "{\"studentId\":\"12881\",\"studentName\":\"Jack\",\"studentClass\":\"10\",\"studentSection\":\"B\",\"rollNo\":\"17CSR001\",\"feesPaid\":\"true\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/editStudent/12881")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(dataOne)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andReturn();
	 	
	 	mockMvc.perform(MockMvcRequestBuilders.get("/getStudent/12881")
				.contentType(MediaType.APPLICATION_JSON)
		 		.accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.studentName").value("Jack"))
		        .andExpect(jsonPath("$.studentClass").value("10"))
		        .andExpect(jsonPath("$.studentSection").value("B"))
		        .andExpect(jsonPath("$.rollNo").value("17CSR001"))
		        .andReturn();
	 	
    }
	
	//Delete the Series
	@Test
    public void TestCase5() throws Exception {
		
	 	mockMvc.perform(MockMvcRequestBuilders.get("/deleteStudent/12881")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andReturn();
	 			
    }


}
