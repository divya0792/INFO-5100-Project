package m2.CustomerUI;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

public class SelectData implements ItemListener {
    private HashMap<String,String> data = new HashMap<>();

    public SelectData(){}

    //0-brand;1-model;2-type;3-category;4-color;5-yearSta; 6-yearTo;7-priceMin;8-priceMax;9-mileage;
    public String sendSelectData(HashMap<String,String> data) {
        StringBuilder sb = new StringBuilder();
        if(data.containsKey("brand")) {
            if(sb.length() > 0)
            {
                sb.append(" and ");
            }
            sb.append("brand = '"+data.get("brand")+"'");
        }

        if(data.containsKey("model")) {
            if(sb.length() > 0)
            {
                sb.append(" and ");
            }
            sb.append("model = '"+data.get("model")+"'");
        }

        if(data.containsKey("type")) {
            if(sb.length() > 0)
            {
                sb.append(" and ");
            }
            sb.append("type = '"+data.get("type")+"'");
        }

        if(data.containsKey("category")) {
            if(sb.length() > 0)
            {
                sb.append(" and ");
            }
            sb.append("category = '"+data.get("category")+"'");
        }

        if(data.containsKey("color")) {
            if(sb.length() > 0)
            {
                sb.append(" and ");
            }
            sb.append("color = '"+data.get("color")+"'");
        }

        if(data.containsKey("yearSta")) {
         //   if(data.containsKey("yearTo")) {

                if(sb.length() > 0)
                {
                    sb.append(" and ");
                }
                //                sb.append("dateofmanufacturing like %" + Integer.parseInt(data.get("yearSta"))+"% "+Integer.parseInt(data.get("yearTo")));
                sb.append("dateofmanufacturing like '%" + Integer.parseInt(data.get("yearSta"))+"%'");
           // }
        }

        if(data.containsKey("priceMin")) {
            if(data.containsKey("priceMax")) {
                if(sb.length() > 0)
                {
                    sb.append(" and ");
                }
                String price = data.get("priceMax");
                if(price.contains("+")){
                    sb.append("price >= "+Integer.parseInt(price.substring(0, price.length()-1)));

                }
                else
                    sb.append("price between "+Integer.parseInt(data.get("priceMin"))+" and "+Integer.parseInt(data.get("priceMax")));
//                sb.append("price between "+Integer.parseInt(data.get("priceMin"))+" and "+Integer.parseInt(data.get("priceMax")));

            }
        }

        if(data.containsKey("mileage")) {
            String[] bounds = convertRange(data.get("mileage"));
            if(sb.length() > 0) {
                sb.append(" and ");
            }
            sb.append("mileage between "+Integer.parseInt(bounds[0])+" and "+Integer.parseInt(bounds[1]));
        }

        return  sb.toString();
    }

    public   String[] convertRange(String s) {
        String[] parts = s.trim().split("-");
        if(parts.length==1) {
            String c =s.substring(s.length()-1);
            if(c.equals("+")) {
                parts[0] = s.substring(0,s.length()-1);
                parts[1] = String.valueOf(Integer.MAX_VALUE);
            }
        }
        return parts;
    }

    public Vector<String> getDataFromSQL(ResultSet rs) throws SQLException {
        Vector<String> columnValues = new Vector<String>();
        ResultSetMetaData data = rs.getMetaData();
        int columnCount = data.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                columnValues.add(rs.getString(i));
            }
        }
        return columnValues;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
