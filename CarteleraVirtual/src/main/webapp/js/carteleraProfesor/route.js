angular.module('myapp.carteleraProfesor')
.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
	$stateProvider
	.state('carteleraProfesor', {
		url:'/carteleraProfesor',
		views:{
			'main':{
				templateUrl: 'js/carteleraProfesor/views/home.html',
				controller: 'CarteleraCtrlProfesor'
			}
		}
	})
	
	;

	//$urlRouterProvider.otherwise('/cartelera');
}]);
