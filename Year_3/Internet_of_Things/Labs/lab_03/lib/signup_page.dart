import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:homework_02/login_page.dart';
import 'package:homework_02/add_products_page.dart';

class SignupPage extends StatefulWidget {
  const SignupPage({super.key});

  @override
  State<SignupPage> createState() => _SignupState();
}

class _SignupState extends State<SignupPage> {
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();
  final TextEditingController _repeatPasswordController =
      TextEditingController();

  void _navToProducts() {
    Navigator.of(context).pushReplacement(
        MaterialPageRoute(builder: (context) => AddProductsPage()));
  }

  void _navToLogin() {
    Navigator.of(context).pushReplacement(
        MaterialPageRoute(builder: (context) => const LoginPage()));
  }

  Future<void> _signUpUser() async {
    String email = _emailController.text;
    String password = _passwordController.text;

    try {
      await FirebaseAuth.instance
          .createUserWithEmailAndPassword(email: email, password: password);
    } on FirebaseAuthException catch (e) {
      if (e.code == 'weak-password') {
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(
            content: Text('The password is too weak. Choose a stronger one!'),
          ),
        );
      } else if (e.code == 'email-already-in-use') {
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(
            content: Text(
                'This email is already used for another account. Log In ?'),
          ),
        );
      }
    }

    _navToProducts();
  }

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
          children: [
            const Text(
              "Register",
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
            SizedBox(
              width: 350,
              child: TextField(
                obscureText: true,
                controller: _repeatPasswordController,
                decoration: const InputDecoration(
                    labelText: 'Validate Password',
                    hintText: "Repeat your password"),
              ),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                backgroundColor: const Color.fromARGB(255, 84, 143, 211),
              ),
              onPressed: () async {
                if (_emailController.text.isEmpty ||
                    _passwordController.text.isEmpty ||
                    _repeatPasswordController.text.isEmpty) {
                  ScaffoldMessenger.of(context).showSnackBar(
                    const SnackBar(
                      content: Text('Please fill in all fields.'),
                    ),
                  );
                } else if (_passwordController.text !=
                    _repeatPasswordController.text) {
                  ScaffoldMessenger.of(context).showSnackBar(
                    const SnackBar(
                      content: Text('The provided passwords are not matching!'),
                    ),
                  );
                } else {
                  _signUpUser;
                }
              },
              child: const Text(
                "Register",
                style: TextStyle(color: Colors.white),
              ),
            ),
            const SizedBox(height: 10),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                backgroundColor: const Color.fromARGB(255, 8, 126, 194),
              ),
              onPressed: _navToLogin,
              child: const Text(
                "Log In instead",
                style: TextStyle(color: Colors.white),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
