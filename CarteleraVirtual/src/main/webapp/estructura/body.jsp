<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<body>
<div ui-view="main"></div>

	<!--  Librerias core de angular -->
  <!-- <script src="shared/libs/angular/angular.js"></script> -->

	<!-- Dependencias necesarias para que funcione masonry -->

	<script src="shared/libs/jquery/dist/jquery.js"></script>
  <script src="shared/libs/jquery-bridget/jquery-bridget.js"></script>
  <script src="shared/libs/ev-emitter/ev-emitter.js"></script>
  <script src="shared/libs/desandro-matches-selector/matches-selector.js"></script>
  <script src="shared/libs/fizzy-ui-utils/utils.js"></script>
  <script src="shared/libs/get-size/get-size.js"></script>
  <script src="shared/libs/outlayer/item.js"></script>
  <script src="shared/libs/outlayer/outlayer.js"></script>
  <script src="shared/libs/masonry/masonry.js"></script>
  <script src="shared/libs/imagesloaded/imagesloaded.js"></script>

	<!--  Lib core de angular -->
  <script src="/CarteleraVirtual/shared/libs/angular/angular.js"></script>

  <script src="/CarteleraVirtual/shared/libs/angular-masonry/angular-masonry.js"></script>

<!-- manejar el routeo -->
	<script type="text/javascript" src="/CarteleraVirtual/shared/libs/angular-ui-router/release/angular-ui-router.js"></script>

<!-- trabajar con el localStorage del nagegador desde angular -->
	<script type="text/javascript" src="/CarteleraVirtual/shared/libs/angular-local-storage.js"></script>


<!-- ************************************************************************************************************* -->
<!-- Dependencies de nuestra aplicacion -->
<!-- Aca declaramos todos nuestros modulos, controllers, servicios, filtros, etc -->
	<script type="text/javascript" src="js/app.modules.js"></script>
	<script type="text/javascript" src="js/app/environment.js"></script>
	<script type="text/javascript" src="js/cartelera/route.js"></script>
	<script type="text/javascript" src="js/cartelera/controllers/cartelera.ctrl.js"></script>
	<script type="text/javascript" src="js/cartelera/controllers/detail.ctrl.js"></script>
	<script type="text/javascript" src="js/cartelera/services/cartelera.service.js"></script>
	<script type="text/javascript" src="js/login/controllers/login.ctrl.js"></script>
	<script type="text/javascript" src="js/login/services/login.service.js"></script>
	<script type="text/javascript" src="js/login/route.js"></script>
	<script type="text/javascript" src="js/app/route.js"></script>
	<script type="text/javascript" src="js/app/http.token.interceptor.js"></script>
	<script type="text/javascript" src="js/app/run.js"></script>

	<!--  directiva que submitea un textarea al hacer click -->
	<script type="text/javascript" src="js/app/enter.directive.js"></script>

</body>

