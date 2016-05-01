'use strict'

var utilities = require('./utilities.js');

exports.newMovement = function(gameArray){
  var columZeros = [];
  for(var i = 0; i < gameArray.length; i++){
      if(utilities.countZeros(gameArray[i]) > 0){
          columZeros.push(i);
      }
  }


  //return (columZeros[?]);
}
