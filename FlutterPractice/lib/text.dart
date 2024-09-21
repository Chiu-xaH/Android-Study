
late var Numbers;

Add(num1,num2) => print(num1 + num2);

void main() {
  var texts = ['我是谁？','呵呵'];
  String text = '对';
  int? nums;
  nums = 55;
  Numbers = 100;
  print(texts[1] + Numbers.toString());
  Add(1,2);
  funcations('sss',true);
 // assert(nums == null);
  //若括号内参数条件为false则抛出异常，若为真，则不做出反应
  assert(say('Bob', 'Howdy') == 'Bob says Howdy');
  assert(say('Bob', 'Howdy', 'smoke signal') ==
      'Bob says Howdy with a smoke signal');
}

void funcations(text, bool ss){
  if (ss)
  print(text);
}


String say(String from, String msg, [String? device]) {
  var result = '$from says $msg';
  if (device != null) {
    result = '$result with a $device';
  }
  return result;
}