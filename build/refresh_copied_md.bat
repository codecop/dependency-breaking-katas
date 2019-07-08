@if exist %~n0%~x0 @cd ..



cd Java
@call "%~p0\_copy.bat" .. README.md .
cd ..



cd CSharp
cd DependencyBreakingKatas
@call "%~p0\_copy.bat" ..\.. README.md .
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\a Assignment.md A\
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\b Assignment.md B\
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\c Assignment.md C\
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\d Assignment.md D\
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\e Assignment.md E\
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\f Assignment.md F\
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\g Assignment.md G\
cd ..\..



pause
