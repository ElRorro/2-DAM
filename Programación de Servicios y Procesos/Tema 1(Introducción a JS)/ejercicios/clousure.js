contador = (function(){
	var contador = 0;
	return function(){
		return contador++;
	};
})();
console.log('contador: ' + contador());
console.log('contador: ' + contador());
