package com.cognizant.sba;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.sba.SBAApplication;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SBATest {

	@Test
	public void contextLoads() {
	}

	
	@Test
	   public void main() {
		SBAApplication.main(new String[] {});
	   }
	
	@Test
	public void configueTest() {
		SpringApplicationBuilder builder = new SpringApplicationBuilder();
			
			 builder.sources(SBAApplication.class);	
	}
	
}