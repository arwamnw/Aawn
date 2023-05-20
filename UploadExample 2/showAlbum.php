<?php
require_once 'dbDetails.php';
$con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect...');
if(!isset($_GET["child_id"])){
    $response['error']=true;
    $response['message']='Error';
}else{
$child_id=$_GET["child_id"];
if(mysqli_connect_errno()){
    $response['error']=true;
    $response['message']='Faild to connect to MySQL';
}else{
    $sql ="SELECT * FROM `albums` where child_id=$child_id";
    $res=mysqli_query($con,$sql);
    if(mysqli_num_rows($res)>0){
        $response['error']=false;
        $response["message"] = $res->fetch_all(MYSQLI_ASSOC);
    }else{
        $response['error']=true;
        // $response['message']='Not Found Data';
    }
}}
mysqli_close($con);
echo json_encode($response);
?>