package adapter2;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientTableModelAdapter extends AbstractTableModel {
	  protected List<Covid19Pacient> pacients;
	  protected String[] columnNames = new String[] {"Symptom", "Weight" };

	  public Covid19PacientTableModelAdapter(List<Covid19Pacient> p) {
	    this.pacients = p;
	  }

	  public int getColumnCount() {
		 return columnNames.length;
	  }

	  public String getColumnName(int i) {
		  return columnNames[i];
	  }

	  public int getRowCount() {
		  int suma = 0;
		  for(Covid19Pacient p : pacients)
			  suma += p.getSymptoms().size();
		  return suma;
	  }
	  
	  public Object getValueAt(int row, int col) {
	        
	        int currentRow = 0;
	        for (Covid19Pacient p : pacients) {
	            for (Symptom s : p.getSymptoms()) {
	                if (currentRow == row) {
	                    switch (col) {
	                        case 0:
	                        	return s.getName();
	                        case 1:
	                            return p.getWeight(s);	                            
	                    }
	                }
	                currentRow++;
	            }
	        }
	        return null;
	    }

	}
