package test;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;

import tickets.DAO;

// This is JUnit Test for checking the ticketlist
public class DaoTest {
	
	@Test
    public void testDAO() throws JSONException, IOException{
    	
    	DAO dao = new DAO();
    	JSONArray list = dao.getTicketList();
    	// The console should show the tickelist from the DAO
    	System.out.println("Ticket List: " + list);

	}	
}
