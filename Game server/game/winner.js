'use strict'

exports.checkWinner = function(gameArray, playerNumber){
    for(var i=0; i<gameArray.length; i++){
        for(var j=0; j<gameArray[i].length; j++){
            if(checkHorizontal(gameArray, i, j, playerNumber) || checkVertical(gameArray, i, j, playerNumber) ||
              checkDiagonal1(gameArray, i, j, playerNumber) ||
              checkDiagonal2(gameArray, i, j, playerNumber)){
                console.log(playerNumber + " wins!");
                return true;
            }
        };
    };
    return false;
};

var checkHorizontal = function(gameArray, i, j, playerNumber){
    if(j >= 3){
        var cont = 0;
        for(var x = 4; x>0; x--){
            if(gameArray[i][j] == playerNumber){
                cont++;
                j--;
            }
        }
        if(cont == 4){
            return true;
        }
    }
    return false;
}

var checkVertical = function(gameArray, i, j, playerNumber){
    if(i >= 3){
        var cont = 0;
        for(var x = 4; x>0; x--){
            if(gameArray[i][j] == playerNumber){
                cont++;
                i--;
            }
        }
        if(cont == 4){
            return true;
        }
    }
    return false;
}

var checkDiagonal1 = function(gameArray, i, j, playerNumber){
    if(j >= 3 && i >= 3){
        var cont = 0;
        for(var x = 4; x>0; x--){
            if(gameArray[i][j] == playerNumber){
                cont++;
                j--;
                i--;
            }
        }
        if(cont == 4){
            return true;
        }
    }
    return false;
}

var checkDiagonal2 = function(gameArray, i, j, playerNumber){
    if(j>=0 && i >= 3){
        var cont = 0;
        for(var x = 4; x>0; x--){
            if(gameArray[i][j] == playerNumber){
                cont++;
                j++;
                i--;
            }
        }
        if(cont == 4){
            return true;
        }
    }
    return false;
}
