package com.example.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Item;
import com.example.model.Snippet;
import com.example.model.YoutubeDataPojo;


@RestController
public class YoutubeDataController {

	@Autowired
	MessageProducerApp msgProducerQueueA;
	@Autowired
	MessageConsumerApp msgConsumerQueueA;
	@Autowired
	MessageProducerApp msgProducerQueueB;
	@GetMapping(value="/youtube-message",produces={MediaType.APPLICATION_XML_VALUE})
	public String testcontroller(@RequestParam String key,@RequestParam String part,@RequestParam String q,@RequestParam String type,@RequestParam String maxResults) {
		String url = "https://www.googleapis.com/youtube/v3/search?key={key}&part={part}&q={q}&type={type}&maxResults={maxResults}";
		// TODO Auto-generated method stub
Map<String,String> reqParams= new HashMap<>();
reqParams.put("key",key);
reqParams.put("part", part);
reqParams.put("q", q);
reqParams.put("type", type);
reqParams.put("maxResults", maxResults);

RestTemplate restTemplate = new RestTemplate();
ResponseEntity<YoutubeDataPojo> response=restTemplate.getForEntity(url, YoutubeDataPojo.class,reqParams);
List<Item> itemlist = response.getBody().getItems();
List<Snippet> snippetlist= new ArrayList<>();
for(Item it :itemlist) {
	snippetlist.add(it.getSnippet());
}

System.out.println("Before sending the Message to Queue A");
for(Snippet sp:snippetlist) {
	System.out.println("Title: "+sp.getTitle());
	System.out.println("Channel Title: "+sp.getChannelTitle());
}

ArrayList<YoutubeDataSerializer> senderDataList = new ArrayList<>();
for(Snippet snippet : snippetlist) {
	YoutubeDataSerializer youtubeData = new YoutubeDataSerializer();
	youtubeData.setTitle(snippet.getTitle().toLowerCase());
	youtubeData.setChannelTitle(snippet.getChannelTitle().toLowerCase());
	youtubeData.setDescription(snippet.getDescription().toLowerCase());
	senderDataList.add(youtubeData);
}
String messagesentA =msgProducerQueueA.sendMessageQueue(senderDataList);
System.out.println("Message A:"+ messagesentA);
//String consumedMessage=msgConsumerQueueA.receiveMessageQueue();
//YoutubeDataService ytServ= new YoutubeDataService();
//ytServ.modifyMessage(consumedMessage);
return "heelo";
	}

}
