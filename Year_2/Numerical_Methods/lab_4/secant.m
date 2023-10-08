clear all
x=2:0.01:5;
y = exp(-x)-x;
plot(x, y)
grid

xi1 = 0;
xi2 = 1;
error_adm = 0.0001;
error = 10;
I = 0;

while error>error_adm,
    f_xi1 = exp(-xi1) - xi1;
    f_xi2 = exp(-xi2) - xi2;
        xi3 = xi2-f_xi2*(xi1-xi2)/(f_xi1-f_xi2);
        I = I + 1;
    error = abs((xi3 - xi2)/xi3) * 100;
    xi1 = xi2;
    xi2 = xi3;
end

[xi3 error*1e5 I]