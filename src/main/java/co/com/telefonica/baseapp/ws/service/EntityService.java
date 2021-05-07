package co.com.telefonica.baseapp.ws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.telefonica.baseapp.ws.persistence.GenericEntityRepository;
import co.com.telefonica.baseapp.ws.ui.model.request.Entity;

@Service
public class EntityService {
    
    @Autowired
    GenericEntityRepository repository;

    public List<Entity> findAllEntities() {
        return (List<Entity>)repository.findAll();
    }

    public Entity insert(Entity p) {
    	
    	try 
    	{
    		return repository.save(p);
    	}
    	catch(Exception e) 
    	{
    		System.out.println(e.getMessage());
    		return p;
    	}
        
    }

    public boolean delete(long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Entity findById(long id) {
        Optional<Entity> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    public boolean update(Entity p) {
        try {
            repository.save(p);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
