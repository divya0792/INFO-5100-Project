package m3.view;

import m3.model.checker.Checker;
import m3.model.checker.EqualChecker;
import m3.model.checker.GreaterChecker;
import m3.model.checker.LessChecker;
import m3.model.filter.*;

import javax.swing.*;
import java.awt.*;

public class FilterDetailUI extends BasicUI {

	private JLabel UIName, NameCombo, TypeCombo, valueInput;
	private JPanel namePanel, UINamePanel, typePanel, valuePanel, buttonPanel;
	private JComboBox Name;
	private JComboBox Type;
	private JTextField value;
	private JButton cancel, ok;
	private IncentiveDetailUI sui;
	private JDialog jd;
    private int Modify;

	FilterDetailUI(IncentiveDetailUI sui) {
		this.sui = sui;
        Modify = 0;
    }

    FilterDetailUI(IncentiveDetailUI sui, int i) {
        this.sui = sui;
        Modify = i;
    }

	@Override
	public void create() {

		UIName = new JLabel("Condition");
        Name = new JComboBox(new String[]{"Brand", "Year", "VehicleIDs", "Color", "Model", "Price"});
		Type = new JComboBox(new String[]{"="});
		NameCombo = new JLabel("name:");
		TypeCombo = new JLabel("type:");
		valueInput = new JLabel("Value:");
		value = new JTextField(10);
		cancel = new JButton("Cancle");
		ok = new JButton("Okay");


	}
	
	
	
	private void addUINamePanel(Container con) {
		UINamePanel = new JPanel();
		con.add(UINamePanel);
	}

	private void addNamePanel(Container con) {
		namePanel = new JPanel();
		namePanel.add(NameCombo);
		namePanel.add(Name);
		con.add(namePanel);
	}
	
	private void addTypePanel(Container con) {
		typePanel = new JPanel();
		typePanel.add(TypeCombo);
		typePanel.add(Type);
		con.add(typePanel);
	}
	
	private void addValuePanel(Container con) {
		valuePanel = new JPanel();
		valuePanel.add(valueInput);
		valuePanel.add(value);
		con.add(valuePanel);
	}
	
	private void addButtonPanel(Container con) {
		buttonPanel = new JPanel();
		buttonPanel.add(cancel);
		buttonPanel.add(ok);
		con.add(buttonPanel);
	}

	private void TypeToBe(String type) {
		switch(type) {
		case("Brand"):{
			Type.removeAllItems();
			Type.addItem("=");
			break;
		}
		case("Year"):{
			Type.removeAllItems();
			Type.addItem(">");
			Type.addItem("<");
			break;
					
		}
		case("VehicleIDs"):
		{
			Type.removeAllItems();
			Type.addItem("=");
			break;
		}
			case ("Color"): {
				Type.removeAllItems();
				Type.addItem("=");
				break;

			}
			case ("Model"): {
				Type.removeAllItems();
				Type.addItem("=");
				break;
			}
            case ("Price"): {
                Type.removeAllItems();
                Type.addItem("<");
                Type.addItem(">");
                break;

            }


		}
	}


	@Override
	public void add(Container con) {

		GridLayout gl = new GridLayout(0, 1);
		con.setLayout(gl);
		con.setName("condition");
		addUINamePanel(con);
		addNamePanel(con);
		addTypePanel(con);
		addValuePanel(con);
		addButtonPanel(con);
		
	}


	
	@Override
	public void addListeners() {
		Name.addActionListener((e) -> TypeToBe(Name.getSelectedItem().toString())
		);

		cancel.addActionListener((e) -> this.dispose());
		ok.addActionListener((e) -> {

                    if (Modify == 1) {
                        sui.modifyRow(toSecondUIFilter());
                    } else
                        sui.addToTableBelow(toSecondUIFilter());

                    this.dispose();
                }




		);
	}


	private Filter addFilter(String name, String type, String value) {


		return FilterFinder(name, type, value);

	}

	public Filter toSecondUIFilter() {
		return addFilter(Name.getSelectedItem().toString(), Type.getSelectedItem().toString(), value.getText());

	}


	private Filter FilterFinder(String name, String type, String value) {
		try {
			switch (name) {
				case ("Brand"): {
					BrandFilter b = new BrandFilter((Checker) new EqualChecker());
					b.setValueFromString(value);
					return b;
				}
				case ("Color"): {
					ColorFilter c = new ColorFilter((Checker) new EqualChecker());
					c.setValue(value);
					return c;
				}
				case("VehicleIDs"): {
					VehicleIDsFilter v = new VehicleIDsFilter(new EqualChecker());
					v.setListFromString(value);
					return v;
				}
				case("Year"):{
                    if (type.equals(">")) {
						YearFilter y = new YearFilter((Checker) new GreaterChecker());
							y.setValueFromString(value);
						return y;
					} else {
						YearFilter y = new YearFilter((Checker) new LessChecker());
							y.setValueFromString(value);
						return y;
					}
				}
				case ("Model"): {
					ModelFilter m = new ModelFilter((Checker) new EqualChecker());
					m.setValue(value);
					return m;
				}
                case ("Price"): {
                    if (type.equals("<")) {
                        PriceFilter p = new PriceFilter((Checker) new LessChecker());
                        p.setValueFromString(value);
                        return p;
                    } else {
                        PriceFilter p = new PriceFilter((Checker) new GreaterChecker());
                        p.setValueFromString(value);
                        return p;
                    }
                }
			}
		} catch (InputException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
		return null;
	}

	public void modifyFilter(String[] filter) {

		Name.setSelectedItem(filter[0]);
		Type.setSelectedItem(filter[1]);
		value.setText(filter[2]);
	}


}
