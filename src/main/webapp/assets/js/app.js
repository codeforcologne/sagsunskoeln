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
			"data" : "requestedDatetime"
		} ]
	});
});
