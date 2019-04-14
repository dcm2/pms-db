package project.service;

import project.entities.*;

public interface SongInfoService {

	SongInfo findByTitle(String title);
	
	SongInfo save(SongInfo songInfo);
}
