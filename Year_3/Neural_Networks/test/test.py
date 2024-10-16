from sklearn.datasets import make_blobs
from sklearn.metrics import confusion_matrix, accuracy_score
from sklearn.neural_network import MLPClassifier
from sklearn.model_selection import train_test_split
import matplotlib.pyplot as plot

state = 17

X, T = make_blobs(n_samples = 20000, n_features=10, centers= 10, cluster_std=4.25, random_state=state)

plot.subplot(2, 1, 1)
plot.scatter(X[:, 0], X[:, 1], c = T)
plot.title("Blob Population")

Xtr, Xts, Ttr, Tts = train_test_split(X, T, train_size=0.2, random_state=state, shuffle=False)

mlp = MLPClassifier(hidden_layer_sizes=(20, 10), activation='relu', solver='adam', alpha = 1e-5, tol = 1e-4, random_state=state, verbose=True, max_iter=2000)

mlp.fit(Xtr, Ttr)

Y = mlp.predict(Xts)

print("The accuracy is: ", accuracy_score(Y, Tts))
print("The confusion matrix is: ") 
print(confusion_matrix(Y, Tts))

plot.subplot(2, 1, 2)
plot.plot(mlp.loss_curve_)
plot.title("Loss Curve Function Graph")
plot.show()