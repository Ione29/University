m = 68.1;
c = 12.5;
g = 9.81;
tf = 30;

ta = 0:0.05:tf;
va = m * g / c * (1 - exp(-c/m*ta));
plot(ta, va, 'r.')
hold on; grid on
disp('press any key')
pause
h = 2;
tn = 0:h:tf;
l=length(tn);
vn(1)=0;
  for i = 1:(l-1),
    vn(i+1)=vn(i)+(g-c/m*vn(i))*h;
  endfor
plot(tn, vn, 'go',tn, vn, 'g')
disp('press any key')
pause
