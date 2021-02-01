package com.lemon1234.elastic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.document.Document;

@SpringBootTest
public class ElasticTest {

	@Autowired
	private ElasticsearchRestTemplate elasticsearchRestTemplate;
	
	@Test
	public void testCreateIndex(){
		
//		IndexOperations indexOperations = elasticsearchRestTemplate.indexOps();
//		Document mapping = indexOperations.createMapping();
//		indexOperations.putMapping(mapping);
	}
}
