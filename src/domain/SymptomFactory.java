package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SymptomFactory {
	
	HashMap<String, Symptom> almacen = new HashMap<String, Symptom>();
	
	public Symptom createSymptom(String symptomName) {
		
	    if (almacen.containsKey(symptomName)) {
	    	return almacen.get(symptomName);
	    }
		
	    List<String> impact5 = Arrays.asList("fiebre", "tos seca", "astenia","expectoracion");
	    List<Double> index5 = Arrays.asList(87.9, 67.7, 38.1, 33.4);
	    List<String> impact3 = Arrays.asList("disnea", "dolor de garganta", "cefalea","mialgia","escalofrios");
	    List<Double> index3 = Arrays.asList(18.6, 13.9, 13.6, 14.8, 11.4);
	    List<String> impact1 = Arrays.asList("nauseas", "vómitos", "congestión nasal","diarrea","hemoptisis","congestion conjuntival", "mareos");
	    List<Double> index1 = Arrays.asList(5.0, 4.8, 3.7, 0.9, 0.8, 0.7);
	    
	    List<String> digestiveSymptom=Arrays.asList("nauseas", "vómitos","diarrea");
	    List<String> neuroMuscularSymptom=Arrays.asList("fiebre", "astenia", "cefalea", "mialgia","escalofrios", "mareos");
	    List<String> respiratorySymptom=Arrays.asList("tos seca","expectoracion","disnea","dolor de garganta", "congestión nasal","hemoptisis","congestion conjuntival");

	    int impact=0;
	    double index=0;
	    if (impact5.contains(symptomName)) {impact=5; index= index5.get(impact5.indexOf(symptomName));}
	      else if (impact3.contains(symptomName)) {impact=3;index= index3.get(impact3.indexOf(symptomName));}
	        else if (impact1.contains(symptomName)) {impact=1; index= index1.get(impact1.indexOf(symptomName));}
	    
	    if (impact!=0)  {
	    	if (digestiveSymptom.contains(symptomName)) {
	    		Symptom s = new DigestiveSymptom(symptomName,(int)index, impact);
	    		almacen.put(symptomName, s);
	    		return s;
	    	}
	    	if (neuroMuscularSymptom.contains(symptomName)) {
	    		Symptom s = new NeuroMuscularSymptom(symptomName,(int)index, impact);
	    		almacen.put(symptomName, s);
	    		return s;
	    	}
	    	if (respiratorySymptom.contains(symptomName)) {
	    		Symptom s = new RespiratorySymptom(symptomName,(int)index, impact);
	    		almacen.put(symptomName, s);
	    		return s;
	    	}
	    }
	    
	    return null;		
		
	}
}
