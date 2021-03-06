angular.module('myapp.carteleraAdministrador')
.controller('CarteleraCtrlAdministrador', function($scope, $state, CarteleraService, LoginService){

	var  imagenRandom = function () {
		var height = ~~(Math.random() * 500) + 100;
		var id = ~~(Math.random() * 10000);
		return 'http://lorempixel.com/g/280/' + height + '/?' + id;
	};

	$scope.cargarCartelera = function(anio){
		CarteleraService.getCartelera(anio)
		.then(function(response){
			  $scope.anioActivo = anio;
				$scope.cartelera = response.data;
		});
	};

	$scope.logout = function() {
		LoginService.logout()
		.then(function(){
			$state.go('login');
		});
	};

	$scope.anioActivo = 'primero';
	//inicializo la cartelera con el primer año
  $scope.cargarCartelera($scope.anioActivo);

});
