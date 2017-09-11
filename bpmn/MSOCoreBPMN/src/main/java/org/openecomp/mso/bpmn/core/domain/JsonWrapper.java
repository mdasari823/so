package org.openecomp.mso.bpmn.core.domain;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


//import org.codehaus.jackson.map.SerializationConfig.Feature;


/**
 * Wrapper encapsulates needed JSON functionality 
 * to be extended by MSO service decomposition objects
 * providing ways to convert to and from JSON
 *
 */
@JsonInclude(Include.NON_NULL)
public abstract class JsonWrapper implements Serializable  {
	
	@JsonInclude(Include.NON_NULL)
	public String toJsonString(){
		
		String jsonString = "";
		//convert with Jackson
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		
		mapper.setSerializationInclusion(Include.NON_NULL);
		
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		try {
			jsonString = ow.writeValueAsString(this);
//		} catch (JsonGenerationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		} catch (Exception e){

			e.printStackTrace();
		}
		return jsonString;
	}
	
	@JsonInclude(Include.NON_NULL)
	public JSONObject toJsonObject(){

        ObjectMapper mapper = new ObjectMapper();
       // mapper.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
        //mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
       // mapper.enable(org.codehaus.jackson.map.DeserializationConfig.Feature.UNWRAP_ROOT_VALUE);
        JSONObject json = new JSONObject();
         try {
			json = new JSONObject(mapper.writeValueAsString(this));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return json; 
	}
	
	public String listToJson(List list) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(list);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
	}
	
	@JsonInclude(Include.NON_NULL)
	public String toJsonStringNoRootName(){
		
		String jsonString = "";
		//convert with Jackson
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		try {
			jsonString = ow.writeValueAsString(this);
		} catch (Exception e){

			e.printStackTrace();
		}
		return jsonString;
	}
	
	/**
	 * Returns a string representation of this object.
	 */
	public String toString() {
		return this.toJsonString();
	}
}