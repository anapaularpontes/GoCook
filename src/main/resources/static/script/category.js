"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let category = button.data('category'); // Extract info from data-* attributes
	let method = button.data('method');
	console.log('[METHOD]', method);
	let inputMethod = `<input name="_method" type="hidden" value="${method}" />`;
	$("#categoryForm").append(inputMethod);
	let modal = $(this);
	if(category!=0) {
		$.ajax({
			dataType: "json",
			url: "/categories/"+category
		}).done(function(data) {
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtCategory").value = data.name;
			modal.find("#modalTitle").text('Editing category');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtCategory").value = "";
		modal.find("#modalTitle").text('Adding category');
	}
  })