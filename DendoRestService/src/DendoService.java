import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import methods.BCrypt;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Dao.UserDAO;
import Models.Comment;
import Models.Company;
import Models.Discount;
import Models.User;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

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
			/*
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dendo","developer", "developer");
            Statement st = connection.createStatement();
            String  sqlQuery = "select id, name, description, category_id from companies";
            a
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
            System.out.println("Yes");
            listCompanies.put("companies", jsonList);
            */
            
            //Hibenate
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    		
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from Company");
            List<Company> companies = query.list();
            JSONArray jsonList = new JSONArray();
            for(int i = 0; i < companies.size(); i++) {
            	JSONObject company = new JSONObject();
                company.put("id", companies.get(i).getId());
                company.put("name", companies.get(i).getName());
                company.put("desc", companies.get(i).getDesc());
                company.put("category", "");

                jsonList.put(company);
            }
            listCompanies.put("companies", jsonList);
            //


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
        }
		return Response.status(200).entity(listCompanies.toString()).build();
	}
	
	@GET
	@Path("/getDiscounts")
	@Produces("application/json;charset=windows-1251")
	public Response getDiscounts() throws JSONException {
		JSONObject listDiscount = new JSONObject();
		try {            
			//Hibenate
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    		
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from Discount");
            List<Discount> disounts = query.list();
            JSONArray jsonList = new JSONArray();
            for(int i = 0; i < disounts.size(); i++) {
            	JSONObject discount = new JSONObject();
                discount.put("id", disounts.get(i).getId());
                discount.put("title", disounts.get(i).getTitle());
                discount.put("desc", disounts.get(i).getDesc());
                discount.put("imageUrl", disounts.get(i).getImageUrl());
                discount.put("oldPrice", disounts.get(i).getOldPrice());
                discount.put("newPrice", disounts.get(i).getNewPrice());
                discount.put("dateStarted", disounts.get(i).getStartedDate());
                discount.put("dateEnded", disounts.get(i).getEndedDate());

                jsonList.put(discount);
            }
            listDiscount.put("disounts", jsonList);

        } catch (Exception e) {
            
        }finally {
        }
		return Response.status(200).entity(listDiscount.toString()).build();
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
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from User");
            List<User> users = query.list();
            JSONArray jsonList = new JSONArray();
            for(int i = 0; i < users.size(); i++) {
            	JSONObject user = new JSONObject();
                user.put("id", users.get(i).getId());
                user.put("username", users.get(i).getUserName());
                user.put("firstName", users.get(i).getFirstName());
                user.put("lastName", users.get(i).getLastName());
                user.put("email", users.get(i).getEmail());
                user.put("phone", users.get(i).getPhone());
                user.put("dateBirth", users.get(i).getBirthDate());

                jsonList.put(user);
            }
            listUsers.put("users", jsonList);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
		return Response.status(200).entity(listUsers.toString()).build();
	}
	
	@GET
	@Path("/getCommentsByDiscount")
	@Produces("application/json;charset=windows-1251")
	public Response getCommentsByDiscount() throws JSONException {
		JSONObject listComments = new JSONObject();
		try {            
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from Comment");
            List<Comment> comments = query.list();
            JSONArray jsonList = new JSONArray();
            for(int i = 0; i < comments.size(); i++) {
            	JSONObject comment = new JSONObject();
                comment.put("id", comments.get(i).getId());
                comment.put("text", comments.get(i).getText());
                comment.put("createdDate", comments.get(i).getCreatedDate());

                jsonList.put(comment);
            }
            
            listComments.put("comments", jsonList);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
		
		return Response.status(200).entity(listComments.toString()).build();
	}

	@GET
	@Path("/login")
	@Produces("application/json;charset=windows-1251")
	public Response login(@QueryParam("userName") String username, @QueryParam("password") String password) throws JSONException, NoSuchAlgorithmException {
		JSONObject listComments = new JSONObject();
		try {            
            String generatedSecuredPasswordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
            System.out.println(generatedSecuredPasswordHash); 
            
            UserDAO udao = new UserDAO();
            String curPasswordHash = udao.getUser(username).getPassword();
            
            boolean matched = BCrypt.checkpw(curPasswordHash, generatedSecuredPasswordHash);
            System.out.println(matched);
            //System.out.println(curPasswordHash.compareTo(generatedSecuredPasswordHash));
            
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
