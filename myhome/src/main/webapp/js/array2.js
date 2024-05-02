/*
*
*/ 
let genderAry = [];
empList.forEach(emp => {
	if(genderAry.indexOf(emp.gender) == -1){
		genderAry.push(emp.gender);
	}
});

genderAry.forEach(gender => {
	let opt = document.createElement('option');
	opt.innerHTML = gender;
	document.querySelector('#genderList').appendChild(opt);
});

//함수(배열)
function makeList(ary = []) {
	let obj = {id:1,first_name:'',last_name:'',email:'',gender:'' ,salary: ''}
	let props = ['id','first_name','email','salary'];
	document.querySelector('#show tbody').innerHTML = "";
	ary.forEach(emp => {
		
	//한건에 대한 처리.
	let tr = document.createElement('tr');
	props.forEach(prop => {
		let td = document.createElement('td');
		td.innerHTML = emp [prop];
		tr.appendChild(td);
		})
	document.querySelector('#show tbody').appendChild(tr);
	})
}

makeList(empList);

//change 이벤트 
document.querySelector('#genderList')
	.addEventListener('change',function(){
		let filterAry = empList.empList.filter(emp => emp.gender == this.value);
		makeList(filterAry);
	});
	
