package m3.db;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.*;

import m3.model.Incentive;
import m3.model.filter.Filter;

public class DataFormatConversion {

    public static String FilterToString(Incentive i) {
    	ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        try {
			for (Filter filter : i.getConditions()) {
				list.add(mapper.writeValueAsString(filter));
			}
			sb.append(mapper.writeValueAsString(list));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return sb.toString();
    }
    
    public static List<Filter> stringToList(String s) {
    	ObjectMapper mapper = new ObjectMapper();
    	List<Filter> list = new ArrayList<>();
		List<String> parser = new ArrayList<>();
    	try {
			parser = mapper.readValue(s, ArrayList.class);
			for (String str : parser) {
				list.add(mapper.readValue(str,Filter.class));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return list;
    }
    

    
    public static String OfferToString(Incentive i) {
    	ObjectMapper mapper = new ObjectMapper();
		String s = null;
		try {
			s = mapper.writeValueAsString(i.getOffer());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return s;
    }

}
