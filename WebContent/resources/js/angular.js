var app = angular.module('Select', []);
app.controller('ExampleController', function($scope, $http,$window,$location) {
	$scope.getDataFromServer = function() {
		$http({
			method : 'GET',
			url : 'getAppsList'
		}).success(function(data, status, headers, config) {
			$scope.bean = data;
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	};
	$scope.load = function() {
		//alert("In load");
		//alert("$scope.selectedName : "+$scope.catname);
		//alert("$scope.catdef : "+$scope.catdef);
		if(typeof $scope.catname === 'undefined')
		{
		return;
		}
		if(typeof $scope.catdef === 'undefined')
			{
			return;
			}
		var selectedNameValue = $scope.catname;
		var selectedCategoryValue = $scope.catdef;
		var url = 'load/'+selectedNameValue+'/'+selectedCategoryValue+'/';
		var res = $http
		({
			method : 'GET',
			url : url,
		});
		res.success(function(data, status, headers, config) {
			console.info('hi');
			$("#search2").show();
			$scope.category=data;
			 $scope.selectedNameValue = selectedNameValue;
			 $scope.selectedCategoryValue= selectedCategoryValue;
		});
		
		//alert("$scope.selectedName : "+$scope.catname);
	
	};
	
	/*$scope.storeSelectedName = function(selectName) {
		console.info('selected name : ' +selectName);
		$scope.selectedName = selectName;
	};
	
	$scope.storeSelectedCategory = function(selectCategory) {
		console.info('selected category:'+selectCategory);
		$scope.selectedCategory = selectCategory;
	};*/


	$scope.cat=["Work Order","Task","Incident","Change Request"];
	
	$scope.send = function(email,nuid){
		
		var email = $scope.ForgotPassword.email;
		var nuid = $scope.ForgotPassword.nuid;
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
		//	alert("suvcc : "+suc);
			if(suc)
				{
				alert("Authentication successfull");
				$("#log").hide();
				}
			else
				{
				alert("Authentication Unsuccessfull");
				alert("Invalid Username/Password. Please try again later");
				}
			//$window.location.href=url+"msmfill";
				//alert("Invalid Username/Password. Please try again later");
		});
	};
	
	///GetCategoryList based on Application and Category
	
$scope.getCategoryListFromWS = function(){
		
		var applicationName = $scope.add.appName;
		var categoryType = $scope.selectedCategoryValue;	
		var res = $http
		({
			method : 'GET',
			url : 'getCatfromWS/'+applicationName+'/'+categoryType+'/',
		});
		//alert("here");
		res.success(function(data, status, headers, config) {
			$scope.catData=data;
		});
	};
	
	$scope.addNewEffort = function(){
		
		var eff = $scope.addNew.effort;
		alert("eff : "+eff);
		if($scope.addNew.effort == undefined)
		{
		alert("Please enter efforts between 1 to 160");
		return;
		}
		var res = $http
		({
			method : 'POST',
			url : 'addEfforts',
				data :{
					catNumber : $scope.addNew.catNumber,
					effort : $scope.addNew.effort,
					category : $scope.selectedCategoryValue,
					updateFlag : 'N'
			}
		});
		res.success(function(data, status, headers, config) {
			$scope.sucs=data;
			if($scope.sucs)
				{
				alert("Efforts are successfully added");
				}
			else
				{
				alert("Unable to add efforts");
				}
			//$scope.catData = null;
			$scope.addNew = null;
			$scope.add.appName = null;
			$scope.load();
		});
		
	};
	
	$scope.addefforts = function(){
	if($scope.CategorySelect == undefined)
	{
	alert("Please select the "+$scope.selectedCategoryValue);
	return;
	}
	var eff = $scope.adding.effort;
	if($scope.adding.effort == undefined)
	{ 
		alert("$scope.adding.effort :"+$scope.adding.effort);
	alert("Please enter efforts between 1 to 160");
	return;
	}
		var res = $http
		({
			method : 'POST',
			url : 'addEfforts',
				data :{
					catNumber : $scope.CategorySelect.catNumber,
					effort : $scope.adding.effort,
					category : $scope.selectedCategoryValue,
					adhocComments : $scope.adding.adhocComments,
					updateFlag : 'A'
			}
		});
		res.success(function(data, status, headers, config) {
			$scope.sucs=data;
			if($scope.sucs)
				{
				alert("Efforts are successfully added");
				}
			else
				{
				alert("Unable to add efforts");
				}
			$scope.category=null;
			$scope.CategorySelect=null;
			$scope.adding=null;
			$scope.load();
		});
		
	};

	$scope.editefforts = function(){
		$scope.editcatNumber = this.history.catNumber;
		$scope.editTaskId = this.history.taskId;
		
	};
	
	$scope.saveEffort = function(){

		if($scope.editeffort == undefined ){
			alert("Please enter efforts between 1 to 160");
			return;
		}
		var res = $http
		({
			method : 'POST',
			url : 'addEfforts',
				data :{
					catNumber : $scope.editcatNumber,
					effort : $scope.editeffort,
					taskId : $scope.editTaskId,
					updateFlag : 'E'
			}
		});
		res.success(function(data, status, headers, config) {
			$scope.sucs=data;
			if($scope.sucs)
				{
				alert("Efforts are successfully saved");
				}
			else
				{
				alert("Unable to edit efforts");
				}
			$scope.category=null;
			$scope.CategorySelect=null;
			$scope.adding=null;
			$scope.editeffort=null;
			$scope.load();
		});
	};
	$scope.deleteEffort = function(){
		if ($window.confirm("Please confirm?")) {
			alert("this.history.taskId : "+this.history.taskId);
		var res = $http
		({
			method:'POST',
			url:'addEfforts',
			data : {
				catNumber : this.history.catNumber,
				taskId : this.history.taskId,
				updateFlag : 'D'
			}
		});
		res.success(function(data,status,headers,config){
			$scope.sucs=data;
			if($scope.sucs)
			{
				alert("Efforts are successfully deleted");
			}
			else
				{
				alert("Unable to delete");
				}
			$scope.category=null;
			$scope.CategorySelect=null;
			$scope.adding=null;
			$scope.load();
		});
		}
	};
});

