package project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.entities.Playlist;
import project.repositories.PlaylistRepository;
import project.service.PlaylistService;

@Service
public class PlaylistServiceImplementation implements PlaylistService{

	// Instance Variable
	PlaylistRepository playlistRepo;
	
	@Autowired
	public PlaylistServiceImplementation(PlaylistRepository playlistRepo) {
		this.playlistRepo = playlistRepo;
	}
	
	/* IMPLEMENTATION OF METHODS IN THE PlaylistService INTERFACE*/
	
	@Override
	public Playlist save(Playlist playlist) {
		return playlistRepo.save(playlist);
	}
	
	@Override
	public Playlist findByTitle(String title) {
		return playlistRepo.findByTitle(title);
	}
	
	@Override
	public List<Playlist> findByUserid(Long id) {
		return playlistRepo.findByUserid(id);
	}
	
	
}
