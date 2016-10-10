var app = angular.module('Select', []);
app.controller('ExampleController', function($scope, $http,$window,$location) {
	$scope.getDataFromServer = function() {
		$http({
			method : 'GET',
			url : 'AngServlet'
		}).success(function(data, status, headers, config) {
			$scope.bean = data;
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	};
	$scope.load = function() {
		
		var selectedNameValue = null, selectedCategoryValue = null;
		selectedNameValue = $scope.selectedName;
		//selectedCategoryValue = $scope.selectedCategory;
		selectedCategoryValue = $scope.category.def;
		
		alert("SelectedNameValue : "+selectedNameValue);
		alert(" selectedCategoryValue : "+selectedCategoryValue);
		
		var dataObj = {
				name : selectedNameValue,
				category : selectedCategoryValue
				
		};	
		
		var res = $http.post('/MSMPI/LoadServlet', JSON.stringify(dataObj));
		res.success(function(data, status, headers, config) {
			console.info('hi');
			$("#search2").show();
			$scope.category=data;
			 $scope.teja = selectedNameValue;
			 $scope.teja2= selectedCategoryValue;
			 $scope.category.def=selectedCategoryValue;
			 $scope.selectedName = selectedNameValue;
			 alert("selected Name :" +$scope.selectedName);
		});
		

	
	};
	
	$scope.storeSelectedName = function(selectName) {
		console.info('selected name : ' +selectName);
		$scope.selectedName = selectName;
	};
	
	$scope.storeSelectedCategory = function(selectCategory) {
		console.info('selected category:'+selectCategory);
		$scope.selectedCategory = selectCategory;
	};


	$scope.cat=["Work Order","Task","Incident","Change Request"];
	
	$scope.send = function(email,nuid){
		
		var email = $scope.ForgotPassword.email;
		var nuid = $scope.ForgotPassword.nuid;
		//alert("Email : "+email);
		//alert("nuid : "+nuid);
		var dataObj = {
				email : email,
				nuid : nuid
				
		};	
		
		var res = $http.post('/MSMPI/sendMailServlet', JSON.stringify(dataObj));
		alert("Reset instructions sent successfully to "+email);
		$scope.ForgotPassword.email=null;
		$scope.ForgotPassword.nuid=null;
	};
	
	$scope.validateEmail = function ()
	{
		var email = $scope.ForgotPassword.email;;
		//alert("Inside this");
		var emailReg =/^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var returnValue =emailReg.test(email);
		if(returnValue)
			{
			$scope.send();
			}
		else
			{
			alert("Please enter a valid email address");
			}
	};
	
	$scope.login = function(){
		
		var uname = $scope.myForm.username;
		var pwd = $scope.myForm.password;
		var url = $location.absUrl();
		alert("url : "+url);
		var dataObj = {
				uname : uname,
				pwd : pwd
				
		};	
		
		var res = $http
		({
			method : 'POST',
			url : 'Login',
				data :{
					username : $scope.myForm.username,
					password : $scope.myForm.password	
			}
		});
		alert("here");
		res.success(function(data, status, headers, config) {
			$scope.logon=data;
			var suc = $scope.logon.auth;
			alert("suvcc : "+suc);
				//alert("Invalid Username/Password. Please try again later");
		});
	};
	
	///GetCategoryList based on Application and Category
	
$scope.getCategoryListFromWS = function(){
		
		var applicationName = $scope.category.app;
		var categoryType = $scope.teja2;
		var url = $location.absUrl();
		var dataObj = {
				applicationName : applicationName,
				categoryType : categoryType
				
		};	
		
		var res = $http.post('/MSMPI/GetCategoryListServlet', JSON.stringify(dataObj));
		alert("here");
		res.success(function(data, status, headers, config) {
			$scope.catData=data;
			
			 //alert("selected Name :" +suc);
		});
	};

$scope.getUserDetails = function(){
		
		var uname = $scope.myForm.username;
		var pwd = $scope.myForm.password;
		var url = $location.absUrl();
		var dataObj = {
				uname : uname,
				pwd : pwd
				
		};	
		
		var res = $http.post('/MSMPI/LoginServlet', JSON.stringify(dataObj));
		alert("here");
		res.success(function(data, status, headers, config) {
			alert("In success Method");
			$scope.logon=data;
			var suc = $scope.logon.success;
			alert("suvcc : "+suc);
			if(suc)
				{
				$window.location.href = url+'msmfill.jsp?admin=true';
				}
			else
				{
				alert("Invalid Username/Password. Please try again later");
				}
			 //alert("selected Name :" +suc);
		});
	};

});
