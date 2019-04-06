package project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.entities.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long>{

	// Saves a playlist in the db
	Playlist save(Playlist playlist);
	
	// To find a particular playlist by title
	@Query(value= "SELECT p FROM Playlist p WHERE p.title = ?1")
	Playlist findByTitle(String title);
	
	// Find playlist by userid
	@Query(value= "SELECT p FROM Playlist p WHERE p.id = ?1")
	List <Playlist> findByUserid(Long id);
	
		
}
