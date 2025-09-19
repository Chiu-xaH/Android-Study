import 'dart:convert';
import 'dart:ffi';

import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:untitled2/listItems.dart';
import 'package:untitled2/tabItems.dart';
import 'dataModel.dart';
import 'package:http/http.dart' as http;

void main() {
  runApp(const MyApp());
  fetch();
}

class CustomColors {
static const Color mainColor = Colors.green;
}



//逻辑层  网络请求
Future<MyResult> fetch() async {
  final response = await http.get(Uri.parse("https://chiu-xah.github.io/"));
  if(response.body.contains("更新")) {
    Map userMap = json.decode(response.body);
    return MyResult.fromJson(userMap as Map<String,dynamic>);
  } else {throw Exception("失败");}
}


//主页面
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '我的接口',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: CustomColors.mainColor, brightness: Brightness.light),
        useMaterial3: true,
      ),
        darkTheme: ThemeData(
          useMaterial3: true,
          colorScheme: ColorScheme.fromSeed(seedColor:CustomColors.mainColor, brightness: Brightness.dark),),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});
  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  late Future<MyResult> future;
  @override
  void initState() {
    super.initState();
    future = fetch();
  }

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 3,
      child: Scaffold(
        appBar: AppBar(
          backgroundColor: Theme.of(context).colorScheme.inversePrimary,
          title: const Text('我的接口'
            // ,style: TextStyle(color: Colors.green),
          ),
          bottom: const TabBar(
            tabs: <Widget>[
              Tab(
                text: "重要安排",
              ),
              Tab(
                text: "其他事项",
              ),
            ],
          ),
        ),
        body: const TabBarView(
          children: <Widget>[
            Lists2(),
            Lists(),
          ],
        ),
      ),
    );
  }
}


