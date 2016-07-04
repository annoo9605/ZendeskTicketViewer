package tickets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/TicketServlet")
public class TicketServlet extends HttpServlet {

	private static final long serialVersionUID = 7761327550420319369L;

	public TicketServlet() {
    super();
    }

    protected void doGet(HttpServletRequest request, 
        HttpServletResponse response)
        throws ServletException, IOException {
    	
    response.setContentType("application/json");
    PrintWriter out = response.getWriter();
    
    List<Ticket> personsList = new ArrayList<Ticket>();
    
    DAO dao = new DAO();
    
    try {
    	
    	// parsing JSONArray list and set value to VO (Ticket class)
		JSONArray list = dao.getTicketList();
		
		for (int i = 0; i < list.length(); i++ ) {
			
			String id = list.getJSONObject(i).getString("id");
			String subject = list.getJSONObject(i).getString("subject");
			String description = list.getJSONObject(i).getString("description");
			
			Ticket ticket2 = new Ticket();
			ticket2.setId(id);
			ticket2.setSubject(subject);
			ticket2.setDescription(description);
			personsList.add(ticket2);
			
		}
	} catch (JSONException e) {
		e.printStackTrace();
	}
    
    // For dataTable (including page), set value to TicketJsonObject
        TicketJsonObject ticketJsonObject = new TicketJsonObject();
        ticketJsonObject.setiTotalDisplayRecords(personsList.size());
        ticketJsonObject.setiTotalRecords(personsList.size());
        ticketJsonObject.setAaData(personsList);

    // use gson lib for parsing
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json2 = gson.toJson(ticketJsonObject);
    out.print(json2);
    }

}
