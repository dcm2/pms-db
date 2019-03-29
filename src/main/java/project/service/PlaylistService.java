package project.service;

import project.entities.Playlist;

public interface PlaylistService {

	Playlist save(Playlist playlist);
	
	Playlist findByTitle(String title);

}
