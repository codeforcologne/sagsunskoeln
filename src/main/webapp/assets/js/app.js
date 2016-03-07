// datatable
$(document).ready(function() {
	$('#data').DataTable({
		"ajax" : "/sagsunskoeln/service/datatable",
		"columns" : [ {
			"data" : "id"
		}, {
			"data" : "status"
		}, {
			"data" : "serviceName"
		}, {
			"data" : "updatedDatetime"
		} ]
	});
	$('#data tbody').on('click', 'tr', function() {
		if ($(this).hasClass('selected')) {
			var data = table.row( this ).data();
			$(this).removeClass('selected');
			$("#sagsuns").empty();
			$("#links").empty();
			$("#modaltitle").empty();
		} else {
			$("#sagsuns").empty();
			$("#links").empty();
			$("#modaltitle").empty();
			table.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
			$("#aboutModal").modal("show");
			$("#modaltitle").append(table.row( this ).data().id);
			$("#sagsuns")
				.append("<h3>" + table.row( this ).data().serviceName + "</h3>")
				.append("<div>" + table.row( this ).data().description + "</div>")
				.append("<h3>Adresse</h3>")
				.append("<div>" + table.row( this ).data().address.split(',').join('</br>') + "</div>")
				.append("<h3>Datum</h3>")
				.append("<table>")
				.append("<tr><td style='font-weight: bold;'>Anfrage:&nbsp;</td><td>" + table.row( this ).data().requestedDatetime + "</td></tr>")
				.append("<tr><td style='font-weight: bold;'>Update:&nbsp;</td><td>" + table.row( this ).data().updatedDatetime + "</td></tr>")
				.append("</table>")
				;
		}
	});
});
