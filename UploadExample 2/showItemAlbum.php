<?php
require_once 'dbDetails.php';
$con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect...');
if(mysqli_connect_errno()){
    $response['error']=true;
    $response['message']='Faild to connect to MySQL';
}else{
    $ID=$_GET["id"];
    $child_id=$_GET["child_id"];
    $sql ="SELECT * FROM `albums_items` where album_id=$ID and child_id=$child_id";
    $res=mysqli_query($con,$sql);
    if(mysqli_num_rows($res)){
        $response['error']=false;
        $response["message"] = $res->fetch_all(MYSQLI_ASSOC);
    }else{
        $response['error']=true;
        $response['message']='Not Found Data';
    }
}
mysqli_close($con);
echo json_encode($response);
?>