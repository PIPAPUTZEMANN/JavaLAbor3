public class DateTEst {

	public static void main(String[] args) {
		
		// Überprüfe übergebene Daten
		System.out.println("Überprüfe übergebene Daten");
		Date test1 = new Date(31,12,1994);
		System.out.println("Vorgegeben 31.12.1994 :: " + test1.toString() + " :: Fall 1: Gültiges Datum");
		Date test2 = new Date(1,1,1111);
		System.out.println("Vorgegeben 01.01.1970 :: " + test2.toString() + " :: Fall 2: Jahr zu klein");
		Date test3 = new Date(33,3,3333);
		System.out.println("Vorgegeben 01.01.1970 :: " + test3.toString() + " :: Fall 3: Tage zu viel");
		Date test4 = new Date(4,44,4444);
		System.out.println("Vorgegeben 01.01.1970 :: " + test4.toString() + " :: Fall 4: Monat zu viel");
		Date test5 = new Date(5,5,5555);
		System.out.println("Vorgegeben 05.05.5555 :: " + test5.toString() + " :: Fall 5: Gültiges Datum");
		System.out.println("");
		
		//Wochentag test
		System.out.println(test5.toString());
		System.out.println(test5.getWeekday().getGermanName());
		System.out.println("");
		
		//NumberOfDateObjects
		System.out.println("Anzahl der erstellten Dateobjekte: " + test1.NumberOfDateObjects);
		System.out.println("");
		
		//nextDate
		System.out.println("Überprüfen der Funktion nextDate");
		test1 = test1.nextDay();
		System.out.println("Alter Tag: 31.12.1994 - Neuer Tag: " + test1.toString());	
		test2 = test2.nextDay();
		System.out.println("Alter Tag: 01.01.1970 - Neuer Tag: " + test2.toString());	
		test3 = test3.nextDay();
		System.out.println("Alter Tag: 01.01.1970 - Neuer Tag: " + test3.toString());
		test4 = test4.nextDay();
		System.out.println("Alter Tag: 01.01.1970 - Neuer Tag: " + test4.toString());
		test5 = test5.nextDay();
		System.out.println("Alter Tag: 05.05.5555 - Neuer Tag: " + test5.toString());
		System.out.println("");
		
		//Date other
		System.out.println("Überprüfen der Funktion Date other");
		Date test6 = new Date(test1);
		System.out.println(test6.toString());
		System.out.println("");
		
		//SetDate
		System.out.println("Überprüfen der Funktion setDate");
		boolean testsD = false;
		testsD = test1.setDate(1, 2, 1111);
		System.out.println(testsD + ", da es sich um kein gültiges Datum handelt.");
		System.out.println(test1.toString() + " Datum sollte 01.01.1995 bleiben");
		testsD = test2.setDate(2, 2, 2222);
		System.out.println(testsD + ", da es sich um ein gültiges Datum handelt.");
		System.out.println(test2.toString() + " Datum sollte 02.02.2222 werden");
		System.out.println("");
		
		//isBefore
		System.out.println("Überprüfen der Funktion isBefore");
		Date test11 = new Date(1,1,2001);
		Date test12 = new Date(1,1,2000);
		System.out.println("false :: " + test11.isBefore(test12));
		Date test13 = new Date(1,1,2000);
		Date test14 = new Date(1,1,2001);
		System.out.println("true  :: " + test13.isBefore(test14));
		Date test15 = new Date(1,1,2000);
		Date test16 = new Date(1,2,2000);
		System.out.println("true  :: " + test15.isBefore(test16));
		Date test17 = new Date(1,2,2000);
		Date test18 = new Date(1,1,2000);
		System.out.println("false :: " + test17.isBefore(test18));
		Date test19 = new Date(1,1,2000);
		Date test110 = new Date(2,1,2000);
		System.out.println("true  :: " + test19.isBefore(test110));
		Date test111 = new Date(2,1,2000);
		Date test112 = new Date(1,1,2000);
		System.out.println("false :: " + test111.isBefore(test112));
		System.out.println("");
		
		//Wochentag test
		System.out.println(test112.toString());
		System.out.println(test112.getWeekday().getGermanName());
		System.out.println(""); 
		
		//NumberOfDateObjects
		System.out.println("Anzahl der erstellten Dateobjekte: " + test112.NumberOfDateObjects);
		System.out.println("");
		
		//Bonusaufgabe GC mit Warteschleife
		
		System.out.println("Wert vor dem GC " + test1);
		System.out.println("");
		System.gc();
		//for (int i = 0; i < 100000; i++){
		//	for (int ib = 0; ib < 10000000; ib++){
		//	}
		//}
		
		
		test1 = new Date(12,4,2032); 
		System.out.println("");
		System.out.println(test1);	
		
		//NumberOfDateObjects
		System.out.println("Anzahl der erstellten Dateobjekte: " + test112.NumberOfDateObjects);
		System.out.println("");
	
		//DateFIFO
		System.out.println("DateFIFO");
		DateFIFO testSpeicher = new DateFIFO(15);
		testSpeicher.push(test112);
		testSpeicher.push(test111);
		testSpeicher.push(test112);
		testSpeicher.push(test111);
		testSpeicher.push(test112);
		testSpeicher.push(test111);
		testSpeicher.push(test112);
		testSpeicher.push(test111);
		testSpeicher.push(test112);
		testSpeicher.push(test111);
		testSpeicher.push(test112);
		testSpeicher.push(test111);
		testSpeicher.push(test112);
		testSpeicher.push(test111);
		testSpeicher.push(test112);
		testSpeicher.push(test111);
		testSpeicher.push(test112);
		testSpeicher.push(test111);
		
		System.out.println(testSpeicher.peek());
		testSpeicher.pop();
		testSpeicher.pop();
		testSpeicher.pop();
		testSpeicher.pop();
		testSpeicher.pop();
		testSpeicher.pop();
		testSpeicher.pop();
		testSpeicher.pop();
		testSpeicher.pop();
		testSpeicher.pop();
		testSpeicher.pop();
		testSpeicher.pop();
		testSpeicher.pop();
		testSpeicher.pop();
		testSpeicher.pop();
		testSpeicher.pop();
		testSpeicher.pop();
		
		System.out.println(testSpeicher.peek());
		
	
	}
		

}
