package project.service.implementation;

import java.util.List;

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
	
	@Override
	public List<String> findAllSongs() {
		return songRepo.findAllTitles();
	}
	
	@Override
	public Song findByTitle(String title) {
		return songRepo.findByTitle(title);
	}
	
	@Override
	public List<Song> findSongs() {
		return songRepo.findAllSongs();
	}
	
	
}
