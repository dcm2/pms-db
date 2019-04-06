package project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.entities.Song;


public interface SongRepository extends JpaRepository<Song, Long>{
	
	// Saves a song in the db
	Song save(Song song);
	
	// Selects all song titles in the db
	@Query(value= "SELECT p.title FROM Song p")
	List <String> findAllTitles();
	
	// To find a particular song by title
	@Query(value= "SELECT p FROM Song p WHERE p.title = ?1")
	Song findByTitle(String title);
	
	// Finds all songs
	@Query(value= "SELECT p FROM Song p")
	List <Song> findAllSongs();
	
	
	
}
