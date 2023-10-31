package adapter2;

import javax.swing.table.AbstractTableModel;

import domain.Covid19Pacient;

public class PacientTableModel extends AbstractTableModel {
	  protected Covid19Pacient pacient;
	  protected String[] columnNames =
	    new String[] { "Name", "Symptom", "Weight" };

	  public PacientTableModel(Covid19Pacient p) {
	    this.pacient=p;
	  }

	  public int getColumnCount() {
	    // Challenge!
		 return 1;
	  }

	  public String getColumnName(int i) {
	    // Challenge!
		  return "Column name 1";
	  }

	  public int getRowCount() {
	    // Challenge!
		  return 1;
	  }

	  public Object getValueAt(int row, int col) {
	    // Challenge!
		  return "value";
	  }
	}
