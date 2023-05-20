<?php 

require_once '../includs/dboperation.php';

$response = array(); 

if($_SERVER['REQUEST_METHOD']=='POST'){
	if(
		isset($_POST['name']) and 
			isset($_POST['email']) and 
				isset($_POST['password']) and
				   isset($_POST['age']))

		{
		//operate the data further 

		$db = new DbOperations(); 

		$result = $db->createUserChild( 	$_POST['name'],
									$_POST['password'],
									$_POST['email'],
									$_POST['age']
								);
		if($result == 1){ 
			echo 'تم إنشاء حساب الطفل بنجاح';
		}elseif($result == 2){
			echo 'حدث خطأ ما ، يرجى المحاولة مرة أخرى';			
		}elseif($result == 0){
			echo 'يبدو أنك مسجل بالفعل ، يرجى تسجيل الدخول';						
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