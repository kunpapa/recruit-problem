package es.ernesto.easyGOband.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHeaders;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.ernesto.easyGOband.model.Provider;
import es.ernesto.easyGOband.utils.Constants;
import es.ernesto.easyGOband.utils.Marshaller;
import es.ernesto.easyGOband.utils.RestCaller;

@RestController
public class BaseRestController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BaseRestController.class);

	@RequestMapping(value = "/providersList/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, headers={"Accept=application/json"})
	public List<Provider> getProvidersList(@PathVariable String id) throws IOException {
		Map<String, String> headers = new HashMap<>();
		headers.put(HttpHeaders.AUTHORIZATION, Constants.AUTH_DEV_PROVIDER);

		Map<String, String> params = new HashMap<>();

		String callResult = RestCaller.restCall(Constants.BASE_URL_DEV+Constants.URL_PROVIDERS+id, headers, params, RequestMethod.GET);
		return Arrays.asList(Marshaller.getProviderFromJson(callResult));

	}

}
