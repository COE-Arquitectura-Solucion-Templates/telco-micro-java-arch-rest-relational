package co.com.telefonica.baseapp.ws.ui.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.telefonica.baseapp.ws.service.EntityService;
import co.com.telefonica.baseapp.ws.ui.model.request.Entity;

@RestController()
@RequestMapping("entity")
public class EntityController {

    @Autowired
    EntityService entityService;
    
    @GetMapping(produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
    public List<Entity> getAllPeople() {
        return entityService.findAllEntities();
    }

    @GetMapping("{id}")
    public Entity getPerson(@PathVariable long id) {
        
    	return entityService.findById(id);
    }

    @PostMapping(produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> addEntity(@RequestBody Entity entity) {

        if(entity != null) {
        	System.out.print(entity.toString());
        	entityService.insert(entity);
            return new ResponseEntity<>("Added a entity", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Request does not contain a body", HttpStatus.BAD_REQUEST);
        }
    }


	@DeleteMapping(path="{id}",produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> deleteEntity(@PathVariable("id") long id) {

        if(id > 0) {
            if(entityService.delete(id)) {
                return new ResponseEntity<>("Deleted the entity.", HttpStatus.OK);
            } else {
            	return new ResponseEntity<>("Cannot delete the entity.", HttpStatus.BAD_GATEWAY);
                
            }
        }
        
        return new ResponseEntity<>("The id is invalid for the entity.", HttpStatus.NOT_FOUND);
    }

    @PutMapping(produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> updateEntity(@RequestBody Entity entity) {
        if(entity != null) {
            entityService.update(entity);
            return new ResponseEntity<>( "Updated entity.", HttpStatus.OK);
          } else {
        	  return new ResponseEntity<>("Request does not contain a body", HttpStatus.BAD_GATEWAY);
            
        }
    }
}
