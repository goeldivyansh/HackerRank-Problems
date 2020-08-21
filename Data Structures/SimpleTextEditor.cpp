#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <stack>

using namespace std;

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    string S, W;
    int Q;
    stack<string> st;
    cin >> Q;

    for(int i=0;i<Q;i++)
    {
        int k,T;
        cin >> T;
        switch(T)
        {
            case 1: // Append
                cin >> W;
                st.push(S);
                S = S+W;
                break;
            case 2: // Erase
                cin >> k;
                st.push(S);
                S = S.substr(0, S.length() - k);
                break;
            case 3: // Get
                cin >> k;
                cout << S[k - 1] << endl;
                break;
            case 4: // Undo
                S = st.top();
                st.pop();
                break;
        }        
    }
    return 0;
}
