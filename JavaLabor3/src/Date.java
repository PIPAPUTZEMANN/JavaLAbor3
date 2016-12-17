public class Date {
	private int day;
	private int month;
	private int year;
	static int NumberOfDateObjects = 0;
	public Date(){
		setDay(1);
		setMonth(1);
		setYear(1970);
		NumberOfDateObjects++;
	
	}
	
	public Date(int myDay, int myMonth, int myYear){
		this();
		if (isValidDate(myDay, myMonth, myYear) == true){
			setDay(myDay);
			setMonth(myMonth);
			setYear(myYear);
		}
	}
	
	public Date(Date other){
		setDay(other.getDay());
		setMonth(other.getMonth());
		setYear(other.getYear());
		NumberOfDateObjects++;
	}
	
	public boolean setDate(int newDay, int newMonth, int newYear){
		boolean valid;
		if (isValidDate(newDay, newMonth, newYear) == true){
			setDay(newDay);
			setMonth(newMonth);
			setYear(newYear);
			valid = true;
		}else{
			valid = false;
		}
		return valid;
	}
	public boolean Schaltjahr(int anyDay,int anyMonth,int anyYear){
		boolean Schaltjahr = false;	
			if (anyYear%4 == 0){
				if (anyYear%100 == 0){
					if (anyYear%400 == 0){
						Schaltjahr = true;
					}
				}
				else{
					Schaltjahr = true;
				}			
			}
			else{
				Schaltjahr = false;
			}		
		return Schaltjahr;
	}
	
	protected boolean isValidDate(int anyDay, int anyMonth, int anyYear){
		boolean valid = true;
		boolean SchaltjahrUndFebruar;
		if (anyMonth == 2){
			SchaltjahrUndFebruar = Schaltjahr(anyDay,anyMonth,anyYear);
		}else{
			SchaltjahrUndFebruar = false;
		}
		
		int maxDay;
		//Überprüft ob es sich um ein Schaltjahr und Februar ist.

		//Überprüft die Anzahl der Tage im Monat
		if (SchaltjahrUndFebruar == true){
			maxDay = 29;
		}
		else{
			switch (anyMonth){
				case 1:	maxDay = 31;	break;
				case 2: maxDay = 28;	break;
				case 3: maxDay = 31;	break;
				case 4: maxDay = 30;	break;
				case 5: maxDay = 31;	break;
				case 6: maxDay = 30;	break;
				case 7: maxDay = 31;	break;
				case 8: maxDay = 31;	break;
				case 9: maxDay = 30;	break;
				case 10:maxDay = 31;	break;
				case 11:maxDay = 30;	break;
				case 12:maxDay = 31;	break;
				default:valid = false;
						maxDay = 0;
			}
		}
		if (anyDay > maxDay || anyDay <=0){
			valid = false;
		}
		if (anyYear < 1583){
			valid = false;
		}
		return valid;
	}
	
	public String toString(){
		//Tag
		String Day;
		if (this.getDay() == 0){
			Day = "00.";
		}else if (this.getDay() <10){
			Day = "0"+this.getDay()+".";
		}else{
			Day = this.getDay()+".";
		}
		//Month
		String Month;
		if (this.getMonth() == 0){
			Month = "00.";
		}else if (this.getMonth() <10){
			Month = "0"+this.getMonth()+".";
		}else{
			Month = this.getMonth()+".";
		}			
	String Datestring = Day + Month +this.getYear();
	return Datestring;
	}
	
	public boolean isBefore(Date otherDate){
		boolean iB = false;
		//Überprüfe Tag
		if (getYear() == otherDate.getYear()){
			if (getMonth() == otherDate.getMonth()){
				if (getDay() < otherDate.getDay()){
					iB = true;
				}
			}
		}
		if (getYear() == otherDate.getYear()){
			if (getMonth() < otherDate.getMonth()){
				iB = true;
			}
		}
		if (getYear() < otherDate.getYear()){
			iB = true;
		}
		
		
		return iB;
	}
	
	public Date nextDay(){
		Date nDate = new Date();
		nDate.setDay(this.getDay() + 1);
		
		if (isValidDate(nDate.getDay(),getMonth(),getYear())==false){
			nDate.setDay(1);
			nDate.setMonth(getMonth() + 1);
			if (isValidDate(nDate.getDay(), nDate.getMonth(), getYear())==false){
				nDate.setMonth(1);
				nDate.setYear(getYear() +1);
				if (isValidDate(nDate.getDay(),nDate.getMonth(),nDate.getYear())==false){
					System.out.println("Error, anything went wrong!");
				}
			}else{
				nDate.setYear(year);
			}
		}else{
			nDate.setMonth(month);
			nDate.setYear(year);
		}
		return nDate;
	}
	public Day getWeekday(){
		Day wday = null;
		//Algorithmus zum berechnen der Wochentage von Wikipedia
		//Tageszahl
		int nt = this.getDay()%7;
		//Monatszahl
		int nm = 0;
		switch(this.getMonth()){
		case 1 : nm = 0; break;
		case 2 : nm = 3; break;
		case 3 : nm = 3; break;
		case 4 : nm = 6; break;
		case 5 : nm = 1; break;
		case 6 : nm = 4; break;
		case 7 : nm = 6; break;
		case 8 : nm = 2; break;
		case 9 : nm = 5; break;
		case 10: nm = 0; break;
		case 11: nm = 3; break;
		case 12: nm = 5; break;
		}
		//Jahreszahl
		int yz = this.getYear()%1000%100;
		int yh = (this.getYear()-yz)/100;
		yz = (yz+(yz/4))%7;
		yh = (3-(yh%4))*2;
		//Schaltjahr
		int ns = 0;
		if (Schaltjahr(this.getDay(),this.getMonth(),this.getYear())==true){
			if (getMonth() == 1 || getMonth() == 2){
				ns = -1;
			}
		}
		//Berechnung
		int w = (nt+nm+yz+yh+ns)%7;
		//Zuweisung
		switch (w) {
		case 0 : wday = Day.Sunday;		break;
		case 1 : wday = Day.Monday;		break;
		case 2 : wday = Day.Tuesday;	break;
		case 3 : wday = Day.Wednesday;	break;
		case 4 : wday = Day.Thursday;	break;
		case 5 : wday = Day.Friday;		break;
		case 6 : wday = Day.Saturday;	break;
		}
		return wday;
	}
	public int getNumberOfDateObjects() {
		return NumberOfDateObjects;
	}
	
	public void finalize(){
		System.out.println("Objekt wird gelöscht");
		NumberOfDateObjects--;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
}