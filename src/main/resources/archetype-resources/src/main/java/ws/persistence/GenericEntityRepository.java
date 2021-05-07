package ${groupId}.ws.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ${groupId}.ws.ui.model.response.UserRest;

public interface GenericEntityRepository
extends JpaRepository<UserRest, String> {

	
}
