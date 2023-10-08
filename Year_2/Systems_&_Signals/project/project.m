clear all
close all

[x11,t1] = impuls(-28, 32, 0.001, -11);
[x12,t1] = impuls(-28, 32, 0.001, -4);
[x13,t1] = impuls(-28, 32, 0.001, 7);
[x14,t1] = impuls(-28, 32, 0.001, 18);
[x15,t1] = impuls(-28, 32, 0.001, 26);
x1 = 5*x11 + 6*x12 + 7*x13 + 10*x14 + -18*x15;
figure
plot(t1,x1), xlabel('time'), ylabel('x1'), grid

[x21,t2] = step(-20, 12, 0.001, -8);
[x22,t2] = step(-20, 12, 0.001, -3);
[x23,t2] = step(-20, 12, 0.001, 1);
[x24,t2] = step(-20, 12, 0.001, 6);
x2 = 2*x21 + -1*x22 + -4*x23 + 3*x24;
figure
plot(t2,x2), xlabel('time'), ylabel('x2'), grid

conv11 = conv(x1, x1);
tconv11 = 2*t1(1):0.001:(2*t1(end));
figure
plot(tconv11, conv11), xlabel('time'), ylabel('(x1*x1)(t)');
grid on;

conv12=conv(x1,x2);
tconv12=(t1(1)+t2(1)):0.001:(t1(end)+t2(end));
figure
plot(tconv12, conv12), xlabel('time'), ylabel ('(x1*x2)(t)');
grid on;

