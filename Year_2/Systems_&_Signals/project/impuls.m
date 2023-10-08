function [y,x] = impuls(li,ls,step,k)
  x=li:step:ls;
  L = length(x);
  y = zeros(1,L);
  y((k-li)/step) = 1;
end
