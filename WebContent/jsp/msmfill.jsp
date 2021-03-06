
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
              <i>Welcome {logon.firstName} {logon.lastName} <img src="Sample.jpg" style="height:50px;width:50px;"></i>
              <button type="button" class="btn btn-default active" data-toggle="popover"
              title="Logout" data-content="Default popover"><span class="glyphicon glyphicon-log-out"></span>Logout</button>
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
		<table style="width:550px;" align="center">
		<tr class="up-table">
		<td>
			<label for="repeatSelect"> <b>Select an application :</b> </label>
			</td>
			<td style="width:320px;">
		 <select class="form-control " name="repeatSelect" ng-model="category.name" ng-change="storeSelectedName(category.name)">
				<option default value="">--Select an application--</option>
				<option ng-repeat="p in bean" value="{{p.appName}}">{{p.appName}}</option>
			</select>
			</td>
			</tr>
			<!-- <tr><td colspan="2"><tt>repeatSelect = {{a.repeatSelect}}</tt></td></tr> -->
		<tr class="up-table"><td> <label for="def"> <b>Select a category : </b></label></td>
		<td style="width:320px;">
		 <select class="form-control" name="def" ng-model="category.def" ng-change="load()" > 
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
		
		<table style="width:550px;" align="center">
		<tr>
		<td>
		<label for="CategorySelect"> <b>Select a {{teja2}} :</b></label>
		</td>
		<td style="width:320px;">
		<select class="form-control" name="CategorySelect" 
		ng-options="cat.catNumber for cat in category.beanList track by cat.catNumber"
		ng-model="CategorySelect" >
		</select> 
		</td></tr>
		<tr><td ></td><td>
		<div class="row">
		<button class="bttn btn-link btn-sm active" ng-click="add()" text-align="center" id="button" data-toggle="modal" data-target="#addNew" >Add new {{teja2}}</button></div></td></tr>
		<tr><td>
		<label for="categoryDesc"> <b> Description :</b></label></td><td align="left" style="width:320px;color:white;"> {{CategorySelect.description}}</td></tr>
		<tr><td><label for="effort"><b> Effort to be added :</b></label></td>
		<td align="left" ><input class="form-control" type="text" maxlength="3" style="width:100px;height:40px;"/></td></tr>
		<tr><td><label for="comments"><b>Comments for Adhoc and monitoring :</b></label></td>
		<td><textarea class="form-control" rows="3" maxlength ="50" id="comment"></textarea></td></tr>
		<tr><td colspan="2" align="right"><button class="btn btn-primary" ng-click="addefforts()" text-align="center" id="button">Add my efforts</button></td></tr></table>
		
		<br>
		
		<table class="table table-striped table-hover active" style="width:90%;" align="center">
		<thead><tr>
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
		<tr class="active" ng-repeat="history in category.historyBeanList"> <td>{{ history.category}}</td>
		<td>{{history.categoryNumber}}</td><td>{{history.categoryDescription}}</td><td>{{history.effort}}</td><td><button 
		class="btn btn-primary btn-sm" ng-click="addefforts()" text-align="center" id="button">Edit</button>
		<button class="btn btn-primary btn-sm" ng-click="addefforts()" text-align="center" id="button">Delete</button></td></tr> 
		</tbody>
		</table>
		
		</div>

	
	<!-- Modal for Add New workorder -->
	                  <div class="modal fade" id="addNew" role="dialog">
	                  <form name="myForm" class ="form-group" ng-init="getDataFromServer()">
    <div  class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h5 class="modal-title">Add a new {{teja2}}</h5>
        </div>
        <div class="modal-body" name="ForgotPassword" >
         <select class="form-control " name="repeatSelect" ng-model="category.app" ng-change="getCategoryListFromWS(category.app)">
				<option default value="">--Select an application--</option>
				<option ng-repeat="p in bean" value="{{p.appName}}">{{p.appName}}</option>
			</select>
			<br>
          <select class="form-control" name="CategorySelect" 
		ng-options="cat.catNumber for cat in catData.catList track by cat.catNumber"
		ng-model="ListCategory" ></select>
		<span>{{ListCategory.description}}</span>
          <input type="text" placeholder="Ex : S123788" ng-model="ForgotPassword.nuid" maxlength="7"/>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="validateEmail()">Send Instructions to Email</button>
          <button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
        </div>
      </div>
      
    </div>
    </form>
  </div>
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