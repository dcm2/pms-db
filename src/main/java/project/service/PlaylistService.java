package project.service;

import java.util.List;

import project.entities.Playlist;

public interface PlaylistService {

	Playlist save(Playlist playlist);
	
	Playlist findByTitle(String title);
	
	List<Playlist> findByUserid(Long id);

}
