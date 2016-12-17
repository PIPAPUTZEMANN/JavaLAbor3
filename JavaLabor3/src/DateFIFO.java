
public class DateFIFO {
	int index = -1;
	Date [] elements;
	Date [] buffer;
	
	public DateFIFO(int size){	
		if (size < 0){
			size = 10;
		}
		 elements = new Date[size];
	}


			//Prüfe ob Array überhaupt kopiert werden muss
		 /**  
		  * Removes and returns the first element in the list 
		  * 
		  * @return the element that was the first in the list
		  * 
		  */ 
		
		public void push(Date aDate){
			
			index++;
			if (index >= elements.length){
					//erstelle Kopie zum zwischenspeichern des Datums
					buffer = elements;
					//vergrößere Date-Array (Daten werden dabei gelöscht)
					elements = new Date[buffer.length + 10];
					//Kopiere die Daten aus dem zwischenspeicher
					System.arraycopy(buffer, 0, elements, 0, buffer.length);
			}
					elements[index] = aDate;				
					buffer = new Date[0];
			
		}
				
		public Date pop(){
			Date ausgabe;
			
			if (index >= 1){
				DateFIFO cDate = new DateFIFO(elements.length);
				cDate = deepCopy();
				for (int i = 0; i < index; i++){
					elements[i] = cDate.elements[i+1];
				}
				elements[index]= null;
				index--;
				ausgabe = cDate.elements[0];
				
			}else if (index == 0){
				ausgabe = elements[0];
				index = -1;
				elements[0] = null;
			}else{
				ausgabe = null;
			}
			return ausgabe;
		}
		
		/**
		 * Searches the list for the given date and returns the index of the date  
		 * within the list or -1 if the given date is not included in the list.   
		 * Two dates are equal, if all of their attribute values are equal.
		 * 
		 * @return the index within the list for the given date, or -1 if the   
		 * given date is not included within the list
		 * 
		 */ 
		public int find(Date aDate){
			int aindex = -1;
			for (int ae = 0;ae < elements.length;ae++){
				if (elements[ae].getYear() == aDate.getYear()){
					if (elements[ae].getMonth()==aDate.getMonth()){
						if (elements[ae].getDay() == aDate.getDay()){
							aindex = ae;
						}
					}					
				}
			}
			return aindex;
		}
		
		/**  
		 * Returns but does not remove the first element in the list
		 *
		 * @return the first element, or null, if there is no such element
		 * 
		 */ 
		public Date peek(){
			return elements[0];
		}
		
		/**  
		 * Tests if this list is empty
		 * 
		 * @return true if this list contains no elements; false otherwise  
		 * 
		 */ 
		public boolean isEmpty(){
			boolean empty = false;
			if (index == 0){
				if (elements[0] == null){
					empty = true;
				}
			}
			return empty;
		}
		
		/**  
		 * Creates a deep copy of the current DateFIFO Object. This means that the   
		 * elements within the list must be copied too, not only the references.
		 * 
		 * * @return a deep copy of this DateFIFO Object  
		 */ 
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
