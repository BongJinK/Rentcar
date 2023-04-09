package venue;

import java.sql.Timestamp;

public class Venue {

	private String venueCode;
	private String venueName;
	private Timestamp regDate;

	public Venue(String venueCode, String venueName, Timestamp regDate) {
		this.venueCode = venueCode;
		this.venueName = venueName;
		this.regDate = regDate;
	}

	public Venue(VenueRequedyDto venueDto) {
		this.venueCode = venueDto.getVenueCode();
		this.venueName = venueDto.getVenueName();
		this.regDate = venueDto.getRegDate();
	}

	public String getVenueCode() {
		return venueCode;
	}

	public String getVenueName() {
		return venueName;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

}
