call runcrud.bat
if %ERRORLEVEL% == 0 goto runbrowser
echo Error during runcrud.bat running
goto fail

:runbrowser
start http://localhost:8080/crud/v1/task/getTasks
if %ERRORLEVEL% == 0 goto end
echo Error during web browser running
goto fail

:fail
echo Error occured - script has been stopped
goto end

:end
echo Work finished