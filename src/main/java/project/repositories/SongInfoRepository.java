package project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.entities.Song;
import project.entities.SongInfo;

public interface SongInfoRepository extends JpaRepository<SongInfo, Long>{

	// To find a particular SongInfo by title
	@Query(value= "SELECT p FROM SongInfo p WHERE p.title =?1")
	SongInfo findByTitle(String titleToSearch);
	
	// Saves a song in the db
	SongInfo save(SongInfo songInfo);
	
}