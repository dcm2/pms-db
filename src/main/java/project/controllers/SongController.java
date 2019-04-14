package project.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.entities.Song;
import project.entities.SongInfo;
import project.entities.User;
import project.service.SongService;

@RestController
@RequestMapping(SongController.BASE_URL)
public class SongController {
	
	protected static final String BASE_URL = "/pms_db/songs";
	private SongService songService;
	
	//constructor for this controller class
	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	// Finding all songs
	@GetMapping
	public List<Song> listAllSongs() {
		return songService.findSongs();
	}
	
}