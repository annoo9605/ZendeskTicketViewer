# ZendeskTicketViewer

README 

==============================================================================

Title: Zendesk Coding Challenge

==============================================================================
Project Development Explanation
README (Zendesk Coding Challenge)
1. This is build based on Java Servlet and jsp.

2. For Backend class
	1) DAO: is the connector to bring the data from zendesk api
	2) Ticket: is the VO for the data
	3) TicketJsonObject : is the VO for the dataTable library
	4) TicketServlet
	5) CORSResponseFilter: is to solve the issue for cross domain prevention
	6) web.xml: for dymamic web programming setting

3. For Front end
	1) index.jsp: I use only this page for rendering the whole list and the detail of clicked ticket as well as error message by hide and show functions.

	2) email.jsp: After showing the error message, it shows the contact email with hyperlink which redirects to email.jsp (But did not add the emailing features)

4. For Test
	I used JUnit test for Connection(DatTest) and MediaType(MediaTest).

==============================================================================
How to execute the project

I used Eclipse for IDE and used Tomcat Server 8.0 and then call the address below:

http://localhost:8080/TicketViewer/index.jsp

I tested after putting the wrong username for error message, and it works fine.
