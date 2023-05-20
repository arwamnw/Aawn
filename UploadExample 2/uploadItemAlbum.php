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
 if(isset($_POST['album_id']) and isset($_POST['name']) and isset($_FILES['image']['name']) and isset($_FILES['audio']['name']) and isset($_POST['child_id'])){
 
 //connecting to the database 
 $con = mysqli_connect(HOST,USER,PASS,DB);
 if(mysqli_connect_errno()){
    $response['error']=true;
    $response['message']='Faild to connect to MySQL';
}else{
 
 //getting name from the request 
 $name = $_POST['name'];
 $album_id = $_POST['album_id'];
 $child_id = $_POST['child_id'];
 $fileinfo = pathinfo($_FILES['image']['name']);
 $fileAudioinfo = pathinfo($_FILES['audio']['name']);
 $extensionAudio = $fileAudioinfo['extension'];
 $extension = $fileinfo['extension'];
 
 //file path to upload in the server and store in database
 $id=getFileName();
 $file_path = $upload_path.'/'.$album_id.'_' . $id . '.'. $extension;
 $file_path_audio = $upload_path.'/'.$album_id.'_' . $id . '.'. $extensionAudio; 
 try{
 move_uploaded_file($_FILES['image']['tmp_name'],$file_path);
 move_uploaded_file($_FILES['audio']['tmp_name'],$file_path_audio);
 $sql = "INSERT INTO `albums_items` (`ID`,`album_id`,`item_name`,`item_photo`, `item_audio`,`child_id`) VALUES ($id,$album_id, N'$name','$file_path','$file_path_audio',$child_id);";
 
 //adding the path and name to database 
 if(mysqli_query($con,$sql)){
 
 //filling response array with values 
 $response['error'] = false; 
 $response['item_photo'] = $file_path; 
 $response['item_audio'] = $file_path_audio; 
 $response['item_name'] = $name;
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
 $sql = "SELECT max(id) as id FROM albums_items";
 $result = mysqli_fetch_array(mysqli_query($con,$sql));
 
 mysqli_close($con);
 if($result['id']==null)
 return 1; 
 else 
 return ++$result['id']; 
 }