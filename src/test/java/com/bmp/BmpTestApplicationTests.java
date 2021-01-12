package com.bmp;

import com.bmp.service.TextProcessorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class BmpTestApplicationTests {

	@InjectMocks
   TextProcessorService textProcessorService;


	@Test
	void TestFindTextCount() {
		List<String> names=new ArrayList<>();
		names.add("John");
		names.add("John");
		names.add("Toms");
		names.add("Harry");
		Map<String,Object> searchText=new HashMap<>();
		searchText.put("searchText",names);
		Map<String, Object> a= textProcessorService.findTextCount(searchText);
		Map<String,Long> map= (Map<String, Long>) a.get("counts");
		Assertions.assertEquals(2,map.get("John"));

	}


}
