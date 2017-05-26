angular.module('myapp.login')
.controller('LoginCtrl', function($scope, $state, LoginService){

  $scope.loginErrorMessage = '';
  $scope.login = function(){
    console.log('Usuario: ' + $scope.username);
    console.log('Password: ' + $scope.password);
    console.log('estoy en el login.ctrl.js va a hacer la funcion loginservices.js');

    LoginService.login($scope.username, $scope.password)
    .then(function(){
      $scope.loginErrorMessage = ''; //reset error message
      $state.go('cartelera');
    })
    .catch(function(){
      $scope.loginErrorMessage = 'Usuario o Contraseña invalido. Por favor, vuelva a intentarlo';
    });
  }
});
