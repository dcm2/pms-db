package project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.entities.Song;


public interface SongRepository extends JpaRepository<Song, Long>{
	
	// Saves a song in the db
	Song save(Song song);
}
