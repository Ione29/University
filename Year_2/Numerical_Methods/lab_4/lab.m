clear all

c = 15.472;

f(c) = (668.061/c)*(1-e^(-c * 0.1468)) - 40
f_deriv(c) = (668.061/c^2)*(e^(-c * 0.1468) * (c*-0.1468 + 1)-1)

c_new = c - f(c) / f_deriv(c)

err = abs(c - c_new) / c_new * 100