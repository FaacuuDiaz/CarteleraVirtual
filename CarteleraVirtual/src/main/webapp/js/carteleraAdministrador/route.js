angular.module('myapp.carteleraAdministrador')
.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
	$stateProvider
	.state('carteleraAdministrador', {
		url:'/carteleraAdministrador',
		views:{
			'main':{
				templateUrl: 'js/carteleraAdministrador/views/home.html',
				controller: 'CarteleraCtrlAdministrador'
			}
		}
	})
;

	//$urlRouterProvider.otherwise('/cartelera');
}]);
