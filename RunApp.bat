@echo off
setlocal

REM Change the path and filename to match your WAR file
set WAR_FILE=Data_To_Graph-0.0.1-SNAPSHOT.war

REM Change the port number to match the one used by your application
set PORT=8080

REM Start the server
start cmd /k "cd %~dp0Data_To_Graph\target && java -jar %WAR_FILE% --server.port=%PORT%"

REM Wait for the server to start
ping -n 5 127.0.0.1 > nul

REM Open Google Chrome with the URL of your application
start chrome http://localhost:%PORT%

exit /b