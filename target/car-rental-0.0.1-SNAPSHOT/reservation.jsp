<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pl">

<head>
<meta charset="utf-8">
<title>Rezerwacja</title>
 
 </head>


<body>
	
	<jsp:include page="header.jsp" flush="true" />
	
	<div class="my-container my-3">
		<div class="row  ">
			<div class="col-8  card bg-light ">
				<form name="infoForReservation" class="d-flex flex-column needs-validation"
					style="height: 100%;" action="AutoExecuter" method="POST"
					novalidate>
					<h4 class="mt-4">Rezerwacja</h4>
					<hr>
					<div class="form-row">
						<div class="form-group col-6">
							<label for="inputForName">Imię</label> <input type="text"
								class="form-control" id="inputForName" name="firstName"
								placeholder="Imię"
								required>
							<div class="valid-feedback">Ok!</div>
							<div class="invalid-feedback">Jakie jest twoje imię?</div>
						</div>
						<div class="form-group col-6">
							<label for="inputForLastName">Nazwisko</label> <input type="text"
								class="form-control" id="inputForLastName" name="lastName"
								placeholder="Nazwisko"
								required>
							<div class="valid-feedback">Ok!</div>
							<div class="invalid-feedback">Jakie jest twoje nazwisko?
							</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-6">
							<label for="inputForEmail">E-mail</label> <input type="email"
								class="form-control" id="inputForEmail" name="email"
								placeholder="Adres e-mail "
								 required>
							<div class="valid-feedback">Ok!</div>
							<div class="invalid-feedback">Podaj właściwy e-mail.
								</div>
						</div>
						<div class="form-group col-6">
							<label for="inputForPhone">Telefon</label> <input type="number"
								class="form-control" id="inputForPhone" name="phone"
								placeholder="Numer telefonu"  required>
							<div class="valid-feedback">Ok!</div>
							<div class="invalid-feedback">Podaj właściwy numer telefonu.
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="inputForAddress">Adres</label> <input type="text"
							class="form-control" id="inputForAddress" name="address"
							placeholder="Ulica Numer domu Numer lokalu" 
							required>
						<div class="valid-feedback">Ok!</div>
						<div class="invalid-feedback">Podaj właściwy adres.
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-6">
							<label for="inputForCity">Miasto</label> <input type="text"
								class="form-control" id="inputForCity" name="town"
								 placeholder="Miasto"
								required>
							<div class="valid-feedback">Ok!</div>
							<div class="invalid-feedback">Wpisz nazwę miasta.
								</div>
						</div>
						<div class="form-group col-3">
							<label for="inputForAge">Wiek</label> <input type="number"
								class="form-control" id="inputForAge" name="age"
								 placeholder="Wiek" required>
							<div class="valid-feedback">Ok!</div>
							<div class="invalid-feedback">Wpisz swój wiek.</div>
						</div>
						<div class="form-group col-3">
							<label for="inputForZip">Kod pocztowy</label> <input type="text"
								class="form-control" id="inputForZip" name="postalCode"
								placeholder="Kod pocztowy"  required>
							<div class="valid-feedback">Ok!</div>
							<div class="invalid-feedback">Wpisz kod pocztowy.</div>
						</div>
					</div>
					<input name="carName" type="hidden" value="${car.carName}"/>
					<input name="price" type="hidden" value="${car.price}"/>
					<input name="cityName" type="hidden" value="${city.cityName}"/>
					<input name="dateOfReceipt" type="hidden" value="${reservation.dateOFReceipt}"/>
					<input name="dateOfReturn" type="hidden" value="${reservation.dateOFReturn}"/>
					<div>
						<button type="submit" class="btn btn-dark btn-block mb-2">Wybieram</button>
					</div>
				</form>
			</div>
			<div class="col-4 card">
				<div class=" px-1 " style="width: 100%;">
					<img src="resources/images/${car.carName}.jpg"   class="card-img-top" alt="Samochód">
					<div class="card-body ">
						<h5 class="card-title">${car.carName}</h5>		
					</div>
		
					<ul class="list-inline ">
						<li class="list-inline-item"><strong>Cena za dobę:</strong></li>
						<li class="list-inline-item float-right pr-4">${car.price} zł</li>
					</ul>
					
					<ul class="list-inline ">
						<li class="list-inline-item"><strong>Miejsce rezerwacji:</strong></li>
						<li class="list-inline-item float-right pr-4">${city.cityName}</li>
					</ul>
					<ul class="list-inline ">
						<li class="list-inline-item"><strong>Od:</strong></li>
						<li class="list-inline-item float-right pr-4">${reservation.dateOFReceipt}</li>
					</ul>
					<ul class="list-inline ">
						<li class="list-inline-item"><strong>Do:</strong></li>
						<li class="list-inline-item float-right pr-4">${reservation.dateOFReturn}</li>
					</ul>
					
				</div>
			</div>
		</div>
	</div>

		

<jsp:include page="footer.jsp" flush="true" />
<script src="resources/JS/reservation.js"></script>

			
</body>


</html>
