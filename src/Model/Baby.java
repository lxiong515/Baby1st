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
	
	/* example for git
	@OneToMany(mappedBy="baby", cascade = CascadeType.ALL)
	private List<ListingDetail> listingDetails;
	*/
	
	public Baby() {
		//super();
	}
	
	public Baby(String string) {
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
	/* git example below
	public List<ListingDetail> getListingDetails() {
		return this.listingDetails;
	}

	public void setListingDetails(List<ListingDetail> listingDetails) {
		this.listingDetails = listingDetails;
	}

	public ListingDetail addListingDetail(ListingDetail listingDetail) {
		getListingDetails().add(listingDetail);
		listingDetail.setRealtor(this);

		return listingDetail;
	}

	public ListingDetail removeListingDetail(ListingDetail listingDetail) {
		getListingDetails().remove(listingDetail);
		listingDetail.setRealtor(null);

		return listingDetail;
	}*/
	
	
}
