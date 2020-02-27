"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let quantity = button.data('quantity'); // Extract info from data-* attributes
	let method = button.data('method');
	console.log('[METHOD]', method);
	let inputMethod = `<input name="_method" type="hidden" value="${method}" />`;
	$("#quantityForm").append(inputMethod);
	let modal = $(this);
	if(quantity!=0) {
		$.ajax({
			dataType: "json",
			url: "/quantities/"+quantity
		}).done(function(data) {
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtQuantity").value = data.quantity;
			modal.find("#modalTitle").text('Editing quantity');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtQuantity").value = "";
		modal.find("#modalTitle").text('Adding quantity');
	}
  })