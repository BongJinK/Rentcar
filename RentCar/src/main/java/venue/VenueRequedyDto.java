package venue;

public class VenueRequedyDto {

	private String venueCode;
	private String venueName;

	public VenueRequedyDto(String venueCode, String venueName) {
		this.venueCode = venueCode;
		this.venueName = venueName;
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

}
