import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Lab_01",
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.cyan),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: "Lab_01"),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => MainPage();
}

class MainPage extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text("Main Menu"),
          backgroundColor: Colors.red,
        ),
        body: Center(
            child: Column(children: <Widget>[
          const Text("Welcome to my first app!"),
          ElevatedButton(
            style: ElevatedButton.styleFrom(
              backgroundColor: const Color.fromARGB(255, 123, 140, 255),
            ),
            onPressed: () {
              Navigator.push(context,
                  MaterialPageRoute(builder: (context) => const ImagePage()));
            },
            child: const Text("Click here!"),
          ),
          GridView.extent(
              primary: false,
              padding: const EdgeInsets.all(16),
              crossAxisSpacing: 20,
              mainAxisSpacing: 20,
              maxCrossAxisExtent: 400,
              children: <Widget>[
                Container(
                  padding: const EdgeInsets.all(8),
                  color: Colors.pink,
                  child: const Text('First', style: TextStyle(fontSize: 20)),
                ),
                Container(
                  padding: const EdgeInsets.all(8),
                  color: Colors.green,
                  child: const Text('First', style: TextStyle(fontSize: 20)),
                ),
                Container(
                  padding: const EdgeInsets.all(8),
                  color: Colors.black,
                  child: const Text('First',
                      style: TextStyle(fontSize: 20, color: Colors.white)),
                ),
                Container(
                  padding: const EdgeInsets.all(8),
                  color: Colors.blue,
                  child: const Text('First', style: TextStyle(fontSize: 20)),
                ),
                Container(
                  padding: const EdgeInsets.all(8),
                  color: Colors.amber,
                  child: const Text('First', style: TextStyle(fontSize: 20)),
                ),
                Container(
                  padding: const EdgeInsets.all(8),
                  color: Colors.blueGrey,
                  child: const Text('First', style: TextStyle(fontSize: 20)),
                ),
              ])
        ])));
  }
}

class ImagePage extends StatelessWidget {
  const ImagePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Image Screen")),
      body: Center(
          child: Column(
        children: <Widget>[
          const Text("This is the image page!"),
          Image.network(
            "https://cdn-amz.woka.io/images/I/918TkODhXPL.jpg",
            width: 600,
            height: 600,
          ),
          ElevatedButton(
            style: ElevatedButton.styleFrom(
                backgroundColor: const Color.fromARGB(255, 0, 0, 128)),
            onPressed: () {
              Navigator.pop(context);
            },
            child: const Text("Go back!"),
          ),
        ],
      )),
    );
  }
}
