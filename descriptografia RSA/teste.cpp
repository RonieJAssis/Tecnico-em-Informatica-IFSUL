#include<iostream>
using namespace std;
main(){
    long int n1,n2,n,z,t=2;
    bool v=true,v1=false;
    cout<<"digite o primeiro numero primo:"<<endl;
    cin>>n1;
    cout<<"digite o segundo numero primo:"<<endl;
    cin>>n2;
    z=(n1-1)*(n2-1);
    cout<<z<<endl;
    n=z;
    do{
        if(n%t!=0){
            t++;
        }
        else{
            if(t!= n){
                n=n/t;
            }
            else{
                v=false;
            }
        }
    }while(v==true);
    t++;
    do{
        for(int i=2;i<t;i++){
            if(t%i==0){
                v=true;
                t++;
                break;
            }
            else{
                v=false;
            }
        }

    }while(v == true);
    cout<<t<<endl;
    int i=1,x;
    do{
        x=(i*z)+1;
        if(x%t==0){
            x=x/t;
            v=true;
        }
        else{
            i++;
        }
    }while(v == false);
    cout<<x;
}
