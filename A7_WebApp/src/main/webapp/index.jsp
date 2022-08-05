<html>
<body>
<h2>Employee Database Application</h2>
<body>
<form action="Create" method="post">  
ID:<input type="number" step="1" name="aid"><br>  
Name:<input type="text" name="aname"><br>  
Age: <input type = "number" step="1" name="aage">
<input type="submit" value="create">  
</form> 

<form action="Update" method="post">
ID:<input type="number" name="uid"><br>  
Name:<input type="text" name="uname"><br>  
Age: <input type = "number" name="uage">
<input type="submit" value="update">

</form>

<form action="Delete" method="post">
ID:<input type="number" name="did"><br>  
<input type="submit" value="delete">

</form>
</body>
</html>
