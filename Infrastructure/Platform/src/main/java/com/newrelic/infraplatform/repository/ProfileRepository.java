package com.newrelic.infraplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.newrelic.infraplatform.dto.ProfileDTO;
import com.newrelic.infraplatform.dto.QueryKeyDTO;
import com.newrelic.infraplatform.dto.QueryKeyNameDTO;
import com.newrelic.infraplatform.model.Profile;
import com.newrelic.infraplatform.model.ProfileID;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, ProfileID> {

	//Return Existing Profile Names (Drop Down)
	public static final String FIND_PROFILE_NAMES = "SELECT new com.newrelic.infraplatform.dto.ProfileDTO( p.profile_id.profile_name) "
			+ "FROM Profile p WHERE p.profile_id.user_id=:user_id";
	@Query(value = FIND_PROFILE_NAMES)
	public List<ProfileDTO> findAllByUserId(@Param("user_id") Long user_id);
	
	
	//Return Existing Key Profiles - FULL from user id
	public static final String FIND_ALL_KEY_PROFILES = "Select new com.newrelic.infraplatform.dto.QueryKeyDTO(p.query_key,p.key_title,p.acc_id) "
			+ "from Profile p where p.profile_id.user_id=:user_id";
	@Query(value = FIND_ALL_KEY_PROFILES)
	public List<QueryKeyDTO> findAllKeysByUserId(@Param("user_id") Long user_id);

	//Return Existing Key Profile Names (Drop Down)
	@Query(value = "SELECT distinct new com.newrelic.infraplatform.dto.QueryKeyNameDTO(p.key_title) from Profile p WHERE p.profile_id.user_id=:user_id")
	public List<QueryKeyNameDTO> findAllKeyNamesByUserId(@Param("user_id") Long user_id);

	//Return Existing Key Profiles - FULL from Key Title
	@Query(value = "SELECT distinct new com.newrelic.infraplatform.dto.QueryKeyDTO( p.query_key, p.key_title, p.acc_id) "
			+ "from Profile p WHERE p.key_title=:key_title")
	public QueryKeyDTO findKeyByKeyTitle(@Param("key_title")String key_title);
		
	//Check whether Key Profile is present or not
	public static final String CHECK_KEY_PROFILES = "Select COUNT(key_title) "
			+ "from Profile p where p.profile_id.user_id=:user_id and p.key_title=:key_title";
	@Query(value = CHECK_KEY_PROFILES)
	public Integer CheckKeyProfile(@Param("user_id") Long user_id, @Param("key_title") String key_title);
	
	
	//Get Key Profile Details from Database
	public static final String FIND_KEY_PROFILES = "Select distinct new com.newrelic.infraplatform.dto.QueryKeyDTO(p.query_key,p.key_title,p.acc_id) "
			+ "from Profile p where p.profile_id.user_id=:user_id and p.key_title=:key_title";
	@Query(value = FIND_KEY_PROFILES)
	public QueryKeyDTO findKeysProfile(@Param("user_id") Long user_id, @Param("key_title") String key_title);
	
}