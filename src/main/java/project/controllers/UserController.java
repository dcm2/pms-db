package project.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project.service.UserService;
import project.entities.Playlist;
import project.entities.Song;
import project.entities.User;
import project.service.PlaylistService;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

	protected static final String BASE_URL = "/pms_db/user";
	private UserService userService;
	private PlaylistService playlistService;
	
	//constructor for this controller class
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/{userName}")
	public User findUserByName(@PathVariable String userName) {
		return userService.findByName(userName);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody User user) {
		return userService.save(user);
	}
	
	// getting all playlists of a user
	@GetMapping("/{userName}/playlists")
	public List<Playlist> findByUserid(@PathVariable String userName) {
		User user = userService.findByName(userName);
		return user.getPlaylists();
	}
	
	// getting a playlist by name
	@GetMapping("/{userName}/playlists/{playlistName}")
	public Playlist findPlaylistByTitle(@PathVariable String userName, @PathVariable String playlistName) {
		User user = userService.findByName(userName);
		
		List <Playlist> playlists = user.getPlaylists();
		for (int i = 0; i < playlists.size(); i++) {
			if (playlists.get(i).getTitle().equals(playlistName)) {
				return playlists.get(i);
			}
		}
		return null;
	}
	
	// creating a new playlist
	@PostMapping(path = "/{userName}/playlists", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Playlist savePlaylist(@RequestBody Playlist playlist, @PathVariable String userName) {
		playlist.setCreator(userService.findByName(userName));
		return playlistService.save(playlist);
	}
		
	// getting the songs of a playlist
	@GetMapping("/{userName}/playlists/{playlistName}/songs")
	public List<Song> getPlaylistSongs(@PathVariable String userName, @PathVariable String playlistName) {
		User user = userService.findByName(userName);
		Playlist playlist = playlistService.findByTitle(playlistName);
		
		return playlist.getSongList();
	}
	
	// adding a song to a playlist
	@PostMapping(path = "/{userName}/playlists/{playlistName}/songs", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Playlist updateSong(@RequestBody Song song, @PathVariable String userName, @PathVariable String playlistName) {
		User user = userService.findByName(userName);
		List <Playlist> userPlaylists = user.getPlaylists();
		Playlist playlist = new Playlist();
		//Playlist playlist = playlistService.findByTitle(playlistName);
		
		for (int i = 0; i < userPlaylists.size(); i++) {
			if (userPlaylists.get(i).getTitle().equals(playlistName)) {
				playlist = userPlaylists.get(i);
			}
		}
		
		// for checking whether song is already in playlist
		boolean inPlaylist = false;
		
		List<Song> songList = playlist.getSongList();
		
		for (int i = 0; i < songList.size(); i++) {
			if (songList.get(i).getTitle().equals(song.getTitle())) {
				inPlaylist = true;
			}
		}
		if (inPlaylist == false) {
			playlist.addSong(song);
		}
		/*System.out.println("what's in the list");
		List <Song> testList = playlist.getSongList();
		for (int i = 0; i < testList.size(); i++) {
			System.out.println(testList.get(i).getTitle());
		}*/
		return playlist;
	}
	
	// finds the correct song in the playlist and changes both the total votes and up-/downvotes
	@PostMapping(path = "/{userName}/playlists/{playlistTitle}/songs/{songTitle}", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public String voteSong(@RequestBody int vote, @PathVariable String userName, @PathVariable String playlistTitle, @PathVariable String songTitle) {
		User user = userService.findByName(userName);
		Playlist playlist = playlistService.findByTitle(playlistTitle);
		List<Song> songList = playlist.getSongList();
		
		for (int i = 0; i < songList.size(); i++) {
			// if the song was found by title
			if (songList.get(i).getTitle().equals(songTitle)) {
				// update the total votes regarding the new vote
				songList.get(i).setVotes(songList.get(i).getUpVotes()+vote);
			}
			// if upvote, update upvotes, otherwise update downvotes
			if (vote == 1) {
				songList.get(i).setUpVotes(songList.get(i).getUpVotes()+vote);
			}
			else {
				songList.get(i).setDownVotes(songList.get(i).getDownVotes()+vote);
			}
		}
		return songTitle;
	}
	
}
