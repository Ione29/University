function LossValue=FrSpcLss(dDistance, dFrequency, dGainT, dGainR)
%FrSpcLss.M - FreeSpaceLoss
%USAGE   : FrSpcLs(dDistance, dFrequency, dGainT, dGainR)
%RETURNS : LossValue
%Subrutina calculeaza pierderile de propagare in spatiul liber
%pentru un emitator si un receptor situati in spatiul liber la
%distanta dDistance. Semnalul emis are frecventa dFrequency.
%Emitatorul, respectiv receptorul, sunt caracterizati de
%castigurile dGainT, respectiv dGainR.
%Ex: FrSpcLss(1000.0,10^8,1.0,1.0)

dLightSpeed=3.0*10^8;

if (nargin~=4)
   disp('Incorrect number of args in calling FreeSpaceLoss.')
   disp('Require 4 double (float) positive values.')
   LossValue=0;
else
   LossValue=10.0*log10(dGainT*dGainR*((dLightSpeed/(4*pi*dDistance*dFrequency))^2) );
end

clear dLightSpeed;
