/*
* array.js
*/

const ary = []; //new Array();
ary.push('apple');
ary.push(['banana','cherry']);

console.log()

const fruits = [];
fruits.push({name:"사과",price: 1000});
fruits.push({name:"수박",price: 5000});
fruits.pop();
fruits.unshift({name:"수박",price: 5000});;
fruits.shift(); //빼버린다
fruits.push({name:"수박",price: 5000});//맨마지막만 가능
//[사과,수박]
//fruits.splice();추가 수정 삭제 가능

fruits.splice(1, 0,{name: '키위',price : 3000}); //추가 
fruits.splice(1, 1,{name: '키위',price : 5000}); //수정 

fruits.splice(1, 1,{name: '참외 ',price : 3000}); //수정 

//fruits.splice(1, 2); //삭제





console.log(fruits);
