<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pl">

<head>
<meta charset="utf-8">
<title>Potwierdzenie</title>
 
 </head>


<body>
	
	<jsp:include page="header.jsp" flush="true" />
	
	<div class="my-container  d-flex flex-column" style="height:400px;">
	  <div class="my-auto mx-auto text-center">
		<h2  class="text-success  py-2" >Wiadomość wysłana! </h2>
		<h3 class=" py-2 ">Nadawca:${contactName}</h3>
		<p class=" py-2 "><a href="home.jsp">Przejdź do strony głównej</a></p>
	  </div>
	</div>

		

<jsp:include page="footer.jsp" flush="true" />


			
</body>


</html>
