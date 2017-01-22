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
		//alert("$scope.adding.effort :"+$scope.adding.effort);
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
			//alert("this.history.taskId : "+this.history.taskId);
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
	

	$scope.findUser = function(){
		//alert("userId :"+$scope.username);
		var userId = $scope.username;
		if($scope.username == undefined ){
			alert("Please enter a user id");
			return;
		}
		var res = $http
		({
			method : 'GET',
			url : 'findUser'+'/'+userId+'/',
		});
		res.success(function(data, status, headers, config) {
			$scope.editUser=data;
			//alert("editUser :"+$scope.editUser);
			if($scope.editUser == undefined || $scope.editUser == "" )
				{
				alert("No User found with this Id");
				}
			else
				{
				$scope.showUser="Show";
				}
		});
	};
	
	$scope.getTotal = function(){
	    var total = 0;
	    for(var i = 0; i < $scope.category.historyBeanList.length; i++){
	        var product = $scope.category.historyBeanList[i];
	        total += parseInt(product.effort);
	    }
	    return total;
	};
	$scope.addUser = function(){
		//alert("$scope.username : "+$scope.addUser.username);
		//alert("$scope.password : "+$scope.addUser.password);
		//alert("$scope.email :"+$scope.addUser.email);
		//alert("$scope.firstName :"+$scope.addUser.firstName);
		//alert("$scope.lastName :"+$scope.addUser.lastName);
		//alert("$scope.isAdmin :"+$scope.addUser.isAdmin);
		if($scope.addUser.username == undefined ){
			alert("Please enter user id");
			return;
		}
		if($scope.addUser.password == undefined ){
			alert("Please enter password");
			return;
		}
		if($scope.addUser.email == undefined ){
			alert("Please enter email");
			return;
		}
		if($scope.addUser.firstName == undefined ){
			alert("Please enter a first name");
			return;
		}
	var res = $http
	({
		method:'POST',
		url:'adduser',
		data : {
			username : $scope.addUser.username,
			password : $scope.addUser.password,
			email : $scope.addUser.email,
			firstName : $scope.addUser.firstName,
			lastName : $scope.addUser.lastName,
			isAdmin : $scope.addUser.isAdmin
		}
	});
	res.success(function(data,status,headers,config){
		$scope.sucs=data;
		if($scope.sucs)
		{
			alert("Efforts are successfully updated");
		}
		else
			{
			alert("Unable to update");
			}
		$scope.addUser = null;
	});
};

	$scope.saveUser = function(){
			//alert("$scope.username : "+$scope.username);
			//alert("$scope.password : "+$scope.editUser.password);
			//alert("$scope.email :"+$scope.editUser.email);
			//alert("$scope.firstName :"+$scope.editUser.firstName);
			//alert("$scope.lastName :"+$scope.editUser.lastName);
			//alert("$scope.isAdmin :"+$scope.editUser.isAdmin);
		if($scope.username == undefined ){
			alert("Please enter userId");
			return;
		}
		if($scope.editUser.password == undefined ){
			alert("Please enter password");
			return;
		}
		if($scope.editUser.email == undefined ){
			alert("Please enter email");
			return;
		}
		if($scope.editUser.firstName == undefined ){
			alert("Please enter a first name");
			return;
		}
		var res = $http
		({
			method:'POST',
			url:'saveuser',
			data : {
				username : $scope.username,
				password : $scope.editUser.password,
				email : $scope.editUser.email,
				firstName : $scope.editUser.firstName,
				lastName : $scope.editUser.lastName,
				isAdmin : $scope.editUser.isAdmin
			}
		});
		res.success(function(data,status,headers,config){
			$scope.sucs=data;
			if($scope.sucs)
			{
				alert("Efforts are successfully updated");
			}
			else
				{
				alert("Unable to update");
				}
			$scope.username = null;
			$scope.editUser = null;
			$scope.showUser = null;
		});
	};

	$scope.deleteUser = function(){
		var userId = $scope.username;
		if($scope.username == undefined ){
			alert("Please enter a user id");
			return;
		}
	if ($window.confirm("Please confirm?")) {
	var res = $http
	({
		method:'GET',
		url:'deleteUser'+'/'+userId+'/'
	});
	res.success(function(data,status,headers,config){
		$scope.sucs=data;
		if($scope.sucs)
		{
			alert("User is successfully deleted");
		}
		else
			{
			alert("Unable to delete");
			}
		$scope.username=null;
	});
	}
	};

	$scope.findEffortsUser = function(){
		//alert("userId :"+$scope.username);
		var userId = $scope.oneUser;
		if($scope.oneUser == undefined ){
			alert("Please enter a user id");
			return;
		}
		var res = $http
		({
			method : 'GET',
			url : 'getEffortUser'+'/'+userId+'/'
		});
		res.success(function(data, status, headers, config) {
			$scope.effortforUser=data;
			//alert("editUser :"+$scope.effortforUser);
			if($scope.effortforUser == undefined || $scope.effortforUser == "" )
				{
				alert("No User found with this Id");
				}
			else
				{
				$scope.showEffortsUser="Show";
				}
		});
	};
	
	$scope.clearthis = function(){
		$scope.effortforUser=null;
		$scope.showEffortsUser = null;
	};
	
	$scope.getTotalforUser = function(){
	    var total = 0;
	    for(var i = 0; i < $scope.effortforUser.length; i++){
	        var product = $scope.effortforUser[i];
	        total += parseInt(product.effort);
	    }
	    return total;
	};
	$scope.findEffortsTask = function(){
		//alert("userId :"+$scope.username);
		var taskId = $scope.oneTask;
		if($scope.oneTask == undefined ){
			alert("Please enter a number");
			return;
		}
		var res = $http
		({
			method : 'GET',
			url : 'getEffortTask'+'/'+taskId+'/'
		});
		res.success(function(data, status, headers, config) {
			$scope.effortforTask=data;
			//alert("editUser :"+$scope.effortforTask);
			if($scope.effortforTask == undefined || $scope.effortforTask == "" )
				{
				alert("No Efforts found for this task");
				}
			else
				{
				$scope.showEffortsTask="Show";
				}
		});
	};
	
	$scope.cleartask = function(){
		$scope.effortforTask=null;
		$scope.showEffortsTask = null;
	};
	
	$scope.getTotalforTask = function(){
	    var total = 0;
	    for(var i = 0; i < $scope.effortforTask.length; i++){
	        var product = $scope.effortforTask[i];
	        total += parseInt(product.effort);
	    }
	    return total;
	};
	
	$scope.getTeamEfforts = function(){
		//alert("Here");
		//alert("userId :"+$scope.username);
		var res = $http
		({
			method : 'GET',
			url : 'getTeamEffort'
		});
		res.success(function(data, status, headers, config) {
			$scope.effortforTeam=data;
			//alert("Task  :"+$scope.effortforTeam);
			if($scope.effortforTeam == undefined || $scope.effortforTeam == "" )
				{
				alert("No Efforts found your Team");
				}
		});
	};
	
	
	$scope.getTotalforTeam = function(){
	    var total = 0;
	    for(var i = 0; i < $scope.effortforTeam.length; i++){
	        var product = $scope.effortforTeam[i];
	        total += parseInt(product.effort);
	    }
	    return total;
	};
	
	$scope.getTeamDetails = function(){
		//alert("Here");
		$scope.teamDet = "show";
		//alert("userId :"+$scope.username);
		var res = $http
		({
			method : 'GET',
			url : 'getTeamDetails'
		});
		res.success(function(data, status, headers, config) {
			$scope.teamDetails=data;
			//alert("Task  :"+$scope.teamDetails);
			if($scope.teamDetails == undefined || $scope.teamDetails == "" )
				{
				$scope.teamDet = null;
				}
		});
	};
	
	$scope.deleteTeamMember = function()
	{
		if ($window.confirm("Please confirm?")) {
			//alert("this.history.taskId : "+this.history.taskId);
			var id = this.member.id;
		var res = $http
		({
			method:'GET',
			url:'deleteMember'+'/'+id
		});
		res.success(function(data,status,headers,config){
			$scope.sucs=data;
			if($scope.sucs)
			{
				alert("Member is successfully deleted");
			}
			else
				{
				alert("Unable to delete");
				}
			$scope.getTeamDetails();
		});
		}
	}; 

	
	$scope.addTeamMember = function()
	{
		//alert("addNewMember :"+$scope.addNewMember);
		if($scope.addNewMember == undefined ){
			alert("Please enter userId");
			return;
		}
			var res = $http
			({
				method:'GET',
				url:'addMember'+'/'+$scope.addNewMember
			});
		res.success(function(data,status,headers,config){
			$scope.sucs=data;
			if($scope.sucs)
			{
				alert("Member is successfully added");
			}
			else
				{
				alert("Unable to add, User is not present");
				}
			$scope.getTeamDetails();
		});
		}; 
});

