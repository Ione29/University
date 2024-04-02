import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'HW_01',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'HW_01'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => LogInPage();
}

class LogInPage extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          "Log In Page",
        ),
        backgroundColor: Colors.red,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text(
              "Log In",
              style: TextStyle(fontSize: 40),
            ),
            const SizedBox(
              width: 350,
              child: TextField(
                decoration: InputDecoration(labelText: 'Username'),
              ),
            ),
            const SizedBox(
              width: 350,
              child: TextField(
                decoration: InputDecoration(labelText: 'Password'),
              ),
            ),
            const SizedBox(height: 10),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                backgroundColor: const Color.fromARGB(255, 8, 196, 39),
              ),
              onPressed: () {
                Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => const ProductsPage()));
              },
              child: const Text(
                "Log In",
                style: TextStyle(color: Colors.white),
              ),
            ),
            const SizedBox(height: 10),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                backgroundColor: const Color.fromARGB(255, 8, 126, 194),
              ),
              onPressed: () {
                Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => const RegisterPage()));
              },
              child: const Text(
                "Register instead",
                style: TextStyle(color: Colors.white),
              ),
            ),
            const SizedBox(height: 10),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                backgroundColor: const Color.fromARGB(255, 8, 126, 194),
              ),
              onPressed: () {
                Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => const ProductsPage()));
              },
              child: const Text(
                "See products without registering",
                style: TextStyle(color: Colors.white),
              ),
            )
          ],
        ),
      ),
    );
  }
}

class RegisterPage extends StatelessWidget {
  const RegisterPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          "Register Page",
          textAlign: TextAlign.center,
        ),
        backgroundColor: Colors.blue,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const SizedBox(
              width: 350,
              child: TextField(
                decoration: InputDecoration(labelText: 'Name'),
              ),
            ),
            const SizedBox(
              width: 350,
              child: TextField(
                decoration: InputDecoration(labelText: 'Username'),
              ),
            ),
            const SizedBox(
              width: 350,
              child: TextField(
                decoration: InputDecoration(labelText: 'Password'),
              ),
            ),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                backgroundColor: const Color.fromARGB(255, 84, 143, 211),
              ),
              onPressed: () {
                Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => const ProductsPage()));
              },
              child: const Text(
                "Register",
                style: TextStyle(color: Colors.white),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class ProductsPage extends StatelessWidget {
  const ProductsPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Products Page"),
        backgroundColor: Colors.amber,
      ),
      body: Center(
        child: Column(
          children: <Widget>[
            const Text(
              "These are our current products:",
              style: TextStyle(
                fontSize: 40,
              ),
            ),
            GridView.count(
              crossAxisCount: 2,
              padding: const EdgeInsets.all(16),
              crossAxisSpacing: 10,
              mainAxisSpacing: 10,
              shrinkWrap: true,
              children: <Widget>[
                SizedBox(
                  child: Image.network(
                    "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.G2SA9t4LJgDJUgcCiXFSPQHaFL%26pid%3DApi&f=1&ipt=5fad95ee6134fbc7a778427223b1bba145154f935506b039a4aa75ce459f9be8&ipo=images",
                    width: 100,
                    height: 100,
                  ),
                ),
                SizedBox(
                  child: Image.network(
                    "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.boardgameswizard.com%2Fwp-content%2Fuploads%2F2018%2F12%2FScythe-Board-Game-Box-2.jpg&f=1&nofb=1&ipt=bcea4c3bbf9cd730779a7a9cdd1e4c195a19da6a82f39034d699199e6771b743&ipo=images",
                    width: 100,
                    height: 100,
                  ),
                )
              ],
            )
          ],
        ),
      ),
    );
  }
}
