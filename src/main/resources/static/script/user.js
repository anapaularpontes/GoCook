"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let users = button.data('users'); // Extract info from data-* attributes
	let method = button.data('method');
	console.log('[METHOD]', method);
	let inputMethod = `<input name="_method" type="hidden" value="${method}" />`;
	$("#usersForm").append(inputMethod);
	let modal = $(this);
	if(users!=0) {
		$.ajax({
			dataType: "json",
			url: "/users/"+users
		}).done(function(data) {
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtUser").value = data.name;
			modal.find("#modalTitle").text('Editing users');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtUser").value = "";
		modal.find("#modalTitle").text('Adding user');
	}
  })