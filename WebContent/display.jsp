<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title> Shots'o'movie   </title>
		  <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.js"></script>
 
 <script>
 $(document).ready(function() {
 var movies = [];
 
 $.ajax({
   type: "GET",
   url: "/Users/shubhamsrivastava/Documents/workspace/Shots'o'movie/Data/MovieDetails.xml", // change to full path of file on server
   dataType: "xml",
   success: parseXml,
   complete: setupAC,
   failure: function(data) {
     alert("XML File could not be found");
   }
 });
 
 function parseXml(xml)
 {
   //find every query value
   $(xml).find("title").each(function()
   {
     movies.push($(this).value);
   });
 }
 
 function setupAC() {
   $("input#searchBox").autocomplete({
   source: movies,
   minLength: 1,
   select: function(event, ui) {
     $("input#searchBox").val(ui.item.value);
     $("#searchForm").submit();
   }
  });
 }
});
 </script>
</head>	
	<body>		
 
  </body>
	
		<form id="searchForm" action="ShotOfMovies" style="align:middle">			
			 <h3>Please enter a Movie Name: </h3>  <br>
			<input type="text" id="searchBox" name="movieName"size="20px" align="middle">
			<input type="submit" name="searchKeyword" id="searchKeyword" value="submit" align="middle" >						
		</form>		
	</body>	
</html>