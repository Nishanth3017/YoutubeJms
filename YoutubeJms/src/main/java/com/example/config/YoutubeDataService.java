package com.example.config;

import java.util.List;

public class YoutubeDataService {
	XMLTransformer transformer = new XMLTransformer();
	public String modifyMessage(String str) {
		List<YoutubeDataSerializer> ob = (List<YoutubeDataSerializer>) transformer.toObject(str);
		for(YoutubeDataSerializer obi :ob) {
			String temp=obi.getTitle();
			if(temp.contains("telecom")) {
				temp=temp.replaceAll("telecom", "telco");
			}
			obi.setTitle(temp);
		}

//MessageProducerApp
		return "mudiyala";
	}
}
