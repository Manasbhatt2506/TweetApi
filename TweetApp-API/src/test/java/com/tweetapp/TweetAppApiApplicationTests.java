package com.tweetapp;

import static org.junit.Assert.assertNotNull;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


@SpringBootTest(classes = TweetAppApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TweetAppApiApplicationTests {

		@Autowired
		private TestRestTemplate restTemplate;
        @LocalServerPort
		private int port;
        private String getRootUrl() {
			return "http://localhost:" + port;
		}
	@Test
	void testFindAllTweetList() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				getRootUrl() + "/api/v1.0/tweets/all", HttpMethod.GET, entity, String.class);
		assertNotNull(response.getBody());
	}

	@Test
	void contextLoads() {
	}

}
