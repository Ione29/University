import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';

class ProductsPage extends StatefulWidget {
  const ProductsPage({super.key});

  @override
  _ProductsState createState() => _ProductsState();
}

class _ProductsState extends State<ProductsPage> {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  oid _navToProducts() {
    Navigator.of(context).pushReplacement(
        MaterialPageRoute(builder: (context) => const ProductsPage()));
  }

  Future<void> _pullProducts() async {
    await _firestore.collection("products").get().then((event) {
      for (var doc in event.docs) {
        print("${doc.id} => ${doc.data()}");
      }
    });
  }

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
            const SizedBox(height: 10),
            ElevatedButton(
                style: ElevatedButton.styleFrom(
                  backgroundColor: const Color.fromARGB(255, 8, 126, 194),
                ),
                onPressed: _navToProducts,
                child: const Text(
                  "Products Page",
                  style: TextStyle(color: Colors.white),
                )),
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
            ),
          ],
        ),
      ),
    );
  }
}
