
public enum Day {
	Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;

	public String getGermanName() {
		String wday = null;
		if (this == Monday) {
			wday = "Montag";
		}
		if (this == Tuesday) {
			wday = "Dienstag";
		}
		if (this == Wednesday) {
			wday = "Mittwoch";
		}
		if (this == Thursday) {
			wday = "Donnerstag";
		}
		if (this == Friday) {
			wday = "Freitag";
		}
		if (this == Saturday) {
			wday = "Samstag";
		}
		if (this == Sunday) {
			wday = "Sonntag";
		}
		return wday;
	}
}
