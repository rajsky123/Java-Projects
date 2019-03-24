<html>
<link href="bootstrap.min.css" rel="stylesheet">
<link href="dataTables.bootstrap.css" rel="stylesheet">
<body>
<h2>Hello World!</h2>
<div class="col-xs-8">
 <table id="mytable" width='80%' class="table table-striped table-bordered">
      <thead>
       <tr>
          <th>ID</th>
          <th>Name</th>
      </tr>
      </thead>
    </table>
    </div>
</body>

<script src="jquery.js"></script>
<script src="bootstrap.min.js"></script>
<script src="jquery.dataTables.js"></script>
<script src="dataTables.bootstrap.js"></script>
<script>

var pr=[

    ['1',"ABC"],
    ['2','XYZ'],
    ['3',"ABS"],
    ['4',"ADC"],
    ['5',"KBC"],
    ['6',"ZBC"]
];

var $table = $('#mytable');
if($table.length){

	$table.DataTable({
		lengthMenu : [ [ 3, 5, 10, -1 ],
				[ '3 Records', '5 Records', '10 Records', 'All' ] ],
		pageLength : 5,
		data:pr,
		"ordering": false
		
});  
}

</script>
</html>
