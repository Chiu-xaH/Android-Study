


//定义数据结构
//解析层

class MyResult {
  final String TimeStamp;
  final String semesterId;
  final Lesson Lessons;

  const MyResult({
    required this.TimeStamp,
    required this.semesterId,
    required this.Lessons,
  });

  factory MyResult.fromJson(Map<String,dynamic> json ) {
    return MyResult(TimeStamp: json['TimeStamp'], semesterId: json['semesterId'],Lessons: Lesson.fromJson(json['Lessons'] as Map<String, dynamic>));
  }
}

class Lesson{
  final List<MyList> MyLists;
  final List<Schedule> Schedules;

  const Lesson({
    required this.MyLists,
    required this.Schedules
  });

  factory Lesson.fromJson(Map<String,dynamic> json) {
    var myListJson = json['MyList'] as List;
    List<MyList> myList = myListJson.map((e) => MyList.fromJson(e)).toList();
    var scheduleJson = json['Schedule'] as List;
    List<Schedule> schedule = scheduleJson.map((i) => Schedule.fromJson(i)).toList();
    return Lesson(MyLists: myList, Schedules: schedule);
  }
}

class Schedule {
  final String time;
  final String title;
  final String info;
  final List<int> startTime;
  final List<int> endTime;

  const  Schedule({
    required this.title,
    required this.time,
    required this.info,
    required this.startTime,
    required this.endTime
  });

  factory Schedule.fromJson(Map<String,dynamic> json) {
    var startTimeJson = json["startTime"] as List;
    List<int> startTime = startTimeJson.map((e) => e as int).toList();
    var endTimeJson = json['endTime'] as List;
    List<int> endTime = endTimeJson.map((i) => i as int).toList();
    return Schedule(
        title: json['title'],
        time: json['time'],
        info: json['info'],
        startTime: startTime,
        endTime: endTime
    );
  }
}

class MyList {
  final String time;
  final String title;
  final String info;
  final List<int> startTime;
  final List<int> endTime;

  const  MyList({
    required this.title,
    required this.time,
    required this.info,
    required this.startTime,
    required this.endTime
  });

  factory MyList.fromJson(Map<String,dynamic> json) {
    var startTimeJson = json['startTime'] as List<dynamic>;
    List<int> startTime = startTimeJson.map((e) => e as int).toList();
    var endTimeJson = json['endTime'] as List<dynamic>;
    List<int> endTime = endTimeJson.map((i) => i as int).toList();
    return MyList(title: json['title'], time: json['time'], info: json['info'], startTime: startTime, endTime: endTime);
  }
}

