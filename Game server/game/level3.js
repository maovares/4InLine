'use strict'

var utilities = require('./utilities.js');

exports.newMovement = function(gameArray, playerNumber){
  playerNumber = utilities.changePlayer(playerNumber);
  var bestMovementsArray = utilities.countMaxAround(gameArray, playerNumber);
  var randomNumber = Math.floor(Math.random()*bestMovementsArray.length+0);
  return bestMovementsArray[randomNumber];
};
