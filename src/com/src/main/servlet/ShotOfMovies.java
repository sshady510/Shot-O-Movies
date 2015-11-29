package com.src.main.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.main.extracter.ReadData;
import com.src.main.object.MovieObject;

public class ShotOfMovies extends HttpServlet {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<MovieObject> relatedMovieDetails= new ArrayList<MovieObject>();
	ArrayList<MovieObject> movieLists= new ArrayList<MovieObject>();
	  protected void doGet(HttpServletRequest request, 
	      HttpServletResponse response) throws ServletException, IOException 
	  {
		  response.setContentType("text/html");
	    // reading the user input
	    String movieName= request.getParameter("movieName");    
	    
	    searchMovie(movieName);
	    //String map = "http://maps.google.co.in/maps?q=" + relatedMovieDetails.get;
	   // System.out.println("Done!");
	    
	    if(relatedMovieDetails.isEmpty()){
	    	MovieObject dummyData = new MovieObject();
	    	dummyData.setMovieName("No Such Movie Found");
	    	dummyData.setMdo(null);
			relatedMovieDetails.add(dummyData);
	    }
	    request.setAttribute("list",relatedMovieDetails);
	    	
	    RequestDispatcher rd= request.getRequestDispatcher("/movieDetails.jsp");
	   // System.out.println("Done!");

	   // printMovie(movieName);
	    
	    rd.forward(request, response);
	    System.out.println("Done!");
	    

	  }
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  doGet(request, response);
		    
		  }
	private void searchMovie(String movieName) {
		
	    movieLists.clear();relatedMovieDetails.clear();
		ReadData data = new ReadData();
	    movieLists = data.getData();
	    
	    for(int i=0;i< movieLists.size();i++)
	    {
	    	if(movieName.equalsIgnoreCase(movieLists.get(i).getMovieName())){
	    		relatedMovieDetails.add(movieLists.get(i));
	    	}
	    }
	   // System.out.println("movielist size: " + movieLists.size());
	}
	
/*	private void printMovie(String movieName) {
		System.out.println(relatedMovieDetails.size());
	    for(int i=0;i< movieLists.size();i++)
	    {
	    	System.out.println(relatedMovieDetails.get(i).getMovieName());
	    	System.out.println(relatedMovieDetails.get(i).getMdo().getTitle());
	    	System.out.println(relatedMovieDetails.get(i).getMdo().getLocations());
	    		
	    	
	    }
	}*/
}

