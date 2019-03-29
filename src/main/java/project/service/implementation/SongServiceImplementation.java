package project.service.implementation;

import org.springframework.stereotype.Service;

import project.entities.Song;
import project.repositories.SongRepository;
import project.service.SongService;

@Service
public class SongServiceImplementation implements SongService{

	// Instance Variables
	private SongRepository songRepo;
	
	public SongServiceImplementation(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	
	/* IMPLEMENTATION OF METHODS IN THE SongService INTERFACE*/
	@Override
	public Song save(Song song) {
		return songRepo.save(song);
	}
	
}
