package methods;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.File;
import java.io.IOException;

public class HTMLParser {
	
	 public static void main(String args[]) {

	 }
	 
	 public static void parseHTMLString() {
		// Parse HTML String using JSoup library
		String HTMLSTring = "<!DOCTYPE html>"
		                 + "<html>"
		                 + "<head>"
		                 + "<title>JSoup Example</title>"
		                 + "</head>"
		                 + "<body>"
		                 + "<table><tr><td><h1>HelloWorld</h1></tr>"
		                 + "</table>"
		                 + "</body>"
		                 + "</html>";
		 Document html = Jsoup.parse(HTMLSTring);
         String title = html.title();
		 String h1 = html.body().getElementsByTag("h1").text();
		 
		 System.out.println("Input HTML String to JSoup :" + HTMLSTring);
		 System.out.println("After parsing, Title : " + title);
		 System.out.println("Afte parsing, Heading : " + h1);

	 }
	 
	 public static void parseHTMLPage() {
		 Document doc;
		 String title = "";
		 try {
			 doc = Jsoup.connect("http://nurbiz.kz/").get();
			 title = doc.title();
			 
			 System.out.println(doc.getElementsByClass("cat_special-list").get(0).data());
			 
			 doc.getElementsByClass("cat_special-list").get(0);
		 } catch (IOException e) {
             e.printStackTrace();
		 }

		 System.out.println("Jsoup Can read HTML page from URL, title : " + title);
	 }
	 
	 public static void parseHTMLFile() {
		 // JSoup Example 3 - Parsing an HTML file in Java
		 //Document htmlFile = Jsoup.parse("login.html", "ISO-8859-1"); // wrong
		 Document htmlFile = null;
		 String title;
         try {
             htmlFile = Jsoup.parse(new File("login.html"), "ISO-8859-1");
         } catch (IOException e) {
             e.printStackTrace();
         }
         title = htmlFile.title();
         Element div = htmlFile.getElementById("login");
         String cssClass = div.className(); // getting class form HTML element
   
         System.out.println("Jsoup can also parse HTML file directly");
         System.out.println("title : " + title);
         System.out.println("class of div tag : " + cssClass);

	 }

}
