import 'package:flutter/material.dart';
import 'package:homework_02/login_page.dart';
import 'package:homework_02/signup_page.dart';

class MainPage extends StatefulWidget {
  const MainPage({super.key});

  @override
  _MainState createState() => _MainState();
}

class _MainState extends State<MainPage> {
  void _navToLogin() {
    Navigator.of(context).pushReplacement(
        MaterialPageRoute(builder: (context) => const LoginPage()));
  }

  void _navToSignup() {
    Navigator.of(context).pushReplacement(
        MaterialPageRoute(builder: (context) => const SignupPage()));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text("Main Menu"),
          backgroundColor: Colors.red,
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              ElevatedButton(
                style: ElevatedButton.styleFrom(
                  backgroundColor: const Color.fromARGB(255, 8, 196, 39),
                ),
                onPressed: _navToLogin,
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
                  onPressed: _navToSignup,
                  child: const Text(
                    "Register instead",
                    style: TextStyle(color: Colors.white),
                  )),
            ],
          ),
        ));
  }
}
