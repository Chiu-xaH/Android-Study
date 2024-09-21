import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
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
  String textToShow = '我R尼玛';
  void _updateText() {
    //更新布局
    setState(() {
      textToShow = '哈哈哈哈';
    });
  }

  void _updateText2() {
    //更新布局
    setState(() {
      textToShow = 'aaaa';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(

        backgroundColor: Theme.of(context).colorScheme.inversePrimary,

        title: Text(widget.title),
      ),
      body: Center(
        //中心布局
        child: ElevatedButton(
          style: ElevatedButton.styleFrom(padding: const EdgeInsets.only(left: 20,right: 30)),
          onPressed: (){},
          child:  Text(textToShow),
        )
      ),
      floatingActionButton:   Column(
        mainAxisAlignment: MainAxisAlignment.end,
        children: [
          FloatingActionButton.extended(
            onPressed: _updateText,
            icon: Icon(Icons.connecting_airports_sharp),
            label: Text(textToShow),
          ),
          SizedBox(height: 10),
          FloatingActionButton.extended(
            onPressed: _updateText2,
            icon: Icon(Icons.inbox),
            label: Text(textToShow),
          )
        ],
      )
      //bottomNavigationBar: BottomNavigationBar(items: [],),
    );
  }
}
