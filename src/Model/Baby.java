package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="baby")
public class Baby {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BABY_ID")
	private int babyId;
	@Column(name="BABY_NAME")
	private String babyName;
	
	public Baby() {
		super();
	}
	
	public Baby(int babyId, String babyName) {
		super();
		this.babyId = babyId;
		this.babyName = babyName;
	}

	public int getBabyId() {
		return babyId;
	}

	public void setBabyId(int babyId) {
		this.babyId = babyId;
	}

	public String getBabyName() {
		return babyName;
	}

	public void setBabyName(String babyName) {
		this.babyName = babyName;
	}

	@Override
	public String toString() {
		return "Baby [babyId=" + babyId + ", babyName=" + babyName + "]";
	}
	
	
}
