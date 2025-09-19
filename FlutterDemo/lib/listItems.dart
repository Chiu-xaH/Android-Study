import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import 'dataModel.dart';


class WangkeList extends StatelessWidget {
  final List<MyList> myLists;

  const WangkeList({Key? key, required this.myLists}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount:  myLists.length,
      itemBuilder: (context, index) {
          // 这里是 MyList 的数据
          int myListIndex = index;
          return ListTile(
            title: Text("${myLists[myListIndex].title} | ${myLists[myListIndex].time}"),
            subtitle: Text(myLists[myListIndex].info),
            // 其他你想要显示的信息
          );
      },
    );
  }
}

class ScheduleList extends StatelessWidget {
  final List<Schedule> schedule;

  const ScheduleList({Key? key, required this.schedule}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount:  schedule.length,
      itemBuilder: (context, index) {
        // 这里是 MyList 的数据
        int myListIndex = index;
        return ListTile(
          title: Text("${schedule[myListIndex].title} | ${schedule[myListIndex].time}"),
          subtitle: Text(schedule[myListIndex].info),
          // 其他你想要显示的信息
        );
      },
    );
  }
}