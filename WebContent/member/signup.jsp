<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
   <form method="post" action="/mem/signup" enctype="multipart/form-data">
      <table border="1">
         <tr>
            <th colspan="2">====회원가입====</th>
         </tr>
         <tr>
            <th>Name</th>
            <td><input type="text" name="miName" id="miName"></td>
         </tr>
         <tr>
            <th>ID</th>
            <td><input type="text" name="miId" id="miId"></td>
         </tr>
         <tr>
            <th>PWD</th>
            <td><input type="password" name="miPwd" id="miPwd"></td>
         </tr>
         <tr>
            <th>Email</th>
            <td><input type="text" name="miEmail" id="miEmail"></td>
         </tr>
         <tr>
            <th>Trans</th>
            <td><input type="radio" name="miTrans" value="1">남자
            <input type="radio" name="miTrans" value="2">여자</td>
         </tr>
         <tr>
            <th>Birth</th>
            <td><input type="date" name="miBirth" id="miBirth"></td>
         </tr>
         <tr>
            <th>ZipCode</th>
            <td><input type="text" name="miZipcode" id="miZipcode"></td>
         </tr>
         <tr>
            <th>Addr1</th>
            <td><input type="text" name="miAddr1" id="miAddr1"></td>
         </tr>
         <tr>
            <th>Addr2</th>
            <td><input type="text" name="miAddr2" id="miAddr2"></td>
         </tr>
         <tr>
            <th>MainImg</th>
            <td><input type="file" name="miMainImg" id="miMainImg"></td>
         </tr>
         <tr>
            <th>NickName</th>
            <td><input type="text" name="miNick" id="miNick"></td>
         </tr>
         <tr>
            <th>ETC</th>
            <td><input type="text" name="miEtc" id="miEtc"></td>
         </tr>
         <tr>
         <td colspan="2"><button>회원가입</button>
         </td>
         </tr>
      </table>      
   </form>
</body>
</html>