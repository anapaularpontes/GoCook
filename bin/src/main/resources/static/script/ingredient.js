"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let ingredient = button.data('ingredient'); // Extract info from data-* attributes
	let method = button.data('method');
	console.log('[METHOD]', method);
	let inputMethod = `<input name="_method" type="hidden" value="${method}" />`;
	$("#ingredientForm").append(inputMethod);
	let modal = $(this);
	if(ingredient!=0) {
		$.ajax({
			dataType: "json",
			url: "/ingredients/"+ingredient
		}).done(function(data) {
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtIngredient").value = data.name;
			modal.find("#modalTitle").text('Editing ingredient');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtIngredient").value = "";
		modal.find("#modalTitle").text('Adding ingredient');
	}
  })