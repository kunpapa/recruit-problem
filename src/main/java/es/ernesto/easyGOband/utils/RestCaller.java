package es.ernesto.easyGOband.utils;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author ernesto
 *
 */
public class RestCaller {

	private RestCaller(){
		//private to disable possible instances of class
	}


	public static String restCall(String url, Map<String, String> headers, Map<String, String> params, RequestMethod method) throws IOException{

		String output = "";
		CloseableHttpResponse response = null;

		//Set del timeout de la llamada
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(Constants.REST_TIMEOUT * 1000)
				.setConnectionRequestTimeout(Constants.REST_TIMEOUT * 1000)
				.setSocketTimeout(Constants.REST_TIMEOUT * 1000).build();

		//libreria de apache para realizar peticiones http
		try(CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build()) {
			if(method.equals(RequestMethod.POST)){
				//TODO
			} else {
				HttpGet httpGet = new HttpGet(url);
				for(Entry<String, String> headerKey : headers.entrySet()) {
					httpGet.setHeader(headerKey.getKey(), headerKey.getValue());
				}
				//TODO add params
				response = httpClient.execute(httpGet);
				output = EntityUtils.toString(response.getEntity());
			}

			//closing post or get connection
			if(response != null)
				response.close();
			httpClient.close();
		} catch (Exception e) {
			//TODO better exception getter and logger
			e.printStackTrace();
		}


		return output;

	}
}