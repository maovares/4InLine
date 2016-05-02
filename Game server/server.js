'use strict'

var gameLogic = require('./js/winner.js');
var level1 = require('./js/level1.js');
var level2 = require('./js/level2.js');
var level3 = require('./js/level3.js');

var express = require('express');
var app = express();
var mongojs= require('mongojs');
var db = mongojs('localhost:27017/db4',['gamesData','gamesCounter']);
var bodyParser = require('body-parser');
var port = 3000;

app.use(express.static(__dirname+'/public'));
app.use(bodyParser.json());


app.get('/newGame/:email',function(req, res){
  console.log("NEW");
  var email = req.params.email;
  var newGameID = "";
  db.gamesCounter.findOne(function(err,docs) {
    var counter = docs.counter;
    var lastCounter = docs.counter;
    var id = docs._id;
    counter = counter+1;
    newGameID = '4line-' + counter;
    db.gamesData.insert({'gameID':newGameID,
                        'user1':email,
                        'user2':'',
                        'turn':1,
                        'data':['000000','000000','000000','000000','000000','000000','000000']
                      },
          function(err,docs){
            db.gamesCounter.findAndModify({
              query: {_id: id},
              update:
              {$set:{counter:counter}}, new:true},function(err,doc){
                res.json({'newGameID':newGameID,'status':0});
            });
          });
  });
  /*
  res.setHeader('Content-Type', 'application/json');
  res.send(JSON.stringify(matrix));*/
});

app.get('/sendGameMatriz/:matriz/:level/:player', function(req,res){
    var matriz = req.params.matriz;
    var level = req.params.level;
    var player = req.params.player;

    var jsonMatriz = JSON.parse(matriz);
    if(gameLogic.checkWinner(jsonMatriz, 1)){
        res.json({"data":"OK","winner":"1", "moveColum":-1});

    }else if(gameLogic.checkWinner(jsonMatriz, 2)){
        res.json({"data":"OK","winner":"2", "moveColum":-1});

    }else{
      if (level == 1) {
          res.json({"data":"OK","winner":"0","moveColum":level1.newMovement(jsonMatriz)});
      }else if (level == 2) {
          res.json({"data":"OK","winner":"0","moveColum":level2.newMovement(jsonMatriz,player)});
      }
    }

});


app.get('/getGameData/:email',function(req,res){
    var user = req.params.email;
	db.gamesData.find({user1:user}).sort({$natural : -1}).limit(1,function(err,docs){
		res.json(docs[0]);
      console.log(docs[0]);
	});
});

app.get('/updateData/:matriz/:gameID',function(req,res){
  var gameID = req.params.gameID;
  var gameMatriz = req.params.matriz;
  var jsonMatriz = JSON.parse(gameMatriz);

  console.log("UPDATING...");

  db.gamesData.findAndModify({
    query: {gameID: gameID},
    update:
    {$set:{data:jsonMatriz}}, new:true},function(err,doc){
      res.json({'status':0});
  });
});

app.listen(port);
console.log("Server ok in port: "+port);
