<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pl">

<head>
<meta charset="utf-8">
<title>Samochody</title>
 
 </head>


<body>
	
	<jsp:include page="header.jsp" flush="true" />
	
	
<div id="multi-item-example" class="my-container carousel slide carousel-multi-item " data-ride="carousel">

  

  <ol class="carousel-indicators">
    <li data-target="#multi-item-example" data-slide-to="0" class="active"></li>  
  </ol>
 

  <div class="carousel-inner " role="listbox">

  
    <div class="carousel-item active ">

      <div class="col-md-12 ">
        <div class="card mb-2 bg-light ">
         <div class="row">
          <img class="card-img-top"
            src="resources/images/Ford Focus.jpg"
            alt="Ford Focus">
          <div class="card-body my-auto">
            <h4 class="card-title">Ford Focus</h4>
            <p class="card-text">Cena za jedną dobę: 250 zł</p>
          </div>
         </div>
        </div>
      </div>

      <div class="col-md-12">
        <div class="card mb-2 bg-light">
         <div class="row">
          <img class="card-img-top"
            src="resources/images/Seat Ibiza.jpg"
            alt="Card image cap">
          <div class="card-body my-auto">
            <h4 class="card-title">Seat Ibiza</h4>
            <p class="card-text">Cena za jedną dobę: 300 zł</p>
          </div>
         </div>
        </div>
      </div>
      
      
	
      <div class="col-md-12">
        <div class="card mb-2 bg-light">
         <div class="row">
          <img class="card-img-top"
            src="resources/images/Toyota Avensis.jpg"
            alt="Card image cap">
          <div class="card-body my-auto">
            <h4 class="card-title">Toyota Avensis</h4>
            <p class="card-text">Cena za jedną dobę: 350 zł</p>
          </div>
         </div>
        </div>
      </div>
  
  </div>
  </div>
</div>
		

<jsp:include page="footer.jsp" flush="true" />
<script src="resources/JS/cars.js"></script>

			
</body>


</html>
