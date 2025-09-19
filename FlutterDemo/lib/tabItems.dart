import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import 'dataModel.dart';
import 'listItems.dart';
import 'main.dart';

//解析层 解析数据

class Lists extends StatelessWidget {
  const Lists({super.key});

  @override
  Widget build(BuildContext context) {
    return FutureBuilder<MyResult> (
      future: fetch(),
      builder: (context,snapshot) {
        if(snapshot.connectionState == ConnectionState.done) {
          if(snapshot.hasError) {
            return Text("错误 ${snapshot.error}");
          } else if (snapshot.hasData) {
            return WangkeList(myLists: snapshot.data!.Lessons.MyLists);
          }
        }
        return const CircularProgressIndicator();
      },
    );
  }
}

class Lists2 extends StatelessWidget {
  const Lists2({super.key});

  @override
  Widget build(BuildContext context) {
    return FutureBuilder<MyResult> (
      future: fetch(),
      builder: (context,snapshot) {
        if(snapshot.connectionState == ConnectionState.done) {
          if(snapshot.hasError) {
            return Text("错误 ${snapshot.error}");
          } else if (snapshot.hasData) {
            return ScheduleList(schedule: snapshot.data!.Lessons.Schedules);
          }
        }
        return const CircularProgressIndicator();
      },
    );
  }
}