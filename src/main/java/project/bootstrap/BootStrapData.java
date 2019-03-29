package project.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import project.repositories.*;
import project.entities.*;

@Component
public class BootStrapData implements CommandLineRunner{

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PlaylistRepository playlistRepo;
	@Autowired
	private SongRepository songRepo;
	@Autowired
	private SongInfoRepository songInfoRepo;
	
	public BootStrapData(UserRepository userRepo, PlaylistRepository playlistRepo, SongInfoRepository songInfoRepo) {
		this.userRepo = userRepo;
		this.playlistRepo = playlistRepo;
		this.songInfoRepo = songInfoRepo;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Loading Initial Data");
		
		//user to test 
		User u1 = new User("dcrespo","strongpassword", "dcm2@hi.is");
		userRepo.save(u1);
		
		//songInfo to test
		SongInfo sInfo1 = new SongInfo("No Manners", "Teyana Taylor", 120, "K.T.S.E", "R&B");
		songInfoRepo.save(sInfo1);
		
		//playlist to test
		Playlist p1 = new Playlist();
		System.out.println("p1 has id -> " + p1.getId());
		
		Song s1 = new Song(sInfo1, p1);
		
		p1.setCreator(u1);
		p1.setTitle("best r&b songs");
		System.out.println("p1 has id -> " + p1.getId());		
		playlistRepo.save(p1);
		System.out.println("p1 has id -> " + p1.getId());
		
		
		System.out.println("s1 has id -> " + s1.getId());
		System.out.println("s1 has title -> " + s1.getTitle());
		System.out.println("s1 belongs to -> " + s1.getBelongsTo().getTitle());

		
		songRepo.save(s1);
		System.out.println("s1 has id -> " + s1.getId());
		
		p1.addSong(s1);			
	}
	
}
