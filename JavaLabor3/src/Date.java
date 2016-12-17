public class Date {
	int day;
	int month;
	int year;
	static int NumberOfDateObjects = 0;
	public Date(){
		day = 1;
		month = 1;
		year = 1970;
		NumberOfDateObjects++;
	
	}
	
	public Date(int myDay, int myMonth, int myYear){
		this();
		if (isValidDate(myDay, myMonth, myYear) == true){
			day = myDay;
			month = myMonth;
			year = myYear;
		}
	}
	
	public Date(Date other){
		day = other.day;
		month = other.month;
		year = other.year;
		NumberOfDateObjects++;
	}
	
	public boolean setDate(int newDay, int newMonth, int newYear){
		boolean valid;
		if (isValidDate(newDay, newMonth, newYear) == true){
			day = newDay;
			month = newMonth;
			year = newYear;
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
		if (this.day == 0){
			Day = "00.";
		}else if (this.day <10){
			Day = "0"+this.day+".";
		}else{
			Day = this.day+".";
		}
		//Month
		String Month;
		if (this.month == 0){
			Month = "00.";
		}else if (this.month <10){
			Month = "0"+this.month+".";
		}else{
			Month = this.month+".";
		}			
	String Datestring = Day + Month +this.year;
	return Datestring;
	}
	
	public boolean isBefore(Date otherDate){
		boolean iB = false;
		//Überprüfe Tag
		if (year == otherDate.year){
			if (month == otherDate.month){
				if (day < otherDate.day){
					iB = true;
				}
			}
		}
		if (year == otherDate.year){
			if (month < otherDate.month){
				iB = true;
			}
		}
		if (year < otherDate.year){
			iB = true;
		}
		
		
		return iB;
	}
	
	public Date nextDay(){
		Date nDate = new Date();
		nDate.day = this.day + 1;
		
		if (isValidDate(nDate.day,month,year)==false){
			nDate.day = 1;
			nDate.month = month + 1;
			if (isValidDate(nDate.day, nDate.month, year)==false){
				nDate.month = 1;
				nDate.year = year +1;
				if (isValidDate(nDate.day,nDate.month,nDate.year)==false){
					System.out.println("Error, anything went wrong!");
				}
			}else{
				nDate.year=year;
			}
		}else{
			nDate.month = month;
			nDate.year = year;
		}
		return nDate;
	}
	public Day getWeekday(){
		Day wday = null;
		//Algorithmus zum berechnen der Wochentage von Wikipedia
		//Tageszahl
		int nt = this.day%7;
		//Monatszahl
		int nm = 0;
		switch(this.month){
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
		int yz = this.year%1000%100;
		int yh = (this.year-yz)/100;
		yz = (yz+(yz/4))%7;
		yh = (3-(yh%4))*2;
		//Schaltjahr
		int ns = 0;
		if (Schaltjahr(this.day,this.month,this.year)==true){
			if (month == 1 || month == 2){
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
}