clear all

x=-2:0.01:5;
y=exp(-x)-x;
plot(x,y);
grid

xi=0;
error_adm=0.0001;
error=10;
I=0;

while error>error_adm,
  xi_new=xi-(exp(-xi)-xi)/(-exp(-xi)-1);
  error=abs((xi_new-xi)/xi_new)*100;
  xi=xi_new;
  I=I+1;
end

disp('Newton')
disp('--------------')
[xi error*1e5 I]