
function [y,x] = step(li,ls,ste,k)
  x=li:ste:ls;
  L = length(x);
  y = zeros(1,L);
  start=(k-li)/ste;
  y((start+1):L)=ones(size((start+1):L));
end