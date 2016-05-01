'use strict'

var countMax = require('./countMaxAround.js');

exports.newMovement = function(gameArray, playerNumber){
  var bestMovementsArray = countMax.countMaxAround(gameArray, playerNumber);
  var randomNumber = Math.floor(Math.random()*bestMovementsArray.length+0);
  return bestMovementsArray[randomNumber];
}
