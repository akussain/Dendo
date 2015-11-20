import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import methods.BCrypt;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Dao.UserDAO;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

@Path("/dendoservice")
public class DendoService {
	
	@GET
	@Produces("application/json")
	public Response getCompanies1() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		Double fahrenheit = 98.24;
		Double celsius;
		celsius = (fahrenheit - 32)*5/9; 
		jsonObject.put("F Value", fahrenheit); 
		jsonObject.put("C Value", celsius);
 
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/getCompanies")
	@Produces("application/json;charset=windows-1251")
	public Response getCompanies() throws JSONException {
		JSONObject listCompanies = new JSONObject();
		try {            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dendo","root", "");
            Statement st = connection.createStatement();
            String  sqlQuery = "select id, name, description, category_id from companies";
            ResultSet rs = st.executeQuery(sqlQuery);
            JSONArray jsonList = new JSONArray();
            while(rs.next()) {
                JSONObject company = new JSONObject();
                company.put("id", rs.getInt("id"));
                company.put("name", rs.getString("name"));
                company.put("desc", rs.getString("description"));
                company.put("category", rs.getString("category_id"));

                jsonList.put(company);
            }

            listCompanies.put("companies", jsonList);

            if(st != null) st.close();
            if(connection != null) connection.close();

        } catch (Exception e) {
            
        }finally {
        }
		return Response.status(200).entity(listCompanies.toString()).build();
	}
	
	@GET
	@Path("/getDiscounts")
	@Produces("application/json;charset=windows-1251")
	public Response getDiscounts() throws JSONException {
		JSONObject listPlaces = new JSONObject();
		try {            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderme","root", "");
            Statement st = connection.createStatement();
            String  sqlQuery = "select id, name, description, address, phone from restaurants";
            ResultSet rs = st.executeQuery(sqlQuery);
            JSONArray jsonList = new JSONArray();
            while(rs.next()) {
                JSONObject discount = new JSONObject();
                discount.put("id", rs.getInt("id"));
                discount.put("name", rs.getString("name"));
                discount.put("desc", rs.getString("description"));
                discount.put("address", rs.getString("address"));
                discount.put("phone", rs.getString("phone"));

                jsonList.put(discount);
            }

            listPlaces.put("discounts", jsonList);

            if(st != null) st.close();
            if(connection != null) connection.close();
        } catch (Exception e) {
            
        }finally {
        }
		return Response.status(200).entity(listPlaces.toString()).build();
	}
	
	@GET
	@Path("/getCategories")
	@Produces("application/json;charset=windows-1251")
	public Response getCategories() throws JSONException {
		JSONObject listCategories = new JSONObject();
		try {            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dendo","root", "");
            Statement st = connection.createStatement();
            String  sqlQuery = "select id, name, description from categories";
            ResultSet rs = st.executeQuery(sqlQuery);
            JSONArray jsonList = new JSONArray();
            while(rs.next()) {
                JSONObject category = new JSONObject();
                category.put("id", rs.getInt("id"));
                category.put("name", rs.getString("name"));
                category.put("desc", rs.getString("description"));

                jsonList.put(category);
            }

            listCategories.put("categories", jsonList);

            if(st != null) st.close();
            if(connection != null) connection.close();
        } catch (Exception e) {
  
        }finally {
        }
		return Response.status(200).entity(listCategories.toString()).build();
	}

	@GET
	@Path("/getUsers")
	@Produces("application/json;charset=windows-1251")
	public Response getUsers() throws JSONException {
		JSONObject listUsers = new JSONObject();
		try {            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dendo","root", "");
            Statement st = connection.createStatement();
            String  sqlQuery = "select id, username, first_name, last_name, email, phone, logo_url from users";
            ResultSet rs = st.executeQuery(sqlQuery);
            JSONArray jsonList = new JSONArray();
            while(rs.next()) {
                JSONObject user = new JSONObject();
                user.put("id", rs.getInt("id"));
                user.put("username", rs.getString("username"));
                user.put("first_name", rs.getString("first_name"));
                user.put("last_name", rs.getInt("last_name"));
                user.put("email", rs.getString("email"));
                user.put("phone", rs.getString("phone"));
                user.put("logo_url", rs.getString("logo_url"));
                
                jsonList.put(user);
            }

            listUsers.put("users", jsonList);

            if(st != null) st.close();
            if(connection != null) connection.close();
        } catch (Exception e) {
  
        }finally {
        }
		return Response.status(200).entity(listUsers.toString()).build();
	}
	
	@GET
	@Path("/getCommentsByDiscount")
	@Produces("application/json;charset=windows-1251")
	public Response getCommentsByDiscount() throws JSONException {
		JSONObject listComments = new JSONObject();
		try {            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dendo","root", "");
            Statement st = connection.createStatement();
            String  sqlQuery = "select id, text, user_id, date_created from comments where discount_id = 1";
            ResultSet rs = st.executeQuery(sqlQuery);
            JSONArray jsonList = new JSONArray();
            while(rs.next()) {
                JSONObject comment = new JSONObject();
                comment.put("id", rs.getInt("id"));
                comment.put("text", rs.getString("text"));
                comment.put("user_id", rs.getString("user_id"));
                comment.put("date_created", rs.getString("date_created"));

                jsonList.put(comment);
            }
            
            listComments.put("comments", jsonList);

            if(st != null) st.close();
            if(connection != null) connection.close();
        } catch (Exception e) {
            
        }finally {
        }
		
		return Response.status(200).entity(listComments.toString()).build();
	}

	@GET
	@Path("/login")
	@Produces("application/json;charset=windows-1251")
	public Response login(@QueryParam("userName") String username, @QueryParam("password") String password) throws JSONException, NoSuchAlgorithmException {
		JSONObject listComments = new JSONObject();
		try {            
            
            //Login
            String generatedSecuredPasswordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
            System.out.println(generatedSecuredPasswordHash); 
            
            //UserDAO udao = new UserDAO();
            //String curPasswordHash = udao.getUser(username).getPassword();
            
            String curPasswordHash = "";
            
            //Using JDBC - should change to Hibernate
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dendo","root", "");
            Statement st = connection.createStatement();
            String  sqlQuery = "select id, name from companies where id = 1";
            ResultSet rs = st.executeQuery(sqlQuery);
            while(rs.next()) {
            	curPasswordHash = rs.getString("name");
            	System.out.println(curPasswordHash + " - user");
            }
            
            
            //System.out.println(generatedSecuredPasswordHash.equals(curPasswordHash) + "!");
            
            boolean matched = BCrypt.checkpw(curPasswordHash, generatedSecuredPasswordHash);
            System.out.println(matched);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
        }
		
		return Response.status(200).entity(listComments.toString()).build();
	}

	@GET
	@Path("/register")
	@Produces("application/json;charset=windows-1251")
	public Response register(@QueryParam("userName") String userName, @QueryParam("password") String password, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("email") String email, @QueryParam("phone") String phone, @QueryParam("birthDate") Date birthDate) throws JSONException, NoSuchAlgorithmException {
		JSONObject listComments = new JSONObject();
		try {            
            //Register
			UserDAO userDAO = new UserDAO();
			userDAO.registerUser(userName, firstName, lastName, password, email, phone, birthDate);
            
        } catch (Exception e) {
            
        }finally {
        }
		
		return Response.status(200).entity(listComments.toString()).build();
	}
	
}
