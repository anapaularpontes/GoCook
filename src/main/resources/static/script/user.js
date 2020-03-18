"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let users = button.data('user'); // Extract info from data-* attributes
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
			document.getElementById("txtfirstname").value = data.firstName;
			document.getElementById("txtlastname").value = data.lastName;
			document.getElementById("txtEmailAddress").value = data.emailAddress;
			document.getElementById("txtrole").value = data.role;
			modal.find("#modalTitle").text('Editing user');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtfirstname").value = "";
		document.getElementById("txtlastname").value = "";
		document.getElementById("txtEmailAddress").value = "";
		document.getElementById("txtrole").value = "";
		modal.find("#modalTitle").text('Adding user');
	}
  })