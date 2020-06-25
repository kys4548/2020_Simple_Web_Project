//값으로써의 함수를 나타낼수 있는 자바스트립트 특성을 활용한 사례

function sortNumber(a, b) {
	console.log(a, b);
  return a - b;
}


numbers = [100,0,99,1,98,2,97,3,96,4,95,5,94,6];
numbers.sort(sortNumber);
document.write(numbers);