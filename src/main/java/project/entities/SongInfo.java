package project.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class SongInfo {
	
	private Long id;
	
	private String title;
	private String artist;
	private int length;
	private String album;
	private String genre;
	@JsonIgnore
	private List<Song> usedBySong;
	
	public SongInfo() {	
	}
	
	
	// another constructor with parameters
	public SongInfo(String title, String artist, int length, String album, String genre) {
		this.title = title;
		this.artist = artist;
		this.length = length;
		this.album = album;
		this.genre = genre;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "songInfoID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@OneToMany(mappedBy = "songInfo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)	
	@JsonIgnoreProperties("songInfo")
	public List<Song> getUsedBySong() {
		return usedBySong;
	}

	public void setUsedBySong(List<Song> usedBySong) {
		this.usedBySong = usedBySong;
	}		
}
