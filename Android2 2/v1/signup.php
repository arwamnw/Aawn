<?php 

require_once '../includs/dboperation.php';

$response = array(); 

if($_SERVER['REQUEST_METHOD']=='POST'){
	if(
		isset($_POST['name']) and 
			isset($_POST['email']) and 
				isset($_POST['password']))
		{
		//operate the data further 

		$db = new DbOperations(); 

		$result = $db->createUserCaregiver( 	$_POST['name'],
									$_POST['password'],
									$_POST['email']
								);
		if($result == 1){
			$response['error'] = false; 
			$response['message'] = "تم تسجيل مقدم الرعاية بنجاح";
		}elseif($result == 2){
			$response['error'] = true; 
			$response['message'] = "حدث خطأ ما ، يرجى المحاولة مرة أخرى";			
		}elseif($result == 0){
			$response['error'] = true; 
			$response['message'] = "يبدو أنك مسجل بالفعل ، يرجى تسجيل الدخول";						
		}

	}else{
		$response['error'] = true; 
		$response['message'] = "الحقول المطلوبة مفقودة";
	}
}else{
	$response['error'] = true; 
	$response['message'] = "طلب غير صالح";
}

echo json_encode($response);