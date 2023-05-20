<?php 

$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "myDB";


$response = array(); 

if($_SERVER['REQUEST_METHOD']=='POST'){
	if(
		isset($_POST['email_CG']) and 
			isset($_POST['email_CH']))
				{

$sql = "INSERT INTO child_caregiver (childEmail, caregiverEmail) VALUES ( email_CH, email_CG)";

}

else{
		$response['error'] = true; 
		$response['message'] = "الحقول المطلوبة مفقودة";
	}
}else{
	$response['error'] = true; 
	$response['message'] = "طلب غير صالح";
}

$conn->close();
		//operate the data further 

		

echo json_encode($response);