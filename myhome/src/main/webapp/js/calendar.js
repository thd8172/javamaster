/*
*calender.js
*/

document.addEventListener("DOMContentLoaded", initForm)

//let show = document.querySelector('#show');
//console.log(show)
//})

function initForm() {
	let show = document.querySelector('#show');
	show.appendChild(svc.makeTabel());
	document.querySelector('#show>table').appendChild(svc.makeHeader2());
	document.querySelector('#show>table').appendChild(svc.makeBody());
}

const svc = {
	makeTabel: function() {
		let tbl = document.createElement('table');
		tbl.setAttribute('border', "2");
		return tbl;
	},
	makeHeader: function() {
		const days = ['sun', 'mon', 'Tue', 'Wed','Thr', 'Fri', 'Sat'];
		let thd = document.createElement('thead');
		let tr = document.createElement('tr');
		days.forEach(function(day) {
			let th = document.createElement('th');
			th.innerHTML = day;
			tr.appendChild(th);
		});
		thd.appendChild(tr);
		return thd;
	},
	makeHeader2: function() {
		const days = ['sun', 'mon', 'Tue', 'Wed','Thr', 'Fri', 'Sat'];
		let tr =  days.reduce((acc, curVal) => {
			let  th = document.createElement('th');
			th.innerHTML = curVal;
			acc.appendChild(th);
			return acc;
		}, document.createElement('tr'));
		let thd = document.createElement('thead');
		thd.appendChild(tr);
		return thd;
	},
	makeBody: function() {
		let tr = document.createElement('tr');
		let tbd = document.createElement('tbody');
		let spaces = 1;
		for (let i = 0; i < spaces; i++) {
			let td = document.createElement('td');
			td.innerHTML = " ";
			tr.appendChild(td);
		}
		for (let d = 1; d <= 30; d++) {
			let td = document.createElement('td');
			td.innerHTML = d;
			tr.appendChild(td);
			if ((d + spaces) % 7 == 0) {
				tbd.appendChild(tr)
				tr = document.createElement('tr');
			}
		}

		tbd.appendChild(tr);
		return tbd;
	}
}