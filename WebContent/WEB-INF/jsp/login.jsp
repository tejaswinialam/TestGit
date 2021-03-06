<!DOCTYPE html>
<html lang="en">

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
        <script	src="/MSMTracker/resources/js/angular.min.js"></script>
        <script src="/MSMTracker/resources/js/angular.js"></script>

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

   <body >
        <!-- Login content -->
        <div class="top-content" id="log">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>MSM</strong> Login Form</h1>
                            <div class="description">
                            	<p>
	                            	Please login to fill your MSM
                            	</p>
                            </div>
                        </div>
                    </div>
                    <span> ${errorMessage}</span>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        	
                        		<div class="form-top-left">
                        			<!-- <h3>Login to our site</h3> -->
                            		<h3><i>Enter your username and password <br>to log on:</i></h3>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="Login" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="username">Username</label>
			                        	<input type="text" name="username" placeholder="Username..." autofocus="autofocus" class="form-username form-control" id="username" ng-model="myForm.username" maxlength="7" required>
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="password">Password</label>
			                        	<input type="password" name="password" placeholder="Password..." class="form-password form-control" id="password" ng-model="myForm.password" maxlength="10" required>
			                        </div>
			                        <button type="submit" class="bttn" >Sign in!</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                    <br><br>
                   <div class="row" ng-app="Select" ng-controller="ExampleController">
                    <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#ForgotPassword">Forgot Password ?</button>
                      <div class="modal fade" id="ForgotPassword" role="dialog">
    <div  class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h5 class="modal-title">Forgot password</h5>
        </div>
        <div class="modal-body" name="ForgotPassword" >
          <p>Enter your KP Email ID :</p>
          <input type="text" placeholder="xxxxxxxxxxxxx@kp.org" ng-model="ForgotPassword.email" maxlength="100"/>
          <!-- <span ng-show="ForgotPassword.email.$touched && ForgotPassword.email.$invalid">Please enter a valid email address</span> -->
          <p>Enter your NUID :</p>
          <input type="text" placeholder="Ex : S123788" ng-model="ForgotPassword.nuid" maxlength="7"/>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="validateEmail()">Send Instructions to Email</button>
          <button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
        </div>
      </div>
      
    </div>
  </div>
                    
                    </div>
            </div>
            
        </div>
        <!-- Login Content End -->


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