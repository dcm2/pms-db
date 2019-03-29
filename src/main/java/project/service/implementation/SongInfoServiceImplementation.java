package project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.entities.Song;
import project.entities.SongInfo;
import project.repositories.SongInfoRepository;
import project.service.SongInfoService;

@Service
public class SongInfoServiceImplementation implements SongInfoService{

	// Instance Variables
	private SongInfoRepository songInfoRepo;
	
	@Autowired
	public SongInfoServiceImplementation(SongInfoRepository songInfoRepo) {
		this.songInfoRepo = songInfoRepo;
	}
	
	/* IMPLEMENTATION OF METHODS IN THE SongInfoService INTERFACE*/
	@Override
	public SongInfo findByTitle(String title) {
		return songInfoRepo.findByTitle(title);
	}
	
	@Override
	public SongInfo save(SongInfo songInfo) {
		return songInfoRepo.save(songInfo);
	} 
	
}
