<head>
	<meta charset="utf-8" />
	<title>EasyGOband Recruitment test</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
	<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<!-- 	<script src="./resources/javascript/datatable.js"></script> -->
</head>

<body>
	<h1>Providers List</h1>
	<table id="providersTable" class="display">
      
       <!-- Header Table -->
       <thead>
            <tr>
                <th>Id</th>
				<th>Name</th>
                <th>Access Group Name</th>
                <th>Access Group ID</th>
                <th>Total Uses</th>
                <th>Sessions</th>
                <th>Event ID</th>
                <th>Estructure Decode</th>
                <th>Date Modificied</th>
                <th>Basic Product ID</th>
            </tr>
        </thead>
        <!-- Footer Table -->
        <tfoot>
            <tr>
                <th>Id</th>
				<th>Name</th>
                <th>Access Group Name</th>
                <th>Access Group ID</th>
                <th>Total Uses</th>
                <th id="searchSession">Sessions</th>
                <th>Event ID</th>
                <th>Estructure Decode</th>
                <th>Date Modificied</th>
                <th>Basic Product ID</th>
            </tr>
        </tfoot>
    </table>
    
</body>
<script type="text/javascript">
<!--

//-->
$(document).ready( function () {
	var table = $('#providersTable').DataTable({
		"sAjaxSource": "./providersList/1",
		"sAjaxDataProp": "",
		"order": [[ 0, "desc" ]],
		"aoColumns": [
			{ "mData": "id"},
			{ "mData": "name" },
			{ "mData": "access_group_name" },
			{ "mData": "access_group_id" },
			{ "mData": "total_uses" },
			{ "mData": "sessions",
				"mRender" : function (data, type, full){
					var sess = '';
					data.forEach(function(session){
						sess+= session.name + ' - ' + session.id + '<br>';
					});
					return sess;
				}},
			{ "mData": "event_id" },
			{ "mData": "structure_decode" },
			{ "mData": "modified" },
			{ "mData": "basic_product_id" }
			]
	});
	
	$('#searchSession').each( function () {
        var title = $(this).text();
        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
    } );
	
	// Apply the search
    table.columns().every( function () {
        var that = this;
 
        $( 'input', this.footer() ).on( 'keyup change', function () {
            if ( that.search() !== this.value ) {
                that
                    .search( this.value )
                    .draw();
            }
        } );
    } );
	
});
</script>
</html>