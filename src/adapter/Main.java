package adapter;

import domain.Covid19Pacient;
import domain.Symptom;
import domain.SymptomFactory;
import java.util.Comparator;
import java.util.Iterator;


public class Main {

	public static void main(String[] args) {
		Covid19Pacient p = new Covid19Pacient("Rubén", 33);
		
		Symptom s1 = new Symptom("s1", 10, 3);
		Symptom s2 = new Symptom("s2", 10, 5);
		Symptom s3 = new Symptom("s3", 10, 1);
		Symptom s4 = new Symptom("s4", 10, 2);
		Symptom s5 = new Symptom("s5", 10, 6);
		
		p.addSymptom(s1, 1);
		p.addSymptom(s2, 2);
		p.addSymptom(s3, 3);
		p.addSymptom(s4, 4);
		p.addSymptom(s5, 5);
		System.out.println(p.getSymptoms());
		
		InvertedIterator adapter = new Covid19PacientAdapter(p);

		Comparator<Symptom> symptomNameComparator = new SymptomNameComparator();
		
		Comparator<Object> objectSymptomNameComparator = (sy1, sy2) -> symptomNameComparator.compare((Symptom) sy1, (Symptom) sy2);
		Iterator<Object> iteratorByName = Sorting.sortedIterator(adapter, objectSymptomNameComparator);
		System.out.println("Sorted by Symptom Name:");
		while (iteratorByName.hasNext()) {
			Symptom symptom = (Symptom) iteratorByName.next();
		    System.out.println("symptom: " + symptom.getName() + ", severity index: " + symptom.getSeverityIndex());
		}

		adapter.goLast();

		     
		Comparator<Symptom> severityIndexComparator = new SeverityIndexComparator();
		     
		Comparator<Object> objectSeverityIndexComparator = (sy1, sy2) -> severityIndexComparator.compare((Symptom) sy1, (Symptom) sy2);
		Iterator<Object> iteratorBySeverity = Sorting.sortedIterator(adapter, objectSeverityIndexComparator);
		System.out.println("\nSorted by Severity Index:");
		while (iteratorBySeverity.hasNext()) {
			Symptom symptom = (Symptom) iteratorBySeverity.next();
			System.out.println("symptom: " + symptom.getName() + ", severity index: " + symptom.getSeverityIndex());
		}
	}
}


