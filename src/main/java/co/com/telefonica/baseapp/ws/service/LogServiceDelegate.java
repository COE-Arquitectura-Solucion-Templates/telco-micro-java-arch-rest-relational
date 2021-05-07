package co.com.telefonica.baseapp.ws.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import co.com.telefonica.baseapp.ws.ui.model.request.LogDetailsRequestModel;
import co.com.telefonica.baseapp.ws.ui.model.response.LogRestResponseModel;

@Service
public class LogServiceDelegate {
	
	@Value("${log.endPointConnectTimeout}")
	private int HTTP_CONNECT_TIMEOUT;
	
	@Value("${log.endPointReadTimeout}")
	private int HTTP_READ_TIMEOUT;

	
	@Value("${log.endPoint}")
	private String logEndPoint;
	
	 @Bean
	 public RestTemplate restTemplate() {
		  return new RestTemplate(getClientHttpRequestFactory());
	 }
	 

	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		    clientHttpRequestFactory.setConnectTimeout(HTTP_CONNECT_TIMEOUT);
		    clientHttpRequestFactory.setReadTimeout(HTTP_READ_TIMEOUT);
		    return clientHttpRequestFactory;
	}
		
	@HystrixCommand(fallbackMethod = "writeLog_Fallback")
	public ResponseEntity<LogRestResponseModel> writeLog(String type , LogDetailsRequestModel logRequest) {
			HttpEntity<LogDetailsRequestModel> request = new HttpEntity<>(logRequest);
			ResponseEntity<LogRestResponseModel> response = null;
			
			
			RestTemplate rest=restTemplate();
	
			if(type.equals("info")) {
						
				response=rest.exchange(logEndPoint+"/info",
						HttpMethod.POST,
						request,LogRestResponseModel.class);
						
					
			}else {
				
				response= rest.exchange(logEndPoint+"/info",
						HttpMethod.POST,
						request,LogRestResponseModel.class);
				
			}	
			
			return response;
					
		}
		
		public ResponseEntity<LogRestResponseModel> writeLog_Fallback(String type , LogDetailsRequestModel logRequest) {
			LogRestResponseModel logResponse= new LogRestResponseModel();
			logResponse.setCodigo(HttpStatus.GATEWAY_TIMEOUT.value());
			logResponse.setDescripcion("Log Service will be back shortly");
			return new ResponseEntity<LogRestResponseModel>(logResponse,HttpStatus.GATEWAY_TIMEOUT) ;
		}

}
