<%@ page import="org.kp.msm.bean.LoginBean" %>
<!DOCTYPE html>
<html>
 <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>MSM Login Form</title>

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
        <script	src="/MSMTracker/resources/js/angular.min.js"></script>
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
              boolean isAdmin = loginbean.getIsAdmin();
              if(isAdmin)
              { %>
              <div align=right><br/>
              <a style="font-size:20px;color:white;" href="admin"><i><span class="glyphicon glyphicon-hand-right"></span> Admin Page </i></a>
              </div>
              <%} %>
                   </div>
            <div class="upper-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>Please</strong> fill your MSM</h1>
                        </div>
                    </div>
                    </div>
                   </div>
                   <form name="myForm" class ="form-group" ng-init="getDataFromServer()">
		<table style="width:650px;" align="center">
		<tr class="up-table">
		<td>
			<label for="repeatSelect"> <b>Select an application :</b> </label>
			</td>
			<td style="width:400px;">
		 <select class="form-control " name="repeatSelect" ng-model="catname" ng-change="load()">
				 <option default value="">--Select an application--</option>
				<option ng-repeat="p in bean" value="{{p.appName}}">{{p.appName}}</option> 
			</select>
			</td>
			</tr>
			<!-- <tr><td colspan="2"><tt>repeatSelect = {{a.repeatSelect}}</tt></td></tr> -->
		<tr class="up-table"><td> <label for="def"> <b>Select a category : </b></label></td>
		<td style="width:400px;">
		 <select class="form-control" name="def" ng-model="catdef" ng-change="load()" > 
		 	<option default value="">--Select a category --</option>
			<option ng-repeat="c in cat" value="{{c}}">{{c}}</option>
		</select> 
		</td>
		</tr> 	
		<!--  <tr> <td colspan="2" align="right"><button class="btn btn-link active" ng-click="load()" text-align="center" id="button">Search</button></td></tr>
		-->
		</table >
		</form>
		<div  class="form-group" id="search2" style="display:none;">
		
		<table style="width:650px;" align="center">
		<tr>
		<td>
		<label for="CategorySelect"> <b>Select a {{selectedCategoryValue}} :</b></label>
		</td>
		<td style="width:400px;">
		<select class="form-control" name="CategorySelect" 
		ng-options="cat.catNumber for cat in category.beanList track by cat.catNumber"
		ng-model="CategorySelect" >
		</select> 
		</td></tr>
		<tr><td ></td><td>
		<div class="row">
		<button class="btn btn-link" ng-click="add()" text-align="center" id="button" data-toggle="modal" data-target="#addNew" >Add new {{selectedCategoryValue}}</button></div></td></tr>
		<tr><td>
		<label for="categoryDesc"> <b> Description :</b></label></td><td align="left" style="width:320px;color:white;"> {{CategorySelect.description}}</td></tr>
		<tr><td><label for="effort"><b> Effort to be added :</b></label></td>
		<td align="left" ><input class="form-control" type="number" min="0" max="100" style="width:100px;height:40px;" required ng-model="adding.effort"/></td></tr>
		<tr><td><label for="comments"><b>Comments for Adhoc and monitoring :</b></label></td>
		<td><textarea class="form-control" rows="3" maxlength ="50" id="comment" ng-model="adding.adhocComments"></textarea></td></tr>
		<tr><td colspan="2" align="right"><button class="btn btn-primary" ng-click="addefforts()" text-align="center" id="button">Add my efforts</button></td></tr></table>
		
		<br>
		
		<table class="table table-striped table-hover active" style="width:90%;" align="center">
		<thead><tr>
		<td>
		S.No
		</td>
		<td>
		Category
		</td>
		<td>
		# Number
		</td>
		<td> Description </td>
		<td> Effort</td>
		<td> Action </td>
		</tr>
		<thead>
		<tbody>
		<tr class="active" ng-repeat="history in category.historyBeanList"> <td> {{ $index + 1}}  </td><td>{{ history.category}}</td>
		<td>{{history.catNumber}} <input type="hidden" value="{{history.taskId}}"/></td><td>{{history.decription}}</td><td>{{history.effort}}</td><td><button 
		class="btn btn-primary btn-sm" ng-click="editefforts()" text-align="center" id="button1" data-toggle="modal" data-target="#edit" >Edit</button>
		<button class="btn btn-primary btn-sm"  ng-really-message="Are you sure to Delete it ?" ng-click="deleteEffort()" text-align="center" id="button">Delete</button></td></tr>
		<tr><td colspan="5" align="right"><b>Total: {{ getTotal() }}</b></td>
		<td></td></tr> 
		</tbody>
		</table>
		
		</div>

	
	<!-- Modal for Add New -->
	                  <div class="modal fade" id="addNew" role="dialog">
	                  <form name="myForm" class ="form-group" ng-init="getDataFromServer()">
    <div  class="modal-dialog">
    
      <!-- Modal content-->
      <div style="width:600px;" align="center"  class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add a new {{selectedCategoryValue}}</h4>
        </div>
        <div class="modal-body" name="AddNew" style="width:400px;" >
         <select class="form-control" name="repeatSelect" ng-model="add.appName" ng-change="getCategoryListFromWS()" required>
				<option default value="">Select an application</option>
				<option ng-repeat="p in bean" value="{{p.appName}}">{{p.appName}}</option>
			</select>
			<br>
          <select class="form-control" name="CategorySelect" ng-model="addNew" 
	 ng-options="cat.catNumber for cat in catData track by cat.catNumber" >
		</select>
		<span>{{ addNew.description }}</span>
		
		<br>
        <label><b> Effort to be added :&nbsp;&nbsp;</b></label><input type="number" placeholder="Efforts" ng-model="addNew.effort" maxlength="3" style="width:100px;height:40px;" required/> 
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="addNewEffort()">Add</button>
          <button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
        </div>
      </div>
      
    </div>
    </form>
  </div>
  
  <!-- End Modal for Add New -->
  
  <!-- Modal content for edit-->
	<div class="modal fade" id="edit" role="dialog">
	                  <form name="myForm" class ="form-group" >
    <div  class="modal-dialog">
    
      <div style="width:600px;" align="center"  class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit</h4>
        </div>
        <div class="modal-body" name="Edit" style="width:400px;" >
        <label><b> Effort to be edited :&nbsp;&nbsp;</b></label><input type="number" placeholder="Efforts" autofocus="autofocus" ng-model="editeffort" maxlength="3" min="0" max="100" style="width:100px;height:40px;" required/> 
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="saveEffort()">Save</button>
          <button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
        </div>
      </div>
      
    </div>
    </form>
  </div>
  
  <!-- End Modal for edit New -->
  
  
  
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
</html>