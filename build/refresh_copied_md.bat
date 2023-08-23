@if exist %~n0%~x0 @cd ..



cd Java
@call "%~p0\_copy.bat" .. README.md .
cd ..



cd CSharp
cd DependencyBreakingKatas
@call "%~p0\_copy.bat" ..\.. README.md .
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\a Assignment.md A
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\b Assignment.md B
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\c Assignment.md C
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\d Assignment.md D
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\e Assignment.md E
cd ..\..



cd PHP
@call "%~p0\_copy.bat" .. README.md .
cd src
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\a Assignment.md A
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\b Assignment.md B
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\c Assignment.md C
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\d Assignment.md D
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\e Assignment.md E
cd ..\..



cd C
@call "%~p0\_copy.bat" .. README.md .
cd src
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\a Assignment.md a
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\b Assignment.md b
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\c Assignment.md c
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\d Assignment.md d
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\e Assignment.md e
cd ..\..



pause
