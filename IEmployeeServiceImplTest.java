package com.dilip.security.serviceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.dilip.security.entity.EmployeeEntity;
import com.dilip.security.repository.IEmployeeRepository;
//https://www.youtube.com/watch?v=VBzhVLozjEQ
@RunWith(MockitoJUnitRunner.class)
public class IEmployeeServiceImplTest {

	@Mock
	List list;

	@InjectMocks
	IEmployeeServiceImpl iEmployeeServiceImpl;

	@Mock
	MongoTemplate mongoTemplate;

	@Mock
	IEmployeeRepository iEmployeeRepositor;

	@Mock
	Page<EmployeeEntity> pageEnitity;

	@Ignore
	public void mockExample() {
		when(list.add("dilip")).thenReturn(false);
		assertEquals(false, list.add("dilip"));
	}

	@Test
	public void createEmployeeTest() {
		EmployeeEntity employee = new EmployeeEntity();
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		Pageable pageable = PageRequest.of(1, 10);
		when(iEmployeeRepositor.findAll(pageable)).thenReturn(pageEnitity);
		when(iEmployeeRepositor.findAll()).thenReturn(list);
		when(iEmployeeRepositor.insert(employee)).thenReturn(employee);
		assertEquals(employee, iEmployeeServiceImpl.createEmployee(employee));

	}

}
