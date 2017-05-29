angular.module('myapp.login')
.controller('LoginCtrl', function($scope, $state, LoginService){

  $scope.loginErrorMessage = '';
  $scope.login = function(){
    console.log('Usuario: ' + $scope.username);
    console.log('Password: ' + $scope.password);

    LoginService.login($scope.username, $scope.password)
    .then(function(response){
      $scope.loginErrorMessage = ''; //reset error message
      $scope.rol=response.idUsuarioApi;
      console.log($scope.rol);
      console.log("primer paso");
      LoginService.rol($scope.rol).then(function(response){
    	  console.log(response);
    	  if (response.rol == 'Alumno'){
    		  console.log("entro en el if");
    		  $state.go('cartelera');
    	  }
    	  else{
    		  if(response.rol == 'Profesor'){
    			  $state.go('carteleraProfesor');
    		  }
    		  else{
    			  $state.go('carteleraAdministrador');
    		  }
    	  }
      })
      
    })
    .catch(function(){
      $scope.loginErrorMessage = 'Usuario o Contraseña invalido. Por favor, vuelva a intentarlo';
    });
  }
});
