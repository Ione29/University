#include <iostream>
#include <queue>

using namespace std;

struct Com{
    int t;  //time when order arrived
    int d;  //time to prepare the order
};

int main(){

    int noOfOrders, closingTime;
    cout << "Give number of orders & closing time:";
    cin >> noOfOrders >> closingTime;

    queue<Com> orderQueue;  //create a queue with all the orders
    for(int i = 0; i < noOfOrders; i++){
        cout << "Order nr. " << i + 1 << ":";
        Com newOrder;   //create a new order variable
        cin >> newOrder.t >> newOrder.d;
        orderQueue.push(newOrder); //insert the new order in the queue
    }
    
    int currentTime = 0;
    int totalDuration = 0; //total duration in order to complete all orders received
    int orderNumber = 0;

    int ordersCompleted = 0, ordersOvertime = 0, ordersDropped = 0;

    while(!orderQueue.empty()){
        Com order;
        order = orderQueue.front();
        orderQueue.pop();      
        orderNumber++;
        totalDuration += order.d;

        if(order.t < closingTime){  //we check if the order was given during the operating hours of the restaurant

            if(currentTime + order.d < closingTime){  //check if the order is completed during overtime
                cout << "Order nr. " << orderNumber << " is completed during overtime.";
                ordersOvertime++;
            }  
            else{   //if not, it is completed normally
                cout << "Order nr. " << orderNumber << " is completed during business hours.";
                ordersCompleted++;
            }

            if(currentTime < order.t){  //if the current time is lower than the order time, it means we have free time
                cout << "We have " << order.t - currentTime << "free time at " << currentTime;  
                currentTime = order.t; //we skip the free time until the next order arrives
            }
            else   //we do not have free time, so the order will be started at the current time
                currentTime += order.d; //prepare the order, so the duration is added to the currentTime
        
            //once we completed the order, we compute the expected time and actual time
            cout<< "Order nr. " << orderNumber << " had an expected time of " << order.d << ", with an actual time of " << (currentTime - order.t) <<".";
        }

        else{
            cout << "The order received at " << order.t << " will not be completed, as it is after the closing time!";
            ordersDropped++;
        }
    }
    
    cout << "Statistics: ";
    cout << "\nThe maximum duration of the orders received is: " << totalDuration;
    cout << "\nOrders completed during business hours: " << ordersCompleted;
    cout << "\nOrders completed after closing time: " << ordersOvertime;
    cout << "\nOrders dropped: " << ordersDropped;

    return 0;
}
