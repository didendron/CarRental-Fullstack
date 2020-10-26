
$('.carousel').carousel({
	  interval: 2000
	})

	
$(function() {
	$("#dateOfReturn").datepicker({
		dateFormat : "yy-mm-dd",
		minDate : '+1d'
	});
	$("#dateOfReceipt").datepicker({
		dateFormat : "yy-mm-dd",
		minDate : 'today',
		onSelect : function(date) {

			var selectedDate = new Date(date);
			var msecsInADay = 86400000;
			var endDate = new Date(selectedDate.getTime() + ( msecsInADay));

			
			$("#dateOfReturn").datepicker("option", "minDate", endDate);

		}
	}).val();

	$("#dateOfReturn").datepicker({
		dateFormat : "yy-mm-dd"
	}).val();
});

function AvailabilityChecker() {
	var dateOfReceipt = $('#dateOfReceipt').val();
	var dateOfReturn = $('#dateOfReturn').val();
	var selectPlace = $('#selectPlace').val();

	if ((dateOfReceipt == null || dateOfReceipt == "")
			|| (dateOfReturn == null || dateOfReturn == "")
			) {

		alert("Proszę wprowadzić daty.");
		return false;
	} else {
		$.ajax({
			url : 'AvailabilityChecker',
			method : 'POST',
			data : {
				'dateOfReceipt' : dateOfReceipt,
				'dateOfReturn' : dateOfReturn,
				'selectPlace' : selectPlace
			},
			success : function(data) {
				var result = data.toString();
				if(data==''){
					alert('Nie znaleziono samochodów');
				}else{
					var html = '';
					var len = data.length;
					for (var i = 0; i < len; i++) {
						
						html += '<div class="card col-12 bg-light mx-auto my-4">';
							html+='<div class="row">';
								html+='<div class="col-4">';
									
									
									html+='<h3 class="card-title py-5">';
									html+=data[i].carName;
									html+='</h3>';
									html+='<h3 class="card-text py-2" >';
									html+='Cena za dobę:';
									html+='<span style="color:red;" >';
									html+=data[i].price;
									html+='zł';
									html+='</span>';
									html+='</h3>';
								
								html += '</div >';
								html+='<div class="col-4">';
								
									html+='<img src="resources/images/';
									html+=data[i].carName;
									html+='.jpg" class="card-img" alt="Car Image"/>';
									
								html += '</div >';
								html+='<div class="col-4 my-auto" >';
									html+='<form name="select"  action="SelectedCar" method="POST" novalidate>';
										html+='<input name="carName" type="hidden" value="';
										html+=data[i].carName;
										html+='" />';
										html+='<input name="price" type="hidden" value="';
										html+=data[i].price;
										html+='" />';
										html+='<input name="dateOfReceipt" type="hidden" value="';
										html+=dateOfReceipt;
										html+='" />';
										html+='<input name="dateOfReturn" type="hidden" value="';
										html+=dateOfReturn;
										html+='" />';
										html+='<input name="selectPlace" type="hidden" value="';
										html+=selectPlace;
										html+='" />';
										html+='<button type="submit" class="btn btn-dark btn-block mb-2">Wybieram</button>';
										html+='</form>';
								html += '</div >';
							html += '</div >';
						html += '</div >';
						
					}
				$('#resultSearch').html(html);
				}
		        
		    },
	        error: function(){      
	            alert('Błąd');
			}

		});
	}
}
