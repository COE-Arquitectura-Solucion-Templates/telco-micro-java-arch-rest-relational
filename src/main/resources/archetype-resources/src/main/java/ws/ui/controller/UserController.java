package ${groupId}.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ${groupId}.ws.exception.UserServiceException;
import ${groupId}.ws.service.LogServiceDelegate;
import ${groupId}.ws.ui.model.request.LogDetailsRequestModel;
import ${groupId}.ws.ui.model.request.UpdateUserDetailsRequestModel;
import ${groupId}.ws.ui.model.request.UserDetailsRequestModel;
import ${groupId}.ws.ui.model.response.LogRestResponseModel;
import ${groupId}.ws.ui.model.response.UserRest;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

//PostManProyectoConsumo: https://www.getpostman.com/collections/f07ac4f3a7fa67a51a2e
@RestController
@RequestMapping("users")//http://localhost:8080/users
public class UserController {
	
	Map<String,UserRest> users;
	
	@Autowired
	LogServiceDelegate logServiceDelegate;
	

	
	@GetMapping(path="/{userId}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		/* Stock User
		UserRest returnValue= new UserRest();
		returnValue.setEmail("test@test.com");
		returnValue.setFirstName("Test Name");
		returnValue.setLastName("Test LastName");
		returnValue.setUserId(userId); */
		
		/* Generate Exception
		String excepcionTest=null;
		int len=excepcionTest.length(); */
		
		
		/* Generate an own exception
		if(true) throw new UserServiceException("My Own Exception");
		*/
		
		
		LogDetailsRequestModel logRequest=new LogDetailsRequestModel();
		ResponseEntity<LogRestResponseModel> logResponse=null;
		
		if(users==null)users=new HashMap<>();
		
		if(users.containsKey(userId)) {
			return new ResponseEntity<UserRest>(users.get(userId),HttpStatus.OK) ;
		}else {
			logRequest.setNombreAplicacion("users");
			logRequest.setMensaje("User: "+userId+" NOT FOUND");
			logResponse=logServiceDelegate.writeLog("exception",logRequest);
			System.out.println(logResponse.toString());			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
		}
		
		
		
	}
	
	
	@GetMapping(produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public String getUsers(@RequestParam(value="page",defaultValue="-1") int page,
			@RequestParam(value="limit",defaultValue="-1") int limit,
			@RequestParam(value="sort",required=false) String sort) {
		if(page==-1 || limit==-1) {
			return "get user called was called";
		}else {
			return "get user called was called page="+page+" and limit="+limit+" and sort="+sort;
		}
	}
	
	@GetMapping(path="/all",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public String getUser() {
		return "get user called was called";
	}
	
	@PostMapping(consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
				 ,produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue= new UserRest();
		String userId=UUID.randomUUID().toString();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setUserId(userId);
		
		if(users==null)users=new HashMap<>();
		users.put(userId, returnValue);
		
		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK) ;
		
		
		
	}
	
	@PutMapping(path="/{userId}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		UserRest returnValue= null;
		if(users.containsKey(userId)) {
			returnValue=users.get(userId);
			
			if(userDetails.getFirstName()!=null) returnValue.setFirstName(userDetails.getFirstName());
			if(userDetails.getLastName()!=null) returnValue.setLastName(userDetails.getLastName());
					
			users.put(userId,returnValue);
			
			return new ResponseEntity<>(returnValue,HttpStatus.OK) ;
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
		}
	}
	
	@DeleteMapping(path="/{userId}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> deleteUser(@PathVariable String userId) {
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.remove(userId),HttpStatus.OK) ;
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
		}
		//ResponseEntity.noContent().build() For an empty response
	}
	
	
}
