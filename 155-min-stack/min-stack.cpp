class MinStack {
public:
    stack<int> st, minSt;// value , min

    MinStack() {
        
    }
    
    void push(int value) {
        st.push(value);
        if(minSt.empty() || value <= minSt.top()){
            minSt.push(value);// if value > minSt.top then value can never contibute the the min value answer 
            // <= why equal sign , -3 comes twice then if we do not enter in minStack then we may pop before eary 
        }
    }
    
    void pop() {
        if(st.top() == minSt.top()){
            minSt.pop(); //<= why equal sign , -3 comes twice then if we do not enter in minStack then we may pop before eary 
        }
        st.pop();
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return minSt.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(value);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */