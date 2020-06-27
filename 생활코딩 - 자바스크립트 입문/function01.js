function cal(mode) {
  var funcs = {
    'plus' : function(left, right) {
      return left + right;
    },
    'minus' : function(left, right) {
      return left - right;
    }
  }
  return funcs[mode];
}
document.write(cal('plus')(1,2)+ "\n");

process = [
	function(input) { return input + 10;},
  function(input) { return input * input;},
  function(input) { return input / 2;},
];

input = 1;

for(i =0; i<process.length; i++) {
	input = process[i](input);
}

document.write(input+"\n");