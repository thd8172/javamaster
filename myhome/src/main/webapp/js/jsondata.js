/**
 * jsondata.js
 */
const employees = `[{"id":1,"first_name":"Tasia","last_name":"Nice","email":"tnice0@tinyurl.com","gender":"Female","ip_address":"217.95.91.132"},
{"id":2,"first_name":"Maxie","last_name":"Rhodus","email":"mrhodus1@cisco.com","gender":"Genderqueer","ip_address":"141.181.205.142"},
{"id":3,"first_name":"Lorraine","last_name":"Negro","email":"lnegro2@pen.io","gender":"Female","ip_address":"169.53.222.83"},
{"id":4,"first_name":"Sharlene","last_name":"Garbutt","email":"sgarbutt3@indiatimes.com","gender":"Female","ip_address":"218.10.244.80"},
{"id":5,"first_name":"Geordie","last_name":"Suffield","email":"gsuffield4@opensource.org","gender":"Male","ip_address":"84.51.45.234"},
{"id":6,"first_name":"Ninetta","last_name":"Gilbee","email":"ngilbee5@live.com","gender":"Female","ip_address":"59.98.106.58"},
{"id":7,"first_name":"Hamlin","last_name":"Skrine","email":"hskrine6@parallels.com","gender":"Male","ip_address":"39.175.32.102"},
{"id":8,"first_name":"Kippy","last_name":"Bloggett","email":"kbloggett7@japanpost.jp","gender":"Male","ip_address":"43.112.134.167"},
{"id":9,"first_name":"Dorise","last_name":"Clinning","email":"dclinning8@hhs.gov","gender":"Female","ip_address":"55.105.182.48"},
{"id":10,"first_name":"Dynah","last_name":"Pacheco","email":"dpacheco9@cyberchimps.com","gender":"Female","ip_address":"117.185.250.252"},
{"id":11,"first_name":"Sonny","last_name":"Spedroni","email":"sspedronia@dyndns.org","gender":"Female","ip_address":"207.148.103.140"},
{"id":12,"first_name":"Templeton","last_name":"Glossup","email":"tglossupb@usatoday.com","gender":"Male","ip_address":"106.38.172.194"},
{"id":13,"first_name":"Meyer","last_name":"Methingam","email":"mmethingamc@va.gov","gender":"Male","ip_address":"168.234.126.129"},
{"id":14,"first_name":"Jada","last_name":"Edser","email":"jedserd@wikipedia.org","gender":"Female","ip_address":"116.53.128.149"},
{"id":15,"first_name":"Christan","last_name":"Biagini","email":"cbiaginie@go.com","gender":"Female","ip_address":"12.22.205.40"},
{"id":16,"first_name":"Shayne","last_name":"Kenneford","email":"skennefordf@nba.com","gender":"Male","ip_address":"108.177.188.203"},
{"id":17,"first_name":"Michelle","last_name":"MacPaik","email":"mmacpaikg@mail.ru","gender":"Female","ip_address":"230.125.119.1"},
{"id":18,"first_name":"Kimble","last_name":"Wethers","email":"kwethersh@csmonitor.com","gender":"Male","ip_address":"139.177.9.0"},
{"id":19,"first_name":"Una","last_name":"Shellcross","email":"ushellcrossi@loc.gov","gender":"Female","ip_address":"88.39.106.226"},
{"id":20,"first_name":"Theo","last_name":"Choudhury","email":"tchoudhuryj@google.ca","gender":"Female","ip_address":"91.74.41.67"}]`;

console.log(employees);
const empList = JSON.parse(employees); //문자열 -> 객채
console.log(employees);