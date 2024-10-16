from sklearn.datasets import make_blobs
from sklearn.neural_network import MLPClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import confusion_matrix, accuracy_score
import matplotlib.pyplot as plt


X, T = make_blobs(n_samples=10000, n_features=10, centers=10, cluster_std=4.25, random_state=17)

#blob graph
plt.subplot(2, 1, 1)
plt.scatter(X[:, 0], X[:, 1], c = T)
plt.title('Blobs graph')

Xtr, Xts, Ttr, Tts = train_test_split(X, T, train_size=0.2, random_state=17, shuffle=False)


mlp = MLPClassifier(hidden_layer_sizes=(20, 10), activation='relu', solver='adam', alpha=1e-5, tol = 1e-4, random_state=17, verbose=True, max_iter=2000)

mlp.fit(Xtr, Ttr)

Y = mlp.predict(Xts)

print('acc', accuracy_score(Y, Tts))
print('conf:')
print(confusion_matrix(Y, Tts))

#loss graph
plt.subplot(2, 1, 2)
plt.plot(mlp.loss_curve_)
plt.title('Loss Curve Function')
plt.show()