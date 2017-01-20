<%@ page import="org.kp.msm.bean.LoginBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Admin Page</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="/MSMTracker/resources/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/MSMTracker/resources/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="/MSMTracker/resources/assets/css/form-elements.css">
        <link rel="stylesheet" href="/MSMTracker/resources/assets/css/style.css">
        <style>
        thead{
        align:center;
        background-color:#85adad;
        color:white;
        height:60px;
        }
        </style>
        <script src="/MSMTracker/resources/js/angular.min.js"></script>
        <script src="/MSMTracker/resources/js/angular.js"></script>
        <script type="text/javascript">
        $(document).ready(function(){
        $('[data-toggle="popover"]').popover({
        placement:'top',
        trigger:'hover'
        });
        });</script>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
              <link rel="shortcut icon" href="/MSMTracker/resources/assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/MSMTracker/resources/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/MSMTracker/resources/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/MSMTracker/resources/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="/MSMTracker/resources/assets/ico/apple-touch-icon-57-precomposed.png">

</head>
<body ng-app="Select">

<div class="top-content" ng-controller="ExampleController">
 <div class="welcome" align=right style="padding: 20px 50px 0px 25px;font-size:20px;" ng-init="getUserDetails()">
              
              <form action="logout" method="post" >
              <i>Welcome ${loginbean.name} 
              <!-- &nbsp;&nbsp;<img src="/MSMTracker/resources/assets/img/sample.jpg" style="height:50px;width:50px;"> -->
              </i>
              &nbsp;&nbsp;&nbsp;
              
              <button type="submit" class="btn btn-default" data-toggle="popover"
              title="Logout" data-content="Default popover"><span class="glyphicon glyphicon-log-out"></span>&nbsp;&nbsp;Logout</button>
              </form>
              <% LoginBean loginbean = (LoginBean)session.getAttribute("user");
              String isAdmin = loginbean.getIsAdmin();
              if(isAdmin.equals("Y"))
              { %>
              <div align=left><br/>
              <a style="font-size:20px;color:white;" href="msmfill"><i><span class="glyphicon glyphicon-hand-left"></span> MSM Fill Page </i></a>
              </div>
              <%} %>
                   </div>
                   
                   <table align ="center" style="width:450px;">
                   <th ></th><td style="padding: 20px 50px;font-size:25px;"><i>User related</i></td><td></td>
                   <tr>
                   <td><button class="btn btn-info" text-align="center" id="buttonAddUser" data-toggle="modal" data-target="#addUser"><i>Add user</i></button></td>
                   <td><button class="btn btn-info" text-align="center" id="buttonEditUser" data-toggle="modal" data-target="#editUser"><i>Edit user</i></button></td>
                   <td><button class="btn btn-info" text-align="center" id="buttonDeleteUser" data-toggle="modal" data-target="#deleteUser"><i>Delete user</i></button></td>
                   <tr>
                   </table>
                   <br/><br/>
                   
                    <table align ="center" style="width:550px;">
                   <th ></th><td style="padding: 20px 50px;font-size:25px;"><i>Check efforts</i></td><td></td>
                   <tr>
                   <td><button class="btn btn-info" text-align="center" id="buttonSingleUser" data-toggle="modal" data-target="#singleUser"><i>For a single user</i></button></td>
                   <td><button class="btn btn-info" text-align="center" id="buttonSingleTask" data-toggle="modal" data-target="#singleTask"><i>For a particular task</i></button></td>
                   <td><button class="btn btn-info" text-align="center" id="buttonUsers" data-toggle="modal" data-target="#users"><i>Group of users</i></button></td>
                   <tr>
                   </table>
                    <br/><br/><br/>
                   <hr style="color:grey;"/>
                   
    <!-- Modal for Add New User -->
	<div class="modal fade" id="addUser" role="dialog">
	<form name="myForm" class ="form-group" >
    <div  class="modal-dialog">
      <div style="width:600px;" align="center"  class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add new user</h4>
        </div>
        <div class="modal-body" name="AddNew" style="width:400px;" >
        <table align="center" style="width:550px;">
        <tr><td><label><b> UserId:&nbsp;&nbsp;</b></label></td><td><input type="text" placeholder="UserId" ng-model="addUser.username" maxlength="7" required/></td></tr> 
		<tr><td><label><b> Password:&nbsp;&nbsp;</b></label></td><td><input type="password" placeholder="Password" ng-model="addUser.password" maxlength="8"  required/></td></tr>
		<tr><td><label><b> Email:&nbsp;&nbsp;</b></label></td><td><input type="text" placeholder="Email" ng-model="addUser.email" maxlength=40"  required/></td></tr>
		<tr><td><label><b> First name:&nbsp;&nbsp;</b></label></td><td><input type="text" placeholder="First name" ng-model="addUser.firstName" maxlength="20" required/></td></tr>
		<tr><td><label><b> Last name:&nbsp;&nbsp;</b></label></td><td><input type="text" placeholder="Last name" ng-model="addUser.lastName" maxlength="20" required/></td></tr>
		<tr><td><label><b> Is Admin:&nbsp;&nbsp;</b></label></td><td><input type="checkbox" ng-model="addUser.isAdmin"/>
		</table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="addNewUser()">Add</button>
          <button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
        </div>
      </div>   
    </div>
    </form>
  </div>
  
  <!-- End Modal for Add New User -->
  
  <!-- Modal for Edit User -->
	<div class="modal fade" id="editUser" role="dialog">
	<form name="myForm" class ="form-group" >
    <div  class="modal-dialog">
      <div style="width:600px;" align="center"  class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit user</h4>
        </div>
        <div class="modal-body" name="EditUser" style="width:400px;" >
        
        <form name="innerForm" class="form-group">
        <label><b> UserId:&nbsp;&nbsp;</b></label><input type="text" placeholder="UserId" ng-model="username" maxlength="7" required/>
			<br/><br/>
			 <button type="button" align="center" class="btn btn-default" ng-click="findUser()">Find</button>
        </form>
        <br/><br/>
        <table ng-show="showUser" align="center" style="width:550px;"> 
		<tr><td><label><b> Password:&nbsp;&nbsp;</b></label></td><td><input type="password" placeholder="Password" ng-model="editUser.password" maxlength="8"  required disabled/></td></tr>
		<tr><td><label><b> Email:&nbsp;&nbsp;</b></label></td><td><input type="text" placeholder="Email" ng-model="editUser.email" maxlength=40"  required/></td></tr>
		<tr><td><label><b> First name:&nbsp;&nbsp;</b></label></td><td><input type="text" placeholder="First name" ng-model="editUser.firstName" maxlength="20" required/></td></tr>
		<tr><td><label><b> Last name:&nbsp;&nbsp;</b></label></td><td><input type="text" placeholder="Last name" ng-model="editUser.lastName" maxlength="20" required/></td></tr>
		<tr><td><label><b> Is Admin:&nbsp;&nbsp;</b></label></td><td><input type="checkbox" ng-model="editUser.isAdmin"/>
		</table>
        </div>
        <div ng-show="showUser" class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="saveUser()">Save</button>
          <button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
        </div>
      </div>   
    </div>
    </form>
  </div>
  
  <!-- End Modal for Add New User -->

</div>
<!-- Javascript -->
        <script src="/MSMTracker/resources/assets/js/jquery-1.11.1.min.js"></script>
        <script src="/MSMTracker/resources/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="/MSMTracker/resources/assets/js/jquery.backstretch.min.js"></script>
        <script src="/MSMTracker/resources/assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

<footer>Developed by CAL Java</footer>

</body>
</html>​