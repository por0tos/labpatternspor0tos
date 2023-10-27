package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Medicament {
	private String name;
	private List<Symptom> symptoms=new ArrayList<Symptom>();
	private SymptomFactory ff;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Medicament(String name, SymptomFactory symptomFactory) {
		super();
		this.name = name;
		ff = symptomFactory;
	}

	public Symptom addSymptomByName(String symptom){
		Symptom s2=null;
		Symptom s=getSymptomByName(symptom);
		if (s==null) {

			s2=ff.createSymptom(symptom);
			symptoms.add(s2);
		}
		return s2;

	}
	public void removeSymptom(Symptom s){
		symptoms.remove(s);

	}
	public Iterator<Symptom> getSymptoms() {
		return symptoms.iterator();
	}
	public Symptom getSymptomByName(String symptomName) {
		Iterator<Symptom> i= symptoms.iterator();
		Symptom s=null;
		while (i.hasNext()) {
			s=i.next();
			if (s!=null && s.getName().compareTo(symptomName)==0) return s;
		}
		return null;	
	}
	public Symptom removeSymptomByName(String symptomName) {
		Symptom s=getSymptomByName(symptomName);
		if (s!=null)removeSymptom(s);
		return s;
	}
}
