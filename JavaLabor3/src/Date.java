
public class Date {
	
	private int day;
	private int month;
	private int year;
	
	private static int[] lastDayInMonth={31, 28, 31, 30, 31, 30, 31, 31, 30, 31 ,30, 31};
	
	
	public Date(){
		
		setDate(1,1,1970);
	}
	
	public Date(int day, int month, int year){
		
		this();
		
		setDate(day,month,year);
		
		
	}
	
	public Date(Date other){
		
		this();
		
		if(other != null){
			
			setDate(other.day,other.month,other.year);
			//setYear(other.getYear());
			
		}
	}
	
//	public int getYear(){
//		
//		return year;
//	}
//		public void setYear(int year){
//			
//			this.year=year;
		
//	}
	 public boolean setDate(int day, int month, int year){
		 if(isValidDate(day, month, year)){
			 
		 
		 this.day=day;
		 this.month=month;
		 this.year=year;
		 
		 return true;}
		 
		 else {
			 
			 return false;
		 }
		 
	 }
	 
	 public static boolean isValidDate(int day, int month, int year){
		 
		 if(year%400 == 0 || (year%4 == 0 && year%100 != 0)){
			 
			 lastDayInMonth[1]=29;
		 }
		 
		 else{
			 
			 lastDayInMonth[1]=28;
			 
		 }
		 
	 
	return (year >= 1582 && month >=1 && month <=12 && day >=1 && day <= lastDayInMonth[month-1]);

	 }
	 
	 public String toString(){
		 
		 return String.format("%02d.%02d.%04d", day, month, year);
	 }
	 
//	 public boolean equals(Object other){
//		 
//		 Date o= (Date)other;
//		 
//	 return (day ==o.day && month == o.month && year ==o.year);
//	 }
	 
	 public boolean isBefore(Date other){
		 
		 if(other == null){
			 
			 return false;
		 }
		 
		 else{
			 
			 return(this.year < other.year || (this.year == other.year && this.month < other.month) || (this.year == other.year && this.month == other.month && this.day < other.day));
			 
		 }
	 }
	 
	 public Date nextDay(){
		 
		 if (isValidDate(day+1,month,year)){
			 
			 return new Date(day+1,month,year);}
			 
			 
			 else if(isValidDate(1, month+1,year)){
				 
				 return new Date(1,month+1,year);}
				 
				 else {
					 
					 return new Date(1,month,year+1);
			 }
		 }
	 }
	 

