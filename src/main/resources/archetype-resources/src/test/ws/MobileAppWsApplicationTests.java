package ${groupId}.ws;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ${groupId}.ws.persistence.GenericEntityRepository;
import ${groupId}.ws.ui.model.response.UserRest;

@SpringBootTest(classes = MobileAppWsApplication.class)

class MobileAppWsApplicationTests {

	//Fuente: https://www.baeldung.com/spring-testing-separate-data-source
	
	@Autowired
	private GenericEntityRepository genericEntityRepository;
	
	/*@Test
	void guardarYTraerEntidad() {
		
		UserRest userTest= new UserRest();
		String userId=UUID.randomUUID().toString();
		userTest.setEmail("test@test.com");
		userTest.setFirstName("Test Name");
		userTest.setLastName("Test LastName");
		userTest.setUserId(userId); 
			
	   genericEntityRepository.save(userTest);
	   UserRest foundEntity = genericEntityRepository.getOne(userTest.getUserId());
		
	   System.out.println("Created: "+userTest.toString());
	   System.out.println("Found: "+foundEntity.toString());
	   assertNotNull(foundEntity);
	   assertEquals(userTest.getEmail(), foundEntity.getEmail());
	   assertEquals(userTest.getFirstName(), foundEntity.getFirstName());
	   assertEquals(userTest.getLastName(), foundEntity.getLastName());
	   
		
	}
	
	
	@Test
	void actualizarEntidad() {
		
		UserRest userTest= new UserRest();
		String userId=UUID.randomUUID().toString();
		userTest.setEmail("test@test.com");
		userTest.setFirstName("Test Name");
		userTest.setLastName("Test LastName");
		userTest.setUserId(userId); 
			
	   genericEntityRepository.save(userTest);
	   UserRest foundEntity = genericEntityRepository.getOne(userId);
	
	   System.out.println("Found: "+foundEntity.toString());
	   foundEntity.setLastName("Test Update");
	   
	   assertNotNull(foundEntity);
	   
	   genericEntityRepository.save(foundEntity);
	   
	   UserRest updateEntity = genericEntityRepository.getOne(userId);
	   System.out.println("Updated: "+updateEntity.toString());
	   assertNotNull(updateEntity);
	   assertEquals(updateEntity.getLastName(), "Test Update");
		
	}
	
	@Test
	void buscarEntidadQueNoExiste() {
		
		UserRest userTest= new UserRest();
		String userId=UUID.randomUUID().toString();
		userTest.setEmail("test@test.com");
		userTest.setFirstName("Test Name");
		userTest.setLastName("Test LastName");
		userTest.setUserId(userId); 
			
	   genericEntityRepository.save(userTest);
	   UserRest foundEntity = genericEntityRepository.getOne("iaiaiiah5");
		
	   assertNotNull(foundEntity);
	    
		
	}*/

}
