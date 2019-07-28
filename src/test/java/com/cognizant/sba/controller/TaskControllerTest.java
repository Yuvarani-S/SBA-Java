package com.cognizant.sba.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.sba.controller.TaskController;
import com.cognizant.sba.dto.TaskDTO;
import com.cognizant.sba.eo.ProjectEO;
import com.cognizant.sba.eo.TaskEO;
import com.cognizant.sba.eo.UserEO;
import com.cognizant.sba.service.TaskService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TaskController.class, secure = false)
public class TaskControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TaskService taskService;

	final Date date = Mockito.mock(Date.class);

	@Test
	public void testGetAllTasks() throws Exception {

		TaskDTO mockTask = new TaskDTO();
		mockTask.setParentTaskId(1);
		mockTask.setProjectId(1L);
		mockTask.setTaskName("A");
		mockTask.setStartDate(date);
		mockTask.setEndDate(date);
		mockTask.setPriority(1);
		mockTask.setUserId(1);

		List<TaskDTO> ticketList = new ArrayList<TaskDTO>();
		ticketList.add(mockTask);

		Mockito.when(taskService.getAllTasks()).thenReturn(ticketList);

		String URI = "/task/all";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(ticketList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	@Test
	public void addNewTaskTest() throws Exception {

		TaskDTO mockTask = new TaskDTO();
		TaskDTO task = new TaskDTO();
		mockTask.setParentTaskId(1);
		mockTask.setProjectId(1L);
		mockTask.setTaskName("A");
		mockTask.setStartDate(date);
		mockTask.setEndDate(date);
		mockTask.setPriority(1);
		mockTask.setUserId(1);

		// ParentTask ptask = new ParentTask();
		// String task="taskName";
		// ptask.setParentTask(task);

		String inputInJson = this.mapToJson(mockTask);

		String URI = "/task/add";

		// Mockito.when(taskService.addNewTask(task)).thenReturn(mockTask);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();
	}

	@Test
	public void getTasksByProjectTest() throws Exception {
		TaskDTO mockTask = new TaskDTO();
		mockTask.setParentTaskId(1);
		mockTask.setProjectId(1L);
		mockTask.setTaskName("A");
		mockTask.setStartDate(date);
		mockTask.setEndDate(date);
		mockTask.setPriority(1);
		mockTask.setUserId(1);

		List<TaskDTO> ticketList = new ArrayList<TaskDTO>();
		ticketList.add(mockTask);

		Mockito.when(taskService.getTasksByProject(1L)).thenReturn(ticketList);

		String URI = "/task/project/{id}";
		/*
		 * RequestBuilder requestBuilder = MockMvcRequestBuilders.get( URI).accept(
		 * MediaType.APPLICATION_JSON);
		 * 
		 * MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 * 
		 * String expectedJson = this.mapToJson(ticketList); String outputInJson =
		 * result.getResponse().getContentAsString();
		 * assertThat(outputInJson).isEqualTo(expectedJson);
		 */
	}

	@Test
	public void updateTaskTest() throws Exception {

		TaskEO mockTask = new TaskEO();
		TaskDTO obj = new TaskDTO();

		mockTask.setTaskId(1);

		ProjectEO project = new ProjectEO();
		project.setProjectId(1L);
		mockTask.setProject(project);
		mockTask.setTask("A");
		mockTask.setStartDate(date);
		mockTask.setEndDate(date);
		mockTask.setPriority(1);

		UserEO user = new UserEO();
		user.setUserId(1);
		mockTask.setUser(user);

		Mockito.when(taskService.updateTask(obj)).thenReturn(mockTask);

		String URI = "/task/update";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(mockTask);
		String outputInJson = result.getResponse().getContentAsString();
		// assertThat(outputInJson).isEqualTo(expectedJson);
	}

}
