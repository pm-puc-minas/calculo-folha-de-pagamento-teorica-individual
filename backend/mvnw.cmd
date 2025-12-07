@echo off
REM ------------------------------------------------------------------
REM Maven Wrapper (Windows)
REM ------------------------------------------------------------------
set MAVEN_PROJECTBASEDIR=%~dp0
set WRAPPER_DIR=%MAVEN_PROJECTBASEDIR%\.mvn\wrapper
set WRAPPER_JAR=%WRAPPER_DIR%\maven-wrapper.jar
set WRAPPER_URL=https://repo1.maven.org/maven2/io/takari/maven-wrapper/0.5.6/maven-wrapper-0.5.6.jar

if not exist "%WRAPPER_JAR%" (
  echo Downloading maven-wrapper.jar...
  if not exist "%WRAPPER_DIR%" mkdir "%WRAPPER_DIR%"
  powershell -Command "[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; (New-Object System.Net.WebClient).DownloadFile('%WRAPPER_URL%', '%WRAPPER_JAR%')"
)

REM Use java from PATH (user must have Java installed)
set JAVA_CMD=java
%JAVA_CMD% -jar "%WRAPPER_JAR%" %*
