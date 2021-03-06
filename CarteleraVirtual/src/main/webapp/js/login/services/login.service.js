'use strict';
angular.module('myapp.login').factory('LoginService', function(ENV, $http, $q) {

	var config = {
		headers : {
			'Content-Type' : 'application/json;charset=utf-8;',
		}
	};

	var login = function(user, password) {
		var defer = $q.defer();
		// ENV.endpoint.url
		// http://localhost:9090/CarteleraVirtual/login
		$http.post('http://localhost:9090/CarteleraVirtual/login', {
			'usuario' : user,
			'clave' : password
		}, config).success(function(data) {
			console.log('El login responde : ');
			console.log(data);
			localStorage.setItem('tokenSeguridad', data.token);
			defer.resolve(data);
		})

		.error(defer.reject);

		return defer.promise;
	};

	var rol = function(id) {

		var defer = $q.defer();
		$http.post('http://localhost:9090/CarteleraVirtual/rol', {
			'idUsuarioApi' : id
		}, config).success(function(data) {

			console.log('El login responde : ');
			console.log(data);
			defer.resolve(data);

		}).error(defer.reject);

		return defer.promise;

	};
	
	var registrarme = function(user, password, rol){
		console.log('usuario:'+user);
		console.log('pass:'+password);
		console.log('rol:'+rol);
		var defer = $q.defer();
		$http.post('http://localhost:9090/CarteleraVirtual/registrarse', {
			'usuario' : user,
			'clave' : password,
			'rol' : rol
		}, config).success(function(data) {

			console.log('El login responde : ');
			console.log(data);
			defer.resolve(data);

		}).error(defer.reject);

		return defer.promise;
	};
	
	var registrarmeUser = function(user, password, rol, idUserApi){
		console.log('usuario:'+user);
		console.log('pass:'+password);
		console.log('rol:'+rol);
		console.log('idUserApi:'+idUserApi);
		var defer = $q.defer();
		$http.post('http://localhost:9090/CarteleraVirtual/agregarUsuario', {
			'usuario' : user,
			'clave' : password,
			'rol' : rol,
			'idUsuarioApi' : idUserApi
		}, config).success(function(data) {

			console.log('El login responde user: ');
			console.log(data);
			defer.resolve(data);

		}).error(defer.reject);

		return defer.promise;
	};

	var logout = function() {
		var defer = $q.defer();
		// invalido el token
		localStorage.removeItem('tokenSeguridad');
		defer.resolve();

		return defer.promise;
	};

	var isLoggedIn = function() {
		var isToken = angular.isDefined(getToken()) && getToken() !== null;
		return isToken;
	};

	var getToken = function() {
		return localStorage.getItem('tokenSeguridad');
	};

	return {
		login : login,
		rol: rol,
		registrarme: registrarme,
		registrarmeUser: registrarmeUser,
		logout : logout,
		getToken : getToken,
		isLoggedIn : isLoggedIn
	};
})
