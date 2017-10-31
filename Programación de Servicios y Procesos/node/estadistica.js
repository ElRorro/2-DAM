module.exports = function estadistica (coleccion) {
//variable local que tabaja con el atributo de la funccion
  var _coleccion = coleccion;
    return {
      numeroElementos :  function () { return _coleccion.length;},
      numeroMasAlto   :  function () {
        var numeroAlto = _coleccion[0];
        if (_coleccion.length > 1) {
          for (var i = 1; i < _coleccion.length; i++){
            if (_coleccion[i] > numeroAlto) {
              numeroAlto = _coleccion[i];
            }
          }
        }
        return numeroAlto;
      },
      numeroMasBajo : function () {
        var numeroBajo = _coleccion[0];
        if (coleccion.length > 1){
          for (var i = 0; i < _coleccion.length; i++) {
            if (numeroBajo > _coleccion[i]) {
              numeroBajo = _coleccion[i];
            }
          }
        }
        return numeroBajo;
      },
      numeroRepetidoColeccion : function (argumentoNumero) {
        var _argumentoNumero = argumentoNumero;
        var _coleccion = coleccion;
        var contador = 0;
        for (var i = 0; i < _coleccion.length; i++) {
          if (_argumentoNumero === _coleccion[i])
            contador++;
        }
        return contador;
      },
      ordernarColeccion : function () {
        var _coleccion = coleccion;
        for (var i = 0; i < (_coleccion.length-1); i++) {
          for (var j = i+1; j < _coleccion.length; j++) {
            if (_coleccion[i] > _coleccion[j]) {
              var numeroAux = _coleccion[i];
              _coleccion[i] = _coleccion[j];
              _coleccion[j] = numeroAux;
            }
          }
        }
        return _coleccion;
      },
      valorPromedioColeccion : function () {
        var _coleccion = coleccion;
        var promedio = 0;
        for (var i = 0; i < _coleccion.length; i++) {
          promedio = promedio + _coleccion[i];
        }
        return promedio/this.numeroElementos();
      }
    }
}
