<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Shots'O'Movie</title>
	<style>
	table, td, th {
    	border: 1px solid green;
	}

	th {
    	background-color: green;
    	color: white;
	}
</style>
</head>
<body>

   <div>
    <table style="">
    	<tr>
    			<th>MOVIE NAME</th>
            	<th>LOCATIONS</th>
            	<th>RELEASE YEAR</th>
            	<th>PRODUCTION COMPANY</th>
            	<th>DISTRIBUTER</th>
            	<th>WRITER</th>
            	<th>DIRECTOR</th>
            	<th>ACTOR 1</th>
            	<th>ACTOR 2</th>
            	<th>ACTOR 3</th>
       </tr>
        <c:forEach items="${list}" var="record">
            <tr>
            	
                <td>${record.movieName }</td>
            	<td><a href="https://www.google.co.in/maps?q= ${record.mdo.locations } +San+Francisco" >${record.mdo.locations }</a></td>
                <td>${record.mdo.releaseYear }</td>
                <td>${record.mdo.productionCompany }</td>
				<td>${record.mdo.distributer }</td>
				<td>${record.mdo.writer }</td>
				<td>${record.mdo.director }</td>
				<td>${record.mdo.actor1 }</td>
				<td>${record.mdo.actor2 }</td>
				<td>${record.mdo.actor3 }</td>
                
            </tr>
             
        </c:forEach>
    </table>
</div>
 
</body>
</html>