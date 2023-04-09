package venue;

public class Venue {

	private String venueCode;
	private String venueName;

	public Venue(String venueCode, String venueName) {
		this.venueCode = venueCode;
		this.venueName = venueName;
	}

	public Venue(VenueRequedyDto venueDto) {
		this.venueCode = venueDto.getVenueCode();
		this.venueName = venueDto.getVenueName();
	}

	public String getVenueCode() {
		return venueCode;
	}

	public String getVenueName() {
		return venueName;
	}

}
