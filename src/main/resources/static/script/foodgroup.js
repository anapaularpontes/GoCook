"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let foodgroup = button.data('foodgroup'); // Extract info from data-* attributes
	let method = button.data('method');
	console.log('[METHOD]', method);
	let inputMethod = `<input name="_method" type="hidden" value="${method}" />`;
	$("#foodGroupForm").append(inputMethod);
	let modal = $(this);
	if(foodgroup!=0) {
		$.ajax({
			dataType: "json",
			url: "/foodgroup/"+foodgroup
		}).done(function(data) {
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtFoodGroup").value = data.name;
			modal.find("#modalTitle").text('Editing foodgroup');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtFoodGroup").value = "";
		modal.find("#modalTitle").text('Adding foodgroup');
	}
  })