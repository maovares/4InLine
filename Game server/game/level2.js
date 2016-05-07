'use strict'

var utilities = require('./utilities.js');

exports.newMovement = function(gameArray, playerNumber){
  var bestMovementsArray = countMaxAround(gameArray, playerNumber);
  var randomNumber = Math.floor(Math.random()*bestMovementsArray.length+0);
  return bestMovementsArray[randomNumber];
}
