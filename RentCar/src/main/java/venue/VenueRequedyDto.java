package venue;

import java.sql.Timestamp;

public class VenueRequedyDto {

	private String venueCode;
	private String venueName;
	private Timestamp regDate;

	public VenueRequedyDto(String venueCode, String venueName, Timestamp regDate) {
		this.venueCode = venueCode;
		this.venueName = venueName;
		this.regDate = regDate;
	}

	public String getVenueCode() {
		return venueCode;
	}

	public void setVenueCode(String venueCode) {
		this.venueCode = venueCode;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	
	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

}
