/*
object.js(객체 함수 )
객체(속성, 메소드)
*/
const obj = {
	name: "홍길동",
	age:20,
	showInfo : function() {
		return `이름은 ${this.name} 이고  ${this.age}입니다.`
	},
	empList: function() {
		fetch('../empList.json')
		.then()(function() {
			return result.json();
		}) 
		.then(function(result) {
		})
	}
} //new object(); 객체만드는법

//console.log('이름 ' + obj.name)
obj.name = "hongkikdong";
console.log(`이름: ${obj.name}, 나이 : ${obj.age}`);
console.log(obj.showInfo());

console.log(window);
//속성확인.
for(let prop in obj) {
	console.log(`속성: ${prop} , 값 ${obj[prop]}`);
}
//window.alert('확인!!');
console.clear();
obj.empList();

