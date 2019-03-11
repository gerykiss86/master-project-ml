import numpy as np
from keras.layers import Dense, Activation
from keras.models import Sequential


def my_train(week):
    
    def keep_columns(passed_array, last_column_to_keep):
        arr = passed_array
        label = arr[:, arr.shape[1] - 1:]
        arr2 = arr[:, :last_column_to_keep]
        arr3 = np.insert(arr2, arr2.shape[1], label.flatten(), axis=1)
        return arr3

    def load_my_data(path='TrainingData.csv', test_split=0.2, seed=113):
        assert 0 <= test_split < 1
        my_data = np.genfromtxt(path, delimiter=',', skip_header=1)
        my_data = keep_columns(my_data, week)
        x = my_data[:, 0:(my_data.shape[1] - 1)]
        y = my_data[:, (my_data.shape[1] - 1):my_data.shape[1]]
        np.random.seed(seed)
        indices = np.arange(len(x))
        np.random.shuffle(indices)
        x = x[indices]
        y = y[indices]
        x_train = np.array(x[:int(len(x) * (1 - test_split))])
        y_train = np.array(y[:int(len(x) * (1 - test_split))])
        y_train = y_train.transpose()
        y_train = y_train[0]
        x_test = np.array(x[int(len(x) * (1 - test_split)):])
        y_test = np.array(y[int(len(x) * (1 - test_split)):])
        y_test = y_test.transpose()
        y_test = y_test[0]

        return (x_train, y_train), (x_test, y_test)

    (X_train, Y_train), (X_test, Y_test) = load_my_data()

    nFeatures = X_train.shape[1]

    model = Sequential()
    model.add(Dense(1, input_shape=(nFeatures,), kernel_initializer='uniform'))
    model.add(Activation('linear'))

    model.compile(optimizer='rmsprop', loss='mse', metrics=['mse', 'mae'])

    model.fit(X_train, Y_train, batch_size=4, epochs=500)

    model.summary()

    model.evaluate(X_test, Y_test, verbose=True)

    Y_pred = model.predict(X_test)

    print(Y_test[:5])
    print(Y_pred[:5, 0])
    filename = ".\models\week" + str(week).zfill(2) + ".h5"
    model.save(filename)
    return 0
   

for i in range(52, 0, -1):
    print("week" + str(i).zfill(2))
    my_train(i)
    print("done")
