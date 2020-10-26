<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pl">

<head>
<meta charset="utf-8">
<title>Kontakt</title>
 
 </head>


<body>
	
	<jsp:include page="header.jsp" flush="true" />
	

<section class="section my-container">

  
  <h2 class="section-heading h1 pt-4 mb-5">Kontakt</h2>

  <div class="card">

    <div class="card-body">

      
      <div id="map-container-google" class="z-depth-1-half  pb-5" style="height: 500px">
        <iframe src="https://maps.google.com/maps?q=Warsaw&t=&z=13&ie=UTF8&iwloc=&output=embed" 
         width="100%" height="100%" style="border:0" allowfullscreen></iframe>
      </div>
	  <form name="contactForm" class="needs-validation" action="SendMessage" method="POST"
					novalidate>
      <div class="row">

        
        <div class="col-md-6 mb-4">
          

            <div class="md-form">
              <input type="text" id="contact-name" class="form-control" name="contactName" required>
              <label for="contact-name" class="">Imię</label>
              <div class="valid-feedback">Ok!</div>
			  <div class="invalid-feedback">Wpisz swoje imię.</div>			
            </div>

            <div class="md-form">
              <input type="text" id="contact-email" class="form-control" name="contactEmail" required>
              <label for="contact-email" class="">Twój e-mail</label>
              <div class="valid-feedback">Ok!</div>
			  <div class="invalid-feedback">Wpisz swój adres e-mail.</div>	
            </div>

            <div class="md-form">
              <input type="text" id="contact-Subject" class="form-control" name="contactSubject" required>
              <label for="contact-Subject" class="">Temat</label>
              <div class="valid-feedback">Ok!</div>
			  <div class="invalid-feedback">Wpisz temat wiadomości.</div>	
            </div>

          
        </div>
        
        <div class="col-md-6 mb-4">
          <div class="md-form primary-textarea">
            <textarea id="contact-message" class="md-textarea form-control mb-0" rows="5" style="padding-bottom: 1.2rem;" name="contactMessage" required></textarea>
            <label for="contact-message">Your message</label>
            <div class="valid-feedback">Ok!</div>
			<div class="invalid-feedback">Wpisz wiadomość.</div>
          </div>
        </div>
        
        <div class="col-md-12">
          <div class="text-center">
            <button type="submit" class="btn btn-primary btn-block" >Wyślij zapytanie</button>
          </div>
        </div>
        

      </div>
	</form>
    </div>

  </div>

</section>

	

		

<jsp:include page="footer.jsp" flush="true" />
<script src="resources/JS/contact.js"></script>

			
</body>


</html>