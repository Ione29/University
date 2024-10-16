import torch
import torch.nn as nn
import torch.optim as optim
import torchvision.transforms as transforms
import matplotlib.pyplot as plt
from sklearn.metrics import confusion_matrix, accuracy_score
import seaborn as sns
from torch.utils.data import DataLoader
from torchvision.datasets import ImageFolder

# Device configuration; I have a 4060 so we use the CUDA cores, the CPU is put here as a failsafe
device = torch.device('cuda' if torch.cuda.is_available() else 'cpu')
print("The device being used is:", device)

# Dataset class for easier access
class PlayingCardDataset(torch.utils.data.Dataset):
    def __init__(self, data_dir, transform=None):
        self.data = ImageFolder(data_dir, transform=transform)
    
    def __len__(self):
        return len(self.data)

    def __getitem__(self, idx):
        return self.data[idx]
    
    @property
    def classes(self):
        return self.data.classes

# Define our model for the neural network
# Since we process images, we use a CNN (Convolution Neural Network)
class CardNet(nn.Module):
    def __init__(self):
        super(CardNet, self).__init__()
        
        # 4 layers of convolution to make the features more obvious
        self.conv1 = nn.Conv2d(3, 32, kernel_size=3, stride=1, padding=1)
        self.conv2 = nn.Conv2d(32, 64, kernel_size=3, stride=1, padding=1)
        self.conv3 = nn.Conv2d(64, 128, kernel_size=3, stride=1, padding=1)
        self.conv4 = nn.Conv2d(128, 256, kernel_size=3, stride=1, padding=1)

        # Dropout function to counter overfitting
        self.dropout = nn.Dropout(p=0.2)

        # 2 fully Connected layers
        self.fc1 = nn.Linear(256 * 8 * 8, 4096)
        self.fc2 = nn.Linear(4096, 1024)
        self.fc3 = nn.Linear(1024, 512)
        self.fc4 = nn.Linear(512, 53)

    def forward(self, x):
        x = nn.functional.relu(self.conv1(x))
        x = nn.functional.max_pool2d(x, 2)
        x = self.dropout(x)
        x = nn.functional.relu(self.conv2(x))
        x = nn.functional.max_pool2d(x, 2)
        x = self.dropout(x)
        x = nn.functional.relu(self.conv3(x))
        x = nn.functional.max_pool2d(x, 2)
        x = self.dropout(x)
        x = nn.functional.relu(self.conv4(x))
        x = nn.functional.max_pool2d(x, 2)
        x = self.dropout(x)
        x = x.view(x.size(0), -1)
        x = self.dropout(x)
        x = nn.functional.relu(self.fc1(x))
        x = self.dropout(x)
        x = nn.functional.relu(self.fc2(x))
        x = self.dropout(x)
        x = nn.functional.relu(self.fc3(x))
        x = self.dropout(x)
        x = self.fc4(x)
        return x

# Define the preprocessing we use on the dataset in order to counter overfitting
# We want the CNN to learn the features, not memorize our dataset
transform = transforms.Compose([
    transforms.Resize((128, 128)),
    transforms.ToTensor(),
])

# Load the train dataset
train_dataset_folder = './downloaded_dataset/train'
train_dataset = PlayingCardDataset(train_dataset_folder, transform=transform)
train_loader = DataLoader(train_dataset, batch_size=64, shuffle=True)

# Load the valid dataset
valid_dataset_folder = './downloaded_dataset/valid'
valid_dataset = PlayingCardDataset(valid_dataset_folder, transform=transform)
valid_loader = DataLoader(valid_dataset, batch_size=64, shuffle=False)

# Initialize the network and define the loss function and optimizer
model = CardNet().to(device)

# Define our loss function and optimizer
criterion = nn.CrossEntropyLoss()
optimizer = optim.Adam(model.parameters(), lr=0.0001)

# Number of epochs
number_of_epochs = 30

# Arrays in which we store our train / valid losses
train_losses = []
valid_losses = []

# Implement early stop after 3 steps

# Training loop
for epoch in range(number_of_epochs):
    
    # Training phase of the epoch
    model.train()
    running_train_loss = 0.0
    for images, labels in train_loader:
        images, labels = images.to(device), labels.to(device)
        outputs = model(images)
        loss = criterion(outputs, labels)

        optimizer.zero_grad()
        loss.backward()
        optimizer.step()
        
        running_train_loss += loss.item()

    # Evaluation phase of the epoch
    model.eval()
    running_valid_loss = 0.0
    all_labels = []
    all_preds = []
    with torch.no_grad():
        for images, labels in valid_loader:
            images, labels = images.to(device), labels.to(device)
            outputs = model(images)
            loss = criterion(outputs, labels)
            running_valid_loss += loss.item()

            _, preds = torch.max(outputs, 1)
            all_labels.extend(labels.cpu().numpy())
            all_preds.extend(preds.cpu().numpy())

    # Compute the average losses
    average_train_loss = running_train_loss / len(train_loader)
    average_valid_loss = running_valid_loss / len(valid_loader)
    
    # Store the losses for plotting
    train_losses.append(average_train_loss)
    valid_losses.append(average_valid_loss)

    # Print the stats of the epoch
    print(f'Epoch [{epoch+1}/{number_of_epochs}], Train Loss: {average_train_loss:.4f}, Validation Loss: {average_valid_loss:.4f}')

# Plot training and validation loss
plt.plot(train_losses, label='Training loss')
plt.plot(valid_losses, label='Validation loss')
plt.legend()
plt.title("Losses per epoch")
plt.show()

# Calculate and print confusion matrix and accuracy
conf_matrix = confusion_matrix(all_labels, all_preds)
accuracy = accuracy_score(all_labels, all_preds)

print(f'Validation Accuracy: {accuracy:.4f}')

plt.figure(figsize=(10, 8))
sns.heatmap(conf_matrix, annot=True, fmt='d', cmap='Blues', xticklabels=train_dataset.classes, yticklabels=train_dataset.classes)
plt.xlabel('Predicted')
plt.ylabel('True')
plt.title('Confusion Matrix')
plt.show()
