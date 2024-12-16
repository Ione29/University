*****************************************************************
*                                                               *
* README.TXT - Brief release information for Erisoft TEMS       *
*                                                               *
* Version: GSM 900/96.0.2                                       *
*                                                               *
* Date:    96-12-18                                             *
*                                                               *
*****************************************************************

*------------------------------------*
* Changes R4B' ---> TEMS GSM 900/96  *
*------------------------------------*

- Support for new TEMS mobile versions, (SW version TMS 300/1 R2 (GH337 HW)
  and TMS 300/2 R2 (GH388 HW) ). Some of the features supported in TEMS GSM
  900/96 requires new mobile SW.
- Improved cell name handling. Identification by GGI or
  positions (Lat/Long). Up to 2000 cell names. 16 characters 
  in cell name.
- Possibility to printout graphical window.
- Optional autoconnect to mobile and positioning equipment at start up.
- Automatic loading of setup file at startup.
- CI and LAC either in decimal or hexadecimal form.
- Signal strength in either RxLev or dBm in all windows.
- Possibility to sort neighbouring cells by RxLev in Serving + Neighbouring 
  cell window.
- Possibility to estimate RxQual in idle mode ('Channel Quality'). Requires
  R2 version of TEMS mobile SW. 
- More options in graphical presentation; possibility to display
  TA, TxPower and Filemarks. Sizeable window. More data shown when
  sample value is taken.
- Monitoring of phase 2 messages (e.g SYSINFO 7 and 8). Requires R2 version of
  TEMS mobile SW.
- Possibility to run separate key sequences for MS 1 and MS 2.
- Scan Tool allows scanning of all frequencies in the band. (Limited
  to 20 frequencies in previous version).
- Possibility to insert filemarks in Scan Tool files. 
- Possibility to replay Scan Tool files.
- SYSTEM INFORMATION messages in Layer 3 Control sequences. Requires R2 version
  of TEMS mobile SW.  
- Possibility to specify direction bit and bit pattern to match
  a specific message in a Layer 3 Control sequence. Requires R2 version of
  TEMS mobile SW.
- The Test of TCH function is capable of handling hopping channels. Requires
  R2 version of TEMS mobile SW.
- SMS mobile originated supported. Possibility to edit and send SMS from
  PC. Requires R2 version of TEMS mobile SW.
- A few notes : 
  - The log file format has been changed. TEMS GSM 900/96 is capable
    of handling log files from previous versions.
  - Data/fax is supported by the TEMS mobiles but it is not possible
    to run TEMS and data/fax applications simultaneously.
  - There is a new cable kit for TEMS (PC<--> MS). Allows powering
    of mobile from car cigarette-lighter.  

*---------------------------------*
* Changes 900/96 ---> 900/96.0.2  *
*---------------------------------*
The following problems/bugs are corrected in 96.0.2:

- Define cell names.
  Defined neighbours are not prioritized before simple ARFCN/BSIC match.
- Trimble Mobile PCMCIA GPS. 
  Problem with positions < Longitude -90,  corrected.
- Error in GPS positions near Lat/Lon 0.
- Support for NMEA RMC messages (GPS).
- Sometimes wrong BSIC values are shown when replaying a scan file.
- Decoding of an incorrect IMMEDIATE ASSIGNMENT REJECT phase 2 message
  causes a program crash.
- Program crash if several frequency scanning commands are sent during 
  dedicated mode.
- Decoding of SYSTEM INFORMATION 4 phase 2 rest octets corrected.
- Decoding of IE Classmark, MS Power class 1 incorrect (PCS1900 only).
- Decoding of IE Channel Mode incorrect.
- Decoding of SCH messages, T3 changed to T3'.
- Decoding of C2 cell reselection parameter in SYSTEM INFORMATION 4 incorrect.
- Display problem in dedicated channel status window regarding speech
  version number (string too long).
- Display problem in graphical presentation window regarding TA.
- Display problem in graphical presentation window regarding RxQual.
- Display problem in remote control window regarding '¤' and '<-' 
  characters.
- Updated decoding of the NECI bit in SYSTEM INFORMATION 3 and 4.

*-----------------*
* Important notes *
*-----------------*

- TEMS will only execute under standard or enhanced mode Windows.

Ericsson Erisoft AB
S-932 83 URSVIKEN
SWEDEN

tel: +46 910 73 10 00
fax: +46 910 73 10 99

(c) 1995 Ericsson Erisoft AB, All rights reserved.
