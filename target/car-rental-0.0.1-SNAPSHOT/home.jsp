<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pl">

<head>
<meta charset="utf-8">
<title>Wypożyczalnia samochodów</title>
 
 </head>


<body>
	<div class=beforeHeader>
		<h2>Wypożyczalnia samochodów</h2>
	</div>
	<jsp:include page="header.jsp" flush="true" />
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
 
  		<ol class="carousel-indicators">
   			 <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    		<li data-target="#myCarousel" data-slide-to="1"></li>
    		<li data-target="#myCarousel" data-slide-to="2"></li>
 		 </ol>

 
 	 <div class="carousel-inner">
    	<div class="carousel-item active">
     		 <img src="resources/images/Ford Focus.jpg" class="d-block w-45 mx-auto " alt="Ford Focus">
     	 <div class="carousel-caption ">
       		 <h3>Ford Focus</h3>
        	<p></p>
        	
      	</div>
    	</div>

   		 <div class="carousel-item">
     		 <img src="resources/images/Seat Ibiza.jpg" class="d-block w-45 mx-auto " alt="Seat Ibiza">
      	<div class="carousel-caption ">
        <h3>Seat Ibiza</h3>
        <p></p>
     	 </div>
   		 </div>

    	<div class="carousel-item">
     		 <img src="resources/images/Toyota Avensis.jpg" class="d-block w-45 mx-auto " alt="Toyota Avensis">
     	 <div class="carousel-caption ">
        	<h3>Toyota Avensis</h3>
      		<p></p>
      	</div>
    	</div>
 	 </div>

  
  	<a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Poprzedni</span>
  </a>
  <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Następny</span>
  </a>
</div>



<div class="bg-white">
	<div class=my-container>
		<form name="searchAuto" method="post">
				<div class="d-flex flex-column ">
					<div class="mx-auto py-3">
						<h4>Wyszukiwanie pojazdu</h4>
					</div>
					<div class="col-4 mx-auto py-3">
						<label for="dateOfReceipt">Data odbioru</label>
						<input type="text" id="dateOfReceipt" class="form-control " readonly>
					</div>
					<div class=" col-4 mx-auto py-3">
						<label for="dateOfReturn">Data zwrotu</label>
						<input type="text" id="dateOfReturn" class="form-control" readonly>
					</div>
					<div class="col-4 mx-auto py-3">
						<label for="selectPlace">Miejsce odbioru</label>
						<select class="form-control" id="selectPlace">
      						<option>Bydgoszcz</option>
      						<option>Gdańsk</option>
      						<option>Gorzów</option>
      						<option>Katowice</option>
      						<option>Kielce</option>
      						<option>Kraków</option>
      						<option>Lublin</option>
      						<option>Rzeszów</option>
      						<option>Warszawa</option>
      						<option>Wrocław</option>
      						<option>Zielona Góra</option>
    					</select>
					</div>
					<div class="col-4 mx-auto py-3 ">
						<button type="button"
							class="btn btn-outline-warning mr-0  btn-block"
							onclick="AvailabilityChecker()">Szukaj</button>
					</div>
				</div>
			</form>
	</div>
</div>

<div id="resultSearch" class="my-container my-3">
	<div class="d-flex flex-column ">
	</div>
</div>	

<jsp:include page="footer.jsp" flush="true" />
<script src="resources/JS/home.js"></script>
			
</body>


</html>
