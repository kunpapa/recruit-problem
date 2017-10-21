package es.ernesto.easyGOband.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.ernesto.easyGOband.model.Provider;

public class Marshaller {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static String getJsonFromProvider(Provider[] provider) throws JsonProcessingException {
		return mapper.writeValueAsString(provider);
	}
	
	public static Provider[] getProviderFromJson(String provider) throws IOException {
		return mapper.readValue(provider, Provider[].class);
	}

}
