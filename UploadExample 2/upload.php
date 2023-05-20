<?php 
 
 //importing dbDetails file 
 require_once 'dbDetails.php';
 
 //this is our upload folder 
 $upload_path = 'uploads/';
 
 //Getting the server ip 
 $server_ip = gethostbyname(gethostname());
 
 //creating the upload url 
 $upload_url = $upload_path; 
 
 //response array 
 $response = array(); 
 
 
 if($_SERVER['REQUEST_METHOD']=='POST'){
 
 //checking the required parameters from the request 
 if(isset($_POST['name']) and isset($_FILES['image']['name']) and isset($_POST['child_id'])){
 
 //connecting to the database 
 $con = mysqli_connect(HOST,USER,PASS,DB);
 if(mysqli_connect_errno()){
    $response['error']=true;
    $response['message']='Faild to connect to MySQL';
}else{
 //getting name from the request 
 $name = $_POST['name'];
 $child_id=$_POST["child_id"];
 //getting file info from the request 
 $fileinfo = pathinfo($_FILES['image']['name']);
 
 //getting the file extension 
 $extension = $fileinfo['extension'];
 $id=getFileName();
 
 //file url to store in the database 
 $file_url = $upload_url . $id . '.' . $extension;
 
 //file path to upload in the server 
 $file_path = $upload_path . $id . '.'. $extension; 
 
 //trying to save the file in the directory 
 try{
 //saving the file 
 move_uploaded_file($_FILES['image']['tmp_name'],$file_path);
 $sql = "INSERT INTO `albums` (`ID`,`album_photo`, `album_name`,`child_id`) VALUES ($id,N'$file_url', N'$name',$child_id)";
 
 //adding the path and name to database 
 if(mysqli_query($con,$sql)){
 //filling response array with values 
 $response['error'] = false; 
 $response['album_photo'] = $file_url; 
 $response['album_name'] = $name;
 }
 //if some error occurred 
 }catch(Exception $e){
 $response['error']=true;
 $response['message']=$e->getMessage();
 } 
 //closing the connection 
 mysqli_close($con);
 }
 }else{
 $response['error']=true;
 $response['message']='Please choose a file';
 }
 //displaying the response 
 echo json_encode($response);
 }
 
 /*
 We are generating the file name 
 so this method will return a file name for the image to be upload 
 */
 function getFileName(){
 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect...');
 $sql = "SELECT max(id) as id FROM albums";
 $result = mysqli_fetch_array(mysqli_query($con,$sql));
 
 mysqli_close($con);
 if($result['id']==null)
 return 1; 
 else 
 return ++$result['id']; 
 }