
public class DateFIFO {

	int index=-1;
	Date[] elements;
	Date[] buffer;	
	
	public DateFIFO(int size){
		
		if(size<0){
			size=10;
		}
			elements=new Date[size]; //prüft ob Array überhaupt kopiert werden muss.
		
	}

	/**  * Adds a new element at the end of the queue  *  
	 * * @param aDate the element to be added  */ 
public void push(Date aDate){ 
index++;

if(index>=elements.length){
	
	//erstellt Kopie zum zwischen speichern des Datums
	buffer=elements;
	//vergrößert Date-Array(Daten werden gelöscht dabei)
	elements=new Date[buffer.length+10];
	//kopiere die Daten aus Zwischenspeicher
	System.arraycopy(buffer,0,elements,0,buffer.length);
}	
	elements[index]=aDate;
	buffer=new Date[0];
	

}
	 
	 /**  * Removes and returns the first element in the queue  *  
	  * * @return the element that was the first in the list,   * or null if there was no such element  */ 
public Date pop(){
	
	Date ausgabe;
	
	if(index>=1){
		DateFIFO cDate=new DateFIFO(elements.length);
		cDate=deepCopy();
		
		for(int i=0;i<index;i++){
			elements[i]=cDate.elements[i+1];}
		elements[index]=null;
		index--;
		ausgabe=cDate.elements[0];
		
	}else if (index==0){
			ausgabe=elements[0];
			index=-1;
			elements[0]=null;}
	else{
	
		ausgabe=null;}

	return ausgabe;
	
}
	 
	/**  * Searches the queue for the given date and returns the index  of the date  
	 * * within the queue, or -1 if the given date is not included in the queue.  
	 * * Two dates are equal if all of their attribute values are equal. This can  
	 * * be checked by implementing the equals(…) method in Date, or by using  
	 * * equals(…) to compare the result of toString() for the two Date objects.  
	 * *  * @return the index within the queue for the given date, or -1 if the   
	 * * given date is not included within the queue  */ 

public int find(Date aDate){ 

int aindex = -1;
for (int ae = 0;ae < elements.length;ae++){
	if (elements[ae].year == aDate.year){
		if (elements[ae].month==aDate.month){
			if (elements[ae].day == aDate.day){
				aindex = ae;
			}
		}					
	}
}
return aindex;
}
	 
	/** 
	 *  * Returns but does not remove the first element in the queue  *  
	 *  * @return the first element, or null, if there is no such element  */ 

public Date peek(){

return elements[0];
}
	/**  * Returns whether or not this queue is empty  * 
	 *  * @return true if this queue contains no elements; false otherwise  */ 

public boolean isEmpty(){
	
	boolean empty = false;
	if (index == 0){
		if (elements[0] == null){
			empty = true;
		}
	}
	return empty;
}

	 
	/**  * Creates a deep copy of the current DateFIFO Object. Deep copy means that   
	 * * the copy contains copies of the original elements (not the original   
	 * * elements themselves)  *  
	 * * @return a deep copy of this DateFIFO Object  */ 

public DateFIFO deepCopy(){
	
	DateFIFO output = new DateFIFO(elements.length);
	for(int i =0;i<elements.length;i++){
		if (elements[i] != null){
		output.push(new Date(elements[i]));
		}				
	}
	return output;
	
}
}


