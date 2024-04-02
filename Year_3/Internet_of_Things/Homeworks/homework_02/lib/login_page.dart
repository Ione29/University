import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:homework_02/product_page.dart';
import 'package:homework_02/signup_page.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({super.key});

  @override
  State<LoginPage> createState() => _LoginState();
}

class _LoginState extends State<LoginPage> {
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();
  late int counter;

  void _navigateToSignup() {
    Navigator.of(context).pushReplacement(
        MaterialPageRoute(builder: (context) => const SignupPage()));
  }

  void _navToProducts() {
    Navigator.of(context).pushReplacement(
        MaterialPageRoute(builder: (context) => const ProductPage()));
  }

  Future<void> _logInUser() async {
    String email = _emailController.text;
    String password = _passwordController.text;
    try {
      await FirebaseAuth.instance.signInWithEmailAndPassword(
        email: email,
        password: password,
      );
      _navToProducts();
    } on FirebaseAuthException catch (e) {
      if (e.code == 'user-not-found' || e.code == 'wrong-password') {
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(
            content: Text('Invalid username or password!'),
          ),
        );
      }
    }
  }

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
            SizedBox(
              width: 350,
              child: TextField(
                controller: _emailController,
                decoration: const InputDecoration(
                    labelText: 'Email', hintText: "Enter your email"),
              ),
            ),
            SizedBox(
              width: 350,
              child: TextField(
                obscureText: true,
                controller: _passwordController,
                decoration: const InputDecoration(
                    labelText: 'Password', hintText: "Enter your password"),
              ),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                backgroundColor: const Color.fromARGB(255, 8, 196, 39),
              ),
              onPressed: () async {
                if (_emailController.text.isEmpty ||
                    _passwordController.text.isEmpty) {
                  ScaffoldMessenger.of(context).showSnackBar(
                    const SnackBar(
                      content: Text('Please fill in all fields.'),
                    ),
                  );
                } else {
                  _logInUser;
                }
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
              onPressed: _navigateToSignup,
              child: const Text(
                "Register instead",
                style: TextStyle(color: Colors.white),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
