<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page isELIgnored="false" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
    <script> var re=JSON.parse('${re}');

    var i;
    var brr=[]
    for(i=0;i<re.data.length;i++){
    	 var arr=[];
         arr.push(re.data[i].id);
         arr.push(re.data[i].first_name);
         arr.push(re.data[i].last_name);
         brr.push(arr);
        }
    console.log(brr);
    </script>
<link href="bootstrap.min.css" rel="stylesheet">
<link href="dataTables.bootstrap.css" rel="stylesheet">
<body>
<h2>Hello World!</h2>
<div class="col-xs-8">
 <table id="mytable" width='80%' class="table table-striped table-bordered">
      <thead>
       <tr>
          <th>ID</th>
          <th>First Name</th>
          <th>Last Name</th>
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



var $table = $('#mytable');
if($table.length){

	$table.DataTable({
		lengthMenu : [ [ 2, 5, 10, -1 ],
				[ '2 Records', '5 Records', '10 Records', 'All' ] ],
		pageLength : 2,
		data:brr,
		"ordering": false
		
});  
}

</script>
</html>
