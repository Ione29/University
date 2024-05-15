import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';

class AddProductsPage extends StatefulWidget {
  @override
  _AddProductsPageState createState() => _AddProductsPageState();
}

class _AddProductsPageState extends State<AddProductsPage> {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;
  final TextEditingController _nameController = TextEditingController();
  final TextEditingController _colorController = TextEditingController();
  final TextEditingController _typeController = TextEditingController();

  void _addProduct() async {
    String name = _nameController.text;
    String color = _colorController.text;
    String type = _typeController.text;

    if (name.isNotEmpty && color.isNotEmpty) {
      await _firestore.collection('products').add({
        'name': name,
        'price': color,
        'type': type,
      });
      // Clear the text fields after successful addition
      _nameController.clear();
      _colorController.clear();
      _typeController.clear();
      // Show a success message or handle the new product UIs
    } else {
      // Handle the error, show an alert or a Snackbar
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Add New Product')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _nameController,
              decoration: const InputDecoration(labelText: 'Product Name'),
            ),
            TextField(
              controller: _colorController,
              decoration: const InputDecoration(labelText: 'Price'),
            ),
            TextField(
              controller: _colorController,
              decoration: const InputDecoration(labelText: 'Type'),
            ),
            ElevatedButton(
              onPressed: _addProduct,
              child: const Text('Add Product'),
            ),
            // Add a widget to display list of products here if necessary
          ],
        ),
      ),
    );
  }
}
