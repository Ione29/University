import pandas as pd
import numpy as np
from sklearn.decomposition import PCA
from sklearn.model_selection import train_test_split, GridSearchCV, cross_val_score, KFold
from sklearn.preprocessing import StandardScaler
from sklearn.ensemble import RandomForestClassifier, VotingClassifier
from sklearn.linear_model import LogisticRegression
from sklearn.tree import DecisionTreeClassifier
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score, classification_report
from sklearn.exceptions import UndefinedMetricWarning
from imblearn.over_sampling import SMOTE
from xgboost import XGBClassifier
from sklearn.preprocessing import LabelEncoder
from matplotlib import pyplot as plt
import seaborn as sns

import warnings
warnings.filterwarnings("ignore", category=FutureWarning, module="sklearn")
warnings.filterwarnings("ignore", category=UndefinedMetricWarning)

def calculate_outliners_IQR(df: pd.DataFrame)->pd.DataFrame:
    Q1 = df.select_dtypes(include=['number']).quantile(0.25)
    Q3 = df.select_dtypes(include=['number']).quantile(0.75)
    IQR = Q3 - Q1

    return ((df.select_dtypes(include=['number']) < (Q1 - 1.5 * IQR)) | (df.select_dtypes(include=['number']) > (Q3 + 1.5 * IQR)))

def main(df: pd.DataFrame)->None:
    
    print("Exploratory Data Analysis:\n================================================")
    
    print(f"Our Dataset contains: {len(df)} rows and {df.shape[1]} columns.")
    print(f"The data types it contains are:\n{df.dtypes}")    

    print(f"The Corelation coeficient for numerical columns: ")
    
    show_correlation_matrix(df)
        
    print("Our target is the loan status, the rest are the model's features.")
    
    missing_values = df.isnull().sum()
    if missing_values.sum() == 0:
        print("We do not have any missing values in our dataset.")
    else:
        print(f"Missing Values per Column:\n{missing_values}")
    
    print("================================================")
    
    print("Data preprocessing:\n================================================")
    
    outliers = calculate_outliners_IQR(df)

    outlier_counts = outliers.sum()
    print(outlier_counts)

    # Identify the column with the highest number of outliers
    max_outliers_column = outlier_counts.idxmax()
        
    show_box_plot(df)


    show_violin_plot(df, max_outliers_column)

    #Dealing with missing values
    
    df = df.interpolate()  
                  
    pca_90 = PCA(n_components=0.90)
    df_pca_90 = pca_90.fit_transform(df.drop('loan_status', axis=1))
    
    df_pca_90 = pd.DataFrame(df_pca_90, columns=[f'Principal Component {i+1}' for i in range(df_pca_90.shape[1])])
    

    X = df_pca_90
    y = df['loan_status']

    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)

    smote = SMOTE(random_state=42)
    X_train_resampled, y_train_resampled = smote.fit_resample(X_train, y_train)
    
    X_train_resampled = X_train
    y_train_resampled = y_train
    
    scaler = StandardScaler()
    
    X_train_resampled = scaler.fit_transform(X_train_resampled)
    X_test = scaler.transform(X_test)    
    param_grid_rf = {
        'n_estimators': [100, 200],
        'max_depth': [None, 10, 20],
        'min_samples_split': [2, 5],
        'min_samples_leaf': [1, 2]
    }
    rf_model = RandomForestClassifier(random_state=42)
    grid_search_rf = GridSearchCV(estimator=rf_model, param_grid=param_grid_rf, cv=3, n_jobs=-1, verbose=2)
    grid_search_rf.fit(X_train_resampled, y_train_resampled)
    print(f"Best Parameters for Random Forest: {grid_search_rf.best_params_}")


    models = [
        ('Logistic Regression', LogisticRegression(random_state=42)),
        ('Decision Tree', DecisionTreeClassifier(random_state=42)),
        ('XGBoost', XGBClassifier(random_state=42)),
        ('Random Forest', grid_search_rf.best_estimator_),  
        ('KNN', KNeighborsClassifier())
    ]

    for name, model in models:
        print(f"Training {name}...")
        model.fit(X_train_resampled, y_train_resampled)
        y_pred = model.predict(X_test)
        print("Accuracy:", accuracy_score(y_test, y_pred))
        print("Classification Report:\n", classification_report(y_test, y_pred))  
    
    print("Voting Classifier") 
    voting_clf = VotingClassifier(estimators=models, voting='soft')
    voting_clf.fit(X_train_resampled, y_train_resampled)
    y_pred = voting_clf.predict(X_test)
    
    print("Voting Classifier Performance:")
    print("Accuracy:", accuracy_score(y_test, y_pred))
    print("Classification Report:\n", classification_report(y_test, y_pred))
    
    kf = KFold(n_splits=5, shuffle=True, random_state=42)

    cv_scores = cross_val_score(model, X, y, cv=kf, scoring='accuracy')

    print("K-Fold Cross-Validation Scores:", cv_scores)
    print("Mean Accuracy:", np.mean(cv_scores))
    print("Standard Deviation of Accuracy:", np.std(cv_scores))

def show_correlation_matrix(df: pd.DataFrame)->None:
    correlation_matrix = df.corr()
        
    plt.figure(figsize=(15, 15))
    sns.heatmap(correlation_matrix, annot=True, cmap='RdGy')
    plt.title("Correlation between coeficients")
    plt.show()
    
    sns.histplot(df['person_age'], kde=True, color="maroon", bins=10) 
    plt.title('person_age')
    plt.show()

def show_box_plot(df: pd.DataFrame)->None:
    plt.figure(figsize=(12, 6))
    sns.boxplot(data=df.select_dtypes(include=['number']))
    plt.title("IQR method for outliers")
    plt.show()

def show_violin_plot(df: pd.DataFrame, max_outliers_column: int)->None:
    plt.figure(figsize=(8, 6))
    sns.violinplot(x=df[max_outliers_column], color='purple', legend=None)
    plt.title(f"Violin Plot for {max_outliers_column}, showing Outliers")
    plt.xlabel("Approval Status (0: Not Approved, 1: Approved)")
    plt.show()

def load_data()-> pd.DataFrame:

    df = pd.read_csv('loan_data.csv')
    
    #Not using One Hot encoding due to multiple non numerical fields which would add a lot of unecesarry columns
    label_encoder = LabelEncoder()
    df['loan_status'] = label_encoder.fit_transform(df['loan_status'])
    df['previous_loan_defaults_on_file'] = label_encoder.fit_transform(df['previous_loan_defaults_on_file'])

    def target_encode(df, feature, target):
        encoding_map = df.groupby(feature)[target].mean()
        df[feature + '_encoded'] = df[feature].map(encoding_map)
        return df

    df = target_encode(df, 'person_education', 'loan_status')
    df = target_encode(df, 'person_gender', 'loan_status')
    df = target_encode(df, 'person_home_ownership', 'loan_status')
    df = target_encode(df, 'loan_intent', 'loan_status')

    df = df.drop(columns=['person_education', 'person_gender', 'person_home_ownership', 'loan_intent'])
    df = df.interpolate() 
    
    return df

if __name__ == "__main__":
    df = load_data()
    main(df)