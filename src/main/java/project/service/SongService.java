package project.service;

import java.util.List;

import project.entities.*;

public interface SongService {

	Song save(Song song);
	
	List<String> findAllSongs();
	
	Song findByTitle(String title);
	
	List<Song> findSongs();
}
