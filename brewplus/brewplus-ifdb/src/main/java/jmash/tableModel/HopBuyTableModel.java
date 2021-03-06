/*
 *  
 *
 *  This file is part of BrewPlus.
 *
 *  BrewPlus is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  BrewPlus is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with BrewPlus; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package jmash.tableModel;

import java.text.ParseException;
import java.util.Date;

import javax.swing.JLabel;

import jmash.Hop;
import jmash.Main;
import jmash.Utils;


/**
 *
 * @author AChiari
 */
public class HopBuyTableModel extends GenericTableModel<Hop> {

	public HopBuyTableModel() {
		this.ret.setIcon(Main.clockIcon);
		this.columnNames = new String[] { "","Nome", "Q.tà", "U.m.", "Forma", "Alfa A.", "Origine", "Data rif." };
	}

	private JLabel ret = new JLabel("");

	@Override
	public Object getValueAt(int row, int col) {
		Hop h = this.dataValues.get(row);
		this.ret.setIcon(Main.hopIcon);
		if (h != null) {
			switch (col) {
			case 0:
				return this.ret;
			case 1:
				return h.getNome();
			case 2:
				return (hmFormatterUM.get(h.getUnitaMisura())).format(h.getConvertedGrammi());
			case 3:
				return h.getUnitaMisura();
			case 4:
				return h.getForma();
			case 5:
				return NumberFormatter.format01(h.getAlfaAcidi());
			case 6:
				return h.getOrigine();
			case 7:
				return h.getDataAcquisto();
			}
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return true;
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		try {
			if (this.dataValues.get(row) != null) {
				Hop h = (this.dataValues.get(row));
				boolean flag = false;
				switch (col) {
				case 1:
					h.setNome(((String) value));
					break;
				case 2:
                                        if (value instanceof Double)
                                            h.setGrammi((Double)value);
                                        else
                                            h.setGrammi(Utils.convertWeight(NF.parse((String) value).doubleValue(), h.getUnitaMisura(), "grammi"));
					break;
				case 3:
					h.setUnitaMisura(((String) value));
					flag = true;
					break;
				case 4:
					h.setForma((String) value);
					break;
				case 5:
					h.setAlfaAcidi(NF.parse((String) value).doubleValue());
					break;
				case 6:
					h.setOrigine((String) value);
					break;
				case 7:
					h.setDataAcquisto((Date) value);
					break;
				default:
					break;
				}
				fireTableCellUpdated(row, col);
				if (flag) {
					fireTableRowsUpdated(row, row);
				}
			}
		} catch (ParseException ex) {
			Utils.showException(ex);
		}
	}
        
        public void appendRow(Hop row) {
            boolean esiste = false;
            //Controllo se il luppolo è già presente
            for (int ii = 0; ii < this.getRowCount(); ii++) {
                if (((String)this.getValueAt(ii, 1)).equalsIgnoreCase(row.getNome()) && ((String)this.getValueAt(ii, 4)).equalsIgnoreCase(row.getForma())) {
                    Double quantitaNecessaria = Utils.convertWeight(Double.parseDouble(((String)this.getValueAt(ii, 2)).replace(",", ".")),(String)this.getValueAt(ii, 3),"grammi");
                    this.setValueAt(quantitaNecessaria+row.getGrammi(), ii, 2);
                    esiste = true;
                    break;
                }
                    
            }
            if (!esiste) this.dataValues.add(row);
            fireTableDataChanged();
        }
}