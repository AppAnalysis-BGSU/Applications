<?php

/*A PHP Script to upload data in the database. 
Created for the Amandroid research and testing purpose. 
For any issues, contact : Shiva Bhusal, civabhusal@gmail.com
*/   

$servername="sql9.freesqldatabase.com"; 
$username="sql9193859"; 
$password="MUEpGxKWUt"; 
$dbname="sql9193859"; 
$sms_content=$_GET["sms_content"]; // Chnage the Server, and database credentials 

$conn=new mysqli($servername,$username,$password,$dbname); 

// check connection 

if ($conn->connect_error){
	die("Connection failed: ".$conn->connect_error); 
}
else {
	echo "connected successfully"; 
	$sql="insert into SMS_TABLE(content) values ($sms_content)"; // Make sure you have a correct table 
	if ($conn->query($sql)===true){
		echo "New record inserted successfully"; 
	}
	else {
		echo "Error:".$sql."<br>".$conn->error; 
	}
}

?>
