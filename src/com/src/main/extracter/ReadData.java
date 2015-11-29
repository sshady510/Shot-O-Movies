package com.src.main.extracter;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import com.src.main.object.MovieDetailsObject;
import com.src.main.object.MovieObject;

import java.io.File;
import java.util.ArrayList;

public class ReadData {


  public ArrayList<MovieObject> getData(){//public static void main(String argv[]) {

	  ArrayList<MovieObject> movieInfo= new ArrayList<MovieObject>();
	  
    try {

	File fXmlFile = new File("/Users/shubhamsrivastava/Documents/workspace/Shots'o'movie/Data/MovieDetails.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("row");
			

	for (int temp = 0; temp < nList.getLength(); temp++) {

		MovieObject movieObj= new MovieObject();
		MovieDetailsObject mdo = new MovieDetailsObject();
		Node nNode = nList.item(temp);
				
		//System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			//System.out.println("Staff id : " + eElement.getAttribute("_id"));
			if(eElement.getElementsByTagName("title").item(0) != null)
			{
				movieObj.setMovieName(eElement.getElementsByTagName("title").item(0).getTextContent());
				//System.out.println("title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
			}
			if(eElement.getElementsByTagName("release_year").item(0) != null)
			{
				mdo.setReleaseYear(eElement.getElementsByTagName("release_year").item(0).getTextContent());
				//System.out.println("release yr : " + eElement.getElementsByTagName("release_year").item(0).getTextContent());
			}
			if(eElement.getElementsByTagName("locations").item(0) != null)
			{
				mdo.setLocations(eElement.getElementsByTagName("locations").item(0).getTextContent());
				//System.out.println("locations : " + eElement.getElementsByTagName("locations").item(0).getTextContent());
			}
			if(eElement.getElementsByTagName("production_company").item(0) != null)
			{
				mdo.setProductionCompany(eElement.getElementsByTagName("production_company").item(0).getTextContent());
				//System.out.println("production comp : " + eElement.getElementsByTagName("production_company").item(0).getTextContent());
			}
			if(eElement.getElementsByTagName("distributor").item(0) != null)
			{
				mdo.setDistributer(eElement.getElementsByTagName("distributor").item(0).getTextContent());
				//System.out.println("distrib. : " + eElement.getElementsByTagName("distributor").item(0).getTextContent());
			}
			if(eElement.getElementsByTagName("director").item(0) != null)
			{
				mdo.setDirector(eElement.getElementsByTagName("director").item(0).getTextContent());
				//System.out.println("dir : " + eElement.getElementsByTagName("director").item(0).getTextContent());
			}
			if(eElement.getElementsByTagName("writer").item(0) != null)
			{
				mdo.setWriter(eElement.getElementsByTagName("writer").item(0).getTextContent());
				//System.out.println("writer : " + eElement.getElementsByTagName("writer").item(0).getTextContent());
			}
			if(eElement.getElementsByTagName("actor_1").item(0) != null)
			{
				mdo.setActor1(eElement.getElementsByTagName("actor_1").item(0).getTextContent());
				//System.out.println("act 1 : " + eElement.getElementsByTagName("actor_1").item(0).getTextContent());
			}
			if(eElement.getElementsByTagName("actor_2").item(0) != null)
			{
				mdo.setActor2(eElement.getElementsByTagName("actor_2").item(0).getTextContent());
				//System.out.println("act 2 : " + eElement.getElementsByTagName("actor_2").item(0).getTextContent());
			}
			if(eElement.getElementsByTagName("actor_3").item(0) != null)
			{
				mdo.setActor3(eElement.getElementsByTagName("actor_3").item(0).getTextContent());
				//System.out.println("aCT 3 : " + eElement.getElementsByTagName("actor_3").item(0).getTextContent());
			}
			movieObj.setMdo(mdo);
			

			movieInfo.add(movieObj);
			
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
    return movieInfo;
  }
}

/*	<row _id="46" _uuid="0D145C84-7960-40E9-8691-D6DC569A490E" _position="46" _address="http://data.sfgov.org/resource/yitu-d5am/46">
	<title>Alcatraz</title>
	<release_year>2012</release_year>
	<locations>Broadway from Mason to Taylor</locations>
	<production_company>Bonanza Productions Inc.</production_company>
	<distributor>Warner Bros. Television</distributor>
	<director>J.J. Abrams</director>
	<writer>Steven Lilien</writer>
	<actor_1>Sarah Jones</actor_1>
	<actor_2>Elizabeth Sarnoff</actor_2>
	<actor_3>Bryan Wynbrandt</actor_3>*/