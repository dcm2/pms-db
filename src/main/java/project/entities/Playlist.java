package project.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Playlist {

	private Long id;
	
	private String title;	
	private User creator;	
	private	int numSongs;
	private int duration;
	private List<Song> songList = new ArrayList<>();
	
	public Playlist(){
	}
	
	// All the getters & setters
	@Id
	@Column(name = "playlistID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
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
	@OneToMany(mappedBy = "belongsTo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("belongsTo")
	public List<Song> getSongList() {
		return songList;
	}

	public void setSongList(List<Song> songList) {
		this.songList = songList;
	}

	public int getNumSongs() {
		return numSongs;
	}
	public void setNumSongs(int numSongs) {
		this.numSongs = numSongs;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "UserID")
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	// This is to add a Song to a playlist
	public void addSong(Song song) {
		songList.add(song);
	}
	

}
