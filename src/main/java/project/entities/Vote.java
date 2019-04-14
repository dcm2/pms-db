package project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vote {
	
	@Id 
	@Column(name = "VoteID") 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	public int myVote;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMyVote() {
		return myVote;
	}

	public void setMyVote(int myVote) {
		this.myVote = myVote;
	}
	
}
