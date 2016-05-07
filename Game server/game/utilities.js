'use strict'

exports.countMaxAround = function(gameArray, playerNumber){
  //console.log(gameArray);
  var colums = [];
  var row = -1;
  var max = -1;
    for(var i=0; i<gameArray.length; i++){
        for(var j=0; j<gameArray[i].length; j++){
          if(gameArray[i][j] == 0){
            var cont = checkLeft(gameArray,i,j, playerNumber) +
            checkDown(gameArray,i,j, playerNumber) +
            checkRight(gameArray,i,j, playerNumber) +
            checkLeftDown(gameArray,i,j, playerNumber) +
            checkRightDown(gameArray,i,j, playerNumber) +
            checkUp(gameArray,i,j, playerNumber) +
            checkLeftUp(gameArray,i,j, playerNumber) +
            checkRightUp(gameArray,i,j, playerNumber);
            if(max == -1){
              row = j;
              colums.push(i);
              max = cont;
            }else if (cont == max) {
              row = j;
              colums.push(i);
              max = cont;
            }else if(cont > max){
              colums = [];
              row = j;
              colums.push(i);
              max = cont;
            }

          }
    };
  }
    return colums;
};


exports.countZeros = function(text){
    var cont = 0;
    for(var j = 0; j < text.length; j++){
        if(text[j] == 0){
            cont++;
        }
    }
    return cont;
}

//i j--

var checkDown = function(gameArray, i, j, playerNumber){
      var cont = 0;
        for(var x = j-1; gameArray[i][x]!=undefined && gameArray[i][x] == playerNumber; x--){
          cont++;
        }
    return cont;
};

//i j--
var checkUp = function(gameArray, i, j, playerNumber){
      var cont = 0;
        for(var x = j+1; gameArray[i][x]!=undefined && gameArray[i][x] == playerNumber; x++){
          cont++;
        }
    return cont;
};

//i++ j
var checkRight = function(gameArray, i, j, playerNumber){
      var cont = 0;
      i = i+1;
        for(; gameArray[i]!=undefined && gameArray[i][j] == playerNumber; i++){
          cont++;
        }
    return cont;
};

//i-- j
var checkLeft = function(gameArray, i, j, playerNumber){
  var cont = 0;
      i = i-1;
        for(; gameArray[i]!=undefined && gameArray[i][j] == playerNumber; i--){
          cont++;
        }
    return cont;
};

//i-- j++
var checkLeftDown = function(gameArray, i, j, playerNumber){
  var cont = 0;
      i = i-1;
      j = j+1
        for(; gameArray[i]!=undefined &&  gameArray[i+1][j]!=undefined && gameArray[i][j] == playerNumber; i--,j++){
          cont++;
        }
    return cont;
};

//i++ j++
var checkRightDown = function(gameArray, i, j, playerNumber){
      var cont = 0;
      i = i+1;
      j = j+1
        for(; gameArray[i]!=undefined &&  gameArray[i-1][j]!=undefined && gameArray[i][j] == playerNumber; i++,j++){
          cont++;
        }
    return cont;
};

//i++ j--
var checkRightUp = function(gameArray, i, j, playerNumber){
  var cont = 0;
      i = i+1;
      j = j-1
        for(; gameArray[i]!=undefined &&  gameArray[i-1][j]!=undefined && gameArray[i][j] == playerNumber; i++,j--){
          cont++;
        }
    return cont;
};

//i-- j--
var checkLeftUp = function(gameArray, i, j, playerNumber){
      var cont = 0;
      i = i-1;
      j = j-1
        for(; gameArray[i]!=undefined &&  gameArray[i][j-1]!=undefined && gameArray[i][j] == playerNumber; i--,j--){
          cont++;
        }
    return cont;
};

exports.changePlayer = function(player){
  if(player == "1"){
    player = "2";
  }else {
    player = "1";
  }
  return player;
}
